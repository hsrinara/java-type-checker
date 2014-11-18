#!/bin/bash

print_environment_variables()
{
  echo "JAVA_HOME is:" $JAVA_HOME
}

initialise() 
{
  echo "Cleaning workspace" 
  rm -rf build
  mkdir build
}

find_java_source_files()
{
  find src/main/java -type f -name "*.java" 
}

compile_main() 
{
  echo "Compiling main"
  $JAVA_HOME/bin/javac -cp "lib/checker-1.8.7.jar:build" -d build `find_java_source_files`
}

check_units()
{
  echo "Checking units"
  $JAVA_HOME/bin/javac \
    -Aunits=org.hsrinara.typechecker.custom.Price,org.hsrinara.typechecker.custom.Quantity \
    -processor org.checkerframework.checker.units.UnitsChecker \
    -cp lib/checker-1.8.7.jar:build \
    -d build \
    `find_java_source_files`
}

print_environment_variables
initialise
compile_main
check_units

