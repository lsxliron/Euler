import java.util.*;

/**
*
*	This class finds a permutation in a specific position of a certain size (lexographic order).<br> <br>
*	Approach:<br>
*	we start from permutation with the first digit (0). Later, we add the next digit on the leftmost side
*	and move it every time one position to the right. <br>
*	The permutation are being kept in an ArrayList and the will be used in the next iteration.<br>
*	Every iteration takes the permuations from the iteration before, adds a digit and moves it to the right
*	one position at a time until the permutations from the pervious iteration are over.<br>
*	At the end, we sort the ArrayList and display the desired position.
*/

public class LexographicPermutations
{

	/**
	*	This method swaps 2 digits in long type
	*	@param numStr The number to swap the digits
	*	@param a The firstion position for the swap
	*	@param b The second position for the swap
	*	@return String
	*/
	public static String swap(String numStr, int a, int b)
	{
		//Convert long to char array for swap
		StringBuilder sb = new StringBuilder(numStr);
		char temp;

		//Perform the swap
		temp = sb.charAt(a);
		sb.setCharAt(a, sb.charAt(b));
		sb.setCharAt(b, temp);
		
		return sb.toString();
	}



	public static void main(String [] args)
	{
		if (args.length != 2)
		{
			System.out.println("Usage:\n------\nLexographicPermutations <number of digits> <position>\n\n");
			return;
		}

		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> current = new ArrayList<String>();

		String currentPerm = "0";	//Initial value
		long counter = 0;			//Holds the number of permutations
		final int SIZE = Integer.parseInt(args[0]);
		final int POSITION = Integer.parseInt(args[1]);

		//The first permutation contain only the digit 0
		temp.add("0");
		

		//Start generating permutations
		for (int i=1; i<SIZE; i++)
		{
			System.out.println("Calculating premutation with " + (i + 1) + " digits.");
			while (temp.size() != 0)
			{
				current.add(String.valueOf(i) + temp.get(0));
				counter++;
				currentPerm = current.get(current.size()-1);

				for (int j=0; j< currentPerm.length()-1; j++)
				{	
					currentPerm = swap(currentPerm, j, j+1);
					current.add(currentPerm);
					counter ++;		
				}

				temp.remove(0);
			}


			System.out.println("GENERATED " + counter + " PERMUTATIONS FOR " + (i+1) + " DIGITS\n");
			
			//Clear the Arraylist if did not reach the destination size
			if ((current.get(0)).length() != SIZE)
			{
				counter = 0;
				
				temp = new ArrayList<String>(current);
				current.clear();
			}
			
		}

		//Sort arraylist
		Collections.sort(current);

		System.out.println("TOTAL NUMBER OF PERMS:\t"+current.size() + "\n-----------------------");
		try
		{
			System.out.println("The permutation in position" + POSITION+ "of " + SIZE + "digits is: " + current.get(POSITION-1));
		}

		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Your permutation does not exists.\nThe number of possible permutations " +
								"contatining " + SIZE + " digits is " + counter + 
								"You asked for " + args[1]);
		}

			
	}


}