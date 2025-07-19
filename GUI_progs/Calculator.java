import java.awt.*;
import java.awt.event.*;

class Calculator extends Frame implements ActionListener 
{
	Button b1,b2,b3,b4,b5;
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Calculator()
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
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent wc)
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
	public void actionPerformed(ActionEvent ae)
	{
		int a=Integer.parseInt(t1.getText());
		int b=Integer.parseInt(t2.getText());
		int c=0;
		if(ae.getSource()==b5)
		{
          t1.setText("");
          t2.setText("");
		  t3.setText("");
		}
		else
		{
		if(ae.getSource()==b1)
			c=a+b;
		if(ae.getSource()==b2)
			c=a-b;
		if(ae.getSource()==b3)
			c=a*b;
		if(ae.getSource()==b4)
			c=a/b;
		t3.setText(c+" ");
		}
	}
		public static void main(String ar[])
		{
			new Calculator();
		}
}
