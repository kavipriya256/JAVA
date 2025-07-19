import java.awt.*;
import java.awt.event.*;
class LabelDemo extends Frame
{
	Label l1,l2,l3;
	LabelDemo()
	{
		setTitle("Label Demo");
		setVisible(true);
		setSize(300,400);
		setLayout(new FlowLayout());
		l1=new Label("one");
		l2=new Label("two");
		l3=new Label("three");
		/*ii=new ImageIcon("img.png");
		l3=new JLabel("Hello",ii,JLabel.LEFT); */ //string,imageiconObj,alignment
		add(l1); add(l2); add(l3);
	}
	
	public static void main(String ar[])
	{
		new LabelDemo();
	}
}