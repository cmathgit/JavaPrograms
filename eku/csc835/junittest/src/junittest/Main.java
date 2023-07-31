// programmer: Cruz Macias
package junittest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Welcome World, to my Java Program, CSC 835!");
		
		Result result = JUnitCore.runClasses(TestJunit.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
		
	}
}// end main class
