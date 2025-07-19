/* 1. Write a program to store all the details of the employees present in an organization. The
details of the employee include employee id, name, date of birth, salary and designation of
the employee. You can use a file to store the information of all the employees. After adding
the details of the employees also add a feature to print the details of all the employees that
were added. Modify the above program such that the end user is given a privilege to check
whether and employee exists or not */

import java.io.*;
import java.util.*;

class EmpDetails 
{
public static void main(String args[]) throws FileNotFoundException, IOException
{
Scanner ob=new Scanner(System.in);
PrintWriter p=new PrintWriter(System.out,true);
int id,dob;
String name,desig;
float sal;
int n;
p.println("enter number of employees: ");
n=ob.nextInt();
FileOutputStream fout=new FileOutputStream("emp.txt");
BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fout));
for(int i=0;i<n;i++)
{
	System.out.println("enter id,name,dob,salary,designation of employee "+(i+1));
	id=ob.nextInt();
	name=ob.next();
    dob=ob.nextInt();
    sal=ob.nextFloat();
    desig=ob.next();
	bw.write(id+" "+name+" "+dob+" "+sal+" "+desig+"\n");
}
bw.close();
fout.close();
/* if BufferedWriter is not close, the content will not be written to file
The data remains in the buffer and is not flushed to the file. 
You need to explicitly close or flush the BufferedWriter after writing 
to the file to ensure the data is properly saved. */

FileInputStream fin=new FileInputStream("emp.txt");
BufferedReader br=new BufferedReader(new InputStreamReader(fin));
String line;
while((line=br.readLine())!=null)
{
	String arr[]=line.split(" ");
	p.println("id: "+arr[0]+" name: "+arr[1]+" dob: "+arr[2]+" salary: "+arr[3]+" designation: "+arr[4]);
}
//br and fin traversed through entire file and now present at end of the file
p.println("wanna check for an employee? (yes/no)");
String ch=ob.next();
if(ch.equals("no"))
{
	br.close();
	fin.close();
	return;
}
//else 
p.println("enter id"); 
int idn=ob.nextInt();
boolean found=false;
//reinitialise so that the pointer comes to the beginning of the file
fin=new FileInputStream("emp.txt");
br=new BufferedReader(new InputStreamReader(fin));
while((line=br.readLine())!=null)
{
	String arr[]=line.split(" ");
	int eid=Integer.parseInt(arr[0]);
	if(eid==idn)
	{
		found=true;
		break;
	}
}
if(found==true)
	p.println("employee exists");
else
	p.println("employee doesn't exist");
br.close();
fin.close();
}
}