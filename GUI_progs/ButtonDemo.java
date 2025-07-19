import java.awt.*;
import java.awt.event.*;
class ButtonDemo extends Frame implements ActionListener
{   //see togglebutton-maga swing pdf
	Button b1,b2,b3;
	String msg="";
	ButtonDemo()
	{
		setTitle("button demo");
		setSize(300,400);
		setVisible(true);
		setLayout(new FlowLayout());
		Button b[]=new Button[3];
		b1=new Button("yes");
		b2=new Button("no");
		b3=new Button("maybe");
		b[0]=(Button)add(b1); b[1]=(Button)add(b2); b[2]=(Button)add(b3);
		for(int i=0;i<3;i++)
			b[i].addActionListener(this);
		addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent wc)
		{
			System.exit(0);
		}
	});
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s=="yes")
			msg="you have typed yes";
		else if(s=="no")
			msg="you have typed no";
		else
			msg="you have typed maybe";
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,20,100);
	}
	public static void main(String ar[])
	{
		new ButtonDemo();
	}
}