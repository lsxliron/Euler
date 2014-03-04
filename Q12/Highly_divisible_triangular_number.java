

/**@author Liron Shimrony
This class will find the first triangle number with more than 500 divisors.
*/
public class Highly_divisible_triangular_number
{
	/** This method counts how many divisors the number in the arguments has
	@param n the desired number
	@return int
	*/
	public static long countDivisers(long n)
	{
		
		//for the sake of correctness
		if (n == 1)
			return 1;

		long counter = 2;	// I start to count from 2 because every number besies 1
							// can be divided by 1 and by itself

		for (long i=2; i<=n/2; i++)
		{
			if (n%i == 0)
			{
				counter++;
			}
		}

		return counter;
	}


	public static void main(String [] args)
	{
		long currentNum = 0;
		long numOfDivisors = 0;
		long counter = 1;
		while (numOfDivisors < 500)
		{
			if (numOfDivisors>300)
				System.out.println("The number " + currentNum + " has " + numOfDivisors);
			
			currentNum = currentNum + counter;
			numOfDivisors = countDivisers(currentNum);
			
			counter ++; //The counter adds up to currentNum to created the triangle number

		}

		System.out.println("The first number with more than 500 dividors is:\t" + currentNum);
	}



}