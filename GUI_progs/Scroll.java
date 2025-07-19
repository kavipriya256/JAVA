import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Scroll extends JFrame
{
	JScrollPane js;
	JPanel jp;
	Scroll()
	{
		setVisible(true);
		setTitle("scrollpane");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int b=1;
		jp=new JPanel();
		for(int i=1;i<=10;i++)
		{
			for(int j=1;j<=10;j++)
			{
				jp.add(new JButton("B"+b));
				b++;
			}
		}
		js=new JScrollPane(jp);
		add(js,BorderLayout.CENTER);
	}
	public static void main(String arg[])
	{
		new Scroll();
	}
}