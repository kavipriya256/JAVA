/* 1.Create a class to represent the ATM machine.
2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.
3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().
4. Create a class to represent the user's bank account, which stores the account balance.
5. Connect the ATM class with the user's bank account class to access and modify the account
balance.
6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions. */

import java.util.*;
import java.io.*;

// class to reperesnt ATM machine
abstract class ATM 
{
	abstract void withdraw(int amount);
	abstract void deposit(int amount);
	abstract void checkBalance();
}
// Bank class implementing ATM interface
class Bank extends ATM
{
	PrintWriter pw=new PrintWriter(System.out,true);
	float balance;
	void initialiseBal(int amount)
	{
		balance=amount;
	}
	void withdraw(int amount)
	{
		// Checking if balance is sufficient to withdraw given amount 
		if(amount>balance)
			pw.println("Insufficient Balance, Unable to withdraw Rs."+amount);
		else
		{
			balance-=amount;
			pw.println("Withdrawn Rs."+amount+"\nNew Balance: Rs."+balance);
		}
	}
	void deposit(int amount)
	{
		balance+=amount;
		pw.println("Deposit Rs."+amount+"\nNew Balance: Rs."+balance);
	}
	void checkBalance()
	{
		pw.println("Balance: Rs."+balance);
	}
}
class Task3 
{
	public static void main(String ar[])
	{
		Bank bank=new Bank();
		Scanner ob=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out,true);
		pw.println("Enter initial balance: ");
		int bal=ob.nextInt();
		pw.println("Enter options: 1-deposit,2-withdraw,3-checkBalance,0-exit");
		int ch=ob.nextInt();
		bank.initialiseBal(bal);
		int amount=0;
		while(ch!=0)
		{
			switch(ch)
			{
				case 1:
				{
					pw.println("Enter amount to be deposited: ");
					amount=ob.nextInt();
					bank.deposit(amount);
					break;
				}
				case 2:
				{
					pw.println("Enter amount to be withdrawn: ");
					amount=ob.nextInt();
					bank.withdraw(amount);
					break;
				}
				case 3:
				{
					bank.checkBalance();
					break;
				}
				default:
				{
					pw.println("Enter correct option");
					break;
				}
			}
			pw.println("Enter options: 1-deposit,2-withdraw,3-checkBalance,0-exit");
			ch=ob.nextInt();
		}
		pw.println("THANK YOU, VISIT AGAIN");
	}
}