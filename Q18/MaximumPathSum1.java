import java.io.*;

/**
*	@author Liron Shimrony
*	This class finds the maximum sum of a path in integers pyramid.
*/
public class MaximumPathSum1
{
	/**
	*	This method reads the pyramid from a text file and puts it in a 2D array
	*	@param filename text file name
	*	@param maxRows the number of elements in the bottom of the pyramid
	*	@return int[ ][ ]
	*/
	public static int [][]pyramidToarray(String filename, int maxRows) throws IOException, FileNotFoundException
	{
		int row = 0;
		int arr [][] = new int [maxRows][maxRows];
		String line;
		
		arr = setArray(arr);

		try
		{
			InputStream is = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			while ((line=br.readLine()) != null )
			{
				String [] nums = line.split(" ");

				for (int i=0; i<nums.length; i++)
				{
					int n = Integer.parseInt(nums[i]);
					arr[row][i] = n;
				}
				row++;
			}

		}

		catch (FileNotFoundException e)
		{
			System.out.println("Error, file not found");
			arr = null;
		}

		return arr;


	}

	/**
	*	This function prints the array in a pyrmid form.
	*	@param arr The array top print
	*/
	public static void printArray (int [][] arr)
	{
		for (int i=0; i<arr.length; i++)
		{
			for (int x=arr.length-i;x>0;x--)
					System.out.print("  ");
			for (int j=0; j<arr.length; j++)
			{
				

				if (arr[i][j] != -1)
					System.out.print(arr[i][j] + "    ");
			}
			System.out.println();
		}
	}

	/**
	*	This function sets all the array elements to -1
	*	@param arr The array to set
	*	@return int[ ][ ]
	*/
	public static int [][] setArray(int [][] arr)
	{
		for (int i=0; i<arr.length; i++)
			for (int j=0; j<arr.length; j++)
				arr[i][j]=-1; 

		return arr;
	}



	public static int findMaxInArray(int [] arr)
	{
		int max = -1;
		for (int i=0; i<arr.length; i++)
		{
			if (arr[i] > max)
				max = arr[i];
		}

		return max;
	}

	public static int [] createMaxArrayIndexes (int [][] arr)
	{
		int [] maxArray = new int[arr.length];

		for (int i=0; i<maxArray.length; i++)
			maxArray[i] = findMaxInArray(arr[i]);

		return maxArray;

	}


	public static void main (String [] args) throws IOException, FileNotFoundException
	{
		if (args.length !=2 )
		{
			System.out.println("Usage:\n------\n MaximumPathSum1 <filename> <Height of the pyramid>");
			return;
		}

		String filename = args[0];
		int numOfRows = Integer.parseInt(args[1]);
		int [][] pyramidArr = pyramidToarray(filename,numOfRows);//("pyramid.txt", 15);
		int [][] sumsArray = new int [numOfRows][numOfRows];
		int temp1, temp2 = -1;
		

		//Set sums array
		sumsArray = setArray(sumsArray);
		
		//First row
		sumsArray[0][0] = pyramidArr[0][0];

		//Rest of the pyramid
		for (int i=0; i<sumsArray.length-1; i++)
		{
			for (int j=0; j<sumsArray.length-1; j++)
			{
				if (pyramidArr[i][j] != -1)
				{
					if (sumsArray[i][j] + pyramidArr[i+1][j] > sumsArray[i+1][j])
						sumsArray[i+1][j] = sumsArray[i][j] + pyramidArr[i+1][j];

					if (sumsArray[i][j] + pyramidArr[i+1][j+1] > sumsArray[i+1][j+1])
						sumsArray[i+1][j+1] = sumsArray[i][j] + pyramidArr[i+1][j+1];
					
				}
			}
			
		}

		//Create a max array
		int [] maxArr = createMaxArrayIndexes(sumsArray);

		System.out.println();

		int temp=0; //Holds the max in the maxArr
		for (int i=0; i<maxArr.length; i++)
		{
			if (temp < maxArr[i])
				temp = maxArr[i];
		}
		
		System.out.println("The maxinum total from top to bottom is:\t " + temp + "\n");
		
	}
}