public class Special_Pythagorean_triplet
{
	/*
	This class finds a only pythagorean triplet where each of the factors
	is less than 1000.
	Approach: try all possible options and terminate when tripplet found.
	*/
	public static void main(String [] args)
	{
		int [] triplet = {1,1,1};
		int result = 1;

		while (triplet[0] < 1000)
		{
			//Check if sum is 1000
			if (triplet[0]+triplet[1]+triplet[2] == 1000)
			{
				//Check if a^2+b^2=c^2
				if (Math.pow(triplet[0],2) + Math.pow(triplet[1],2) == Math.pow(triplet[2],2))
				{
					//calculate the product
					result = triplet[0]*triplet[1]*triplet[2];
					System.out.println("tripplet:\t" + triplet[0] + "\t" + triplet[1] + "\t" + triplet[2]);
					System.out.println("Result is\t" + result);
					return;
				}
			}

			
			//Incremnt the triplet
			if ((triplet[1] == 999) && (triplet[2]==999))
			{
				triplet[0]++;
				triplet[1]=1;
				triplet[2]=1;
			}

			else if (triplet[2] == 999)
			{
				triplet[1]++;
				triplet[2] = 1;
			}

			else 
				triplet[2]++;
		}
	}
}