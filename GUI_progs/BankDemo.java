/* Bank X has decided to collect and store the customer details. They are interested in developing 
a graphical user interface for the transaction purpose. Assume that you are the programming 
expert, so that they are requesting your service to develop a swing-based java application to 
store and manipulate the customer details using the following specifications: 
Create an interface named as “Bank” with the following methods: 
deposit(double); 
wthdrawal(double); 
checkBalance(); 
Create a class “Customer” which implements the above interface along with data members 
such as customerName, accountNumber (unique for a customer), balance. 
Create another class called “BankDemo”. In this class create an ArrayList to store the objects 
of Customer class. Create methods to perform the following activities: 
- add_customer() - this method should receive a customer class object and insert it 
into array list. 
- deposit() – have to reflect the balance by adding the deposit amount 
- withdrawal() – have to reflect the balance by subtracting the withdrawal amount 
- checkBalance() - this method should accept a AccountNumber and returns the 
corresponding customer balance. 
Note: (initialize the arraylist with 5 records). 
Create a frame window with 3 text field to accept the input values for customerName, 
accountNumber and amount along with 1 textarea component to display the customer details. 
Create five buttons namely “Add Customer”, “Deposit”, “Withdrawal”, and “Check Balance” 
and Display”. 
Add button - is used to read the information from the GUI and pass this information to array 
list. 
Deposit button – get the deposit amount from the “amount” textfield and perform the deposit 
operation. If the deposit amount is invalid (i.e., <= 0), then throw the user-defined exception 
“InvalidAmountException”
Withdrawal button – get the withdrawal amount from the “amount” textfield and perform the 
withdrawal operation. If the balance is not sufficient to withdraw, then throw the user-defined 
exception called as “InSufficientFundException”.
CheckBalance button - read an accountNumber and pass this to checkBalance method of 
BankDemo class. If found, then display the balance in the “amount“ textfield itself. 
Display button – display all customer details in the textarea component. 
 */
 
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import java.util.*;
 
