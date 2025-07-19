/* 1. Generate a random number within a specified range, such as 1 to 100.
2. Prompt the user to enter their guess for the generated number.
3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.
4. Repeat steps 2 and 3 until the user guesses the correct number.
You can incorporate additional details as follows:
5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won. */

import java.util.*;
import java.io.*;

class Task1
{
	public static void main(String ar[])
	{
		int min=1;
        int max=100;
        int guess;
		String ch="";
        Scanner ob=new Scanner(System.in);
        PrintWriter pw=new PrintWriter(System.out,true);
        int i,round=0;
		float score[]=new float[20];
		boolean won=false;
		do
		{
		// Generating random number
		int num=(int)(Math.random()*(max-min))+min;
		round++;
		// An user is given 3 attempts to guess
        for(i=0;i<3;i++)
        {
			// Prompting the user to enter his/her guess 
	        pw.println("Guess"+(i+1));
	        pw.println("enter your guess");
	        guess=ob.nextInt();
			// Comparing user's guess with the generated number
	        if(guess==num)
	        {
		        pw.println("Yaass, your guess is right");
				won=true;
		        break;
	        }
	        else if((guess-num)<0)
	        {
		        if((guess-num)<-20)
			        pw.println("your guess is too low");
		        else
			        pw.println("your guess is low");
	        }
	        else if((guess-num)>0)
	        {
		        if((guess-num)>20)
			        pw.println("your guess is too high");
		        else
			        pw.println("your guess is high");
	       }
        }
		if(won==false)
			pw.println("The number is "+num);
		score[round]=((float)(3-i)/3)*100;
		pw.println("your score for round"+round+" : "+score[round]);
		// Option to play multiple rounds
		pw.println("Wanna play again?(yes/no)");
		ch=ob.next();
		}while(!ch.equals("no"));
		// Calculating and displaying score of the user
		if(round>1)
		{
			float totScore=0;
		    for(int k=1;k<=round;k++)
			   totScore+=score[k];
		    pw.println("Total Score: "+(totScore/round));
		}
		
	}
}

