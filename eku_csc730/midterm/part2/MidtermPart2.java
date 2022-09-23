/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . MidtermPart2.java
 * to run the program, execute:
 *		java midtermpart2.MidtermPart2
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac MidtermPart2.java
 * to run the program, execute:
 *		java MidtermPart2
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java MidtermPart2.java
 * this command will not run the program if the main class is after a different class definition
 * alternative compile options
 * list what the compiler is doing
 * javac -d . MidtermPart2.java -verbose
 *
 * to list warning details
 * javac -d . MidtermPart2.java -Xlint:unchecked
 */
package midtermpart2;

/**
 * @programmer: Cruz Macias
 * Midterm Part 2 Programming Problems
 */
public class MidtermPart2
{
    public static void main(String[] args) 
    {     
		Functions func = new Functions();
		String qStr1 = "booboo";
		String qStr2 = "abcab";
		// Example Practice Problem 2
		//func.hello();
		
		// Midterm Part 2 Problem 1
		if(func.hasEqualHalves(qStr1))   // use stack to determine if the given string is a palindrome by calling reverseSequence() which uses a StackArr object
			System.out.println(qStr1 + " has equal halves.");
		else
			System.out.println(qStr1 + " does not have equal halves.");
		
		if(func.hasEqualHalves(qStr2))   // use stack to determine if the given string is a palindrome by calling reverseSequence() which uses a StackArr object
			System.out.println(qStr2 + " has equal halves.");
		else
			System.out.println(qStr2 + " does not have equal halves.");
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
	
	/* Important: 
 Consider strings that can be split so that their first half is the same as their second half. For example, the string “booboo” can be split into “boo” and “boo”. However, the string “abcab” has unequal halves. Write a function boolean hasEqualHalves(String s) that uses a queue to test whether a given string s has two equal halves. Let’s assume a class QueueArr has been implemented as in Example06Queue and is available for you to use.
	*/	
	public boolean hasEqualHalves(String str)
	{
		boolean result = true;
		int strSize = str.length(); 
		Character temp;

		if(strSize % 2 == 0)
		{
			result = true;
			int queueSize = (strSize / 2);
			QueueArr<Character> halves_queue = new QueueArr<>(queueSize);    

			int i = 0;

			while(!halves_queue.isFull())
			{
				temp = str.charAt(i);       // store the current character of the string
				halves_queue.enqueue(temp);
				i++;
			}
			
			while(!halves_queue.isEmpty())
			{
				temp = str.charAt(i);       // store the current character of the string
				Character t = halves_queue.dequeue();
				
				if(!temp.equals(t))
					result = false;
					
				i++;
			}
		}			
		else
			result = false;
        
		
		return result;
	}
}

/**
 * 
 * Queues implemented by arrays whose element type is E  
 */
class QueueArr<E>
{
    private E a[];
    private int front, rear;

    /**
     * 
     * Constructor: create an empty queue with the specified size 
     */
    public QueueArr(int size)
    {
        a = (E[]) new Object[size];         // can store at most (size) number of elements
        front = rear = -1;                  // empty queue: no item in the queue yet
    }

    /**
     * 
     * Return true if the queue is already full 
     */
    public boolean isFull()
    {
        return ((rear + 1) % a.length == front);
    }

    /**
     * 
     * Return true if the queue is empty
     */
    public boolean isEmpty()
    {
        return (front == -1);
    }

    /**
     * 
     * Return true if the enqueue operation completes successfully
     */
    public boolean enqueue(E item)
    {
        if (!isFull())
        {
            a[(rear+1) % a.length] = item;
            rear = (rear+1) % a.length;

            if (front == -1)    front = 0;
            
            return true;
        }
        else
        {
            System.out.println("Queue is full. Enqueue failed.");
            return false;
        }
    }

    /**
     * Take item from the front 
     * Return the item if the operation completes successfully
     *        null to indicate the operation failed
     */
    public E dequeue()
    {
        if (!isEmpty())
        {
            boolean flag = false;        // more than one item in the queue
            if (front == rear)  flag = true;

            E item = a[front];
            front = (front + 1) % a.length;

            if (flag)      front = rear = -1;
            return item;
        }
        else
        {
            System.out.println("Queue is empty. Dequeue failed.");
            return null;
        }
    }

    /**
     * 
     * Peek at the item at the front 
     * Return the item if the operation completes successfully
     *        null to indicate the operation failed
     */
    public E peekFront()
    {
        if (!isEmpty())
            return a[front];
        else
        {
            System.out.println("Peek front failed! ");
            return null;
        }
    }

    /**
     * 
     * Peek at the item at the rear 
     * Return the item if the operation completes successfully
     *        null to indicate the operation failed
     */
    public E peekRear()
    {
        if (!isEmpty())
            return a[rear];
        else
        {
            System.out.println("Peek rear failed");
            return null;
        }
    }

    /**
     * 
     * Return the number of items that are currently in the queue 
     */
    public int queueCount()
    {
        if (!isEmpty())
        {
            if (rear >= front)
                return rear - front + 1;
            else
                return rear + 1 + (a.length - front);
        }
        else
             return 0;

    }
}