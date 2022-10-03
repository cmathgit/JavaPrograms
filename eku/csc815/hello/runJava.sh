# Run a Java Program in the current directory
# CSC 815 Example Shell Script
# Programmer: Cruz Macias
# compile the java source code and place the class files containing the byte code in the user-defined package and place it in the pwd 
javac -d classes/ src/hello/Main.java -verbose -Xlint:unchecked
# create a jar file and specify the directory where the class files live
jar --create --file lib/hello.jar -C classes/ .
# run the compiled java program (specify the class path in the user-defined packages directory)
java -cp lib/hello.jar hello.Main