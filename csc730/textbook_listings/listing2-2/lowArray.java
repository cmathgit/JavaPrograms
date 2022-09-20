// lowArray.java
// demonstrates array class with low-level interface
// to compile this program: Make sure JDK is installed.
//		1. Open the MS-DOS (cmd) prompt.
//		2. Navigate to the respective project folder using the cd command.
//		3. SET the PATH variable if needed. For JDK 18.0.2, execute the following command: SET PATH=C:\Program Files\Java\jdk-18.0.2\bin
//		4. execute the following command: javac lowarray.java
// to run this program: Make sure the bank.class file exists in the project folder.
//		execute java LowArrayApp or C>java LowArrayApp
///////////////////////////////////////////////////////////////////
class LowArray
{
	private long[] a;										// ref to array a
//------------------------------------------------------------------
	public LowArray(int size)								// constructor
		{ a = new long[size]; }								// create array
//------------------------------------------------------------------
	public void setElem(int index, long value)				// set value
		{ a[index] = value;}
//------------------------------------------------------------------
	public long getElem(int index)									// get value
		{ return a[index]; }
//------------------------------------------------------------------
} // end class LowArray

class LowArrayApp
{
	public static void main(String[] args)
	{
		LowArray arr;										// reference
		arr = new LowArray(100);							// create LowArray object
		int nElems = 0;									// number of items in array
		int j;												// loop variable

		arr.setElem(0, 77);									// insert 10 items
		arr.setElem(1, 99);
		arr.setElem(2, 44);
		arr.setElem(3, 55);
		arr.setElem(4, 22);
		arr.setElem(5, 88);
		arr.setElem(6, 11);
		arr.setElem(7, 00);
		arr.setElem(8, 66);
		arr.setElem(9, 33);
		nElems = 10;										// now 10 items in array
		
		for(j=0; j<nElems; j++)								// display items
			System.out.print(arr.getElem(j) + " ");
		System.out.println("");
		
		int searchKey = 26;									// search for data item
		for(j=0; j<nElems; j++)								// for each element,
			if(arr.getElem(j) == searchKey)					// found item?
				break;
		if(j == nElems)										// no
			System.out.println("Can't find " + searchKey);
		else												// yes
			System.out.println("Found " + searchKey);
			
		// delete value 55
		for(j=0; j<nElems; j++)								// look for item
		if(arr.getElem(j) == 55)
			break;
		for(int k=j; k<nElems; k++)							// higher ones down
			arr.setElem(k, arr.getElem(k+1));
		nElems--;											// decrement size
		
		for(j=0; j<nElems; j++)								// display items
			System.out.print(arr.getElem(j) + " ");
		System.out.println("");
	} // end main
} // end class LowArrayApp
///////////////////////////////////////////////////////////////////