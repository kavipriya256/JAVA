import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MouseVersion1 extends JFrame implements MouseListener, MouseMotionListener
{
	String msg="";	int x,y;
	MouseVersion1()
	{
		setSize(500,500);
		setVisible(true);
		setTitle("MouseDemo");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public void mouseEntered(MouseEvent me)
	{
		x=100;  y=100;  msg="Entered";
		repaint();
	}
	public void mouseExited(MouseEvent me)
	{
		x=100;  y=100;  msg="Exited";
		repaint();
	}
	public void mouseClicked(MouseEvent me)
	{
		x=getX();  y=getY();  msg="clicked";
		repaint();
	}
	public void mousePressed(MouseEvent me)
	{
		x=me.getX();  y=me.getY();  msg="pressed";
		repaint();
	}	
	public void mouseReleased(MouseEvent me)
	{
		x=me.getX();  y=me.getY();  msg="released";
        repaint();		
	}
	public void mouseMoved(MouseEvent me)
	{
		x=me.getX();  y=me.getY();  msg="moved";
		repaint();
	}
	public void mouseDragged(MouseEvent me)
	{
		x=me.getX();  y=me.getY();  msg="dragged";
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,x,y);
	}
	public static void main(String ar[])
	{
		new MouseVersion1();
	}
}