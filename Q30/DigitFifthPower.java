import java.util.*;

/**
*	This class calculates the sum of all the digits that can be written as the sum of their
*	digits to the power of 5. For example: 4150 = 4^5 + 1^5 + 0^5.
*/
public class DigitFifthPower
{
	public static void main(String [] args)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int power = 5;
		int sum = 0;
		for (int i=2; i<360000; i++)
		{
			if (validNumber(i,power))
			{
				arr.add(i);
				sum+=i;
				System.out.println (i);
			}
		}
		System.out.println("The sum of all the elemnts is: " + sum);

	}

	/**
	* 	This method checks if the sum of every digitis^p equal to the number itself.<br>
	*	For example: 1634 = 1^4 + 6^4 + 3^4 + 4^4.
	*	@param num The number we want to check.
	*	@param power The power we want to raise the digit.
	*	@return boolean
	*/
	public static boolean validNumber(int num, int power)
	{
		int sum = 0;
		int temp = num;
		while (temp != 0)
		{
			sum += Math.pow(temp%10, power);
			temp = temp/10;
		}

		if (sum == num)
			return true;

		return false;
	}

}