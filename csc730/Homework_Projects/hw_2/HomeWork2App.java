/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . HomeWork2App.java
 * to run the program, execute:
 *		java homework2app.HomeWork2App
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac HomeWork2App.java
 * to run the program, execute:
 *		java HomeWork2App
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java HomeWork2App.java
 * this command will not run the program if the main class is after a different class definition
 * alternative compile options
 * list what the compiler is doing
 * javac -d . HomeWork2App.java -verbose
 *
 * to list warning details
 * javac -d . HomeWork2App.java -Xlint:unchecked
 */
package homework2app;

/***************
 * @programmer: Cruz Macias
 * @contributors: Dr. Yang (StackArr class)
 * Program: Create a project that will solve the following application use cases under spcified condtions:
 *			1. to emulate keyboard input including backspaces
 *			2. to determine if the given string is a palindrome
 *			3. to compare the number of 1s and 0s in a given string
 *	This application must implement a class titles StringProcessor with three functions only:
 *			1. String processStringInput(String str) 
 *			2. boolean isPalindrome(String str)
 *			3.  int checkZeroOne(String str)
 ***************/

import java.util.Scanner;

public class HomeWork2App
{
    public static void main(String [] args)
    {
		Scanner input = new Scanner(System.in); // create a scanner object for user input
		StringProcessor stringProcessor = new StringProcessor();
		int return_check;
		String pstring = ""; // create and empty string to store processed input
		
        System.out.print("\nEnter a string (< for backspace): ");
        String s_in = input.nextLine(); // read the user input with next line
		  
		// use stack to emulate keyboard input including backspaces
		pstring = stringProcessor.processStringInput(s_in);
		  
		// Display the processed string
		System.out.println("After processing backspaces, the string becomes: " + pstring); 
	
       if(stringProcessor.isPalindrome(pstring))   // use stack to determine if the given string is a palindrome by calling reverseSequence() which uses a StackArr object
			System.out.println(pstring + " is a palindrome");
		else
			System.out.println(pstring + " is NOT a palindrome");
        
		// store the return value of the checkZeroOne(string) method of the StringProcessor class
		return_check = stringProcessor.checkZeroOne(pstring); // use stack to compare the number of 1s and 0s in a given string
		
        switch(return_check)
		{
			case -1: 
				System.out.println("more 0s than 1s");
				break;
			case 0: 
				System.out.println("Number of 0s is equal to number of 1s");
				break;
			case 1: 
				System.out.println("more 1s than 0s");
				break;
		}
			
	} // end main class
	
} // end class HomeWork2App

/***************
 * class to process a string in various application use cases: 
 * 1. to emulate keyboard input including backspaces
 * 2. to determine if the given string is a palindrome
 * 3. to compare the number of 1s and 0s in a given string
 ***************/
class StringProcessor 
{	
	// no other data members nor methods required for processing

	/* Important: 
	*			This method must use a stack and must return the processed string in the correct order.
	*  		The processed string cannot be returned to the main class and be reversed there.
	*		The reversing can take place in another method of the StringProcessor class.
	* Method Details: 
	*			This function simulates how the operating system handles text input from keyboard,
	* 		with the help of a stack. When a non-backspace character is entered, it is pushed into the
	*		stack. When a backspace is typed, the topmost character is popped from the stack and erased. 
	*		Assume the given string uses < to represent the backspace character.
	*/
	public String processStringInput(String str)
	{
		int stack_size = str.length();
        StackArr<Character> sinput_stack = new StackArr<>(stack_size); // create a StackArr object (stack) with size equal to passed in string
		String process_str = ""; // create an empty string for processing


        for (int i = 0; i < str.length(); i++)        // scan the passed string from left to right
        {
            Character t = str.charAt(i);                   // current character we are looking at in the string

			if(!t.equals('<')) // not a backspace character
				sinput_stack.push(t); // push item onto stack
			else // process backspace
				sinput_stack.pop(); // delete the item at the top of the stack 
        }

        while (!sinput_stack.isEmpty())                      // empty the stack
            process_str = sinput_stack.pop() + process_str;				  // assign to the return string
			
		return process_str;
	}

