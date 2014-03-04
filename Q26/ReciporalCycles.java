import java.util.regex.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.*;
public class ReciporalCycles
{

	// public static void findLongestPattern(String original)
	// {


	// }


	public static void main(String [] args)
	{
		// MathContext mc = new MathContext(MathContext.DECIMAL128);
		BigDecimal num = new BigDecimal("0");
		BigDecimal denom;
		Pattern p = Pattern.compile("(\\d.+).*\\1");
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> temp2 = new ArrayList<String>();

		MathContext mc = new MathContext(100);
		
		
		for (int i=2; i<1000; i++)
		{
			denom = new BigDecimal(i);
			num = new BigDecimal("1").divide(denom,mc);
			String numStr = String.valueOf(num);
			numStr = numStr.substring(2, numStr.length());	
			Matcher m = p.matcher(numStr);
			
			if (m.matches())
			{
				// if ((m.group(1).length() != 100) && (m.group(1).length() != 2))
					temp.add(i + "\t " + m.group(1) + "(" + m.group(1).length()+")");
				// if (m.group(1) != "00")
				// System.out.println(i + "\t " + m);
				// System.out.println(i + "\t " + m.group(1) + "(" + m.group(1).length()+")");

			}

			

		}

		

		// Collections.sort(temp);
		for (int i=0; i<temp.size(); i++)
		{
			System.out.println(temp.get(i));
		





			// Matcher m2 = p.matcher((temp.get(i)).substring(4,temp.get(i).length()));
			// if (m2.matches())
			// 	temp2.add(temp.get(i).substring(0,4) + "\t " + m2.group(1) + "(" + m2.group(1).length()+")");

			// if (temp.get(i) == "00")	
				// temp.remove(i);	
		}

		String s = String.valueOf(new BigDecimal("1").divide(new BigDecimal("999"),mc));
		s = s.substring(2,s.length());
		
		Matcher mm = p.matcher(s);
		
		System.out.println(s);
		System.out.println(mm);
		// for (int i=0; i<temp2.size(); i++)
		// {
		// 	System.out.println(temp2.get(i));
		// }
		// // for (int i=0; i<temp.size(); i++)
		// 	// System.out.println(i + "\t" + temp.get(i));

		System.out.println("\n\n"+temp2.size());
		// double d = 1.0/11.0;
		// String a=String.valueOf(d);
		// a=a.substring(2,a.length());
		// System.out.println(a);
		// Pattern p = Pattern.compile( "(\\d.+).*\\1.*" );//THE GOOD ONE
		// Pattern p = Pattern.compile("(.+)(?=.*\\1.*?)");

		// Matcher m = p.matcher(a);
		// System.out.println(m.matches());
		// System.out.println(m.group());

		// System.out.println(m.toString());
		// System.out.println(m.group(1));

		// Pattern p = Pattern.compile("a*b");
		// Matcher m = p.matcher("aaaaab");
		// boolean b = m.matches();
		// System.out.println(new BigDecimal("1").divide(new BigDecimal("997"),mc));

	}
}