/* Policy: add policy num, policy name, name, premium, policy type.
   submit button- add the details to arrayList
   if same policy num is entered again and submitted throw InvalidPolicyException saying it already exists
   search button- get policy num, and search if it exisits, if yes add it in a file, else DataNotFoundException
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

class InvalidPolicyException extends Exception
{
	InvalidPolicyException(String m)
	{
		super(m);
	}
}

class DataNotFoundException extends Exception
{
	DataNotFoundException(String m)
	{
		super(m);
	}
}

class PolicyDetails
{
	String pno,pname,name,pre,ptype;
	PolicyDetails(String a,String b,String c,String d,String e)
	{
		pno=a;
		pname=b;
		name=c;
		pre=d;
		ptype=e;
	}
	public String toString()
	{
		return ("PolicyNumber: "+pno+"\nPolicyName: "+pname+"\nPolicyHolderName: "+name+"\nPremium: "+pre+"\nPolicyType: "+ptype+"\n\n");
	}
}

class Policy extends JFrame implements ActionListener,Runnable /**/
{
	JPanel p1,p2,p3,p4;
	JLabel l1,l2,l3,l4,l5;
/**/JLabel bl;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4;
	JTextArea ta;
	ArrayList<PolicyDetails> al;
/**/Thread bt; 
/**/String banner;
	Policy()
	{
	/**/banner="WELCOME TO SUNDARAM FINANCE  ";
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
	/**/bl=new JLabel(banner);
	    bl.setPreferredSize(new Dimension(200,50));
	/**/bl.setFont(new Font("arial",Font.BOLD,18));
	/**/bt=new Thread(this);
	/**/bt.start();
	/**/p3.add(bl);
		l1=new JLabel("PolicyNumber");
		l2=new JLabel("PolicyName");
		l3=new JLabel("PolicyHolderName");
		l4=new JLabel("Premium");
		l5=new JLabel("PolicyType");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		b1=new JButton("Submit");
		b2=new JButton("Clear");
		b3=new JButton("Display");
		b4=new JButton("Search");
		ta=new JTextArea();
		al=new ArrayList<PolicyDetails>();
		setTitle("Policy");
		setSize(700,700);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		p1.setLayout(new GridLayout(7,2));
		p2.setLayout(new BorderLayout());
		p3.setPreferredSize(new Dimension(300,80)); //setPreferredSize works only for border/flow layout
		p4.setLayout(new GridLayout(1,2));                      //grid allocates equal space for all panel
		p1.add(l1);   p1.add(t1);                            // which results in overriding of our setPreSize method
		p1.add(l2);   p1.add(t2);
		p1.add(l3);   p1.add(t3);
		p1.add(l4);   p1.add(t4);
		p1.add(l5);   p1.add(t5);
		p1.add(b1);   p1.add(b2);
		p1.add(b3);   p1.add(b4);
		p2.add(ta);
	/**/p3.add(bl);
		p4.add(p1); p4.add(p2);
		add(p3,BorderLayout.NORTH);   add(p4,BorderLayout.CENTER);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
/**/public void run()
	{
		while(true)
		{
			banner=banner.substring(1)+banner.charAt(0);
			bl.setText(banner);
		try
		{
			Thread.sleep(200);
		}
		catch(InterruptedException e)
		{
			JOptionPane.showMessageDialog(null,"thread interrupted","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
				addFunc();
			}
			catch(InvalidPolicyException e)
			{
				JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(ae.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			ta.setText("");
		}
		if(ae.getSource()==b3)
		{
			StringBuilder sb=new StringBuilder();
			for(PolicyDetails p:al)
				sb.append(p);
			ta.setText(sb.toString());
		}
		if(ae.getSource()==b4)
		{
			try
			{
				searchFunc();
			}
			catch(DataNotFoundException e)
			{
				JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	void addFunc() throws InvalidPolicyException
	{
		String pnum,pn,n,p,pt;
		pnum=t1.getText();
		pn=t2.getText();
		n=t3.getText();
		p=t4.getText();
		pt=t5.getText();
		boolean pExists=false;
		for(PolicyDetails pd:al)
		{
			if(pnum.equals(pd.pno))
			{
				pExists=true;
				throw new InvalidPolicyException("Invalid policy number,this policy num already exists");
		     }  
		}
		if(pExists==false)
		   al.add(new PolicyDetails(pnum,pn,n,p,pt));
	}
	void searchFunc() throws DataNotFoundException
	{
		boolean pExists=false;
		PolicyDetails ob=null;
		String pnum=t1.getText();
		for(PolicyDetails pd:al)
		{
			if(pnum.equals(pd.pno))
			{
				pExists=true;
				ob=pd; // passing the policyDetails object to ob for further processing
				break;
			}
		}
		if(pExists==true)
		{
			try(FileOutputStream fout=new FileOutputStream("output.txt"))
			{
				String s=ob.toString();
				byte b[]=new byte[100];
				b=s.getBytes();
				fout.write(b);
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(null,"IOException has occured","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			ta.setText("Data found.check output text file to see details");
		}
		else
			throw new DataNotFoundException("Data not found in the list");
	}
	public static void main(String ar[])
	{
		new Policy();
	}
}