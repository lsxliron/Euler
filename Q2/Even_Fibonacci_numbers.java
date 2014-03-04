public class Even_Fibonacci_numbers
{
	public static void main(String [] args)
	{
		int fib1 = 1;
		int fib2 = 2;
		int currentFib = 0;
		int sum = 2;
		int temp = 0;
		while (currentFib < 4000000)
		{
			currentFib = fib1 + fib2;
			if (currentFib%2 == 0)
				sum+=currentFib;

			fib1 = fib2;
			fib2 = currentFib;
		}
		System.out.println(sum);
	}
}