/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . MidtermPracticeProblems.java
 * to run the program, execute:
 *		java midtermpracticeproblems.MidtermPracticeProblems
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac MidtermPracticeProblems.java
 * to run the program, execute:
 *		java Example09Recursion
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java Example09Recursion.java
 * this command will not run the program if the main class is after a different class definition
 * alternative compile options
 * list what the compiler is doing
 * javac -d . MidtermPracticeProblems.java -verbose
 *
 * to list warning details
 * javac -d . MidtermPracticeProblems.java -Xlint:unchecked
 */
package midtermpracticeproblems;

/**
 * @programmer: Cruz Macias
 */
public class MidtermPracticeProblems 
{
    public static void main(String[] args) 
    {        
		// Practice Problem 2
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
	* Practice problem 2: Write a function to print "Hello World!" ten times
	*/
	static void hello()
	{
		for (int i = 0; i < 10; i++)
			System.out.println("Hello World!");
	}
}