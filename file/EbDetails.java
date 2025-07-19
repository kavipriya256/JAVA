/* Create a class called “ EBBill ” with the following instance variables: house number, name
of the tenant, starting energymeter reading, ending energymeter reading and bill amount.
Create a java application to get the above mentioned details, get House number, name of the
tenant, starting energy meter reading and ending energy meter reading. Add two functions
SaveData ’ and CalculateBill . Add a Menu for displaying the details , When ‘ SaveData ’ is
selected, create a EBBill class object from the entered details and store it in an file. The data
is to be entered for all the 4 houses and to be saved. The amount is to be calculated as (ending
energy meter reading starting energymeter reading) X Rs . 10 per unit. After entering the
house number for which bill amount is to be calculated the ‘ CalculateBill ’ is to be pressed
and the details to be displayed. */

import java.util.*;
import java.io.*;

class EBBill 
{
    int hn;
    String name;
    float s,e,bill;
    EBBill(int n,String nm, float a, float b)
    {
        hn=n; name=nm;
        s=a; e=b;
        bill=0.0;
    }
    public String toString()
    {
        return ("houseNo.: "+hn+" tenant's name: "+name+" energymeter reading: start-"+s+" end-"+e+" bill: "+bill);
    }
}
class EbDetails()
{
	public static void main(String arg[])
	{
	PrintWriter p=new PrintWriter(System.out,true);
	int 
	for(int i=0;i<4;i++)
	{
		p.println("enter houseNo., tenant's name, reading of enerygymeter (start and end) of tenant"(i+1));

	}
    void saveData()
    {
        FileOutputStream fout=new FileOutputStream("EbDetails.txt");
    }
	}
}