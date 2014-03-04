
/**
*	This class finds the sum of all the numbers which the factorial of their digits equals to
*	the number itself.
*/
public class DigitFactorial
{
	/**
	*	This method calculates the factorial of a number.
	*	@param i The number to perform factorial on
	*	@return long
	*/
	public static long factorial(long i)
	{
		if (i == 0)
			return 1;
		
		return i * factorial(i-1);
	}

	/**
	*	This method calculates the sum of the digits factorial<br>
	*	For example 145 = 1! + 4! + 5!
	*	@param i The number to sum
	*	@return long
	*/
	public static long addDigitsFactorials(long i)
	{
		long sum = 0;
		while (i>0)
		{
			sum+=factorial(i%10);
			i = i/10;
		}
		return sum;
	}


	public static void main(String [] args)
	{
		int sum = 0;
		System.out.println("The valid numbers are:");
		for (long i=3; i<41000; i++)
		{
			if (i == addDigitsFactorials(i))
			{
				System.out.println(i);
				sum += i;
			}
		}

		System.out.printf("\nThe sum of all the valid digits is %d\n\n", sum);
	}
}