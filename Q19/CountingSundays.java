
	/**
	*	This class finds the number of sundays that occured on the 1st of the month between
	*	the years 1901-2001.
	*	@author Liron Shimrony
	*/

public class CountingSundays
{

	/**
	*	This method returns true if a year is a leap tear and false otherwise.
	*	@param year The year to test
	*	@return boolean
	*/


	public static boolean isLeapYear(int year)
	{
		if (year%100 == 0)
			if (year%400 == 0)
				return true;
			else 
				return false;

		else if (year%4 == 0)
			return true;

		return false;
	}


	public static void main(String [] args)
	{
		int [] cal = {31,28,31,30,31,30,31,31,30,31,30,31};

			int sundayCounter = 0;

			 //Given that 01/01/1900 was monday
			 //Find the first dat fo 1901
			 int firstDay= 365%7+2;

			 int currentDay = firstDay;

			 //Loop the years and find sundays
			 for (int year=1901; year<2001; year++)
			 {
			 	for (int i=0; i<cal.length; i++)
			 	{
			 		if ((isLeapYear(year)) && (i==1))
			 			currentDay = (currentDay + 29)%7;	
			 		else
			 			currentDay = (currentDay + cal[i])%7;

			 		if (currentDay == 1)
			 			sundayCounter++;

			 		System.out.println(currentDay);
			 	}
			 }

			 System.out.println("\nNumber of Sundays on 1st of month:\t" + sundayCounter);

	}

}