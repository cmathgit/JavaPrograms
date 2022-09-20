/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . MidtermPart1.java
 * to run the program, execute:
 *		java midtermpart1.MidtermPart1
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac MidtermPart1.java
 * to run the program, execute:
 *		java MidtermPart1
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java MidtermPart1.java
 * this command will not run the program if the main class is after a different class definition
 * alternative compile options
 * list what the compiler is doing
 * javac -d . MidtermPart1.java -verbose
 *
 * to list warning details
 * javac -d . MidtermPart1.java -Xlint:unchecked
 */
package midtermpart1;

/**
 * @programmer: Cruz Macias
 * Midterm Part 1 Programming Problems
 */
public class MidtermPart1
{
    public static void main(String[] args) 
    {        
		// Example Practice Problem 2
		Functions.hello();
    }
}

/**
 * 
 * Recursive functions to calculate some math problems
 */
class Functions
{
	/**
	* Example Practice Problem 2: Write a function to print "Hello World!" ten times
	*/
	static void hello()
	{
		for (int i = 0; i < 10; i++)
			System.out.println("Hello World!");
	}
}