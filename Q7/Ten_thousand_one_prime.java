import java.math.BigInteger;

public class Ten_thousand_one_prime
{
	/*This class finds the 10,001 prime number
	*/
	public static boolean isPrime(BigInteger num)
	{
		/** This method returns true if a number is prime and false otherwise
		@param num the number to be tested
		@returns boolean
		 */
		BigInteger limit = num.divide(new BigInteger("2"));
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		boolean prime = true;
		
		for (BigInteger counter = new BigInteger("2"); ((counter.compareTo(limit) != 1) && (prime == true)); counter=counter.add(one))
		{
			if ((prime == true) && ((num.mod(counter)).compareTo(zero) == 0))
				prime = false;
		}
		return prime;
	}

	public static BigInteger find_next_prime(BigInteger num)
	{
		/** This method returns the next prime number which is greater than num
		@param num the current prime number
		@return BigInteger
		*/
		num = num.add(new BigInteger("1"));
		while (isPrime(num) == false)
			num = num.add(new BigInteger("1"));
		return num;

	}

	public static void main(String [] args)
	{
		BigInteger first = new BigInteger("2");

		for (int i=0; i<10000; i++)
		{
			if (i%1000 == 0)
				System.out.println("Now passed "+ i);
			first = find_next_prime(first);
		}

		System.out.println(first);

	}
}