	/* Important: 
	*			This method must use a stack. Another method which reverses the processed string cannot
	*		be called to check if the string is a palindrome. The algorithm must be used in the function.
	* Method Details: 
	* 			This function uses a stack to help check if a given string is a palindrome or not. A
	* 		palindrome is a string that reads the same backward as forward, e.g., level, noon, radar. 
	*/	
	public boolean isPalindrome(String str)
	{
		boolean result = true;
		int stackSize = str.length(); 
		Character temp;
        StackArr<Character> palindrome_stack = new StackArr<>(stackSize);    // create a StackArr object (stack) with size equal to passed in string

        // push each character into stack, the original string is reversed when the stack if full
        for (int i = 0; i < str.length(); i ++) // scan the passed string from left to right
		{
			temp = str.charAt(i);       // store the current character of the string
			
			if ((stackSize % 2) == 0)
			{
				if ((i + 1) > (stackSize / 2))
				{
					if (!temp.equals(palindrome_stack.pop())) 
						return false;
				}
				else
				{
					palindrome_stack.push(temp);
				}
			}
			else
			{
				if ((i + 1) == ((stackSize / 2) + 1))
				{
						// do nothing; compare item with itself
				}
				else if ((i + 1) > ((stackSize / 2) + 1))
				{
					if(!temp.equals(palindrome_stack.pop())) 
						return false;
				}
				else
				{
					palindrome_stack.push(temp);
				}
			}
		}

		return result;
	}
	
	/* Important: 
	*			This method must use a stack even if the number of 1s and 0s can be determined without 
			implementing a stack.
	* Method Details: 
	* 			This function uses a stack but no arithmetic to compare the number of 0s and the
	*		number of 1s in a given string.
	*/	
	
public int checkZeroOne(String str) 
	{

        int value;
        StackArr<Character> stackC = new StackArr<>(str.length());

        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);

            if(c == '0' || c == '1')
            {
                if(stackC.isEmpty())
                    stackC.push(c);
                else if(stackC.peekTop() == c)    // c is the same as the characters currently in the stack
                    stackC.push(c);
                else                                      // c is different from the characters currently in the stack
                    stackC.pop();
            }
        }

        if(stackC.isEmpty())                       // if empty, then the number of 1’s and the number of 0’s are the same
            value = 0;
        else if (stackC.peekTop() == '1')        // more 1's than 0's
            value = 1;
        else                                                 // more 0's than 1's
            value = -1;

        return value;
	}
	
}

/**
 * StackArr class definition
 * Stacks implemented by using arrays whose element type is E 
 * @contributors: Dr. Yang
 */
class StackArr<E>
{
    private E a[];                  // array used to store the stack         
    private int top;                // index of the stack top 

    /**
     * 
     * Constructor: create an empty stack with the specified size
     */
    public StackArr(int size)
    {
        a = (E[]) new Object[size];
        top = -1;            // empty stack
    }

    /**
     * 
     * Constructor: create an empty stack with size 5
     */
    public StackArr()
    {        
        this(5);            // create a stack that can store at most 5 elements
    }

    /**
     * 
     * Return true if the stack is already full 
     */
    public boolean isFull()
    {
        return (top == a.length - 1);
    }

    /**
     * 
     * Return true if the stack is empty
     */
    public boolean isEmpty()
    {
        return (top == -1);
    }

    /**
     * 
     * Put a given on top of the stack
     * Return true if the push operation completes successfully
     */
    public boolean push(E item)
    {
        if (isFull())   
        {
            System.out.println("PUSH (" + item + ") failed!");
            return false;
        }
        
        top += 1;
        a[top] = item;
        
        return true;
    }

    /**
     * 
     * Take item from top of the stack 
     * Return the item if the operation completes successfully
     *        null to indicate the operation failed
     */
    public E pop()
    {
        if (isEmpty())
        {
            System.out.println("POP failed!");
            return null;
        }

        E item = a[top];
        top -= 1;
        return item;
    }

    /**
     * 
     * Peek at the top of the stack
     * Return the item if the operation completes successfully
     *        null to indicate the operation failed
     */
    public E peekTop()
    {
        if (isEmpty())
        {
            System.out.println("PEEK failed!");
            return null;
        }
        
        E item = a[top];
        return item;
    }
}

