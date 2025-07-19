/* 1. Create a Java program to validate email addresses with a class named Email. This
class stores an email address, trims spaces, and converts it to lowercase. The check() method 
splits the email by using the "@" character, verifying there are two parts: the local part (before 
"@") without a dot, the domain part (after "@") with at least one dot, and no spaces. The valid 
variable is set to true if these conditions are met, otherwise false. The result() method prints 
the email and its validity status. The main class, CheckEmailAddress, prompts the user for an 
email, creates an Email instance, and invokes result() to display the validation outcome. */

import java.util.*;
class Email
{
    boolean b;
    void check(String str)
    {
        String s1=str.trim().toLowerCase();
        String s[]=s1.split("@");
        if(s.length!=2)
        {
         b=false;
         return;
        }
        else if(s[0].contains(".")==true)
        {
         b=false;
         return;
        }
        else if(s[1].contains(".")==false)
        {
         b=false;
         return;
        }
        else 
        {
         b=true;
         return;
        }
    }
    void result()
    {
        if(b==true)
         System.out.println("vaild");
        else
         System.out.println("not vaild");
    }
} 
class EmailMain 
{
    public static void main (String[] args) 
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("enter an email id");
        String e=ob.next();
        Email em=new Email();
        em.check(e);
        em.result();
    }
}