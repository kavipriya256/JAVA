import java.io.*;
import java.util.*;
class Main 
{
    public static void main (String[] args) throws IOException,FileNotFoundException
    {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
		String s[]=new String[10];
		pw.println("enter stop to stop");
		String l;
		for(int i=0;i<10;i++)
		{
			s[i]=br.readLine();
			if(s[i].equals("stop"))
				break;
		}
		for(int i=0;i<10;i++)
		{
			if(s[i].equals("stop"))
				break;
			pw.println(s[i]);
		}
    }
}