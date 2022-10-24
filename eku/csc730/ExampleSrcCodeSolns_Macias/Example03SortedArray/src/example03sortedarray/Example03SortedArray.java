/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . Example03SortedArray.java
 * to run the program, execute:
 *		java example03sortedarray.Example03SortedArray
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac Example03SortedArray.java
 * to run the program, execute:
 *		java Example03SortedArray
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java Example03SortedArray.java
 * this command will not run the program if the main class is after a different class definition
 */
package example03sortedarray;

/**
 *
 * @author Yang
 * @revisions: Cruz Macias
 */

import java.util.Scanner;

public class Example03SortedArray 
{
    public static void main(String[] args)
    {
        int arrSize = 5;
		int arr2size = 4;
        SortedArray arr = new SortedArray(arrSize);
        SortedArray arr2 = new SortedArray(arr2size);
		SortedArray arr_merge = new SortedArray(arrSize + arr2size);
		
        // insert some elements
        arr.insert(2);
        arr.insert(5);
        arr.insert(7);
        arr.insert(9);
        arr.insert(12);

        // insert some elements
        arr2.insert(1);
        arr2.insert(3);
        arr2.insert(9);
        arr2.insert(15);

		System.out.println("Before the merge: ");
		System.out.println("arr: ");
        arr.display();                      // display all elements in the array
		System.out.println("arr2: ");
		arr2.display();
		System.out.println("arr_merge: ");
		arr_merge.display();
        
		arr_merge = arr.merge(arr2);
		
        /*int key = 55;
        int idx = arr.binarySearch(key);    // search for 66 in the array
        if (idx < 0)                
            System.out.println(key + "Cannot find " + key);
        else
            System.out.println(key + " was found at index: " + idx);

        key = 33;                           // delete 55 from the array
        if (!arr.delete(key))        
            System.out.println(key + " not found. Deletion failed!");
        else
            System.out.println(key + " has been removed!");*/
        
		System.out.println("After the merge: ");
		System.out.println("arr: ");
        arr.display();   
		System.out.println("arr2: ");
		arr2.display();
		System.out.println("arr_merge: ");
		arr_merge.display();
    }
}

/**
 * 
 * SortedArray class that implements sorted arrays
 * Assumptions:
 * - Elements are sorted in increasing order
 * - Elements in the arrays are non-negative
 * - All elements in an array are distinct 
 */
class SortedArray
{
    private int a[];            // a: reference to an array
    private int n;              // number of elements that are currently in the array
    
    /** 
     * 
     * Constructor: create an array with the specified size and 0 element
     */
    public SortedArray(int size)
    {
        a = new int[size];
        n = 0;
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
     * Insert a given key into the array
     * Return: true if the insertion completes successfully
     *         false if the array is already full and has no room for a new element
     */
    public boolean insert(int key)
    {
        if (n == a.length)
        {
            System.out.println("Array is already full. Insertion failed!");
            return false;
        }
        
        int i;                           
        for (i = n - 1; i >= 0; i --)
        {   
            if (key < a[i])             
            {
                a[i + 1] = a[i];    // shift a[i] right for one position if it is greater than the key
            }
            else
                break;              
        }
        a[i + 1] = key;
                
        n ++;
        
        return true;
    }
    
    /**
     * 
     * Search for a given key using the binary search algorithm
     * Return: index (0 ~ n-1) of the key if it is found 
     *         -1 if the key is not found
     */
    public int binarySearch(int key)
    {
        int left = 0, right = n - 1;
        int middle;
        
        while (true)
        {   // search for the key among a[left] ~ a[right]
                        
            if (left > right)           // key cannot be found
                return -1;  
            
            middle = (left + right) / 2;
            if (key == a[middle])
                return middle;
            else if (key < a[middle])
                right = middle - 1;     // key may be found among a[left] ~ a[middle-1]
            else
                left = middle + 1;      // key may be found among a[middle+1] ~ a[right]
        }
    }
    
    /**
     * 
     * Delete a given key from the array
     * Return: true if the deletion completes successfully
     *         false if the key is not found and therefore cannot be removed from the array
     */
    public boolean delete(int key)
    {
        int i = binarySearch(key);      // i: index of the key if it is found
        
        if(i < 0)                      // key was not found 
            return false;
        
        // shift every element among a[i+1] ~ a[n-1] left for one position
        for(int j = i + 1; j < n; j++)        
            a[j - 1 ] = a[j];              
        
        n--;                            
        
        return true;
    }
    
    /**
     * 
     * Read elements from user input until a negative number is entered
     */
    public void read()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter elements (negative to end): ");
        int i;
        for (i = n; i<a.length; i++)        // allow at most a.length elements to be stored into the array
        {
            int e = input.nextInt();
            
            if (e >= 0)
                insert(e);                  // store a non-negative number into the array
            else
                break;
        }
    }
    
    /**
     * 
     * Practice problem 1:
     * Write a function to merge the array with another array
     * For example, the current array contains 2 5 7 9 12
     * Merging it with another array 1 3 9 15 will 
     * result in a new array 1 2 3 5 7 9 12 15
     */
	 
	 public SortedArray merge(SortedArray parray)
	 {
		int val1, val2;
		SortedArray merge_arr = new SortedArray(n + parray.n);
		
		// insert the elements in the array a
		for(int x = 0; x < n; x++)
		{
			val1 = a[x];
			merge_arr.insert(val1);
		}
		
		// assign the values in array parray 
		for(int y = 0; y < parray.n; y++)
		{
			val2 = parray.a[y];
			merge_arr.insert(val2);
		}
		
		// sort the new merged array
		/*for (int i = 0; i < (merge_arr.n - 1); i++)
        {   // look at the sub-array
		
			// verfiy the smallest element in the sub-array, among a[i] ~ a[n-1]
            int idxMin = i;                     // idxMin: index of the minimum element among a[i] ~ a[n-1]
            for (int j = i; j < merge_arr.n; j ++)
            {
                if (merge_arr.a[j] < merge_arr.a[idxMin])           // a smaller element, a[j], is found
                    idxMin = j;
            }

			// place the smallest value at the front of the sub-array
			// swap a[i] with a[idxMin]
			// this sorts the array
            int t = merge_arr.a[i];
            merge_arr.a[i] = merge_arr.a[idxMin];
            merge_arr.a[idxMin] = t;
		}*/
		
		// delete duplicate values
		for(int j = 0; j < (merge_arr.n - 1); j++)					// loop through sorted array and compare adjacent elements
		{
			if(merge_arr.a[j] == merge_arr.a[j+1])
			{
				// if values match, delete one
				for(int k = (j + 1); k < (merge_arr.n - 1); k++)				// move higher ones down
					merge_arr.a[k] = merge_arr.a[k+1];
				
				merge_arr.n--;									// decrement size
				j--; 									// decrement counter and check the same two elements again as the array has decreased 
			}
		}
		
		return merge_arr;
	 }
    
}
