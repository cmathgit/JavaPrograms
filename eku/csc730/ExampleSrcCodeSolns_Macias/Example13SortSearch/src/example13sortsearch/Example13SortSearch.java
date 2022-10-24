/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . Example13SortSearch.java
 * to run the program, execute:
 *		java example13sortsearch.Example13SortSearch
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac Example13SortSearch.java
 * to run the program, execute:
 *		java Example13SortSearch
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java Example13SortSearch.java
 * this command will not run the program if the main class is after a different class definition
 * alternative compile options
 * list what the compiler is doing
 * javac -d . Example13SortSearch.java -verbose
 *
 * to list warning details
 * javac -d . Example13SortSearch.java -Xlint:unchecked
 */
package example13sortsearch;

/**
 * @revisions: Cruz Macias
 * @author Yang
 */

import java.util.Scanner;
import java.util.Random;

public class Example13SortSearch 
{
    public static void main(String[] args)
    {
        int arrSize = 20;                      // size of the array
        MyArray arr = new MyArray(arrSize);
        
        Scanner input = new Scanner(System.in);
        int option;
        do
        {
            // menu of options for uses to choose from
            System.out.println("Select from:\n1. Read Array\n2. Generate Array\n3. Print Array\n4. Sort\n5. Search\n0. Quit");
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
                case 5: 
                    searchArray(arr);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!  Try again: ");
            }
        } while (option != 0);
        
        System.out.println("Thanks for using my program.");        
    }
	
    static void sortArray(MyArray ar)
    {
        Scanner input = new Scanner(System.in);
        int sortOption;
        do
        {
            System.out.println("Select from:\n1. Bubble sort\n2. Selection sort\n3. Insertion sort\n0. Quit");
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
                case 0:
                    break;
                default:
                    System.out.println("Invalid sort option!  Try again: ");
            }
        } while (sortOption != 0);
    }
	
    static void searchArray(MyArray ar)
    {
        Scanner input = new Scanner(System.in);
        int sortOption;
		int key;
		int idx;
		int max;
        do
        {
            System.out.println("Select from:\n1. Binary Search\n2. Greatest Search \n0. Quit");
            sortOption = input.nextInt();
            switch (sortOption)
            {
                case 1:
                    System.out.print("Enter a key: ");
                    key = input.nextInt(); 
                    idx = ar.binarySearch(key);
                    if (idx < 0)
                        System.out.println(key + " is not found!");
                    else
                        System.out.println(key + " is found at index " + idx);
                    break;
                case 2:
                    System.out.print("Searching for the greatest element in the array.\n");
                    max = ar.getMax();
                    if (max < 0)
                        System.out.println("error: array out of bounds");
                    else
                        System.out.println(max + " is the max element.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid sort option!  Try again: ");
            }
        } while (sortOption != 0);
    }
}

