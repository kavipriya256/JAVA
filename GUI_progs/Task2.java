/* Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user */

/*
Grade:
    90-100: S
	80-90 : A
	70-80 : B 
	60-70 : C 
	50-60 : D 
	<50   : F (Fail)
*/

import java.util.*;
import java.io.*;
class Task2 
{
	public static void main(String ar[])
	{
		int m[]=new int[5];
		int sum=0;
		float avg;
		char grade;
		Scanner ob=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out,true);
		
		// Getting marks from user
		pw.println("Enter 5 subject marks:");
		for(int i=0;i<5;i++)
			m[i]=ob.nextInt();
		// Calculating total sum
		for(int i=0;i<5;i++)
			sum+=m[i]; 
		// Calculating average percentage 
		avg=(float)sum/5;
		// Grade calculation 
		if(avg>90)
			grade='S';
		else if(avg>80 && avg<90)
			grade='A';
		else if(avg>70 && avg<80)
			grade='B';
		else if(avg>60 && avg<70)
			grade='C';
		else if(avg>50 && avg<60)
			grade='D';
		else
			grade='F';
		// Displaying results to the user
		pw.println("\n***** RESULTS *****");
		pw.println("Total marks: "+sum);
		pw.println("Average percentage: "+avg);
		pw.println("Grade: "+grade);
	} 
}