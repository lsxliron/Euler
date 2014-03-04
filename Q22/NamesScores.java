import java.math.BigInteger;
import java.util.*;
import java.io.*;


/**	
*	@author Liron Shimrony
*	This class sorts a list of name and returns the following value:<br>
*	TOTAL += sum of the numerical value of the letters * position in the list
*	@author Liron Shimrony
*/
public class NamesScores
{
	/**
	* 	This method reads a text file into an array.
	*	@param filename The filename to read from.
	*	@return String[ ]
	*/
	public static String [] namesToArray(String filename) throws IOException, FileNotFoundException
	{
		ArrayList<String> names = new ArrayList<String>();
		String line;


		try
		{
			InputStream is = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			while ((line=br.readLine())!=null)
			{
				line=line.replace("\"","");
				String [] tempNames = line.split(",");
				List<String> tempNamsList = Arrays.asList(tempNames);
				names.addAll(tempNamsList);
			}
		}

		catch (Exception e)
		{
			System.out.println("Error, file not found");
			names = null;
		}
		return names.toArray(new String[names.size()]);


	}

	public static void main(String [] args) throws IOException, FileNotFoundException
	{
		if (args.length != 1)
		{
			System.out.println("Usage\n------\n NamesScores <filename>\n");
			return;
		}

		String [] names = namesToArray("names.txt");
		Arrays.sort(names);
		long tempSum = 0;	//Holds the sum of each name
		long total = 0;		//Holds the total sum

		//Use a dictionary
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A',1);
		map.put('B',2);
		map.put('C',3);
		map.put('D',4);
		map.put('E',5);
		map.put('F',6);
		map.put('G',7);
		map.put('H',8);
		map.put('I',9);
		map.put('J',10);
		map.put('K',11);
		map.put('L',12);
		map.put('M',13);
		map.put('N',14);
		map.put('O',15);
		map.put('P',16);
		map.put('Q',17);
		map.put('R',18);
		map.put('S',19);
		map.put('T',20);
		map.put('U',21);
		map.put('V',22);
		map.put('W',23);
		map.put('X',24);
		map.put('Y',25);
		map.put('Z',26);

		//Loop the array and calculate the sum
		for (int i=0; i<names.length; i++)
		{
			tempSum = 0;
			for (int j=0; j<names[i].length(); j++)
			{
				tempSum += map.get(names[i].charAt(j));
			}
			
			total = total + ((i+1) * tempSum);
			tempSum =0;
			
		}
		System.out.println("The total sum of the list is:\t" + total);
		
	}

}