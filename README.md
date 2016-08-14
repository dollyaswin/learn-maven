Maven Project Example
==================

Learn how to use Maven in Java. At this project, maven will build `jar`  with dependencies. So, we can use this `jar` as `classpath` when run the Java Class.

## Requirement
* JRE 1.8

## Compile
* mvn compile
* mvn package
* mvn install assembly:assembly

# Usage
* `java -cp target/learning-maven-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.aqilix.learning.java.JodaTimeDemo`
* `java -cp target/learning-maven-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.aqilix.learning.java.ParseCSV`
* `java -cp target/learning-maven-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.aqilix.learning.java.WriteCSV`
