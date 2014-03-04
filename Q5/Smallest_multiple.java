public class Smallest_multiple
{
	/*
	This class finds the smallest number that can be divided in all the integers
	between 1 and 20
	*/
	public static boolean isDivisible(int num)
	{
		/**Finds if a number can be divided in all the integers between 1 and 20
		@param num the desired number to test
		@return boolean
		*/
		boolean divisible = true;
		int counter = 2;
		int limit = 20;

		while (counter <= limit)
		{
			if (num%counter != 0)
				return false;
			counter++;
		}
		return true;

	}

	public static void main(String [] args)
	{

		int number = 2520;
		while (isDivisible(number) == false)
			number++;

		System.out.println(number);
	}
}