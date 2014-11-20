#!/bin/sh

BUILD_DIR=build
LIB_DIR=lib

guarantee_java_8()
{
  JAVA_VERSION=`$JAVA_HOME/bin/java -version 2>&1 | grep version`
  echo $JAVA_VERSION | grep "1.8" > /dev/null
  if [ $? -ne 0 ]; then
    echo "Required Java 8, got:" $JAVA_VERSION
    return 1
  else
    return 0
  fi
}

print_environment_variables()
{
  echo "JAVA_HOME is:" $JAVA_HOME
}

initialise() 
{
  echo "Cleaning workspace" 
  rm -rf $BUILD_DIR
  mkdir $BUILD_DIR
}

find_java_source_files()
{
  find src/main/java -type f -name "*.java" 
}

## If we were using a proper build tool, these annotated types would go in a submodule which we would depend on.
compile_custom_annotated_types()
{
  echo "Compiling main"
  $JAVA_HOME/bin/javac -proc:none -cp "$LIB_DIR/checker-1.8.7.jar:$BUILD_DIR" -d $BUILD_DIR \
    src/main/java/org/hsrinara/typechecker/custom/Price.java \
    src/main/java/org/hsrinara/typechecker/custom/Quantity.java
}

check_units()
{
  echo "Checking units"
  $JAVA_HOME/bin/javac \
    -proc:only \
    -Aunits=org.hsrinara.typechecker.custom.Price,org.hsrinara.typechecker.custom.Quantity \
    -processor org.checkerframework.checker.units.UnitsChecker \
    -cp $LIB_DIR/checker-1.8.7.jar:$BUILD_DIR \
    `find_java_source_files`
}

guarantee_java_8 &&
print_environment_variables && 
initialise && 
compile_custom_annotated_types &&
check_units 

