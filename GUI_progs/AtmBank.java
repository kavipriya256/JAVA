//ATM 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AtmMc
{
	// Default balance amount=Rs.2000
	float bal=2000;
	void deposit(float amt)
	{
		bal+=amt;
	}
	boolean withdraw(float amt)
	{
		if(amt<bal)
		{
			bal-=amt;
			return true;
		}
		else
		{
			return false;
		}
	}
	String balance()
	{
		return String.valueOf(bal);
	}
}

class AtmBank extends JFrame implements ActionListener 
{
	AtmMc acc;
	JButton b1,b2,b3,b4,b5;
	JLabel l1,l2;
	JPanel p1,p2,p3;
	JTextField t1;
	Font f1,f2;
	AtmBank()
	{
		acc=new AtmMc();
		setTitle("Bank");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		f1=new Font("times new roman",Font.BOLD,25);
		f2=new Font("times new roman",Font.PLAIN,18);
		b1=new JButton("Deposit");
		b2=new JButton("Withdraw");
		b3=new JButton("BalanceCheck");
		b4=new JButton("Clear");
		b5=new JButton("Submit");
		t1=new JTextField(); t1.setForeground(Color.BLUE);
		l1=new JLabel("BANK",JLabel.CENTER);
		l1.setForeground(Color.WHITE);
		l1.setFont(f1);
		l2=new JLabel();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p3.setLayout(new GridLayout(1,1));
		p3.add(l1);
		p2.setLayout(new GridLayout(2,2));
		p2.add(b1); p2.add(b2);
		p2.add(b3); p2.add(b4);
		b1.addActionListener(this);   b1.setBackground(Color.WHITE);  b1.setForeground(Color.BLUE);
		b2.addActionListener(this);   b2.setBackground(Color.WHITE);  b2.setForeground(Color.BLUE);
		b3.addActionListener(this);   b3.setBackground(Color.WHITE);  b3.setForeground(Color.BLUE);
		b4.addActionListener(this);   b4.setBackground(Color.WHITE);  b4.setForeground(Color.BLUE);
		b5.addActionListener(this);   b5.setBackground(Color.WHITE);  b5.setForeground(Color.BLUE);
		p3.setBackground(Color.BLUE);
		p1.setBackground(Color.BLUE);
		add(p3);
		add(p1);
		add(p2);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		getContentPane().removeAll(); //removing previous content on gui
		if(ae.getSource()==b1)
		{
			l2.setText("Deposit amount:");
			l2.setForeground(Color.BLUE);
			l2.setFont(f2);
			p1=new JPanel();
			p1.setLayout(new GridLayout(1,3));
			p1.add(l2); p1.add(t1); p1.add(b5);
			add(p3);
			add(p1);
			add(p2);
			setVisible(true);
		}
		if(ae.getSource()==b2)
		{
			l2.setText("Withdraw amount:");
			l2.setForeground(Color.BLUE);
			l2.setFont(f2);
			p1=new JPanel();
			p1.setLayout(new GridLayout(1,3));
			p1.add(l2); p1.add(t1); p1.add(b5);
			add(p3);
			add(p1);
			add(p2);
			setVisible(true);
		}
		if(ae.getSource()==b3)
		{
			l2.setText("Balance: "+acc.balance());
			l2.setForeground(Color.WHITE);
			l2.setFont(f2);
			p1=new JPanel();
			p1.setBackground(Color.BLUE);
			p1.setLayout(new GridLayout(1,1));
			p1.add(l2);
			add(p3);
			add(p1);
			add(p2);
			setVisible(true);
		}
		if(ae.getSource()==b4)
		{
			p1=new JPanel();
			p1.setBackground(Color.BLUE);
			p1.setLayout(new GridLayout(1,1));
			add(p3);
			add(p1);
			add(p2);
			setVisible(true);
		}
		if(ae.getSource()==b5)
		{
			String label=l2.getText();
			float amt=Float.parseFloat(t1.getText());
			if(label.equals("Deposit amount:"))
			{
				if(amt>0)
				{
					acc.deposit(amt);
					l2=new JLabel("Deposited Rs."+amt);
					l2.setFont(f2);
					l2.setForeground(Color.WHITE);
				}
				else
				{
					l2=new JLabel("Can't deposit amount in negative");
					l2.setFont(f2);
					l2.setForeground(Color.WHITE);
				}
			}
			else if(label.equals("Withdraw amount:"))
			{
				boolean success=acc.withdraw(amt);
				if(success==true)
					l2.setText("Withdrawn Rs."+amt);
				else
					l2.setText("Insufficient balance Cant withdraw");
				l2.setFont(f2);
				l2.setForeground(Color.WHITE);
			}
			t1.setText("");
			p1=new JPanel();
			p1.setBackground(Color.BLUE);
			p1.setLayout(new GridLayout(1,1));
			p1.add(l2);
			add(p3);
			add(p1);
			add(p2);
			setVisible(true);
		}
	}
	public static void main(String ar[])
	{
		new AtmBank();
	}
}
