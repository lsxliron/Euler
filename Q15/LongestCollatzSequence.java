import java.math.BigInteger;

/**
*	This class calculates the number of Lattice paths which exists
*	in a grid.
*	A simple solution will be to use the binomial coefficient formula n choose k.
*	For a square grid we can sum up the number of possible for each point by summing
* 	up the indexes.
* 	For example:
*
*
*	<br>The number of Lattice paths from the left upeer point to the right bottom point
*	is 6.
*	<br>
*	1------1------1<br>
*	|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|<br>
*	|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|<br>
*	1------2------3<br>
*	|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|<br>
*	|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|<br>
*	1------3------6<br>
*/

public class LongestCollatzSequence
{

	/**
	*	This function returns the factorial of a number (n!)
	*	@param n the factorial to calculate
	*	@return BigInteger
	*/
	public static BigInteger factorial(BigInteger n)
	{
		if (n.compareTo(new BigInteger("0")) == 0)
			return new BigInteger("1");
		else
			return (n.multiply(factorial(n.subtract(new BigInteger("1")))));
	}

	/**
	*	This function calculates the binomal coefficient n choose k.
	*	@param n the total number of items
	*	@param k number to choose
	*	@return BigInteger
	*/
	public static BigInteger binom(int n, int k)
	{
		BigInteger bin = new BigInteger(String.valueOf(n));
		BigInteger kin = new BigInteger(String.valueOf(k));
		return factorial(bin).divide(factorial(kin).multiply(factorial(bin.subtract(kin))));
	}
	/**
	*	This function performs the calculation.
	*	@param width the width of the grid
	*	@param height the hight of the grid
	*/
	public static void main (String [] args)
	{
		if (args.length != 2)
		{
			System.out.println("Usage:\n-----\n LongestCollatzSequence [height][width]\n\n");
			return;
		}
		final int HEIGHT = Integer.parseInt(args[0]);
		final int WIDTH = Integer.parseInt(args[1]);


		System.out.println("\nThe number of possible Lattice paths in a " + HEIGHT + " x " + WIDTH +
			" grid is:\t" + binom(HEIGHT+WIDTH,HEIGHT)+ "\n");
	}
}