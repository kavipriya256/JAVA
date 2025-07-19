/* Currency Selection: Allow the user to choose the base currency and the target
currency.
Currency Rates: Fetch real-time exchange rates from a reliable API.
Amount Input: Take input from the user for the amount they want to convert.
Currency Conversion: Convert the input amount from the base currency to the
target currency using the fetched exchange rate.
Display Result: Show the converted amount and the target currency symbol
to the user. */

import java.util.*;
import java.io.*;

class Task4 
{
	public static void main(String ar[])
	{
		Scanner ob=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out,true);
		// Currency Selection 
		pw.println("Enter choice:\n1-Rupee to Dollar, 2-Dollar to Rupee");
		int ch=ob.nextInt();
		if(ch==1)
		{
			// Getting amount from user in rupee 
			pw.println("Enter amount in rupee");
			float r=ob.nextFloat();
			// Currency conversion- rupee to dollar
			float d=r*0.012f;
			// Displaying results
			pw.println(r+"rupee="+d+"$");
		}
		else if(ch==2)
		{
			// Getting amount from user in  dollar
			pw.println("Enter amount in dollar");
			float d=ob.nextFloat();
			// Currency conversion- dollar to rupee
			float r=d/0.012f;
			// Displaying results
			pw.println(d+"$="+r+"rupee");
		}
		else 
			pw.println("Invalid choice");
	}
}