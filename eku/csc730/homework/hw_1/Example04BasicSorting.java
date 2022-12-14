/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . Example04BasicSorting.java
 * to run the program, execute:
 *		java example04basicsorting.Example04BasicSorting
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac Example04BasicSorting.java
 * to run the program, execute:
 *		java Example04BasicSorting
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java Example04BasicSorting.java
 * this command will not run the program if the main class is after a different class definition
 */
package example04basicsorting;

/**
 *
 * @author Yang
 * @revisions: Cruz Macias
 */

/**
 * 
 * Implement basic sorting algorithms
 * Assumptions:
 * - All elements in the array are non-negative
 */

import java.util.Scanner;
import java.util.Random;

public class Example04BasicSorting 
{
    public static void main(String[] args)
    {
        int arrSize = 100;                      // size of the array
        MyArray arr = new MyArray(arrSize);
        
        Scanner input = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("Select from:\n1. Read Array\n2. Generate Array\n3. Print Array\n4. Sort\n0. Quit");
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
                    sortArray(arr);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!  Try again: ");
            }
            
        } while (option != 0);
        
        System.out.println("Thanks for using my program.");
    } // end main class
    
    static void sortArray(MyArray ar)
    {
        Scanner input = new Scanner(System.in);
        int sortOption;
        do
        {
            System.out.println("Select from:\n1. Bubble sort\n2. Selection sort\n3. Insertion sort\n4. Odd Even Sort\n5. Deletion Sort \n0. Quit");
            sortOption = input.nextInt();
            switch (sortOption)
            {
                case 1:
                    ar.bubbleSort();
                    break;
                case 2:
                    ar.selectionSort();
                    break;
                case 3:
                    ar.insertionSort();
                    break;
                case 4:
                    ar.oddevenSort();
                    break;
                case 5:
                    ar.deletionSort();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid sort option!  Try again: ");
            }
        } while (sortOption != 0);
    } // end sortArray class
} // end Example04BasicSorting class

/**
 * 
 * MyArray class that includes basic sorting algorithms implemented
 */
class MyArray
{
    private int a[];            // a: reference to an array
    private int n;              // number of elements that are currently in the array
    
