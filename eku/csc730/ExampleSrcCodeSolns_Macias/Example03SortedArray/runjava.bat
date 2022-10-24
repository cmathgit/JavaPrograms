:: Run a Java Program in the current directory
:: CSC 730 Week 1 Worksheet 3 Example 1 Problem 1 Example03SortedArray Solutions
:: Programmer: Cruz Macias
@ECHO OFF
color 06

:: compile the java source code and place the class files containing the byte code in the user-defined package and place it in the pwd 
:: javac -d . Example03SortedArray.java

:: alternative compile options

:: list what the compiler is doing
:: javac -d . Example03SortedArray.java -verbose

:: remove any existing dependencies
::echo removing jars, class definitions, and json payload
::echo enter to confirm
::pause

::rm -f lib\example03sortedarray.jar
::rm -rf classes/*

:: to list warning details
echo compile and build Java program
pause
javac -d classes/ src\example03sortedarray\Example03SortedArray.java -verbose -Xlint:unchecked

:: create a jar file and specify the directory where the class files live
echo create jar files
jar --create --file lib\example03sortedarray.jar -C classes/ .
::ls lib
pause

:: run the compiled java program (specify the class path in the user-defined packages directory)
echo run Java program
pause
::java example03sortedarray.Example03SortedArray > output.txt
java -cp lib\example03sortedarray.jar example03sortedarray.Example03SortedArray
::echo running ...
::echo program result:
::pause
::cat output.txt
pause