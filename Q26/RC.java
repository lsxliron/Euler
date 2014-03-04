import java.util.*;


/**
*	This class finds the number with the largest amount of digits in its cycle from 1/first to 1/last.</br>
*	Approach:</br> 
*	We start by dividing 10/number, find the result (integer) and find the reminder. </br>
*	The result is part of the cycle while the reminder * 10 is part of the next interation.</br>
*	Every iteration we check if the reminder already exists in the reminders array. If so, it's a cycle
*	that will repeat forever. If not, we add it to the array and keep the division.
*/
public class RC
{
	/**
	*	This method returns the size of the cycle of 1/a. For example, 1/7 will return 6 since 1/7 = 0.142857....
	*	@param a The integer we want to divide.
	*	@return int
	*/
	public static int divide(int a) 
	{
		int reminder = -1;
		int result = 0;
		int numerator = 1;
		ArrayList<Integer> reminders = new ArrayList<Integer>();
		ArrayList<Integer> cycle = new ArrayList<Integer>();
		int numOfDigits = -1;

		do
		{
			//Do not insert to reminder before the first iteration
			if (reminder != -1)
				reminders.add(reminder);
			
			numerator *= 10;
			result = numerator/a;
			reminder = numerator%a;
			numerator = reminder;
			cycle.add(result);
			numOfDigits++;
		}

		while (reminderInArray(reminders, reminder) == false);
		System.out.println("Number " + a + " has a cycle of " + numOfDigits + " digits.");

		return numOfDigits;
	}


	/**
	*	This method returns true of the the number r exists in the ArrayList rems.
	*	@param rems An ArrayList of integer.
	*	@param r The number we are looking for.
	*	@return boolean
	*/
	public static boolean reminderInArray(ArrayList<Integer> rems, int r)
	{
		for (int i=0; i<rems.size(); i++)
		{
			if (rems.get(i) == r)
				return true;
		}

		return false;
	}


	public static void main(String [] args)
	{
		if (args.length != 2)
		{
			System.out.println("RC <first number> <last number>");
			return;
		}

		int first = Integer.parseInt(args[0]);
		int last = Integer.parseInt(args[1]);
		int max = 0;	//Holds the largest number of digits
		int temp = 0;	//A temporary variable which holds the number of digits in every cycle
		int largestCycle = 0;	//Holds the number with the largest cycle.

		for (int i=first; i<=last; i++)
		{
			temp = divide(first);
			if (temp > max)
			{
				max = temp;
				largestCycle = first;
			}

			first++;
		}

		System.out.println("\nThe number " + largestCycle + " has the largest cycle.");
	}
}