// flashing messages

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Flash extends JFrame
{
	JLabel l;
	String s="HELLO WORLD";
	Flash()
	{
		setVisible(true);
	    setTitle("flash");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(300,300);
	    setLayout(new FlowLayout());
		l=new JLabel();
		l.setForeground(Color.red);
		add(l);
		func();
	}
	void func()
	{
		boolean var=false;
		while(true)
		{
			var=!var;
			if(var==true)
				l.setText(s);
			else
				l.setText("");
			try
			{
				Thread.sleep(300);
			}
			catch(InterruptedException e)
			{
				System.out.println("exception");
			}
		}
	}
	public static void main(String arg[])
	{
        new Flash();		
	}
}
