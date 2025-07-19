/* Write a program for Employee registration process, take the employee details like empId,
empName, age from user and register employee through addEmployee method, and throw
the user defined exception like AgeMisMatchException, if the age of the employee is not
greater than 18. */

import java.util.*;
class AgeMisMatchException extends Exception 
{
	AgeMisMatchException(String msg)
	{
		super(msg);
	}
}
class EmpReg
{
int empId,age;
String empName;
void addEmp(int i,String n,int a) throws AgeMisMatchException
{
empId=i;
age=a;
empName=n;
if(a<=18) 
throw new AgeMisMatchException("Age should be more than 18");
else
System.out.println("Registered successfully...");
}
}
class EmpDemo
{
public static void main(String ar[])
{
EmpReg e=new EmpReg();
Scanner ob=new Scanner(System.in);
System.out.println("enter employee Name,Id,Age ");
String n=ob.nextLine();
int i=ob.nextInt();
int a=ob.nextInt();
try
{
e.addEmp(i,n,a);
}
catch(AgeMisMatchException ame)
{
System.out.println(ame.getMessage());
}
}
}