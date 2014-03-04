/**
*	This class finds the sum of all the amicable pairs between 1-10,000
*	@author Liron Shimrony
*/

public class AmicableNumbers
{

	/**
	*	This method return true if a number has an amicabple pair
	*	@param n The number to test
	*	@return boolean
	*/
	public static boolean isAmicable(int n)
	{
		int sumA = 0;
		int sumB = 0;

		//Find all the proper divisors of n
		for (int i=1; i<n+1/2; i++)
		{
			if (n%i == 0)
				sumA += i;
		}

		//Find all the proper divisors of sumA
		for (int i=1; i<sumA+1/2; i++)
		{
			if (sumA%i == 0) 
				sumB += i;
		}
		
	
		if ((sumB == n) && (sumA != sumB))
			return true;
		else
			return false;
	}

	public static void main(String [] args)
	{
		int sum = 0;

		for (int i=1; i<10000; i++)
		{
			if (isAmicable(i))
				sum+=i;

		}

		System.out.println(sum);
	}

}