/**
 * 
 * MyArray class implements basic searching and sorting algorithms on arrays
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
        for (i = 0; i < a.length; i++)      // allow at most a.length elements to be stored into the array
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
     * Implement a recursive approach to sorting array elements into non-decreasing order using insertion sort algorithm
     */
    public void insertionSort()
    {
        insertionSort(n - 1);           // sort elements a[0] ~ a[n-1]
    }
    
    /**
     * 
     * Recursive helper function 
     * Sort elements a[0] ~ a[right] into non-decreasing order using insertion sort algorithm
     */
    public void insertionSort(int right)
    {
        // base case ................................
        if (right == 0)             // Need to do nothing for sorting one single element: a[0]
            return;

        // general case .............................

	
        // First of all, sort elements a[0] ~ a[right-1] 
        insertionSort(right-1);      

        // Then insert a[right] to the appropriate place among a[0] ~ a[right-1]
        int t = a[right];         
        int i = right-1;
        while (i >= 0)
        {
            if (a[i] > t)
            {
                a[i+1] = a[i];
                i--;
            }
            else	break;
        }

        a[i+1] = t;
    }

    /**
     * 
     * Implement a recursive approach to search for the given key in a sorted array using binary search algorithm
     */    
    public int binarySearch(int key)
    {
        return binarySearch(key, 0, n - 1);
    }
    
    /**
     * 
     * Recursive helper function 
     * Search for the given key among elements a[left] ~ a[right]
     */
    public int binarySearch(int key, int left, int right)
    {
        if (left > right)
            return -1;
        
        int middle = (left + right) / 2;
        if (key == a[middle])
            return middle;
        else if (key < a[middle])
            return binarySearch(key, left, middle - 1);     // key may be found among a[left] ~ a[middle-1]
        else
            return binarySearch(key, middle + 1, right);    // key may be found among a[middle+1] ~ a[right]
    }

    /**
     * 
     * Practice problem:
     * Implement a recursive approach to sorting array elements into non-decreasing order using bubble sort algorithm
     */
    public void bubbleSort()
    {
        bubbleSort(n - 1);           // sort elements a[0] ~ a[n-1]
    }
    
    /**
     * 
     * Recursive helper function 
     * Sort elements a[0] ~ a[right] into non-decreasing order using bubble sort algorithm
     */
    public void bubbleSort(int right)
    {
        // base case ................................
        if (right == 0)             // Need to do nothing for sorting one single element: a[0]
            return;

        // general case .............................

	
		// first of all, move the largest element into the a[right] by swapping between neighbors if they are out of order
		boolean swapped = false;
		for (int j = 0; j < right; j++)
		{
			if (a[j] > a[j + 1])
			{
				int t = a[j];
				a[j] = a[j + 1];
				a[j + 1] = t;
				swapped = true;
			}
		}
	
		// Then sort elements a[0] ~ a[right - 1] if necessary
		if (swapped)
			bubbleSort(right - 1);
	
        // First of all, sort elements a[0] ~ a[right-1] 
        /*bubbleSort(right-1);      

        // Then swap a[i] and a[i+1] a[0] ~ a[right-1]
		
        int i = 0;
        while (i <= right)
        {
            if (a[i] > a[i+1])
            {
				int t = a[i];
				a[i] = a[i+1];
				a[i+1] = t;
            }
			
			i++;
        }*/
    }
    
    /**
     * 
     * Practice problem:
     * Implement a recursive approach to sorting array elements into non-decreasing order using selection sort algorithm
     */
    public void selectionSort()
    {
        selectionSort(0);           // sort elements a[0] ~ a[n-1]
    }
    
    /**
     * 
     * Recursive helper function 
     * Sort elements a[0] ~ a[right] into non-decreasing order using selection sort algorithm
     */
    public void selectionSort(int left)
    {
		// base case ................................
		if(left == n - 1) // need to do nothing for sorting one single element: a[n-1]
			return;
		
		// general case .............................
		
		// first of all, find the smallest element among a[left] ~a[n-1] and then swap it with a[left]
		int idxMin = left; // idxMin: index of the minimum element among a[left] ~ a[n-1]
		for (int j = left + 1; j < n; j++)
		{
			if (a[j] < a[idxMin]) // if a smaller element is found, store its index
				idxMin = j;
		}
		int t = a[left];
		a[left] = a[idxMin];
		a[idxMin] = t;
		
		// then sort the elements a[left+1] ~ a[n-1]
		selectionSort(left + 1);
		
        // base case ................................
        /*if (left == n)             // Nreached end of array
            return;

        // general case .............................

	
        // First of all, sort elements a[0] ~ a[right-1] 
        selectionSort(left+1);      

        // Then swap a[i] and a[i+1] a[0] ~ a[right-1]
		
        int i = left;
		int idxMax = i;
		for(int j = 0; j < i+1; j++)
		{
			if(a[j] > a[idxMax]) //greater element in sub-array found
				idxMax = j;
		}
		
		//swap a[i] with a[idxMax]
		int t = a[i];
		a[i] = a[idxMax];
		a[idxMax] = t;*/
		
    }
   
    
    /**
     * 
     * Practice problem:
     * Implement a recursive approach to finding the greatest element in the array without sorting the elements
     */
    public int getMax()
	{
		return getMax(0, n - 1);
	}
	
	public int getMax(int left, int right)
	{
		if (left > right)
			return -1;
		
		if (left == right)
			return a[left];
		
		int middle = (left + right) / 2;
		int t1 = getMax(left, middle);
		int t2 = getMax(middle + 1, right);
		
		if (t1 >= t2)
			return t1;
		else
			return t2;
	}
}

