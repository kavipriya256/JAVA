import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Toolbar extends JFrame implements ActionListener
{
	JToolBar tb;
	JButton b1,b2;
	ImageIcon ob1,ob2;
	Toolbar()
	{
		setTitle("tool bar");
		setSize(400,400);
		setLayout(new BorderLayout());
		tb=new JToolBar();
		ob1=new ImageIcon("uparrow.png");
		ob2=new ImageIcon("downarrow.png");
		b1=new JButton(ob1);
		b2=new JButton(ob2);
		b1.setActionCommand("uparrow");
		b2.setActionCommand("downarrow");
		b1.addActionListener(this);
		b2.addActionListener(this);
		tb.add(b1);   tb.add(b2);
		add(tb,BorderLayout.NORTH);
		tb.setRollover(true);  
		tb.setFloatable(true); //default ah true thaan
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		JOptionPane.showMessageDialog(null,ae.getActionCommand());
	}
	public static void main(String ar[])
	{
		new Toolbar();
	}
}