import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

class Person 
{
	String name,age;
	Person(String n,String a)
	{
		name=n;
		age=a;
	}
	public String toString()
	{
		return ("Name: "+name+" Age: "+age+"\n");
	}
}

class Comp implements Comparator<Person>
{
	public int compare(Person p1,Person p2)
	{
		return p1.name.compareTo(p2.name);
	}
} 

class GUIDemo extends JFramse implements ActionListener
{
	
	TreeSet<Person> ts;
	JButton b1,b2,b3,b4,b5;
	JLabel l1,l2;
	JTextArea ta;
	JTextField t1,t2;
	JPanel p1,p2;
	GUIDemo()
	{
		setSize(700,700); setTitle("GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(2,1));
		ts=new TreeSet<Person>(new Comp());
		p1=new JPanel();
		p2=new JPanel();
		b1=new JButton("add");
		b2=new JButton("remove");
		b4=new JButton("display");
		b3=new JButton("search");
		b5=new JButton("clear");
		l1=new JLabel("name");
		l2=new JLabel("age");
		t1=new JTextField(); //can setsize: useful in flowlayout 
		t2=new JTextField();
		ta=new JTextArea(10,10);
		p1.setLayout(new GridLayout(5,2));
		p2.setLayout(new FlowLayout());
		p1.add(l1);  p1.add(t1);  
		p1.add(l2);  p1.add(t2);  
		p1.add(b1);  p1.add(b2);
		p1.add(b3);  p1.add(b4);
		p1.add(b5);  p2.add(ta);
		add(p1);  add(p2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String n=t1.getText();
			String a=t2.getText();
			ts.add(new Person(n,a));
		}
		if(ae.getSource()==b2)
		{
			String n=t1.getText();
			for(Person p:ts) //ts.get(i): will not work for treeset
			{
				if(p.name.equals(n))
				{
					ts.remove(p);
					break;
				}
			}
		}
		if(ae.getSource()==b3)
		{
			boolean found=false;
			String n=t1.getText();
			for(Person p:ts) //ts.get(i): will not work for treeset
			{
				if(p.name.equals(n))
				{
					ta.setText(p.toString());
					found=true;
					break;
				}
			}
			if(found==false)
				ta.setText("not found");
		} 
		if(ae.getSource()==b4)
		{
			StringBuilder sb=new StringBuilder();
			sb.setLength(0);
			for(Person p:ts)
				sb.append(p.toString());
			ta.setText(sb.toString());	
		}
		if(ae.getSource()==b5)
		{
			t1.setText("");
			t2.setText("");
			ta.setText("");
		} 
	}
	public static void main(String ar[])
	{
		new GUIDemo();
	}
}
