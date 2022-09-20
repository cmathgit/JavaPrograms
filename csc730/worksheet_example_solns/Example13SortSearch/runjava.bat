:: Run a Java Program in the current directory
:: CSC 730 Week 5 Worksheets 1-2 Example 5 Problem 1-2, 1 Example13SortSearch Solutions
:: Programmer: Cruz Macias
@ECHO OFF
color 0a

:: compile the java source code and place the class files containing the byte code in the user-defined package and place it in the pwd 
:: javac -d . Example13SortSearch.java

:: alternative compile options

:: list what the compiler is doing
:: javac -d . Example13SortSearch.java -verbose

:: remove any existing dependencies
::echo removing jars, class definitions, and json payload
::echo enter to confirm
::pause

::rm -f lib\example13sortsearch.jar
::rm -rf classes/*

:: to list warning details
echo compile and build Java program
pause
javac -d classes/ src\example13sortsearch\Example13SortSearch.java -verbose -Xlint:unchecked

:: create a jar file and specify the directory where the class files live
echo create jar files
jar --create --file lib\example13sortsearch.jar -C classes/ .
::ls lib
pause

:: run the compiled java program (specify the class path in the user-defined packages directory)
echo run Java program
pause
::java example13sortsearch.Example13SortSearch > output.txt
java -cp lib\example13sortsearch.jar example13sortsearch.Example13SortSearch
::echo running ...
::echo program result:
::pause
::cat output.txt
pause