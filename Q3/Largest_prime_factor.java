import java.math.BigInteger;

public class Largest_prime_factor
{
	/*
	This file finds the prime factors of the number of a given number
	and return the largest factor. In addition it lists all the prime factors of a number
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
		BigInteger num = new BigInteger("600851475143");
		BigInteger zero = new BigInteger("0");			//Holds a 0
		BigInteger one = new BigInteger("1");			//Holds a 1
		BigInteger firstPrime = new BigInteger("3");	//The first prime to start with
		BigInteger [] result = new BigInteger[2]; //Holds the result of division and reminder
		BigInteger currentPrime = firstPrime;	//The prime number which divides the desired num
		BigInteger largestFactor = zero;		//Holds the largest factor
		while (num.compareTo(one) != 0)
		{
			//Division
			result = num.divideAndRemainder(currentPrime);

			//Find out if there is a reminder
			if (result[1].compareTo(zero) == 0)
			{
				//Case of no reminder
				System.out.println("Factor: " + currentPrime);
				
				//Set the number
				num = result[0];
				
				//Set the largest factor
				if (largestFactor.compareTo(currentPrime) != 1)
					largestFactor = currentPrime;

				//Reset the prime number back to 3
				currentPrime = firstPrime;
			}
			//Get the next prime
			else
				currentPrime = find_next_prime(currentPrime);
		}
		System.out.println("The largest factor is: " + largestFactor);
	}
}

