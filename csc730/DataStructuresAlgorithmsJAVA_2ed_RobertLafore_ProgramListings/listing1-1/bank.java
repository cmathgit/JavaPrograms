// bank.java
// demonstrates basic OOP syntax
// to compile this program: Make sure JDK is installed.
//		1. Open the MS-DOS (cmd) prompt.
//		2. Navigate to the respective project folder using the cd command.
//		3. SET the PATH variable if needed. For JDK 18.0.2, execute the following command: SET PATH=C:\Program Files\Java\jdk-18.0.2\bin
//		4. execute the following command: javac bank.java
// to run this program: Make sure the bank.class file exists in the project folder.
//		execute java hello or C>java BankApp
///////////////////////////////////////////////////////////////////
class BankAccount
{
	private double balance; 					// account balance

	public BankAccount(double openingBalance) 	// constructor
	{
		balance = openingBalance;
	}

	public void deposit(double amount) 			// makes deposit
	{
		balance = balance + amount;
	}	

	public void withdraw(double amount) 		// makes withdrawal
	{
		balance = balance - amount;
	}

	public void display() 						// displays balance
	{
		System.out.println("balance=" + balance);
	}
} // end class BankAccount
///////////////////////////////////////////////////////////////////
class BankApp
{
	public static void main(String[] args)
	{
		BankAccount ba1 = new BankAccount(100.00);  // create acct
		
		System.out.print("Before transactions, ");
		ba1.display();								// display balance

		ba1.deposit(74.35);							// make deposit
		ba1.withdraw(20.00);						// make withdrawal
		
		System.out.print("After transactions, ");
		ba1.display();								// display balance
		
	} //end main()
} // end class BankApp