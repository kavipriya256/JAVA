import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class TabbedPane extends JFrame
{
	JTabbedPane jp;
	TabbedPane()
	{
		jp=new JTabbedPane();
		setSize(400,500); setVisible(true);
		setTitle("JTabbedPaneDemo");
		setLayout(new GridLayout(1,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.addTab("cities",new CityPanel());
		jp.addTab("color",new ColorPanel());
		jp.addTab("flavor",new FlavorPanel());
		add(jp);
	}
	public static void main(String arg[])
	{
		new TabbedPane();
	}
}
class CityPanel extends JPanel
{
	JButton b1,b2,b3;
	CityPanel()
	{
		b1=new JButton("delhi");
		b2=new JButton("mumbai");
		b3=new JButton("chennai");
		add(b1); add(b2); add(b3);
	}
}
class ColorPanel extends JPanel
{
	JCheckBox c1,c2,c3;
	ColorPanel()
	{
		c1=new JCheckBox("red");
		c2=new JCheckBox("green");
		c3=new JCheckBox("blue");
		add(c1);add(c2);add(c3);
	}
}
class FlavorPanel extends JPanel
{
	JComboBox<String> jc;
	FlavorPanel()
	{
		jc=new JComboBox<String>();
		jc.addItem("chocolate");
        jc.addItem("vanilla");
        jc.addItem("blueberry");
        add(jc);		
	}
}