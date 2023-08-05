package edu.eku;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SmallestAndLargestTest 
    extends TestCase
{
    /**
     * Test Case 1
     * @Test 1
	 * Test for empty array
     */
    public void testSmallestAndLargest1() {
        int[] inputArray = {};
        assertNull(SmallestAndLargest.findSmallestAndLargest(inputArray));
    }

    /**
     * Test Case 2
     * @Test 2
	 * Test for smallest and largest in unordered array with positive integer elements
     */
    public void testSmallestAndLargest2() {
        int[] inputArray = {5, 2, 9, 1, 7};
		Pair expectedPair = new Pair(1, 9);
		Pair resultPair = SmallestAndLargest.findSmallestAndLargest(inputArray);
		assertEquals(expectedPair.getFirst(), resultPair.getFirst());
		assertEquals(expectedPair.getSecond(), resultPair.getSecond());
    }
    /**
     * Test Case 3
     * @Test 3
	 * Test for smallest and largest in unordered array with negative integer elements
     */
    public void testSmallestAndLargest3() {
        int[] inputArray = {-3, -8, -1, -5};
		Pair expectedPair = new Pair(-8, -1);
		Pair resultPair = SmallestAndLargest.findSmallestAndLargest(inputArray);
		assertEquals(expectedPair.getFirst(), resultPair.getFirst());
		assertEquals(expectedPair.getSecond(), resultPair.getSecond());
    }

    /**
     * Test Case 4
     * @Test 4
	 * Test for smallest and largest in array with duplicate elements
     */
    public void testSmallestAndLargest4() {
		int[] inputArray = {10, 10, 10, 10};
		Pair expectedPair = new Pair(10, 10);
		Pair resultPair = SmallestAndLargest.findSmallestAndLargest(inputArray);
		assertEquals(expectedPair.getFirst(), resultPair.getFirst());
		assertEquals(expectedPair.getSecond(), resultPair.getSecond());
    }

    /**
     * Test Case 5
     * @Test 5
	 * Test for smallest and largest in unordered array with less than 5 elements
     */
    public void testSmallestAndLargest5() {
        int[] inputArray = {4, 2, 8, 6};
		Pair expectedPair = new Pair(2, 8);
		Pair resultPair = SmallestAndLargest.findSmallestAndLargest(inputArray);
		assertEquals(expectedPair.getFirst(), resultPair.getFirst());
		assertEquals(expectedPair.getSecond(), resultPair.getSecond());
    }

    /**
     * Test Case 6
     * @Test 6
	 * Test for smallest and largest in unordered array where the last element is the largest and the index is even
     */
    public void testSmallestAndLargest6() {
        int[] inputArray = {4, 2, 8, 6, 9};
		Pair expectedPair = new Pair(2, 9);
		Pair resultPair = SmallestAndLargest.findSmallestAndLargest(inputArray);
		assertEquals(expectedPair.getFirst(), resultPair.getFirst());
		assertEquals(expectedPair.getSecond(), resultPair.getSecond());
    }
	
    /**
     * Test Case 7
     * @Test 7
	 * Test for smallest and largest in unordered array where the last element is the largest and the index is odd
     */
    public void testSmallestAndLargest7() {
        int[] inputArray = {4, 2, 6, 8};
		Pair expectedPair = new Pair(2, 8);
		Pair resultPair = SmallestAndLargest.findSmallestAndLargest(inputArray);
		assertEquals(expectedPair.getFirst(), resultPair.getFirst());
		assertEquals(expectedPair.getSecond(), resultPair.getSecond());
    }
}
