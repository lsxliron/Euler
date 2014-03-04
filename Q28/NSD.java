
/**
*	This class creates a grid filled spirally with consecutive integers and returns the sum of the diagonals.
*/
public class NSD
{		
		private int [][] _grid;
		private int _xMiddle;
		private int _yMiddle ;
		private int _content;
		private int _upDownDirection;	//-1 down,  1 up
		private int _leftRightDirection;	//1 right, -1 left
		private int _counter;
		private int _xLocation;
		private int _yLocation ;
		
		/**
		*	This constractor creates an NSD object
		*	NSD stands for Number Spiral Diagonals, meaning- an 2D array filled with consecutive integers 
		*	starting from the middle and moving spiraly increasing.
		*	@param size The size of the 2D array.
		*/
		public NSD(int size)
		{
			_grid = new int [size][size];
			_yMiddle = size/2;
			_xMiddle = size/2;
			_content = 1;
			_upDownDirection = -1;
			_leftRightDirection = 1;
			_counter = 1;
			_xLocation = _xMiddle;
			_yLocation = _yMiddle;
		}

		/**
		*	This method fills the NSD with integers
		*/
		public void createAndFillGrid()
		{
			//Fill the first value in the middle
			_grid[_xMiddle][_yMiddle] = _content;
			_content++;

			//Fill the rest of the grid
			while (_counter <_grid.length)
			{
				//Move horizontaly
				this.fillGridHorizontal(this._grid, this._content, this._counter, this._xLocation, 
									    this._yLocation, this._leftRightDirection);

				//Move vertically
				this.fillGridVertical(this._grid, this._content, this._counter, this._yLocation, 
									    this._xLocation, this._upDownDirection);

				_leftRightDirection = -_leftRightDirection;
				_upDownDirection = -_upDownDirection;
				_counter+=1;
			}

			//Fill the top row at the end of execution
			for (int i=1; i<_grid.length; i++)
			{
				_grid[0][i] = _content;
				_content++;
			}

		}

		//This  method fills the grid horizontally. When direction = 1 filling occurs left to right
		//and when direction = -1 filling is right to left
		private void fillGridHorizontal(int [][] grid, int content, int counter, int currentLocation, 
									  int verticalLocation, int direction)
		{
			//Check direction
			if (direction < 0)
			{
				for (int i=-1; i>=-this._counter; i--)
				{
					grid[verticalLocation][currentLocation + i]= _content;
					_xLocation = currentLocation + i;
					this._content++;
				}
			}

			else
			{
				for (int i=1; i<=this._counter; i++)
				{
					grid[verticalLocation][currentLocation + i] = _content;
					_xLocation = currentLocation + i;
					this._content++;
				}
			}
			
		}

		//This  method fills the grid horizontally. When direction = 1 filling occurs bottom to top
		//and when direction = -1 filling is top to bottom
		private void fillGridVertical(int [][] grid, int content, int counter, int currentLocation, 
									  int horizontalLocation, int direction)
	{
		//Check direction
		if (direction > 0)
		{
			for (int i=-1; i>=-this._counter; i--)
			{
				this._grid[currentLocation + i][horizontalLocation] = _content;
				_yLocation = currentLocation + i;
				_content++;
			}
		}

		else
		{
			for (int i=1; i<=_counter; i++)
			{
				_grid[currentLocation + i][horizontalLocation] = _content;
				_yLocation = currentLocation + i;
				_content++;
			}
		}
	}

		/**
		*	This method prints the grid to the display.
		*/
		public void printGrid()
		{
			for (int i=0; i<this._grid.length; i++)
			{
				for (int j=0; j<this._grid[i].length; j++)
					System.out.print(this._grid[i][j] + "\t");
				System.out.println();
			}
		}

		/**
		*	This method sums the diagonals of the grid
		*	@return int
		*/
		public int sumDiagonals()
		{
			int diagonal1 = 0;
			int diagonal2 = 0;
			int j=0;

			//First diagonal
			for (int i=0; i<_grid.length; i++)
				diagonal1 += _grid[i][i];
			
			
			//Second diagonal
			for (int i=_grid.length-1; i>=0; i--)
			{

				diagonal2 += _grid[i][j];
				j++;
				
			}
			
			return diagonal1 + diagonal2-1;
		}


		public static void main(String [] args)
		{
			if (args.length != 1)
			{
				System.out.println("Usage:\n------\nNSD <Size of grid>\n");
				return;
			}

			NSD g = new NSD(Integer.parseInt(args[0]));
			int sum = 0;
			g.createAndFillGrid();
			sum = g.sumDiagonals();
			System.out.printf("\n\nThe sum of the diagonals of a %s x %s grid is: %d\n\n",args[0], args[0], sum);


		}

}