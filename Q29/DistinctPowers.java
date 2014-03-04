import java.util.ArrayList;
import java.math.BigInteger;

/**
*	This class counts how many distinct item exists on A^B when 2{<}A{<}100 and 2{<}B{<}100 
*/
public class DistinctPowers
{

	public static void main(String [] args)
	{
		ArrayList<String> arr = new ArrayList<String>();	//holds all the ele,ents
		BigInteger result;	//holds the current calculation
		String numStr;	//Holds the value in String type

		//Perform calculation
		for (int i=2; i<101; i++)
			for (int j=2; j<101; j++)
			{
				result = new BigInteger(String.valueOf(i));
				result = result.pow(j);
				numStr = result.toString();

				//Check if element already exists
				if (arr.contains(numStr) == false)
					arr.add(numStr);
			}

			System.out.println("The number of distinct elemnts is: " + arr.size());


	}
}