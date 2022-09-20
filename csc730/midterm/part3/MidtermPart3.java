/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . MidtermPart3.java
 * to run the program, execute:
 *		java midtermpart3.MidtermPart3
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac MidtermPart3.java
 * to run the program, execute:
 *		java MidtermPart3
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java MidtermPart3.java
 * this command will not run the program if the main class is after a different class definition
 * alternative compile options
 * list what the compiler is doing
 * javac -d . MidtermPart3.java -verbose
 *
 * to list warning details
 * javac -d . MidtermPart3.java -Xlint:unchecked
 */
package midtermpart3;

/**
 * @programmer: Cruz Macias
 * Midterm Part 3 Programming Problems
 */
public class MidtermPart3
{
    public static void main(String[] args) 
    {     
		Functions func = new Functions();
		// Example Practice Problem 2
		func.hello();
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


/**
 * 
 * Priority queues implemented by simple arrays  
 * Assume:
 * - All elements in the priority queue will be non-negative integers
 * - The item with the lowest key is always at the front 
 */
class PriorityQueueArr
{
    private int a[];
    private int front;

    /**
     * 
     * Constructor: create an empty queue with the specified size 
     */
    public PriorityQueueArr(int size)
    {
        a = new int[size];          // can store at most (size) number of elements
        front = -1;                 // empty queue: no item in the queue yet
    }

    /**
     * 
     * Return true if the queue is full 
     */
    public boolean isFull()
    {
        return (front == a.length - 1);
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
    public boolean enqueue(int item)
    {
        if (!isFull())
        {
            int i;
            for (i = front; i >= 0; i --)
            {
                if (item > a[i])
                {
                    a[i + 1] = a[i];
                }
                else
                    break;
            }
            a[i + 1] = item;
            front ++;
                        
            return true;
        }
        else
        {
            System.out.println("Queue is full. Enqueue failed.");
            return false;
        }
    }

    /**
     * 
     * Take item from the front
     * Return the item if the operation completes successfully
     *        -1 to indicate the operation failed
     */
    public int dequeue()
    {
        if (!isEmpty())
        {
            int item = a[front];
            front --;
            return item;
        }
        else
        {
            System.out.println("Queue is empty. Dequeue failed.");
            return -1;
        }
    }

    /**
     * 
     * Peek at the item at the front 
     * Return the item if the operation completes successfully
     *        null to indicate the operation failed
     */
    public int peekFront()
    {
        if (!isEmpty())
            return a[front];
        else
        {
            System.out.println("Peek front failed! ");
            return -1;
        }
    }

    /**
     * 
     * Return the number of items that are currently in the queue 
     */
    public int queueCount()
    {
        return front + 1;

    }
}


