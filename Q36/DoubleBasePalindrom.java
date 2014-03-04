
/**
*	This class calculates the sum of all the numbers which are palindroms int base 2 and base 10.
*/
public class DoubleBasePalindrom
{
	/**
	*	This method checls if a number if a palindrom in base 10.
	*	@param n The number to check
	*	@return boolean
	*/
	public static boolean isPalindromDec(int n)
	{
		int length = String.valueOf(n).length();
		int nCopy = n;
		String palindromic = "";
		int reversed = 0;

		for (int i=0; i<length; i++)
		{
			palindromic += String.valueOf(n%10);
			n = n/10;
		}
		reversed = Integer.parseInt(palindromic);

		
		if (nCopy == reversed)
			return true;

		return false;
	}

	/**
	*	This method checls if a number if a palindrom in base 10 and base 2.
	*	@param n The number to check
	*	@return boolean
	*/
	public static boolean isPalindromDoubleBase(int n)
	{
		return ((isPalindromDec(n)) && (isPalindromBin(Integer.toBinaryString(n))));
		
	}

	/**
	*	This method checls if a number if a palindrom in base 2.
	*	@param bin A binary string to check
	*	@return boolean
	*/
	public static boolean isPalindromBin(String bin)
	{
		int length = bin.length();
		String binCopy = bin;
		String palindromic = "";
		for (int i=0; i<length; i++)
		{
			palindromic += bin.substring(bin.length()-1, bin.length());
			bin = bin.substring(0, bin.length()-1);
		}

	
		if (binCopy.equals(palindromic))
			return true;

		return false;
	}



	public static void main(String [] args)
	{
		if (args.length != 1)
		{
			System.out.println("Usage\n-----\n DoubleBasePalindrom <limit>");
			return;
		}
		
		int limit = Integer.parseInt(args[0]);
		int sum = 0;
		for (int i=0; i<1000000; i++)
		{
			if (isPalindromDoubleBase(i))
				sum+=i;
		}

		System.out.printf("The sum of all the double-base palindroms bellow %d is %d.\n",limit, sum);


		


	}
}