/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . FinalP1.java
 * to run the program, execute:
 *		java finalp1.FinalP1
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac FinalP1.java
 * to run the program, execute:
 *		java FinalP1
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java FinalP1.java
 * this command will not run the program if the main class is after a different class definition
 * alternative compile options
 * list what the compiler is doing
 * javac -d . FinalP1.java -verbose
 *
 * to list warning details
 * javac -d . FinalP1.java -Xlint:unchecked
 */
package finalp1;

/***************
 * @programmer: Cruz Macias
 * @contributor(s): Dr. Yang
 ***************/

import java.util.Scanner;
import java.lang.Math;

public class FinalP1 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
		Heap cHeap = new Heap(100);
		
        int option;
        do
        {
            System.out.println("Select from:\n1. Read items and build heap\n2. Display heap\n3. Insert a node\n4. Remove the largest node\n5. Search for a key\n0. Exit");
            option = input.nextInt();
            switch (option)
            {
                case 1:
					cHeap.build();
                    break;
                case 2:
					cHeap.displayBreadthFirst();	
                    break;
                case 3:
                    cHeap.insert();
                    break;
                case 4:
                    cHeap.remove();
                    break;
                case 5:
                    cHeap.search();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!  Try again: ");
            }
            
        } while (option != 0);
        
        System.out.println("Thanks for using my program.");
    } // End main class    
} //End Example16Heap class



/**
 * 
 * Assume all items in the heap are non-negative
 */
class Heap
{
    private int n;
    private int a[];

    public Heap(int size)
    {
        a = new int[size];
		n = 0;                      // initialized with an empty heap
        
        //build();                    // build the heap: bottom-up approach
    }

    public void build()
    {
        // In the homework assignment, need to remove the above 11 statements and replace them with your own code that
        // 1) ask the user to enter non-negative integers (negative to stop)
        // 2) use the entered non-negative integers to build a heap using the algorithm discussed in class
		Scanner input = new Scanner(System.in);

        int temp;
		int idx = 0;

		System.out.print("Enter keys (negative to stop): ");

		// insert nodes without worrying about the heap condition
        while (true)
        {
            temp = input.nextInt();
            
			if (temp < 0)    break;
                
			a[idx] = temp;          // insert a new node
			
			idx++;
        }	
		
		System.out.println();
		n = idx; // assign the size of the heap to class member
		// recover the heap condition from bottom up
		while(true)
		{
			if (idx < 0) break;
			
			downHeap(idx);
			idx--;
		}			
    }
    
    public boolean isEmpty()
    {
        return (n == 0);
    }
    
    /**
     * 
     * Remove the root from the heap
     */ 
    public int remove()
    {
        int key = a[0];
        a[0] = a[n-1];
        n --;
        
        downHeap(0);

        return key;
    }

    /**
     * 
     * if node a[i] is smaller than some of its children, 
     * move it down the heap until the heap condition is recovered, or it reaches the leaf 
     */
    public void downHeap(int i)
    {
        int key = a[i];
        
        int ci = maxChild(i);       // index of the larger child of a[i], if exists
        while (ci != -1)            // has not arrived at a leaf node yet
        {
            if (key >= a[ci])       // no less than the bigger child
                break;              // stop down heap adjustment

            a[i] = a[ci];
            i = ci;
            ci = maxChild(i);
        }
        a[i] = key;
    }

    /**
     * 
     * Return the index of the larger child of node a[i]
     * Return -1 if a[i] has no children
     */
    public int maxChild(int i)
    {
        if (2 * i + 1 >= n)                     // no children
            return -1;
        else if (2 * i + 2 >= n)                // no right child
            return 2 * i + 1;
        else if (a[2 * i + 1] >= a[2 * i + 2])	// have two children and left child is larger
            return 2 * i + 1;
        else					// right child is larger
            return 2 * i + 2;
    }
	
    /**
     * Display the contents of the Heap using breadth-first traversal
     */
	public void displayBreadthFirst()
	{
		/*for(int j = 0; j < n; j++)
			System.out.println("a[" + j + "] = " + a[j]);*/
		
		int e = 0;
		int fe;
		
		System.out.println("Heap:");
		for(int i = 0; i < n; i++)
		{	
			System.out.print(a[i] + " ");		
			
			if(i == (2*(Math.pow(2, e)-1))) //print a newline at the end of each level of the heap
			{
				System.out.println();
				e++;
			}
		}
		
		System.out.println();
	}
	
    /**
     * Insert a new node into the heap
     */
	public void insert()
	{
		Scanner input = new Scanner(System.in);

        int temp;
		int idx = n;
		System.out.print("Enter a non-negative integer to be inserted: ");

		// insert nodes without worrying about the heap condition
		temp = input.nextInt();
            
		if (temp < 0)
			System.out.println("Invalid option!  Try again: ");
        else
		{
			a[n] = temp;         // insert a new node
			n++;
		}
		
		System.out.println();
		// recover the heap condition from bottom up
		while(true)
		{
			if (idx < 0) break;
			
			downHeap(idx);
			idx--;
		}	
	}
	
	
    /**
     * Search the heap for a specified key and print the index of the key in the array
     * Implement a recursive approach to search for the given key in a sorted array using binary search algorithm
     * Search the heap for a specified key and print the index of the key in the array
     */    
    public void search()
    {
		Scanner input = new Scanner(System.in);
		int result = -1;
        int temp;
		System.out.print("Enter the key to be searched for: ");
		temp = input.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			if(a[i] == temp)
				result = i;
		}
		
		if (result < 0)
			System.out.println(temp + " NOT found");
		else
			System.out.println(temp + " found at index " + result);

	}
}

