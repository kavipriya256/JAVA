/* Create abstract class – Account with attributes account id, customer id and abstract
methods – deposit and withdraw. Create child class – SavingAccount from this abstract class.
This class will implement withdraw and deposit methods. deposit method will take account id
and deposit amount. Amount will be deposited into specific account with that id. Method will
return new balance if account with that id exists, else returns -1. withdraw method will take
account id and withdraw amount. It will return -1 if account with specific id does not exist. Else,
it will check if withdraw amount is less than or equal to existing balance. If yes, perform
withdrawal and return new balance. Write a java program to test the SavingAccount class by
creating an instance of it */

import java.util.*;
abstract class Account
{
int acc_id;
int cus_id;
int bal;
abstract int deposit(int a, int am);
abstract int withdraw(int a, int am);
}

class SavingAccount extends Account
{
void get()
{
System.out.println("enter acc_id, cus_id and current balance");
Scanner ob=new Scanner(System.in);
acc_id=ob.nextInt();	
cus_id=ob.nextInt();
bal=ob.nextInt();
}
int deposit(int acc, int amt)
{
if(acc==acc_id)
{
bal=bal+amt;
return bal;
}
else
{
System.out.println("account id doesn't exist");
return -1;
}
}
int withdraw(int acc, int amt)
{
if(acc==acc_id)
{
if(amt<bal)
{
bal=bal-amt;
return bal;
}
else
{
System.out.println("entered amount is more than the balance");
return -1;
}
}
else
{
System.out.println("account id doesn't exist");
return -1;
}
}

}
class AccountDemo
{
public static void main(String ar[])
{
SavingAccount a=new SavingAccount();
a.get();
int ch;
int amt,acc;
System.out.println("enter choice: 1-deposit, 2-withdraw");
Scanner ob=new Scanner(System.in);
ch=ob.nextInt();
if(ch==1)
{
System.out.println("enter acc_id and amount to be deposited:");
acc=ob.nextInt();
amt=ob.nextInt();
int b=a.deposit(acc,amt);
System.out.println("balance after deposition: "+b +"Rs");
}if(ch==2)
{
System.out.println("enter acc_id and amount to be withdraw:");
acc=ob.nextInt();
amt=ob.nextInt();
int b=a.withdraw(acc,amt);
System.out.println("balance after withdrawal: "+b +"Rs");
}
}
}