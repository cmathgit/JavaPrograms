/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . MidtermPart4.java
 * to run the program, execute:
 *		java midtermpart4.MidtermPart4
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac MidtermPart4.java
 * to run the program, execute:
 *		java MidtermPart4
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java MidtermPart4.java
 * this command will not run the program if the main class is after a different class definition
 * alternative compile options
 * list what the compiler is doing
 * javac -d . MidtermPart4.java -verbose
 *
 * to list warning details
 * javac -d . MidtermPart4.java -Xlint:unchecked
 */
package midtermpart4;

/**
 * @programmer: Cruz Macias
 * Midterm Part 4 Programming Problems
 */
public class MidtermPart4
{
    public static void main(String[] args) 
    {        
		String str = "abcdbst";
		String pFix1 = "abc/*e+";
		String pFix2 = "abc/*e+/";
		String pFix3 = "abc/*e";
		
		Functions func = new Functions();
		// Example Practice Problem 2
		func.hello();
		
		System.out.println(func.count(str, 'b'));
		System.out.println(func.isPostfix(pFix1));
		System.out.println(func.isPostfix(pFix2));
		System.out.println(func.isPostfix(pFix3));
		func.printNumbers(4);
		
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
	
	/* Problem 1*/
	static int count(String s, char c)
	{
		if (s.equals(""))		
			return 0;
		else if (s.charAt(0) == c)
			return 1 + count(s.substring(1), c);
		else
			return 0 + count(s.substring(1), c);
	}
	
		/* Problem 2*/
	static boolean isPostfix(String e)
	{
		return true;
	}
	
			/* Problem 3*/
	static void printNumbers(int n)
	{
		if (n > 1)
		{
			for (int i = n; i > 1; i--) 
			{
				for(int j = 0; j < i-1; j++)
					System.out.print("  ");

				System.out.println(i);
			}
			
			printNumbers(1);
		}
		else if (n == 1)
		{
			System.out.println(n);
			System.out.println(n);
			
			//printNumbers(2*n);
		}
	}
}