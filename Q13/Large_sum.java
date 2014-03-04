import java.math.BigInteger;
import java.io.*;

/** @author Liron Shimrony
*   This class finds the sum of list of number, read from a text file.
*/

public class Large_sum
{
	/**This function reads numbers from a text file and returns an array with that number
	*  @param filename the name of the file which contains the list of numbers to add
	*  @return BigInteger
	*/
	public static BigInteger [] fileToArray(String filename) throws IOException, FileNotFoundException
	{

		String line;
		BigInteger [] arr = new BigInteger[100];
		int counter = 0;
		try
		{
			InputStream is = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null)
			{
				arr[counter] = new BigInteger(line);
				counter++;
				// System.out.println("LINE\t\t:"+line);
			}
		}

		catch (FileNotFoundException e)
		{
			System.out.println("Error, file not found.");
			arr = null;
		}

		return arr;


	}


	public static void main(String [] args) throws IOException, FileNotFoundException
	{
		if (args.length <1)
			System.out.println("Usage:\n-------\n Large_sum [filename]");

		final String FILENAME = args[0];
		BigInteger sum = new BigInteger("0");

		//Create array with the numbers list
		BigInteger [] numArr = fileToArray(FILENAME);
		

		//add al the numbers and print the results
		for (int i=0; i<numArr.length; i++)
			sum = sum.add(numArr[i]);

		System.out.println("The sum of all the numbers is:\n"+sum);

	}

}