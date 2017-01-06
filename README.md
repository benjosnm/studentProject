# studentProject
Student project exercise

## Synopsis
Student project contain a business objects to process student basic information data in .CSV file.

## Required
* Java 8
* CSV data file

### Format:
Student Type, Student Name, Gender, Timestamp

## Instruction:
Execute student project with

`java -jar studentSolution.jar  *filename.csv* [criteria]=stringToSearch`

criteria = {name, type, gender}

### Example
In order to search in example.csv file all student named "Benjamin" and course "Kinder" level:

`java -jar studentSolution.jar example.csv name=Benjamin type=Kinder`

## StundetProject features

* Store student data into porject from csv file.
* Provide create and add Student implementation to stored students.
* Provide delete specific student implementation.
* Search student with some criteria provided by command line arguments.
  * {name, type, gender}
* The result is sorted with the sort criteria provided by user in argument *order*.
