import java.awt.*;
import java.awt.event.*;

class Arithmetics extends Frame implements ActionListener 
{
	Button b1,b2,b3,b4,b5;
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Arithmetics()
	{
		setTitle("Calculator");
		setVisible(true);
		setSize(300,400);
		setLayout(new GridLayout(6,2));
		setFont(new Font("arial",Font.BOLD,20));
		b1=new Button("+");
		b2=new Button("-");
		b3=new Button("*");
		b4=new Button("/");
		b5=new Button("clear");
		l1=new Label("number1");
		l2=new Label("number2");
		l3=new Label("result");
		t1=new TextField();
		t2=new TextField();
		t3=new TextField();
		addWindowListener(new WindowAdadpter(){
			public void windowClosing()
			{System.exit(0);}
		});
		add(l1); add(t1);
		add(l2); add(t2);
		add(l3); add(t3);
		add(b1); add(b2);
		add(b3); add(b4);
		add(b5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	}
}