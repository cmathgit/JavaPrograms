package edu.eku;
/**
 * COURSE: CSC 835 Project Management Summer 2023
 * PROJECT: Assignment 4 - TDD with JUnit
 * PROGRAMMER: Cruz Macias
 * DESCRIPTION: 
 */
 
public class SmallestAndLargest 
{
	//remove main once Test Cases are implemented
    public static void main(String[] args) {
		//do nothing
		System.out.print("JUnit Testing complete.\n");
    }

/**
 * FUNCTION: Pair
 * DESCRIPTION: compare values in an array and return the smallest and largest as a pair
 */
    public static Pair findSmallestAndLargest(int[] nums) {
		// return if array is empty
        if (nums == null || nums.length == 0) {
            return null;
        }

		//declare new Pairs for comparison
		Pair keyPair, testPair;

		// assign a largest and smallest key value
		if(nums[1] > nums[0]) 
			keyPair = new Pair(nums[0], nums[1]);
		else
			keyPair = new Pair(nums[1], nums[0]);
		
		int i = 2;
		while(i < nums.length)
		{
			if(i == (nums.length - 1))
			{
				// if the last index is even and the value is equal to the largest key value, exit the loop
				if(keyPair.getSecond() == nums[i])
					break;
				
				//if the last element value is larger than the largest key value, update the key pair
				if(keyPair.getSecond() < nums[i])
					keyPair = new Pair(keyPair.getFirst(), nums[i]);
				else
				{
					// if the last element is smaller than the smallest key value, update the key pair
					if(keyPair.getFirst() > nums[i])
						keyPair = new Pair(nums[i], keyPair.getSecond());
				}
				
				i++; //exit
			}
			else
			{
				//assign the largest and smallest values of the test pair
				if(nums[i] > nums[i+1])
					testPair = new Pair(nums[i+1], nums[i]);
				else
					testPair = new Pair(nums[i], nums[i+1]);
			
				// if the smallest element of the test pair is smaller than the smallest key value, update the key pair
				if(keyPair.getFirst() > testPair.getFirst())
					keyPair = new Pair(testPair.getFirst(), keyPair.getSecond());
				
				// if the largest element of the test pair is larger than the largest key value, update the key pair
				if(keyPair.getSecond() < testPair.getSecond())
					keyPair = new Pair(keyPair.getFirst(), testPair.getSecond());
			
				i = i+2;//exit
			}
		}
		
		return keyPair; //return the key pair
    }
}

/**
 * CLASS: Pair
 * DESCRIPTION: create a pair of two values
 */
class Pair {
	//data members of the class
    private int first; //the smaller value
    private int second; //the larger value

   /**
    * method: constructor
    * DESCRIPTION: assign values to the data members if values are passed to the class object declaration
    */
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

   /**
    * method: getFirst
    * DESCRIPTION: return the first data member
    */
    public int getFirst() {
        return first;
    }
	
   /**
    * method: getSecond
    * DESCRIPTION: return the second data member
    */
    public int getSecond() {
        return second;
    }
}