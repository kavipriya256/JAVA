// JColorChooser

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ColorChoosing extends JFrame implements ActionListener 
{
	JPanel jp;  JButton b;
	ColorChoosing()
	{
		setVisible(true);  setTitle("colorss");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		jp=new JPanel();
		b=new JButton("color");
		b.addActionListener(this);
		add(jp,BorderLayout.CENTER);
		add(b,BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Color c=JColorChooser.showDialog(null,"pick a clr",jp.getBackground());
		if(c!=null)
			jp.setBackground(c);
	}
    public static void main(String arg[])
	{
		new ColorChoosing();
	}
}