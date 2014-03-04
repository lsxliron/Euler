import java.io.*;

/**This class finds the max product of 4 consecutive numbers (row, column
or diagonal). 
*/
public class Largest_product_in_a_grid
{
	

		/**This function reads a text file and put it inside a 2D array
		* @param filname the filename to read from
		* @param numOfRows the number of rows in the array
		* @param numOfCols the number of cols on the array
		* @return int [][]
		* @throws FileNotFoundException,IOException
		*/
	public static int[][] fileToArray(String filename, int numOfRows, int numOfCols) throws FileNotFoundException,IOException
	{
		
		
		    int row = 0;
		    int [][] arr = new int [numOfRows][numOfCols];
		    String line;
	    try
		{
			InputStream is = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		    while ((line = br.readLine()) != null)
		    {
		        String[] nums = line.split(" ");

		        for (int col = 0; col < nums.length; col++)
		        {
		            int n = Integer.parseInt(nums[col]);
			        arr[row][col] = n;
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

	/** This function returns the largest product of 4 consecutive numbers
		int the same direction in a 2D array.
		@param arr the 2D array
		@direction the directon of the proudct. accepts ROW, COL and DIAGONAL
		@return int
		@throws IOException
	*/
	public static int multiplyArray(int [][] arr, String direction) throws IOException
	{
		int result = 0;
		int temp = 0;
		try
		{
			if (direction == "ROW")
			{
				for (int i=0; i<20; i++)
					for (int j=0; j<17; j++)
					{
						temp = arr[i][j] * arr[i][j+1] * arr[i][j+2] * arr[i][j+3];
						if (temp > result)
							result = temp;
						
					}
				System.out.println("MAX ROW MULTIPLICATION:\t\t" + result);
			}


			else if (direction == "COLUMN")
			{
				for (int i=0; i<17; i++)
					for (int j=0; j<20; j++)
					{
						temp = arr[i][j] * arr[i+1][j] * arr[i+2][j] * arr[i+3][j];
						if (temp > result)
							result = temp;
					}
					System.out.println("MAX COLUMN MULTIPLICATION:\t" + result);
			}

			else if (direction == "DIAGONAL")
			{
				for (int i=0; i<17; i++)
					for (int j=0; j<17; j++)
					{
						temp = arr[i][j] * arr[i+1][j+1] * arr[i+2][j+2] * arr[i+3][j+3];
						if (temp > result)
							result = temp;
					}
					System.out.println("MAX DIAGONAL1 MULTIPLICATION:\t" + result);

					result = 0;
					temp = 0;

					for (int i=3; i<20; i++)
						for (int j=3; j<17; j++)
						{
							temp = arr[i][j] * arr[i-1][j+1] * arr[i-2][j+2] * arr[i-3][j+3];
							if (temp > result)
								result = temp;
						}
						System.out.println("MAX DIAGONAL2 MULTIPLICATION:\t" + result);
			}

			else 
				throw new IOException();
		}
		catch (IOException e)
		{
			System.out.println("ERROR, input not defined.");
		}

		return result;
	}
	
	public static void main (String [] args) throws FileNotFoundException,IOException
	{
		//Check if user typed all the arguments
		
		if (args.length < 3)
		{
			System.out.println("\nUsage:\n------\n Largest_product_in_a_grid [Filename] [# of rows] [# of cols]\n\n");
			return;
		}
		final String FILENAME = args[0];
		final int ROWS = Integer.parseInt(args[1]);
		final int COLS = Integer.parseInt(args[2]);
		

		int row, diag, col = 0;
		int [][] grid = fileToArray(FILENAME, ROWS, COLS);
		int maxValue = 0;
		//Case file not found
		if (grid == null)
			return;

		
		row = multiplyArray(grid, "ROW");
		col = multiplyArray(grid, "COLUMN");
		maxValue = Math.max(row, col);

		diag = multiplyArray(grid, "DIAGONAL");
		maxValue = Math.max(maxValue, diag);

		System.out.println("MAX PRODUCT:\t\t\t" + maxValue);



		
		
			
		
		

		

	    // for (int i=0; i<20; i++)
	    // 	for (int j=0; j<20; j++)
	    // 		System.out.print(grid[i][j]+"\t");
	    	
	    	
	    
    }	
}