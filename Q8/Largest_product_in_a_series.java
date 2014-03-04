public class Largest_product_in_a_series
{
	/*
		this class finds the largest product of 5 consecutive numbers
		from a given string
	*/

	public static int [] stringToArray(String str)
	{
		/**This method convert a string to integer array
		@param str the string to convert
		@return int[]
		*/
		int len = String.valueOf(str).length();
		int [] numArr = new int[len];

		for (int i=0; i<len; i++)
			numArr[i] = Integer.parseInt(str.substring(i,i+1));

		for (int i=0; i<len; i++)
		{
			System.out.print(numArr[i]);
			
		}
		System.out.println();

		return numArr;
	}

	/**This method multiplies all the elements of an integers array
	@param arr the array to multiply
	@return int
	*/
	public static int multiplyArray(int [] arr)
	{

		int mult = 1;

		for (int i=0; i<arr.length; i++)
			mult = mult * arr[i];

		return mult;
	}

	public static void main(String [] args)
	{
		String num = "731671765313306249192251196744265747423553491949349698352" +
					 "031277450632623957831801698480186947885184385861560789112" +
					 "949495459501737958331952853208805511125406987471585238630" +
					 "507156932909632952274430435576689664895044524452316173185" +
					 "640309871112172238311362229893423380308135336276614282806" +
					 "444486645238749303589072962904915604407723907138105158593" +
					 "079608667017242712188399879790879227492190169972088809377" +
					 "665727333001053367881220235421809751254540594752243525849" +
					 "077116705560136048395864467063244157221553975369781797784" +
					 "617406495514929086256932197846862248283972241375657056057" +
					 "490261407972968652414535100474821663704844031998900088952" +
					 "434506585412275886668811642717147992444292823086346567481" +
					 "391912316282458617866458359124566529476545682848912883142" +
					 "607690042242190226710556263211111093705442175069416589604" +
					 "080719840385096245544436298123098787992724428490918884580" +
					 "156166097919133875499200524063689912560717606058861164671" +
					 "094050775410022569831552000559357297257163626956188267042" +
					 "8252483600823257530420752963450";
		int [] section;
		int tail = 0;
		int head = 5;
		int result = 0;
		int max = 0;

		while (head <= String.valueOf(num).length())
		{
			section = stringToArray(num.substring(tail,head));
			result = multiplyArray(section);

			if (max < result)
				max = result;

			head++;
			tail++;
		}
		
		System.out.println("Max product is:\t"+max);
		// System.out.println(num.substring(1,2));

	}
}