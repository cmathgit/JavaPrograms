/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * to compile in MS-DOS JDK 18.0.2 with user-defined packages, execute:
 *		javac -d . Example01UnsortedArray.java
 * to run the program, execute:
 *		java example01unsortedarray.Example01UnsortedArray
 * to compile in MS-DOS JDK 18.0.2 without user-defined packages, execute:
 *		javac Example01UnsortedArray.java
 * to run the program, execute:
 *		java Example01UnsortedArray
 * alternatively, starting with Java SE 11, you can run the program without compiling 
 *		if the main class is at the start of the program by simply executing 
 * 			java Example01UnsortedArray.java
 * this command will not run the program if the main class is after a different class definition
 */
package example01unsortedarray;

/**
 *
 * @author Yang
 * @revisions: Cruz Macias
 */

/**
 *
 * Demonstrate basic operations of an unsorted array
 * Assumption:
 *   - The array is unsorted
 *   - All elements in the array are distinct (no duplicated elements exist)
 */

public class Example01UnsortedArray 
{
    public static void main(String[] args)
    {
        int size = 10;              // size of the array
        int a[] = new int[size];    // make an array with the specified size
        int n = 0;                  // number of elements that are currently in the array
        
        // Sequentially insert 6 elements
        a[0] = 44;
        a[1] = 55;
        a[2] = 22;
        a[3] = 11;
        a[4] = 66;
        a[5] = 33;
        n = 6;
        
        // Display all elements that are currently in the array
        int i;
        for(i = 0; i < n; i ++)
            System.out.print(a[i] + " ");
        System.out.println();
        
        // Search for a given key 66 
        int key = 66;
        for(i = 0; i < n; i++)
            if(a[i] == key) break;    // exit the loop if key is found
        
        if(i == n)                      // key was not found in the array
            System.out.println(key + " cannot be found.");
        else
            System.out.println(key + " is found at index: " + i);
        
        // Search for a given key 18 
        key = 18;
        for(i = 0; i < n; i++)
            if(a[i] == key) break;    // exit the loop if key is found
        
        if(i == n)                      // key was not found in the array
            System.out.println(key + " cannot be found.");
        else
            System.out.println(key + " is found at index: " + i);
        
        // Delete a given key 11
        key = 11;
        for(i = 0; i < n; i++)
            if(a[i] == key)   break;
        
        if(i == n)                      // key was not found in the array
            System.out.println(key + " cannot be found. Deletion failed!");
        else
        {
            // shift a[i+1] ~ a[n-1] left for one position
            for(int j = i+1; j < n; j++)
                a[j-1] = a[j];

            n--;
        }
        
        // Display all elements that are currently in the array
        for(i = 0; i < n; i ++) // display items
            System.out.print(a[i] + " ");
        System.out.println();
        
        /**
         * 
         * Practice problem 1:
         * Write statements to insert 200 as the 6th element in the array
         */
		 
		System.out.println("a[5] = " + a[5]); // print the value stored in index 5 before insert
        a[5] = 200; // replace value stored in the 6th element of the array with 200
		n++;
		System.out.println("a[5] = " + a[5]); // print the value stored in index 5 after insert
        
        /**
         * 
         * Practice problem 2:
         * Write statements to insert 100 into the array so that it becomes the 1st element
         */
		 
		 // print the contents of the array before update
		 for(int l = 0; l < n; l++)
			 System.out.print(a[l] + " ");
		 
		 System.out.println();
		 
		 n++; // increment the array by one
		 for(int k = n - 1; k > 0; k--) // shift the array contents
			a[k] = a[k-1];
			
		a[0] = 100; // update the first element in the array with 100
			
		 // print the contents of the array before update
		 for(int h = 0; h < n; h++)
			 System.out.print(a[h] + " ");
		 
		 System.out.println();
    }
}
