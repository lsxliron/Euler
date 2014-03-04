import java.math.BigInteger;

/**
*	@author Liron Shimrony
*	This class finds the position of an element in Fibonacci series which contains specific anount
*	of digits requested by the user.
*/
public class ThousandDigitsFibonacci
{

	public static void main(String [] args)
	{
		if (args.length != 1)
		{
			System.out.println("Usage:\n-----\n ThousandDigitsFibonacci <# of digits\n>");
			return;
		}

		BigInteger first = new BigInteger("1");
		BigInteger second = new BigInteger("1");
		BigInteger temp = new BigInteger("0");
		int counter = 2;	//Position in the sequence
		
		while ((temp.toString()).length() < Integer.parseInt(args[0]))
		{
			temp = first.add(second); 	//Finds the next element
			first = second;
			second = temp;
			counter++;
		}
		System.out.println("The first number contains " + args[0] + 
						   " digits in Fibonacci series is:\t" + counter);

	}


}