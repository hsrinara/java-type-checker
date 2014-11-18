# Type Checker
A simple demonstration of using the Java annotation processor to give compilation errors for annotated types. See output by running: 

```bash
./gradlew compileJava
```  

## Intellij Settings

### Compiler-> Java Compiler -> Additional command line parameters 
```
-target 1.8 -source 1.8 -Aunits=org.hsrinara.typechecker.custom.Price,org.hsrinara.typechecker.custom.Quantity
```

### Compiler -> Annotation processors
Enable annotation processor by ticking the checkbox

### Compiler -> Annotation processors -> Processor FQ Name
```
org.checkerframework.checker.units.UnitsChecker
```


## Other resources

* The [official documentation](http://types.cs.washington.edu/checker-framework/current/checker-framework-manual.html#units-checker) on the unit-checker.
* The [google groups](https://groups.google.com/forum/#!forum/checker-framework-discuss) on the unit-checker
* A clear [blog post](http://blog.paralleluniverse.co/2014/05/01/modern-java) with a section on annotation processors. 