// listt
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
class List1 extends JFrame implements ListSelectionListener 
{
	JList<String>l;
	String s[]={"kavi","priya","pooli"};
	List1()
	{
		l=new JList<String>(s);
		setTitle("list");
		setSize(300,300);
		setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		l.addListSelectionListener(this);
		//l.setListSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		add(l);
	}
	public void valueChanged(ListSelectionEvent ae)
	{
		StringBuilder sb=new StringBuilder();
		//List<String>l1=;
		for(Object o:l.getSelectedValuesList())
		{
			sb.append(String.valueOf(o));
		}
		System.out.println(sb.toString());
	}
	public static void main(String ar[])
	{
		new List1();
	}
}