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
	PrintWriter p=new PrintWriter(System.out,true);
	EBBill()
	{
		hn=0; name=" ";
		s=e=0;
	}
	EBBill(int n,String m,float a, float b)
	{
		hn=n; name=m;
		s=a; e=b;
	}
    /* public String toString()
    {
        return ("houseNo.: "+hn+" tenant's name: "+name+" energymeter reading: start-"+s+" end-"+e+" bill: "+bill);
    } */
	void saveData(int[] hn, String[] name, float[]s, float[] e) throws IOException
    {
		
        FileOutputStream fout=new FileOutputStream("EbDetails.txt");
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fout));
		for(int i=0;i<4;i++)
			bw.write(hn[i]+","+name[i]+","+s[i]+","+e[i]+"\n");
		p.println("saved successfully");
		bw.close();
		fout.close();
    }
	void calcBill(int hno)throws IOException
	{
		FileInputStream fin=new FileInputStream("EbDetails.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(fin));
		String line;
		while((line=br.readLine())!=null)
		{
			String arr[]=line.split(",");
			int h=Integer.parseInt(arr[0]);
			if(h==hno)
			{
				float sr=Float.parseFloat(arr[2]);
				float er=Float.parseFloat(arr[3]);
                float bill=(er-sr)*10;
                p.println("House Details:\nHouseNo: "+h+" Tenant's name: "+arr[1]+" Readings: start-"+sr+" ending-"+er+" Bill: "+bill);		
                break;				
			}
		}
		br.close();
		fin.close();
	}
	}
class EbDetailsMain
{
	public static void main(String arg[])
	{
	Scanner ob=new Scanner(System.in);
	PrintWriter p=new PrintWriter(System.out,true);
	p.println("1-saveData, 2-calcBill");
	EBBill eb=new EBBill();
	int ch=ob.nextInt();
	if(ch==1)
	{
	int hn[]=new int[4];
	String name[]=new String[4];
	float s[]=new float[4];
	float e[]=new float[4];
	for(int i=0;i<4;i++)
	{
		p.println("enter houseNo., tenant's name, reading of enerygymeter (start and end) of tenant"+(i+1));
		hn[i]=ob.nextInt();
		name[i]=ob.next();
		s[i]=ob.nextFloat();
		e[i]=ob.nextFloat();
	}
		try
		{ eb.saveData(hn,name,s,e); }
		catch(IOException se)
		{ p.println("unable to save data"); }
	}
		
	else if(ch==2)
	{
		p.println("enter houseNo ");
		int hno=ob.nextInt();
		try
		{ eb.calcBill(hno); }
		catch(IOException ce)
		{ p.println("unable to calc bill"); }
	}
	else
		p.println("choice is wrong");
	}
}