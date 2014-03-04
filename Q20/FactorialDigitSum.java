import java.math.BigInteger;

/**
*	@author Liron Shimrony
*	This class will compute the sum of digits of a factorial of a number
*/
public class FactorialDigitSum
{

	/**
	*	This method will calculate a factorial of a number (n!)
	*	@param n the number to calculate
	*	@return BigInteger
	*/
	public static BigInteger factorial(BigInteger n)
	{
		if (n.compareTo(new BigInteger ("0")) == 0)
			return new BigInteger("1");
		else
			return n.multiply(factorial(n.subtract(new BigInteger("1"))));
	}

	public static void main(String [] args)
	{
		if (args.length != 1)
		{
			System.out.println("Usage:\n-----\n FactorialDigitSum [number]\n\n");
			return;
		}

		BigInteger num = new BigInteger(args[0]);
		int sumOfDigits = 0;
		BigInteger ten = new BigInteger("10");
		BigInteger zero = new BigInteger("0");
		
		
		num = factorial(num);

		//Calculate sum
		while (num.compareTo(zero)!= 0)
		{
			sumOfDigits += (num.mod(ten)).intValue();
			num = num.divide(ten);
		}

		System.out.println("Sum of digits:\t" + sumOfDigits);
	}

}