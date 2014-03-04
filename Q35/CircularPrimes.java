
/**
*	This class finds the nuber of circular primes between 1 and the specified limit.
*/

public class CircularPrimes
{
	/**
	*	This method checks if a number is prime.
	*	@param n The number we want to check.
	*	@return int
	*/
	public static boolean isPrime(int n)
	{
		if ((n == 2) || (n == 3))
			return true;

		for (int i=2; i<Math.sqrt(n)+1; i++)
		{
			if (n%i == 0)
				return false;
		}
		return true;
	}


	/**
	*	This method checks if a number is circular prime.
	*	@param n The number we want to check.
	*	@return int
	*/
	public static boolean flipAndPrime(int n)
	{
		int length = String.valueOf(n).length();
		if (isPrime(n) == false)
			return false;

		int lastDigit = n%10;
		for (int i=0; i<length-1; i++)
		{
			n = Integer.parseInt(String.valueOf(lastDigit) + String.valueOf(n).substring(0,length-1));
			lastDigit = n%10;
			if (isPrime(n) == false)
				return false;
		}
		return true;
		
	}



	public static void main(String [] args)
	{
		if (args.length != 1)
		{
			System.out.println("Usage:\n------\n CircularPrimes <limit>");
			return;
		}

		int limit = Integer.parseInt(args[0]);
		int counter = 0;
		for (int i=2; i<limit; i++)
		{
			if (flipAndPrime(i))
				counter++;
		}
		System.out.printf("The number of circular primes less then million is %d\n\n", counter);
	}

}