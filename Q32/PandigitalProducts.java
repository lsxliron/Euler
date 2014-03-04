import java.math.BigInteger;
import java.util.ArrayList;

/**
*	This class finds all the possible pandigital products containing the digits 1- 9.	
*/

public class PandigitalProducts
{
	private ArrayList<Integer> _digits;
	private ArrayList<Integer> _digitsChecker;	//Contains all the valid digits
	private BigInteger _num1;
	private BigInteger _num2;
	private BigInteger _zero;
	private BigInteger _ten;
	private BigInteger _product;
	private ArrayList<Integer> _validProducts;

	public PandigitalProducts()
	{
		_zero = new BigInteger("0");
		_ten = new BigInteger("10");
		_num1 = new BigInteger("1");
		_num2 = new BigInteger("2");
		_product = _num1.multiply(_num2);
		_digits = new ArrayList<Integer>();
		_validProducts = new ArrayList<Integer>();

		for (int i=1; i<10; i++)
			_digits.add(i);

		_digitsChecker = new ArrayList<Integer>(_digits);
	}

	/**
	* 	This method resets the digits checker and fill all the digits back
	*/
	public void resetChecker()
	{
		_digitsChecker = new ArrayList<Integer>(_digits);
	}

	/**
	* 	This method removes a given number from the digits array list if it exists.
	*	@param digit The digits to remove.
	*	@return boolean
	*/
	public boolean removeDigitFromChecker(int digit)
	{
		Integer i = new Integer(digit);
		if (_digitsChecker.contains(i))
		{
			_digitsChecker.remove(i);
			return true;
		}
		return false;


	}

	/**
	*	This method sets the product of a*b.
	*/
	public void multiply()
	{
		_product = _num1.multiply(_num2);
	}


	
	//	This method contains the logic for validNumber(). It checks is a digit appears more 
	//	than once in a pandigital expression.
	
	private boolean validNumberHelper(BigInteger number)
	{
		boolean valid = true;

		BigInteger num = new BigInteger(number.toString());

		while (num.compareTo(_zero) == 1)
		{
			valid = this.removeDigitFromChecker(((num.mod(_ten)).intValue()));
			num = num.divide(_ten);

			if (valid == false)
				return false;
		}

		
		return true;
	}

	/**
	*	This method checks if a a*b=c is pandigital
	*	@return boolean
	*/
	public boolean validNumber()
	{
		//Check all compnents (a, b and a*b)
		multiply();
		boolean valid = ((validNumberHelper(_num1)) &&
					     (validNumberHelper(_num2)) &&
				 	 	 (validNumberHelper(_product)));

		//add the pandigital products to an array for sum calculation
		if ((_digitsChecker.size() == 0) && (valid))
		{
			if (_validProducts.contains(_product.intValue()) == false)
			{
				_validProducts.add(new Integer(_product.intValue()));
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString()
	{
		return _num1.toString() + " * " + _num2.toString() + " = " + _product.toString();
	}

	
	public static void main(String [] args)
	{
		BigInteger limit = new BigInteger("2000");
		BigInteger one = new BigInteger("1");
		PandigitalProducts pp = new PandigitalProducts();
		long sum = 0;

		//Iterate all existing options
		for (pp._num1 = new BigInteger("1"); pp._num1.compareTo(limit) == -1; pp._num1 = pp._num1.add(one))
		{
			for (pp._num2 = new BigInteger("1"); pp._num2.compareTo(limit) == -1; pp._num2 = pp._num2.add(one))
			{
				
				if (pp.validNumber()==true)
				{
					System.out.println(pp);
					sum += pp._product.intValue();
				}
				
				pp.resetChecker();
			}

		}

		System.out.printf("The sum of all the pandigital products is %d\n\n", sum);		
	}
}