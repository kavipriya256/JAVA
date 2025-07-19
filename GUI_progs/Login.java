/* Create a login screen which has two labels and two text fields to display and get User Name
and password and two buttons namely OK and CANCEL. In the text fields initially "Enter User
Name" / "Enter Password" should be displayed. When the focus moves to that text field, the
message should be cleared. After entering the username and password when the user
presses the OK button, it should check for validity and display either "Login Successful" or
"Invalid User Name and / or Password" message. If the user presses the CANCEL button the
current content in the text field should be cleared. */


// username: kavi , password: 1234

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Login extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	
	String un="kavi";
	String pw="1234";
	Login()
	{
	setTitle("Login");
	setSize(500,600);
	setVisible(true);
	setLayout(new GridLayout(3,2));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	l1=new JLabel("UserName and Password:");
	l2=new JLabel("Validity:");
	t1=new JTextField("enter");
	t2=new JTextField();
	b1=new JButton("OK");
	b2=new JButton("CANCEL");
	add(l1); add(t1);
	add(l2); add(t2);
	add(b1); add(b2);
	b1.addActionListener(this);
	b2.addActionListener(this);
	t1.addFocusListener(new FocusAdapter()
	{
		public void focusGained(FocusEvent fe)
		{
			if(t1.getText().equals("enter"))
				t1.setText("");
		}
		public void focusLost(FocusEvent fe)
		{
			if(t1.getText().equals(""))
				t1.setText("enter");
		}
	}
	);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String s=t1.getText();
			String str[]=s.split("\\s+");
			if(un.equals(str[0]) && pw.equals(str[1]))
				t2.setText("Login Successful");
			else
				t2.setText("Invalid User Name/Password"); 
				
		}
		if(ae.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
		}
	}
	public static void main(String arg[])
	{
		new Login();
	}
}