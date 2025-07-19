import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class ImagesDemo extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4;
	JLabel l;
	ImageIcon ob1,ob2,ob3,ob4;
	JPanel p1,p2;
	ImagesDemo()
	{
		p1=new JPanel();
		p2=new JPanel();
		ob1=new ImageIcon("sandClock.jpeg");
		ob2=new ImageIcon("analogClock.jpeg");
		ob3=new ImageIcon("digitalClock.jpeg");
		ob4=new ImageIcon("stopWatch.jpeg");
		b1=new JButton(ob1);  b1.setActionCommand("sandClock");
		b2=new JButton(ob2);  b2.setActionCommand("analogClock");
		b3=new JButton(ob3);  b3.setActionCommand("digitalClock");
		b4=new JButton(ob4);  b4.setActionCommand("stopWatch");
		l=new JLabel();
		if (ob1.getImageLoadStatus() != MediaTracker.COMPLETE) {
    System.out.println("sandClock.png not loaded!");
}

		setVisible(true); setTitle("CLOCKS");
		setLayout(new GridLayout(2,1));
		setSize(650,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1.setLayout(new GridLayout(2,2));
		p2.setLayout(new GridLayout(1,1));
		p1.add(b1);  p1.add(b2);  p1.add(b3);  p1.add(b4);
		p2.add(l);
		add(p1); add(p2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
			l.setText(b1.getActionCommand());
		if(ae.getSource()==b2)
			l.setText(b2.getActionCommand());
		if(ae.getSource()==b3)
			l.setText(b3.getActionCommand());
		if(ae.getSource()==b4)
			l.setText(b4.getActionCommand());
	}
	public static void main(String arg[])
	{
		new ImagesDemo();
	}
}