/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . HomeWork4App.java
 * to run the program, execute:
 *		java homework4app.HomeWork4App
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac HomeWork4App.java
 * to run the program, execute:
 *		java HomeWork4App
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java HomeWork4App.java
 * this command will not run the program if the main class is after a different class definition
 * alternative compile options
 * list what the compiler is doing
 * javac -d . HomeWork4App.java -verbose
 *
 * to list warning details
 * javac -d . HomeWork4App.java -Xlint:unchecked
 */
package homework4app;

/***************
 * @programmer: Cruz Macias
 * @contributor(s): Dr. Yang
 ***************/

/**
 * Objective: In this project, you will implement a recursive function to find the k-th smallest element
 * in an unsorted array, and then use your function to find the median in the array.
 * Hint: Think about how to modify the recursive function partition(int left, int
 * right) in the example program Example14AdvancedSort and transform it to a
 * recursive function to find the k-th smallest element in an unsorted array.

 * Assumptions:
 * 1. All keys in the unsorted array are non-negative.
 * 2. Duplicated keys are allowed in a unsorted array 
 */

import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class HomeWork4App
{
    public static void main(String [] args)
    {
        int arrSize = 20;                      // size of the array
        MyArray arr = new MyArray(arrSize);
        
        Scanner input = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("Select from:\n1. Read Array\n2. Generate Array\n3. Print Array\n4. Median\n0. Quit");
            option = input.nextInt();
            switch (option)
            {
                case 1:
                    arr.read();
                    break;
                case 2:
                    arr.randGenerate();
                    break;
                case 3:
                    arr.display();
                    break;
                case 4:
                    arr.kthMedian();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!  Try again: ");
            }
            
        } while (option != 0);
        
        System.out.println("Thanks for using my program.");
		
	} // end main class	
} // end class HomeWork4App


/**
 * 
 * MyArray class implements advanced sorting algorithms on arrays
 * Assumptions:
 * - All elements in the array are non-negative
 */
class MyArray
{
    private int a[];            // a: reference to an array
    private int n;              // number of elements that are currently in the array
    
    /**
     *
     * Constructor: create an empty array with the specified size 
     */
    public MyArray(int size)
    {
        a = new int[size];
        n = 0;
    }
    
    /**
     * 
     * Read elements from user input into the array until a negative number is entered
     */ 
    public void read()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter elements (negative to end): ");
        
        int i;
        for (i = 0; i < a.length; i++)        // allow at most a.length elements to be stored into the array
        {
            int e = input.nextInt();
            
            if (e >= 0)
                a[i] = e;                   // store a non-negative number into the array 
            else                        
                break;
        }
        n = i;                              // record the total number of elements that have been stored into the array
        
    }
    
    /**
     * 
     * Randomly generate non-negative integers and store them into the array
     */
    public void randGenerate()
    {
        Random rand = new Random();
        
        n = rand.nextInt(a.length + 1);     // random integer as the number of elements: [0, a.length]
        for (int i = 0; i < n; i++)
            a[i] = rand.nextInt(15);        // random integer as value of an element: [0,14]
    }
    
    /**
     * 
     * Display all elements that are currently in the array
     */
    public void display()
    {
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        
        System.out.println();
    }
    
	
    /**
     * 
     * Recursive helper function
     * Use quick sort algorithm to sort elements a[left] ~ a[right] in non-decreasing order
     */
    public void kthMedian()
    {
       System.out.println("Median (k-th smallest number in the series): " + kthMedian(0, n - 1));
    }
   
	 
    /**
     * 
     * You can use the partitioning strategy of quick sort to find the k-th smallest element in an
	 * array. After finding the pivot and forming the subarrays Smaller and Larger, as shown in the
	 * following figure, you can draw one of the following conclusions:
	 * • If Smaller contains k or more elements, it must contain the k-th smallest element.
	 * • If Smaller contains k-1 elements, the k-th smallest element is the pivot.
	 * • If Smaller contains fewer than k-1 element, the k-th smallest element is in Large.
     */
    public int kthMedian(int left, int right)
    {
		// debug-code
		//System.out.println("left and right are " + left + " and " + right + ", respectively.");
		
		if (left < right)
        {	
	
			// debug-code
			//System.out.println("left and right are " + left + " and " + right + ", respectively.");
            // partition a[left] ~ a[right] and move pivot into a[i], 
            // such that a[left] ~ a[i-1] are no greater than a[i] and 
            // a[i+1] ~ a[right] are no less than a[i]
			int i = partition(left, right);  // potential pivot index
			
			// determine the kth smallest element	
			// We are looking for the ((n+1)/2)-th smallest number if n is odd and n/2 if n is even among the given numbers, where n is the size of given collection.
			double k = (double)n / 2; // if n is even, k will be a whole number, and if n is odd, k will need to be rounded up
			//System.out.println("k is " + k);
			int kth = (int) Math.ceil(k);			// round k up if the operation returns a double
		
			// debug-code
			//System.out.println("i and k are " + i + " and " + kth + ", respectively.");

			// recursively call the function until the k-th smallest index is found, that is, the (n/2)-th smallest index in the series
			if (i > kth) //If Smaller contains k or more elements, it must contain the k-th smallest element
			{
				// debug-code
				//System.out.println("Smaller must contain the k-th smallest element!");
				//  a[left] ~ a[i-1]
				return kthMedian(left, i-1); // Smaller subarray
			}
			else if (i == kth) //If Smaller contains k-1 elements, the k-th smallest element is the pivot
			{
				// debug-code
				//System.out.println("the k-th smallest element, " + i + ", is the pivot!");	
				return a[i-1]; // a[kth-1] is the kth smallest element
			}
			else if (i < kth) //If Smaller contains fewer than k-1 element, the k-th smallest element is in Larger
			{
				// debug-code
				//System.out.println("the k-th smallest element is in Larger!");
				//  a[i+1] ~ a[right]
				return kthMedian(i+1, right); // Larger subarray				
			}
        }
		
		// returnsmallest element is found
		return a[left-1];
    }
  
    /**
     * 
     * Recursive helper function
     * find the kth smallest element in the array. when found, find the median
     */
    public int partition(int left, int right)
    {		
        boolean lr = true;
        
		while (left < right)
		{
			if (a[left] > a[right])
			{	
				int t = a[left];
				a[left] = a[right];
				a[right] = t;
                    
				lr = !lr;
			}
        
			// debug-code
			//System.out.println("left and right are " + left + " and " + right + ", respectively.");
        
			if (lr)	
				right--;
			else		
				left++;	
		}
		
		// debug-code
		//System.out.println("left: " + left);
		return left;
    }    
}


