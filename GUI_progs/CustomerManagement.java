/* ABC Corporation has decided to collect and store the data of their customers. They are 
interested in developing a GUI for this purpose. As a programming expert they are requesting 
your service to develop a java application using swings to store the customer data using the 
following specification. 
Create a class Customer with details like CustomerName, CustomerNumber (Unique for a 
customer), City, State and Pincode. 
Create another class called CustomerManagement. In this class create an ArrayList to store 
the objects of Customer class. Create methods to perform the following activities. 
- Add a Customer into array list. This method should receive a customer class object 
and insert it into array list. 
- Search Customer - This method should accept a Customer Number and searches it 
in the array list. 
In swing application use appropriate components for accepting input and displaying the output. 
Create three buttons namely “Add customer”, “Search Customer” and “Display Customers”. 
- Add Customer button is used to Read the information from the GUI and pass this 
information to addCustomer method of CustomerManagement class to store the 
customer details in the array list. 
- Search Customer – Read a CustomerNumber and pass this to SearchCustomer 
method of CustomerManagement class. If found, then write the corresponding 
customer name in a file, otherwise display the respective error message in a text 
area. 
- DisplayCustomer – Read the customer name from the file and display it in a text 
area. */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Customers
{
	String name,city,state,no,pincode;
	Customers(String n,String num,String c,String s,String p)
	{
		name=n;  city=c;  state=s;
		no=num;  pincode=p;
	}
	@Override
	public String toString()
	{
		return ("Name: "+name+"\nNumber: "+no+"\nCity: "+city+"\nState: "+state+"\nPincode: "+pincode+"\n\n");
	}
}
class CustomerManagement extends JFrame implements ActionListener
{
	ArrayList<Customers> al;
	JTextArea ta;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3,b4;
	JPanel p1,p2;
	JScrollPane js;
	CustomerManagement()
	{
		setSize(700,700);   setVisible(true);
	    setTitle("CustomerManagement");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	    setLayout(new GridLayout(2,1));
		al=new ArrayList<Customers>();
		ta=new JTextArea(30,30);
		p1=new JPanel();  p2=new JPanel();
		l1=new JLabel("name:");  l2=new JLabel("number:");
	    l3=new JLabel("city:");	 l4=new JLabel("state:");
		l5=new JLabel("pincode:");
		t1=new JTextField();  t2=new JTextField();  t3=new JTextField();
		t4=new JTextField();  t5=new JTextField();
		b1=new JButton("add");   b2=new JButton("search");
		b3=new JButton("display"); b4=new JButton("clear");
		p1.setLayout(new GridLayout(7,2));
		p2.setLayout(new FlowLayout());
		p1.add(l1);  p1.add(t1);
		p1.add(l2);  p1.add(t2);
		p1.add(l3);  p1.add(t3);
		p1.add(l4);  p1.add(t4);
		p1.add(l5);  p1.add(t5);
		p1.add(b1);  p1.add(b2);
		p1.add(b3);  p1.add(b4);
		p2.add(ta);
		add(p1);
		js=new JScrollPane(p2);
		add(js);
		b1.addActionListener(this);  b2.addActionListener(this);
		b3.addActionListener(this);  b4.addActionListener(this);
	}
	
	void addCustomer()
	{
		String s1,s2,s3,s4,s5;
		s1=t1.getText();
		s2=t2.getText();
		s3=t3.getText();
		s4=t4.getText();
		s5=t5.getText();
		al.add(new Customers(s1,s2,s3,s4,s5));
		ta.setText("added");
	}
	void searchCustomer()
	{
		boolean found=false;
		String n=t2.getText();
		
		for(int i=0;i<al.size();i++)
		{
			Customers s=(Customers)al.get(i);
			if(n.equals(s.no))
			{
				ta.setText(s.toString());
				found=true; 
				break;
			}
		}
		if(found==false)
			ta.setText("Customer not found");
	}
	void display()
	{
		StringBuilder sb=new StringBuilder();
		sb.setLength(0);
		for(Customers c:al)
		{
			sb.append(c.toString());
		}
		ta.setText(sb.toString());
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
			addCustomer();
		if(ae.getSource()==b2)
			searchCustomer();
		if(ae.getSource()==b3)
			display();
		if(ae.getSource()==b4)
		{
			t1.setText(""); t2.setText("");
			t3.setText(""); t4.setText("");
			t5.setText(""); ta.setText("");
		}
	}
	public static void main(String arg[])
	{
		new CustomerManagement();
	}
}