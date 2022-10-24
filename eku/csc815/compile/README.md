# Solution for Week 4 Assignment not included due to Academic Integrity policy and will be uploaded upon course completion.

# CSC 815 Week 4 Assignment - Shell Script
```
Create a shell script "compile" that will compile and run a C or Java program.  The user will type "compile x.c" or "compile y.java" on the command line.  Your script should call "gcc" or "javac" as appropriate, and run the resulting program if the compile finishes without any errors.
```
# Cruz Macias

# Script Instructions
```
Include at most one parameter in the execution. This parameter must be a Java or C program. Try including zero, more than one, or the testfile.txt as your input.
```

# To Run the Script without Parameters
```
./compile.sh
```

# or Try
```
bash compile.sh
```

# To Run a Java Program
```
bash compile.sh y.java
```

# To Run a C Program
```
bash compile.sh x.c
```