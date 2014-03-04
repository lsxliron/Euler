import java.math.BigInteger;

/**
*	This class calculate the sum of the digits of a number n^k
*/

public class PowerDigitSum
{
	public static void main (String [] args)
	{
		if (args.length != 2)
		{
			System.out.println ("usage\n-----\n PowerDigitSum [number] [exponent]\n\n");
			return;
		}

		final int n =  Integer.parseInt(args[0]);
		final int k =  Integer.parseInt(args[1]);
		int temp = 0;
		BigInteger power = new BigInteger(String.valueOf(n)).pow(k);


		while (power.compareTo(new BigInteger("0")) != 0)
		{
			temp = temp+power.mod(new BigInteger("10")).intValue();
			power = power.divide(new BigInteger("10"));
		}

		System.out.println("The sum of digits of " + n +"^"+k+ "is:\t"+temp);
	}

}