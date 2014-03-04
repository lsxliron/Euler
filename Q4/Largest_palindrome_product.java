public class Largest_palindrome_product
{
	/*
	This class finds the largest palindrom which is possible to get from 3 digits.
	Approach: find all palindroms from 999*999 to 2*2 and find the largest one on the fly.
	*/

	public static int[] numberToArray(int num)
	{
		/*
		This method converts an int to array where each digit is one array element
		@params num the number to convert
		@return int[]
		*/

		//Get array length
		int len = String.valueOf(num).length();
		//Create new array
		int [] numArr = new int [len];

		//put the number in the array
		for (int i=len-1; i>=0; i--)
		{
			numArr[i] = num%10;
			num = num/10;
		}
		return numArr;

	}

	public static boolean isPalindrom(int num)
	{
		/*
		Returns true if the number is palindrom and false otherwise
		Approach: each number starts as palindrom unless we found otherwise
		*/
		int [] numArr = numberToArray(num);
		int head = numArr.length-1;
		int tail = 0;
		

		while (head >= tail)
		{
			if (numArr[tail] != numArr[head])
				return false;
			else
			{
				tail++;
				head--;
			}
		}
		return true;
	}

	public static void main(String [] args)
	{
		
		int num1 = 999;
		int num2 = 999;
		int result;
		int largest = 0;

		
		while (num1 != 2)
		{
			result = num1 * num2;
			

			if (isPalindrom(result))
			{
				System.out.println("--------------------------");
				System.out.println("Palindrom:\t" + result);
				System.out.println("First Factor:\t"+ num1 + "\nSecondFactor:\t" + num2);
				System.out.println("--------------------------");

				if (largest < result)
					largest = result;
				
			}
		
			if (num2 == 2)
			{
				num2 = num1-1;
				num1--;
			}

			else
				num2--;
		}
		System.out.println("#######################");
		System.out.println("LARGEST PALINDROM:\t" + largest);
		System.out.println("#######################");
		
		// int [] a = numberToArray(999*801);
		// for (int i=0; i<a.length; i++)
		// 	System.out.print(a[i]);
		// System.out.println();

	}
}