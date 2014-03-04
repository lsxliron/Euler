/** This class finds the longest Collats sequence for 1 < X < 10^6
 *	Reminder: x even: x --> x/2
 *			  x odd:  x --> 3x+1
 *  @author Liron Shimrony
*/

public class Longest_Collatz_sequence
{
	/**
	*	This function counts the number of items of a Collatz sequence of a given number
	*	@param n the number we want to find its sequence
	*	@return int
	*/
	public static int countCollatsTerms(long n)
	{
		int counter = 1;

		while (n != 1L)
		{
			if (n%2 == 0)
				n = n/2;
			else
				n = 3*n + 1;

			counter++;

		}
		return counter;

	}


	public static void main(String [] args)
	{
		int maxSequenceTerms = 0;
		int maxNum = 0;
		int currentNum = 1;
		int temp = 0;

		
		while (currentNum < 1000000)
		{
			temp = countCollatsTerms(currentNum);
			if (maxSequenceTerms < temp)
			{
				maxSequenceTerms = temp;
				maxNum = currentNum;

			}
			currentNum++;
		}

		System.out.println("The number with the largest Collatz sequence:\t" + maxNum + " and it has " + maxSequenceTerms + " items.");

	}


}