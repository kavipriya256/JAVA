import java.util.*;
import java.io.*;
class OddEven
{
public static void main(String ar[])throws FileNotFoundException, IOException
{
Scanner ob=new Scanner(System.in);
PrintWriter pw=new PrintWriter(System.out,true); // true:  flush on new line.
FileOutputStream fout=new FileOutputStream("master.txt");
int no; //no.
pw.println("enter numbers and enter -1 to stop");
do{
	no=ob.nextInt();
	if(no==-1)
		break;
	else
	{
        String s=no+" ";		
		fout.write(s.getBytes());
	}
}while(no!=-1);
  fout.close();
  FileInputStream fin=new FileInputStream("master.txt");
  FileOutputStream ofout=new FileOutputStream("odd.txt");
  FileOutputStream efout=new FileOutputStream("even.txt");
  StringBuilder num=new StringBuilder();
  int j;
  while((j=fin.read())!=-1)
  {
	  char ch=(char)j;
	  if(Character.isDigit(ch))
		num.append(ch);
	  else if(ch==' ')
	  {
		  int n=Integer.parseInt(num.toString()); // convert StringBuilder to string, and use parseInt
		  String s=n+" ";
		  if(n%2==0)
			  efout.write(s.getBytes());
		  else 
			  ofout.write(s.getBytes());
		  num.setLength(0);
	  }
  }
  pw.println("successfully written in odd,even files");
  FileInputStream ofin=new FileInputStream("odd.txt");
  FileInputStream efin=new FileInputStream("even.txt");
  pw.println("odd file:");
  while((j=ofin.read())!=-1)
  {
	 pw.print((char)j);
	 pw.flush();
  }
  pw.println();
  pw.println("even file:");
  while((j=efin.read())!=-1)
  {
	 pw.print((char)j);
	 pw.flush();
  }
  /* Without flushing, PrintWriter 
	 might hold the content in its buffer and not 
	 print it until it's full or the program ends.*/
  efin.close();
  ofin.close();
  ofout.close();
  efout.close();
}
}
