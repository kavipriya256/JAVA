import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

class JListDemo extends JFrame implements ListSelectionListener 
{
	JList<String> jl;
	JLabel l1;
	String arr[]={"cities:","Chennai","Mumbai","Delhi"};
	JListDemo()
	{
		setSize(300,400);
		setVisible(true);
		setLayout(new GridLayout(4,1));
		setTitle("JListDemo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1=new JLabel("none");
		jl=new JList<String>(arr);
		jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// single selection: ListSelectionModel.SINGLE_SELECTION 
		add(jl); add(l1);
		jl.addListSelectionListener(this);
	}
	public void valueChanged(ListSelectionEvent le)
	{
		/* single sel 
		int index=jl.getSelectedIndex(); //returns int (and not int array)
		String s=arr[index];
		l1.setText(s);
		*/
		/*if(!le.getValueIsAdjusting())
		{
			//util list and awt list : creates ambiguity, so mention package
			java.util.List<String>sel=jl.getSelectedValuesList(); //returs list
			String s=String.join(",",sel);
			l1.setText(s);
		}*/
		StringBuilder sb=new StringBuilder(); //shows warning, but works
		for(Object o:jl.getSelectedValues()) //returns Object array
		{
			sb.append(String.valueOf(o));
		}
		l1.setText(sb.toString());
	}
	public static void main(String arg[])
	{
		new JListDemo();
	}
}