class InvalidAmountException extends Exception
{
	InvalidAmountException(String msg)
	{
		super(msg);
	}
} 
 class InSufficientFundException extends Exception
 {
	 InSufficientFundException(String msg)
	 {
		 super(msg);
	 }
 }
 
 interface Bank
 {
	void deposit(double x)throws InvalidAmountException; 
    void wthdrawal(double x)throws InSufficientFundException; 
    void checkBalance();
 }
 class Customer implements Bank 
 {
	 String name;
	 String acc_no;
	 double bal;
	 
	 Customer(String n,String a,double b)
	 {
		 name=n; acc_no=a; bal=b;
	 }
	 public String toString()
	 {
		 return("Name: "+name+"\nAccount number: "+acc_no+"\nBalance: "+bal+"\n\n");
	 }
	 public void deposit(double amt) throws InvalidAmountException
	 {
		 if(amt<0)
			 throw new InvalidAmountException("amount cant be negative");
		 else
			 bal+=amt;
	 }
	 public void wthdrawal(double amt) throws InSufficientFundException
	 {
		 if(bal<amt)
			 throw new InSufficientFundException("balance is less than the amount specified");
		 else
			 bal-=amt;
	 }
	 public void checkBalance()
	 {
		 System.out.println("Balance Rs."+bal);
	 }
 }
 class BankDemo extends JFrame implements ActionListener
 {
	 ArrayList <Customer> al;
	 JButton b1,b2,b3,b4,b5,b6;
	 JTextField t1,t2,t3;
	 JLabel l1,l2,l3;
	 JTextArea ta;
	 JPanel p1,p2;
	 BankDemo()
	 {
		 setVisible(true);
		 setTitle("BANK");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setLayout(new GridLayout(1,2));
		 setSize(500,600);
		 al=new ArrayList<Customer>();
		 al.add (new Customer("alice","12700",500));  
		 al.add (new Customer("bob","12701",700));
		 al.add (new Customer("charlie","12702",300));
		 al.add (new Customer("david","12703",1000));
		 al.add (new Customer("eve","12704",900));
		 b1=new JButton("Add");
		 b2=new JButton("Deposit");
		 b3=new JButton("Withdraw");
		 b4=new JButton("BalanceCheck");
		 b5=new JButton("Display");
		 b6=new JButton("Clear");
		 l1=new JLabel("Customer Name");
		 l2=new JLabel("Account No.");
		 l3=new JLabel("Amount");
		 t1=new JTextField();
		 t2=new JTextField();
		 t3=new JTextField();
		 ta=new JTextArea();
		 p1=new JPanel();
		 p2=new JPanel();
		 p1.setLayout(new GridLayout(6,2));
		 p2.setLayout(new GridLayout(1,1));
		 p1.add(l1);  p1.add(t1);
		 p1.add(l2);  p1.add(t2);
		 p1.add(l3);  p1.add(t3);
		 p1.add(b1);  p1.add(b2);
		 p1.add(b3);  p1.add(b4);
		 p1.add(b5);  p1.add(b6);
		 p2.add(ta);
		 add(p1); add(p2);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 b5.addActionListener(this);
		 b6.addActionListener(this);
	 }
	 public void actionPerformed(ActionEvent ae)
	 {
		 String n,ac;
		 double amt;
		 Customer ob;
		 if(ae.getSource()==b1)
		 {   n=t1.getText();
			 ac=t2.getText();
			 amt=Double.parseDouble(t3.getText());
			 add_customer(new Customer(n,ac,amt));
		 }
		 if(ae.getSource()==b2)
		 {
			ac=t2.getText();
			amt=Double.parseDouble(t3.getText());
			for(int i=0;i<al.size();i++)
			{
				ob=(Customer)al.get(i);
				if(ob.acc_no.equals(ac))
				{
					try
					{	 
					    ob.deposit(amt);
						ta.setText("Deposited Rs."+amt+"\nBalance Rs."+ob.bal);
					}
					catch(InvalidAmountException e)
					{
						ta.setText(e.getMessage());
					}
					break;
				}
			}
		 }
		 if(ae.getSource()==b3)
		 {
			ac=t2.getText();
			 amt=Double.parseDouble(t3.getText());
			 for(int i=0;i<al.size();i++)
			 {
				 ob=(Customer)al.get(i);
				 if(ob.acc_no.equals(ac))
				 {
					 try
					 {	 
						ob.wthdrawal(amt);
						ta.setText("Withdrawn Rs."+amt+"\nBalance Rs."+ob.bal);
					 }
					 catch(InSufficientFundException e)
					 {
						 ta.setText(e.getMessage());
					 }
					 break;
				 }
			 } 
		 }
		 if(ae.getSource()==b4)
		 {
			 ac=t2.getText();
			 for(int i=0;i<al.size();i++)
			 {
				 ob=(Customer)al.get(i);
				 if(ob.acc_no.equals(ac))
				 {
					 checkBalance(ac);
					 break;
				 }
			 }
		 }
		 if(ae.getSource()==b5)
		 {
			 StringBuilder sb=new StringBuilder();
			 sb.setLength(0);
			 for(Customer c:al)
			 {
				 sb.append(c.toString());
			 }
			 ta.setText(sb.toString());
		 }
		 if(ae.getSource()==b6)
		 {
			 t1.setText("");
			 t2.setText("");
			 t3.setText("");
			 ta.setText("");
		 }
	 }
	 void add_customer(Customer ob) 
	 {
		 al.add(ob);
		 ta.setText("Added");
	 }
	 void checkBalance(String ac)
	 {
		 Customer ob;
		 for(int i=0;i<al.size();i++)
		 {
			 ob=(Customer)al.get(i);
			 if(ob.acc_no.equals(ac))
			 {
				 ta.setText("Balance Rs."+ob.bal);
				 return;
			 }	
		 }
		 ta.setText("Account not found");
	 }
	 public static void main(String arg[])
	 {
		 new BankDemo();
	 }
 }