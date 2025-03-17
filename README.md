# NexDB 

Effortlessly manage local storage on Android with NexDB.

Official documentation can be on docs - Check some examples below. The example application is provided in the **example** folder in the source.

## Features
- Simple and clean integration process with minimal configuration.
- Automatic table and column naming via reflection.
- Seamless migrations between different schema versions.

## Installing

### As a Gradle dependency
Preferred method. Add the following:
```groovy
implementation 'com.github.krishpranav:nexdb:1.0'
```
Then run `gradle build` or `gradle assemble`.


### As a Maven dependency
Declare the dependency in Maven:
```xml
<dependency>
    <groupId>com.github.krishpranav</groupId>
    <artifactId>nexdb</artifactId>
    <version>1.0</version>
</dependency>
```

### Settings:

Include the following in your **settings.gradle**:
```gradle
include ':app', ':nexdb'

def getLocalProperty(prop) {
    Properties properties = new Properties()
    properties.load(new File(rootDir.absolutePath + '/local.properties').newDataInputStream())
    return properties.getProperty(prop, '')
}

project(':nexdb').projectDir = new File(getLocalProperty('nexdb.dir'))
```

And in **local.properties**:
```
nexdb.dir=/path/to/nexdb/library
```

Add NexDB to dependencies in **build.gradle**:
```gradle
dependencies {
    implementation project(':nexdb')
}
```

## Examples:

### NexRecord
```java
public class Student extends NexRecord {
  @Unique
  String dob;
  String name;
  String class;

  public Book() {}

  public Book(String dob, String name, String class) {
    this.dob = dob;
    this.name = name;
    this.class = class;
  }
}
```

### Save Entity
```java
Student student = new Student("01 Jan", "Some name", "Some class");
book.save();
```

### Load Entity
```java
Student student = Student.findById(Student.class, 1);
```

### Update Entity
```java
Student student = Student.findById(Book.class, 1);
student.title = "Updated Title";
student.save();
```

### Delete Entity
```java
student.delete();
```

### Bulk Insert
```java
List<Student> students = Arrays.asList(
    new Book("", "", ""),
    new Book("", "", "")
);
NexRecord.saveInTx(students);
```
