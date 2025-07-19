/*  A person wants to purchase a mobile phone through online. Develop a class 
MOBILE_PURCHASE for the customers to enter their preference for the purchase. 
 The program should get the values Brand Name, Model, Price and Year of Product 
Release. Develop a Java program using swing, multithreading and exception handling. 
 The program should be designed with the following requirements: 
(a) Brand Name should be a drop down with values SAMSUNG, SONY, 
MOTOROLA. 
(b) Year of Product Release – should be an option button with values 2018, 2019, 2020. 
(c) Model value should be a text field. It should accept values like SAMS for 
SAMSUNG, SONY for SONY and MOTO for MOTOROLA followed by four 
digits (Eg:SAMS1234). 
(d) Customers should enter the price in a textfield. The valid range is between 10,000 
to 50,000. If a customer has entered a value which is not within the range, an 
exception should be raised and a message “PRODUCT NOT AVAIABLE IN THIS 
RANGE”. 
(e) A flash message “ONLINE MOBILE SHOPPING” should be displayed at the top 
of the page, which should move from right to left using multithreading. 
 Create a textarea and a button named “Submit”. 
 When the user clicks the Submit Button – You need to ensure all the above conditions 
are satisfied.  
 If atleast any one of these condition is not satisfied then display an 
appropriate Error message in the text area.  
 Otherwise, Extract the inputs from the GUI and Display it in the text area. */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Mobile extends JFrame implements ActionListener 
{
	String BrandName,Mode;
	float Price;
	int year;
	JComboBox<String>jc;
	String arr[]={"MOBILES:","SAMSUNG","SONY","MOTOROLA"};
	JRadioButton r1,r2,r3;
	JTextField t1,t2;
	JTextArea ta;
	JButton b;
	ButtonGroup grp;
	Mobile()
	{
		jc=new JComboBox<String>(arr);
		r1=new JRadioButton("2018");
		r2=new JRadioButton("2019");
		r3=new JRadioButton("2020");
		grp=new ButtonGroup();
		grp.add(r1); grp.add(r2); grp.add(r3);
		t1=new JTextField();
		t2=new JTextField();
		ta=new JTextArea();
		b=new JButton("submit");
		setVisible(true); setTitle("mobile");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400); 
		setLayout(new GridLayout(5,2));
		add(jc);  add(ta);
		add(r1);  add(r2);
		add(r3);  add(t1);
		add(t2);  add(b);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
			int n=Integer.parseInt(t2.getText());
			if(n<10000 || n>50000)
				ta.setText("not avail");
			else
				ta.setText("avail");
		}
	}
	public static void main(String arg[])
	{
		new Mobile();
	}
}