    /**
     *
     * Constructor: create an array with the specified size and 0 element
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
     * Randomly generate non-negative numbers and store them into the array
     */
    void randGenerate()
    {
        Random rand = new Random();
        
        n = rand.nextInt(a.length + 1);     // number of elements: [0, a.length]
        for (int i = 0; i < n; i++)
            a[i] = rand.nextInt(20);        // random integer: [0,19]
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
     * Use bubble sort algorithm to sort elements in non-decreasing order
     */
    public void bubbleSort()
    {
		// Revised Code
		boolean swapped = false;                // false: no swap happened during the current round
	
        for (int i = 0; i < n - 1; i++)  	
        {   // look at the sub-array from a[i] ~ a[n - 1]	
	
           for (int j = n - 1; j > i; j--)		// move smallest value to the front of the sub-array by necesary swapping
            {									// compare the last element in the sub-array with the element prior and swap if smaller
              if (a[j - 1] > a[j])
               {
                    int t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                    swapped = true;
               }	   
            }
			
           if (!swapped)                       // already sorted
				break;
            
			swapped = false;
        }
		
		/**
		* Original Code
		**/
       /* boolean swapped = false;                // false: no swap happened during the current round
        
        for (int i = n - 1; i > 1; i --)             
        {   // move the largest element among a[0] ~ a[i] into a[i] by swapping
            
            for (int j = 0; j < i; j++)         // swap A[j] and A[j+1], if necessary
            {
                if (a[j] > a[j + 1])
                {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    swapped = true;
                }
            }
            
            if (!swapped)                       // already sorted
                break;
            
            swapped = false;
        }*/
    }
    
    /**
     * 
     * Use selection sort algorithm to sort elements in non-decreasing order
     */
    public void selectionSort()
    {
		// Revised Code
        for (int i = n - 1; i > -1; i--)    			
        {   // find the smallest element among a[0] ~ a[i] and then swap it with a[i]
	
            
            int idxMax = i;                     // idxMax: index of the maximum element among a[0] ~ a[i]
            for (int j = 0; j < i + 1; j ++)
            {
                if (a[j] > a[idxMax])           // a larger element, a[j], is found
                    idxMax = j;
            }

            // swap a[i] with a[idxMax]
            int t = a[i];
            a[i] = a[idxMax];
            a[idxMax] = t;			
        }
		
		/**
		* Original Code
		**/
        /*for (int i = 0; i < n; i ++)        
        {   // find the smallest element among a[i] ~ a[n-1] and then swap it with a[i]
            
            int idxMin = i;                     // idxMin: index of the minimum element among a[i] ~ a[n-1]
            for (int j = i + 1; j < n; j ++)
            {
                if (a[j] < a[idxMin])           // a smaller element, a[j], is found
                    idxMin = j;
            }
            
            // swap a[i] with a[idxMin]
            int t = a[i];
            a[i] = a[idxMin];
            a[idxMin] = t;
        }*/
    }
    
    /**
     * 
     * Use insertion sort algorithm to sort elements into non-decreasing order
     */
    public void insertionSort()
    {
		// Revised Code
        for (int i = n - 1; i > 0; i--)           
        {   // insert a[i] into a[n - 1] ~ a[i] so that a[n - 1] ~ a[i] become sorted
            int t = a[i - 1];
            int j;
			for (j = i; j < n; j++)
            {
                if (t > a[j])
                    a[j - 1] = a[j];
				else
                    break;
            }
            a[j - 1] = t;
        }
		/**
		* Original Code
		**/
        /*for (int i=1; i < n; i++)           
        {   // insert a[i] into a[0] ~ a[i-1] so that a[0] ~ a[i] become sorted
            
            int t = a[i];
            int j;
            for (j = i - 1; j >= 0; j --)
            {
                if (t < a[j])
                    a[j+1] = a[j];
                else
                    break;
            }
            a[j + 1] = t;
        }*/
    }
	
    /**
     * 
     * Use odd-even sort algorithm to sort elements into non-decreasing order
	 * make two passes through the array
	 * on the first pass, compare key values for adjacent indices j and j+1 where j is odd (j = 1, 3, 5, ...)
	 * if the values are unsorted, swap them
	 * on the second pass, compare key values for adjacent indices j and j+1 where j is even (j = 0, 2, 4, ...)
	 * if the values are unsorted, swap them
	 * repeat this process until the array is sorted
     */
    public void oddevenSort()
    {
		boolean swap_odd = true; // initialize odd pass flag for while loop 
		boolean swap_even = true; // initialize even pass flag for while loop 
		
		while(swap_odd || swap_even) // loop until no items are swapped
		{
			
			// reset the odd pass and even pass swap counters
			int count_odd_swaps = 0; // track the number of times an odd key pair is swapped
			int count_even_swaps = 0; // track the number of times an even key pair is swapped
			swap_odd = true; 			// reset the odd pass flag 
			swap_even = true; 			// reset the even pass flag 
			
			for(int i = 0; i < n - 1; i++) // check odd pass
			{
				if((i % 2) == 0) // check if i is even
				{
					// do nothing
				}
				else // i is odd
				{
					if(a[i] > a[i + 1])
					{
						// swap a[i] with a[i+1]
						int t = a[i];
						a[i] = a[i+1];
						a[i+1] = t;	
						
						count_odd_swaps++; // increment the odd counter any time an odd key pair is swapped
					}

					// else no swap occurred
					// do nothing
				}
			}
			
			if(count_odd_swaps == 0) // if an odd key pair swap did not occur even once, set the odd pass flag to false
				swap_odd = false;
			
			for(int i = 0; i < n - 1; i++) // check even pass
			{
				if((i % 2) == 1) // check if i is odd
				{
					// do nothing
				}
				else // i is even
				{
					if(a[i] > a[i + 1])
					{
						// swap a[i] with a[i+1]
						int t = a[i];
						a[i] = a[i+1];
						a[i+1] = t;	

						count_even_swaps++; // increment the even counter any time an even key pair is swapped
					}
					
					// else no swap occurred
					// do nothing
				}
			}
		
			if(count_even_swaps == 0) // if an even key pair swap did not occur even once, set the even pass flag to false
				swap_even = false;
		} // end while loop, if any swap occurred, continue the loop, else exit the loop
    }
    
    /**
     * 
     * Practice problem 1:
     * Write a function to remove duplicate from the array
     * For example, if the array contains 8 5 12 15 7 3 8 15 30 15
     * After calling the function, the array will become 3 5 7 8 12 15 30
     */
    public void deletionSort()
	{
        for (int i = 0; i < n - 1; i++)  // sort the array	
        {   // look at the sub-array
		
			// verfiy the smallest element in the sub-array, among a[i] ~ a[n-1]
            int idxMin = i;                     // idxMin: index of the minimum element among a[i] ~ a[n-1]
            for (int j = i; j < n; j ++)
            {
                if (a[j] < a[idxMin])           // a smaller element, a[j], is found
                    idxMin = j;
            }

			// place the smallest value at the front of the sub-array
			// swap a[i] with a[idxMin]
			// this sorts the array
            int t = a[i];
            a[i] = a[idxMin];
            a[idxMin] = t;
		}
		
		// delete duplicate values
		for(int j = 0; j < n - 1; j++)					// loop through sorted array and compare adjacent elements
		{
			if(a[j] == a[j+1])
			{
				// if values match, delete one
				for(int k = (j + 1); k < n; k++)				// move higher ones down
					a[k] = a[k+1];
				
				n--;									// decrement size
				j--; 									// decrement counter and check the same two elements again as the array has decreased 
			}
		}
		
	}
	
} // end MyArray class
