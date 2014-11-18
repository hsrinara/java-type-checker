#!/bin/sh

BUILD_DIR=build
LIB_DIR=lib

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

compile_main() 
{
  echo "Compiling main"
  $JAVA_HOME/bin/javac -proc:none -cp "$LIB_DIR/checker-1.8.7.jar:$BUILD_DIR" -d $BUILD_DIR `find_java_source_files`
}

check_units()
{
  echo "Checking units"
  $JAVA_HOME/bin/javac \
    -proc:only \
    -Aunits=org.hsrinara.typechecker.custom.Price,org.hsrinara.typechecker.custom.Quantity \
    -processor org.checkerframework.checker.units.UnitsChecker \
    -cp $LIB_DIR/checker-1.8.7.jar:$BUILD_DIR \
    -d $BUILD_DIR \
    `find_java_source_files`
}

print_environment_variables && 
initialise && 
compile_main && 
check_units 

