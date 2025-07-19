/* 1. Sets up the main window (JFrame), initializes drawingPanel with a custom
paintComponent method to draw the ball.
2. Implement a MouseListener to detect mouse clicks on the JPanel, triggering a change
in the color of the ball.
3. Override paintComponent to dynamically draw the ball with the current color on the
JPanel
4. Generate random RGB colors for the ball using the Random class.
5. Manage events (mouse clicks) to update the state (color) of the graphical object (ball) */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MouseDemo extends JFrame implements MouseListener, MouseMotionListener
{
	int bx,by,bd; //x,y-coordinates, d-dia of ball
	Color clr; //clr of ball
	boolean dragging; 
	int ox,oy; //offsetX and Y
	int times;
	MouseDemo()
	{
		bx=50; by=50; bd=50;
		times=0;
		clr=Color.red;
		dragging=false;
		setVisible(true);  setTitle("MouseEvent");
	    setLayout(new FlowLayout());
	    setSize(400,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		addMouseMotionListener(this);
		repaint();
	}
	public void mouseClicked(MouseEvent me)
	{
		if(isballClicked(me.getX(),me.getY()))
		{
			times++;
			if(times%2!=0) //odd times of clicking (1st click=green,2nd click=red)
			clr=Color.green; 
			else
			clr=Color.red;
		    repaint();
		}
	}
	public void mousePressed(MouseEvent me)
	{
	   if(isballClicked(me.getX(),me.getY()))
	   {
		// Store the offset between mouse position and top-left corner of the ball
        ox=me.getX()-bx;
		oy=me.getY()-by;
		dragging=true;
	   }
	} 
	public void mouseReleased(MouseEvent me)
	{
		dragging=false;
	}
	public void mouseDragged(MouseEvent me)
	{
		if(dragging)
		{
		bx=me.getX()-ox;
		by=me.getY()-oy;
		repaint();
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(clr);
		g.fillOval(bx,by,bd,bd);
	}
	boolean isballClicked(int mx,int my) //mx=mouseX, my=mouseY coordinates
	{
		int br=bd/2;    //radius of ball
		int cx=bx+br;   //cx=center positon of ball's x coordinate
		int cy=by+br;   //cy=center positon of ball's y coordinate
		int dx=mx-cx;   //diff bw mouseX and CenterX
		int dy=my-cy;   //diff bw mouseY and CenterY
		/* we need to check :
		   sqrt((mx-cx)^2 + (my-cy)^2)<=br
		*/
		if(dx*dx+dy*dy<=br*br) //distance formula to find if click is within ball's range
			return true;
		else
			return false;
	}
	public void mouseEntered(MouseEvent me)
	{
		System.out.println("mouse entered");
	}
	public void mouseExited(MouseEvent me)
	{
		System.out.println("mouse exited");
	}
	public void mouseMoved(MouseEvent me)
	{
		boolean moving=true;
	}
	public static void main(String arg[])
	{
		new MouseDemo();
	}
}