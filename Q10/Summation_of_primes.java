import java.math.BigInteger;

public class Summation_of_primes
{
	/*This class finds the sum of all the prime numbers less than LIMIT
	*/

	public static boolean isPrime(long num)
	{
		/** This method returns true if a number is prime and false otherwise
		@param num the number to be tested
		@returns boolean
		 */
		long limit = (long)Math.sqrt(num);
		boolean prime = true;
		
		for (int i=2; i<=limit; i++)
			if ((prime == true) && (num%i == 0))
				prime = false;
		return prime;
	}

	public static long find_next_prime(long num)
	{
		/** This method returns the next prime number which is greater than num
		@param num the current prime number
		@return long
		*/
		num++;
		while (isPrime(num) == false)
			num++;
		return num;

	}
	//Usage: arg[0] is the limit
	public static void main(String [] args)
	{
		long first = 2;
		long sum = 0;
		final int LIMIT = Integer.parseInt(args[0]);
		
		
		while (first < LIMIT)
		{
			sum = sum + first;	
			first = find_next_prime(first);	
			System.out.println("Prime  is:\t" + first + ", The sum is:\t" + sum);
		}

		System.out.println("The sum is:\t" + sum);

	}
}