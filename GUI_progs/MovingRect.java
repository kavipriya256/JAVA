//moving rectangle
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MovingRect extends JFrame implements ActionListener
{
	JButton b;
	int x,speed;
	MovingRect()
	{
		x=35;
		speed=3;
		b=new JButton("click");
		setTitle("moving rect");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLayout(new FlowLayout());
		add(b);
		b.addActionListener(this);
		setVisible(true);
	}
	public void paint(Graphics g) // if JPanel is extended, instaed of paint method use paintComponent
	{
		super.paint(g);
		g.setColor(Color.red);
		g.fillRect(x,45,25,35); //g.fillRect(int x, int y, int width, int height);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
			if(x>0 && x<300)
			{
				x=x+speed;
				repaint();
			}
		}
	}
	public static void main(String ar[])
	{
		new MovingRect();
	}
}