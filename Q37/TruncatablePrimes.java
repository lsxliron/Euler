
/**
*	This class finds the sum of all the trunctable prime numbers exists (overall 11).
*/
public class TruncatablePrimes
{
	/**
	*	This method checks if a number is prime.
	*	@param n The number to check.
	*	@return boolean
	*/
	public static boolean isPrime(int n)
	{
		if (n == 1)
			return false;
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
	*	This method checks if a number is truncatable when we remove digits from the right
	*	@param n The number to check
	*	@return boolean
	*/
	public static boolean primeCutRight(int n)
	{
		if (n == 0)
			return true;

		else if (isPrime(n) == false)
			return false;

		return primeCutRight(n/10);
	}



	/**
	*	This method checks if a number is truncatable when we remove digits from the left
	*	@param n The number to check
	*	@return boolean
	*/
	public static boolean primeCutLeft(int n)
	{
		if (String.valueOf(n).length() == 1)
			return isPrime(n);

		else if (isPrime(n) == false)
			return false;

		return primeCutLeft(Integer.parseInt(String.valueOf(n).substring(1, String.valueOf(n).length())));
	}

	/**
	*	This method checks if a number is truncatable when we remove digits from both sides
	*	@param n The number to check
	*	@return boolean
	*/
	public static boolean primeLeftAndRight(int n)
	{
		return ((primeCutLeft(n)) && (primeCutRight(n)));
	}

	public static void main(String [] args)
	{
		int sum = 0;
		int counter = 0;
		int num = 10;
		System.out.println("List of truncatable primes numbers:\n");
		while (counter != 11)
		{
			if (primeLeftAndRight(num))
			{
				System.out.printf("%d. %d\n",counter+1, num);
				sum += num;
				counter++;
			}
			num++;
		}


		System.out.printf("\nThe sum of all the truncatable prime numbers is %d\n", sum);
	
	}
}