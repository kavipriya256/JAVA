/* JACK & JILL airlines has decided to store the information of passengers who use the airline 
frequently to fly out to their destinations. They are interested in developing a GUI for this 
purpose. As a programming expert they are requesting your service to develop a java 
application using swings to store the passenger data using the following specification. 
Create a class Airlines with details like Passenger_Name, Passenger_ID, Flight_Number, 
Source and Destination.   
Create another class called AirlinesManagement.  In this class create an ArrayList to store the 
objects of Airlines class.  Create methods to perform following activities. - - - 
Add a Travel Detail into array list. 
o  This method should receive an Airline class object and insert it into array 
list. 
Search Passenger. 
o This method should accept a Passenger_ID and searches it in the array list.  
If it is available, then return the corresponding object otherwise throw an 
user defined exception “Passenger Not Found”. 
Display Passenger  
o This method should return array list sorted by name. 
In swing application use appropriate components for accepting input and displaying the output.  
Create three buttons namely “Add Passenger”, “Search Passenger” and “Display Passenger”. - - - 
Add Passenger -  Read the information from the GUI and pass this information to 
addPassenger method of AirlinesManagement class to store the passenger details in 
the array list. 
Search Passenger – Read a Passenger_ID and pass this to SearchPassenger method 
of AirlinesManagement class. If found display the passenger details in a text area, 
otherwise display an error message in the same text area. 
DisplayPassengers – call the displayPassenger method from AirlinesManagement 
class.  Display all details in a text area by iterating the array list. (Concatenate all 
contact details into one single string and set this string to text area). */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PassengerNotFoundException extends Exception 
{
	PassengerNotFoundException(String msg)
	{
		super(msg);
	}
}

class Airlines 
{
	String pname,pid,fno,s,d;
	Airlines(String n,String i,String f,String sr,String dt)
	{
		pname=n;
		pid=i;
		fno=f;
		s=sr;
		d=dt;
	}
	public String toString()
	{
		return ("Passenger name: "+pname+"\nPassenger id: "+pid+"\nFlight number: "+fno+"\nSoruce: "+s+"\nDestination: "+d+"\n\n");
	}
}
class Comp implements Comparator<Airlines>
{
	public int compare(Airlines a1,Airlines a2)
	{
		return a1.pname.compareTo(a2.pname);
	}
}
class AirlinesManagement extends JFrame implements ActionListener,Runnable
{
	ArrayList<Airlines> al;
	JButton b1,b2,b3,b4;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5,la;
	JPanel p1,p2,p3,p4;
	JTextArea ta;
	Thread t;
	String banner;
	AirlinesManagement()
	{
		banner="Welcome to JACK & JILL Airlines";
		al=new ArrayList<Airlines>();
		b1=new JButton("Add");
		b2=new JButton("Search");
		b3=new JButton("Display");
		b4=new JButton("Clear");
		t1=new JTextField();              t1.setBackground(Color.GRAY);
		t2=new JTextField();              t2.setBackground(Color.GRAY);
		t3=new JTextField();              t3.setBackground(Color.GRAY);
		t4=new JTextField();              t4.setBackground(Color.GRAY);
		t5=new JTextField();              t5.setBackground(Color.GRAY);
		l1=new JLabel("Passenger name");   l1.setForeground(Color.WHITE); //to set colors to letters
		l2=new JLabel("Passenger id");     l2.setForeground(Color.WHITE);
		l3=new JLabel("Flight number");    l3.setForeground(Color.WHITE);
		l4=new JLabel("Source");           l4.setForeground(Color.WHITE);
		l5=new JLabel("Destination");      l5.setForeground(Color.WHITE);
		la=new JLabel(banner);             la.setForeground(Color.WHITE);
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p3.setBackground(Color.CYAN);
		ta=new JTextArea(30,30);
		t=new Thread(this);
		t.start();
		setTitle("Passenger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLayout(new BorderLayout());
		p1.setLayout(new GridLayout(7,2));
		p2.setLayout(new FlowLayout());
		p3.setPreferredSize(new Dimension(300,80));
		p4.setLayout(new GridLayout(1,2));
        p1.setBackground(Color.GRAY);
        p2.setBackground(Color.GRAY);	
        ta.setBackground(Color.GRAY);		
		p1.add(l1);  p1.add(t1);
		p1.add(l2);  p1.add(t2);
		p1.add(l3);  p1.add(t3);
		p1.add(l4);  p1.add(t4);
		p1.add(l5);  p1.add(t5);
		p1.add(b1);  p1.add(b2);
		p1.add(b3);  p1.add(b4);
		p2.add(ta);
		p3.add(la,BorderLayout.CENTER); //if still banner is not at center: la.setHorizontalAlignment(JLabel.CENTER)
		p4.add(p1); p4.add(p2);                                            //la.setVerticalAlignment(JLabel.CENTER)
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		add(p3,BorderLayout.NORTH); add(p4,BorderLayout.CENTER); 
		setVisible(true);
	}
	public void run()
	{
		while(true)
		{
		    banner=banner.substring(1)+banner.charAt(0);
			la.setText(banner);
			try
			{
				Thread.sleep(300);
			}
			catch(InterruptedException e)
			{
				ta.setText("exception");
			}
		}
	}
	void addPassenger()
	{
		String n,i,f,sr,dt;
		n=t1.getText();
		i=t2.getText();
		f=t3.getText();
		sr=t4.getText();
		dt=t5.getText();
		al.add(new Airlines(n,i,f,sr,dt));
	}
	void searchPassenger() 
	{
		String i=t2.getText();
		boolean found=false;
		try
		{
		for(Airlines a:al)
		{
			if(a.pid.equals(i))
			{
				found=true;
				ta.setText(a.toString());
				break;
			}
		}	
		if(found==false)
			throw new PassengerNotFoundException("Passenger not found");
		}
		catch(PassengerNotFoundException e)
		{
			ta.setText(e.getMessage());
		}
	}
	void displayPassenger()
	{
		StringBuilder sb=new StringBuilder();
		for(Airlines a:al)
			sb.append(a.toString());
		ta.setText(sb.toString());
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			addPassenger();
		}
		if(ae.getSource()==b2)
		{
			searchPassenger();
		}
		if(ae.getSource()==b3)
		{
			displayPassenger();
		}
		if(ae.getSource()==b4)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			ta.setText("");
		}
	}
	public static void main(String arg[])
	{
		new AirlinesManagement();
	}
}