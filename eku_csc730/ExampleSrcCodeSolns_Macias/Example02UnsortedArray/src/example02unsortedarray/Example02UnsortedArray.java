/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . Example02UnsortedArray.java
 * to run the program, execute:
 *		java example02unsortedarray.Example02UnsortedArray
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac Example02UnsortedArray.java
 * to run the program, execute:
 *		java Example02UnsortedArray
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java Example02UnsortedArray.java
 * this command will not run the program if the main class is after a different class definition
 */
package example02unsortedarray;

/**
 *
 * @author Yang
 * @revisions: Cruz Macias
 */

/**
 * 
 * Encapsulate unsorted arrays and basic operations into a class
 * Assumption:
 * - The arrays are unsorted
 * - All elements in an array are distinct (no duplicated elements exist)
 * - All elements in the arrays are not negative
 */

import java.util.Scanner;

public class Example02UnsortedArray 
{
    public static void main(String[] args)
    {
        int arrSize = 10;
        UnsortedArray arr = new UnsortedArray(arrSize);
        
        // Sequentially insert 6 elements
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(11);
        arr.insert(66);
        arr.insert(33);
        
        arr.display();          // display all elements in the array
        
        int key = 66;           // search for 66
        int idx = arr.search(key);
        if (idx < 0)
            System.out.println(key + " cannot be found.");
        else
            System.out.println(key + " is found at index: " + idx);
        
        key = 18;           // search for 18
        idx = arr.search(key);
        if (idx < 0)
            System.out.println(key + " cannot be found.");
        else
            System.out.println(key + " is found at index: " + idx);
        
        key = 11;               // delete 11 from the array
        if (!arr.delete(key))
            System.out.println(key + " not found. Deletion failed!");
        else
            System.out.println(key + " has been removed!");
        arr.display();          // display all elements in the array
		
		// confirm problem 1 solution
		arr.display(); // show contents of array
		arr.flip(); // call the flip function
		arr.display(); // show contents of updated array
		
		// confirm problem 2 solution
		arr.display(); // show contents of array
		arr.leftRotate(); // call the leftRotate function
		arr.display(); // show contents of updated array
		
		// confirm problem 3 solution
		arr.display(); // show contents of array
		arr.rightRotate(); // call the rightRotate function
		arr.display(); // show contents of updated array
    }
}

/**
 * 
 * UnsortedArray class that include basic operations on unsorted arrays
 */
class UnsortedArray
{
    private int a[];            // a: reference to an array
    private int n;              // number of elements that are currently in the array
    
    /** 
     * 
     * Constructor: create an array with the specified size and 0 element
     */
    public UnsortedArray(int size)
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
        for(int i = 0; i < n; i ++)
            System.out.print(a[i] + " ");
        
        System.out.println();
    }
    
    /**
     * 
     * Search for a given key using the sequential search algorithm
     * Return: index (0 ~ n-1) of the key if it is found 
     *         -1 if the key is not found
     */
    public int search(int key)
    {
        for(int i = 0; i < n; i ++)
            if(a[i] == key)   return i;
        
        return -1;
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
        
        a[n] = key;
        n ++;
        
        return true;
    }
    
    /**
     * 
     * Delete a given key from the array
     * Return: true if the deletion completes successfully
     *         false if the key is not found and therefore cannot be removed from the array
     */
    public boolean delete(int key)
    {
        int i = search(key);
        
        if(i < 0)                      // key was not found in the array
            return false;
        
        for(int j = i + 1; j < n; j++)        
            a[j - 1 ] = a[j];              
        
        n--;  
        
        return true;
    }
    
    /**
     * 
     * Practice problem 1:
     * Write a function to flip the order of elements
     * For example, the array contains 50, 20, 30, 10, 40
     * After calling the function, the array will become 40, 20, 30, 10, 50
     */
    public void flip()
	{
		
		int t  = a[0]; // temporarily store the first element
		a[0] = a[n-1]; // replace the first element value with the last element value
		a[n-1] = t;
		
		//Professor's solution (note - does not match problem output above)
		/*for (int i = 0; i <= (n - 1) / 2; i++)
		{
			int t = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = t;
		}*/
	}
    
    /**
     * 
     * Practice problem 2:
     * Write a function to left rotate the array
     * For example, the array contains 50, 20, 30, 10, 40
     * After calling the function, the array will become 20, 30, 10, 40, 50
     */
    public void leftRotate()
	{
		if (n == 0) return;
		
		int t  = a[0]; // temporarily store the first element
		for(int i = 1; i < n; i++) // shift the array
			a[i-1] = a[i];
		a[n-1] = t; // replace the last element value with the first element value
	}
    
    /**
     * 
     * Practice problem 3:
     * Write a function to right rotate the array
     * For example, the array contains 50, 20, 30, 10, 40
     * After calling the function, the array will become 40, 50, 20, 30, 10
     */
    public void rightRotate()
	{
		if (n == 0) return;
		
		int t  = a[n-1]; // temporarily store the last element
		for(int i = n - 1; i > 0; i--) // shift the array
			a[i] = a[i-1];
		a[0] = t; // replace the last element value with the first element value
	}
    
}

