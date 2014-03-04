public class Multiples_of_3_and_5
{
	public static void main(String [] args)
	{
		//BELOW 1000
		int counter = 1;
		int sum = 0;
		for (int i=1; i<1000; i++)
		{
			if ((i%3 == 0) || (i%5 == 0))
				sum +=i;

		}
		System.out.println(sum);

	}
}