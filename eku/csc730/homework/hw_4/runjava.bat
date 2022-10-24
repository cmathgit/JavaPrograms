:: Run a Java Program in the current directory
:: CSC 730 Homework 3 Solutions
:: Programmer: Cruz Macias
@ECHO OFF
color 0a

:: compile the java source code and place the class files containing the byte code in the user-defined package and place it in the pwd 
:: javac -d . HomeWork4App.java

:: alternative compile options

:: list what the compiler is doing
:: javac -d . HomeWork4App.java -verbose

:: remove any existing dependencies
::echo removing jars, class definitions, and json payload
::echo enter to confirm
::pause

::rm -f lib\homework4app.jar
::rm -rf classes/*

:: to list warning details
echo compile and build Java program
pause
javac -d classes/ src\homework4app\HomeWork4App.java -verbose -Xlint:unchecked

:: create a jar file and specify the directory where the class files live
echo create jar files
jar --create --file lib\homework4app.jar -C classes/ .
::ls lib
pause

:: run the compiled java program (specify the class path in the user-defined packages directory)
echo run Java program
pause
::java homework4app.HomeWork4App > output.txt
java -cp lib\homework4app.jar homework4app.HomeWork4App
::echo running ...
::echo program result:
::pause
::cat output.txt
pause