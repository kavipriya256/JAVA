import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JComboBoxDemo extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JComboBox<String> jc;
	JComboBoxDemo()
	{
		setSize(400,500);
		setVisible(true);
		setLayout(new GridLayout(3,1));
		setTitle("JComboBoxDemo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String items[]={"items:","vannila","strawberry","chocolate"};
		l1=new JLabel("choose your fav color");
		l2=new JLabel("none");
		jc=new JComboBox<String>(items);
		add(l1); add(jc); add(l2);
		jc.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s=(String)jc.getSelectedItem();
		l2.setText(s);
	}
	public static void main(String arg[])
	{
		new JComboBoxDemo();
	}JTreeDemo
}
