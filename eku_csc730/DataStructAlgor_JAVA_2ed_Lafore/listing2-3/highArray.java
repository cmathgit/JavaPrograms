// highArray.java
// demonstrates array class with high-level interface
//			compare this program with the lowArray.java program; Does this program achieve the same function?
// to compile this program: Make sure JDK is installed.
//		1. Open the MS-DOS (cmd) prompt.
//		2. Navigate to the respective project folder using the cd command.
//		3. SET the PATH variable if needed. For JDK 18.0.2, execute the following command: SET PATH=C:\Program Files\Java\jdk-18.0.2\bin
//		4. execute the following command: javac highArray.java
// to run this program: Make sure the bank.class file exists in the project folder.
//		execute java highArrayApp or C>java highArrayApp
///////////////////////////////////////////////////////////////////
class HighArray
{
	private long[] a;									// ref to array a
	private int nElems;									// number of data items
//------------------------------------------------------------------
	public HighArray(int max)							// constructor
	{ 
		a = new long[max]; 								// create the array
		nElems = 0;										// no items yet
	}								
//------------------------------------------------------------------
	public boolean find(long searchKey)
	{													// find specified value
		int j;
		for(j=0; j<nElems; j++)							// for each element,
			if(a[j] == searchKey)						// found item?
				break;									// exit loop before and
			if(j == nElems)								// gone to end?
				return false;							// yes, can't find item
			else
				return true;							// no, found item
	}		// end find()
//------------------------------------------------------------------
	public void insert(long value)						// put element into array
	{
		a[nElems] = value;								// insert item
		nElems++;										// increment size
	}
//------------------------------------------------------------------
	public boolean delete(long value)
	{
		int j;
		for(j=0; j<nElems; j++)								// look for it
			if(value == a[j])
				break;
		if(j == nElems)										// can't find it
			return false;
		else												// found it	
			{
				for(int k=j; k<nElems; k++)					// move higher ones down
					a[k] = a[k+1];
				nElems--;									// decrement size
				return true;
			}
	}	// end delete()
//------------------------------------------------------------------
	public void display()									// displays array contents
	{
		for(int j=0; j<nElems; j++)								// for each element,
			System.out.print(a[j] + " ");					// display it
		System.out.println("");
	}
//------------------------------------------------------------------
} // end class HighArray
///////////////////////////////////////////////////////////////////
class HighArrayApp
{
	public static void main(String[] args)
	{
		int maxSize = 100;									// array size
		HighArray arr;										// reference to array
		arr = new HighArray(maxSize);						// create the array

		arr.insert(77);										// insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.display();										// display items
		
		int searchKey = 35;									// search for item
		if( arr.find(searchKey) )
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);
		
		arr.delete(00);										// delete 3 items
		arr.delete(55);
		arr.delete(99);
		
		arr.display();										// display items again
	} // end main
} // end class HighArrayApp
///////////////////////////////////////////////////////////////////