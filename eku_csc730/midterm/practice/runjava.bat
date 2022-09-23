:: Run a Java Program in the current directory
:: CSC 730 Midterm Practice Problems
:: Programmer: Cruz Macias
@ECHO OFF
color 0a

:: compile the java source code and place the class files containing the byte code in the user-defined package and place it in the pwd 
:: javac -d . MidtermPracticeProblems.java

:: alternative compile options

:: list what the compiler is doing
:: javac -d . MidtermPracticeProblems.java -verbose

:: to list warning details
echo compile and build Java program
pause
javac -d . MidtermPracticeProblems.java -verbose -Xlint:unchecked
:: run the compiled java program (specify the class path in the user-defined packages directory)
echo run Java program
pause
java midtermpracticeproblems.MidtermPracticeProblems > output.txt
echo running ...
echo program result:
pause
cat output.txt
pause