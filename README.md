Maven Project Example
==================

Learn how to use Maven in Java. At this project, we will use some dependencies for testing 

* [`joda-time: 2.9.4`](http://search.maven.org/#artifactdetails%7Cjoda-time%7Cjoda-time%7C2.9.4%7Cjar)
* [`commons-csv: 1.3`](http://search.maven.org/#artifactdetails%7Corg.apache.commons%7Ccommons-csv%7C1.3%7Cjar)

Maven will build `jar`  with dependencies. So, we can use this `jar` as `classpath` when run the Java Class.

For csv usage, Java Class will read `data/sample.csv` for CSV Parsing. And will write to `data/result.csv` for CSV Writing.

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
