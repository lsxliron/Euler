/**
*	@author Liron Shimrony
*	This class counts the number of letters of all the numbers from 1 to 1000 (include)
*/

public class NumberLetterCounts
{
	public static void main(String [] args)
	{
		String [] oneToNineteen = {"0", "one", "two", "three", "four", "five", "six", "seven",
								   "eight", "nine", "ten", "eleven", "twelve", "thirteen",
								   "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", 
								   "nineteen"};

		String [] tens = {"0", "10", "twenty", "thirty", "forty", "fifty", "sixty", 
	 					  "seventy", "eighty", "ninety"};
		
		String [] hundreds = {"0", "oneHundred", "twoHundred", "threeHundred", "fourHundred", 
							  "fiveHundred", "sixHundred", "sevenHundred", "eightHundred", 
							  "nineHundred"};

		String thousand = "oneThousand";
		
		String and = "and";



		int oneToNintyNine = 0;
		int hunds = 0;
		int total = 0;

		// System.out.println(oneToNineteen[0].length());

		
		//Count from 1 to 19

		for (int i=1; i<=19; i++)
			oneToNintyNine += oneToNineteen[i].length();

		System.out.println("1 to 19:\t" + oneToNintyNine);
		
		//count from 20 to 99
		for (int i=20; i<=99; i++)
		{
			if (i%10 == 0)
				oneToNintyNine += tens[i/10].length();

			else 
				oneToNintyNine = oneToNintyNine + tens[i/10].length() + oneToNineteen[i%10].length();
		
		}

		System.out.println("1 to 99:\t" + oneToNintyNine);

		//Number of ends from 1 to 1000
		int ands = and.length() * 99 * 9;

		//1-99 appears 10 times in the range 1-1000
		oneToNintyNine = oneToNintyNine * 10;


		//count the henders- each one appears 100 times in the range 100-1000
		for (int i=1; i<10; i++)
			hunds = hunds + (hundreds[i].length()*100);
		

		System.out.println("Hundreds\t:" + hunds);
		System.out.println("Ands\t:" + ands);
		System.out.println("One to ninety nine\t:" + oneToNintyNine);

		//Add up the letters
		total = ands + oneToNintyNine +hunds + thousand.length();

		System.out.println("Total number of letters\t:" + total + "\n\n");
	}

}

