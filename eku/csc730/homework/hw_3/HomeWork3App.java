/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . HomeWork3App.java
 * to run the program, execute:
 *		java homework2app.HomeWork2App
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac HomeWork3App.java
 * to run the program, execute:
 *		java HomeWork3App
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java HomeWork3App.java
 * this command will not run the program if the main class is after a different class definition
 * alternative compile options
 * list what the compiler is doing
 * javac -d . HomeWork3App.java -verbose
 *
 * to list warning details
 * javac -d . HomeWork3App.java -Xlint:unchecked
 */
package homework3app;

/***************
 * @programmer: Cruz Macias
 * @contributor(s): Dr. Yang
 ***************/

/**
 * Objective: Implement priority queues using linked lists, and 
 *			  then use a priority queue to help sort a given group 
 *			  of integer numbers into non-increasing order. 
 * Assumptions:
 * 1. All keys in the priority queue are non-negative.
 * 2. Duplicated keys are allowed in a priority queue
 */

import java.util.Scanner;
import java.util.Random;

public class HomeWork3App
{
    public static void main(String [] args)
    {
        MyPriorityQueueLinkedList my_adt = new MyPriorityQueueLinkedList();
		Scanner input = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("Select from:\n1. Read Keys\n2. Generate Keys\n3. Sort\n0. Quit");
            option = input.nextInt();
            switch (option)
            {
                case 1:
                    my_adt.read();
                    break;
                case 2:
					int no_keys;
					System.out.print("Enter the number of keys: ");
					no_keys = input.nextInt();
                    my_adt.randGenerate(no_keys);
					System.out.println();
                    break;
                case 3:
                    my_adt.sortADT();
					System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!  Try again: ");
            }
            
        } while (option != 0);
        
        System.out.println("Thanks for using my program.");
		
		
		
		//System.out.println(PQ_LL.isEmpty());
		
	} // end main class	
} // end class HomeWork3App

/**
 * 
 * MyPriorityQueueLinkedList class that includes read(), generate(), and sort() implemented
 */
class MyPriorityQueueLinkedList
{
    private PriorityQueueLinkedList pq_ll;   // a reference to a PriorityQueueLinkedList
    private int nkey;              // number of keys to generate the Priority Queue ADT implemented as a Linked List
    
    /**
     *
     * Constructor: create a Priority Queue ADT implemented as a Linked List
     */
    public MyPriorityQueueLinkedList()
    {
        pq_ll = new PriorityQueueLinkedList();
        nkey = 0;
    }
    
    /**
     * 
     * Read elements from user input into the PriorityQueueLinkedList object until a negative number is entered
     */ 
    public void read()
    {		
		Scanner input = new Scanner(System.in);
        int k;                      // key 

		System.out.print("Enter keys (negative to stop): ");

        while (true)
        {
            k = input.nextInt();
            //System.out.print(k + " ");
			
			if (k < 0)    break;
                
            pq_ll.enqueue(k);           // insert a new node
			
			//System.out.println(pq_ll.peekFront());
        }	
		
		System.out.println();
    }
    
    /**
     * 
     * Randomly generate non-negative numbers and store them into the PriorityQueueLinkedList object
     */
    void randGenerate(int n)
    {
        Random rand = new Random();

		System.out.print("The following keys have been generated: ");
        for (int i = 0; i < n; i++)
        {
			nkey = rand.nextInt(n);     // number of keys: [0, n]
			
            System.out.print(nkey + " ");
                
            pq_ll.enqueue(nkey);           // insert a new node
			
			//System.out.println(pq_ll.peekFront());
        }	
		
		System.out.println();
    }
	
    /**
     * 
     * Use isEmpty() and dequeue() functions to output the keys in non-increasing order (sorted in the enqueue() function)
     */
    public void sortADT()
    {
		while(!pq_ll.isEmpty())
		{
			//System.out.println(pq_ll.peekFront());			
			System.out.print(pq_ll.dequeue() + " ");
		}
		System.out.println();
    }
	
} // end class 


/**
 * 
 * Node in PriorityQueueLinkedList
 * @contributor(s): Dr. Yang
 */
class Node
{
    private int     key;    // key of the node
    private String  data;   // data in the node
    private Node    next;   // reference to the next node in linked list

    /**
     * 
     * Constructor: create a node with k as its key, and d as its data 
     */
    public Node(int k, String d)     
    {
        key = k;
        data = d;
        next = null;        
    }

    public int getKey()
    {
        return key;
    }

    public String getData()
    {
        return data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setKey(int k)
    {
        key = k;
    }

    public void setData(String d)
    {
        data = d;
    }

    public void setNext(Node n)
    {
        next = n;
    }
}

/***************
 * PriorityQueueLinkedList class definition
 * @programmer: Cruz Macias
 * @contributor(s): Dr. Yang
 ***************/
class PriorityQueueLinkedList
{
	private Node front; // reference to the front

	public PriorityQueueLinkedList()
	{
		front = null;
	}

	public boolean isEmpty()
	{
		return (front == null);
	}

	public void enqueue(int k)
	{
        ReferencePair rp = new ReferencePair(null, front);   // start from beginning of  list
        
        while (rp.current != null)                          // not the end of list yet
        {
            if (k >= rp.current.getKey())                   // found the location to insert the new node (non-increasing order)
                break;
            
            rp.moveNext();                                  // move to next node
        }
        
        Node newNode = new Node(k, null);                      // create a new node
        
        newNode.setNext(rp.current);
        
        if (rp.previous != null)                            // will become the first node
            rp.previous.setNext(newNode);
        else                                                // will not become the first node
            front = newNode;
		
	}

	public int dequeue()
	{
		if (!isEmpty())
        {
            int key = front.getKey();
            front = front.getNext();
            return key;
        }
        else
        {
            System.out.println("Queue is empty. Dequeue failed.");
            return -1;
        }
	}

	public int peekFront()
	{
		if(!isEmpty())
			return front.getKey();
		else
		{
			System.out.println("Peek front failed!");
            return -1;
		}
	}
}


/**
 * 
 * A pair of references, one to a node (current) and the other to its previous node (previous) in linked list
 * @contributor(s): Dr. Yang
 */
class ReferencePair
{
    public Node previous;       // reference to the previous node
    public Node current;        // reference to the current node

    /**
     * 
     * Constructor: create a pair of references, with both initialized to null
     */
    public ReferencePair()                     
    {
        this(null, null);
    }

    /**
     * 
     * Constructor: create a pair of references initialized to p and c respectively
     */
    public ReferencePair(Node p, Node c)
    {
        previous = p;
        current = c;
    }

    /**
     * 
     * Set the pair of references initialized to p and c respectively
     */
    public void set(Node p, Node c)
    {
        previous = p;
        current = c;
    }

    /**
     * 
     * Update the references to move to the next node in linked list
     */
    public void moveNext()
    {
        if (current != null)
        {
            previous = current;
            current = current.getNext();
        }
    }
}