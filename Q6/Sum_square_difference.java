import java.math.BigInteger;

public class Sum_square_difference
{
	/*This class finds the difference between the sum of squares and the square of the sum
	For example (1 + 2 + 3)^2 - (1^2 + 2^2 + 3^2)
	*/

	public static void main(String [] args)
	{
		//Get the sum of squares
		BigInteger sumOfSquares = new BigInteger("0");
		BigInteger squaresOfSum = new BigInteger("0");
		BigInteger sosSqr = new BigInteger("0"); 
		

		for (BigInteger counter = new BigInteger("1"); counter.compareTo(new BigInteger("100")) != 1; counter = counter.add(new BigInteger("1")))
		{
			sumOfSquares = sumOfSquares.add(counter.pow(2));
			squaresOfSum = squaresOfSum.add(counter);
		}
		squaresOfSum = squaresOfSum.pow(2);

		System.out.println(squaresOfSum.subtract(sumOfSquares));

	}

}