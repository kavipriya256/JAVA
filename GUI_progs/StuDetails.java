import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
class Student 
{
	int reg;
	String name;
	Student(int r, String n)
	{
		reg=r;
		name=n;
	}
	@Override
	public String toString()
	{
		return ("Reg no.: "+reg+"  Name: "+name+"\n");
	}
}
class StuDetails extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4;
	JLabel l1,l2;
	JTextField t1,t2;
	JPanel p1,p2;
	JTextArea ta;
	ArrayList<Student>al=new ArrayList<Student>();
	StuDetails()
	{
		setTitle("student");
		setVisible(true);
		setSize(1000,800);
		setLayout(new GridLayout(1,2));
		Font f1 =new Font("arial",Font.BOLD,25);
		Font f2 =new Font("arial",Font.PLAIN,25);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1=new JButton("Add");  b1.setFont(f1); 
		b2=new JButton("Remove"); b2.setFont(f1); 
		b3=new JButton("Display"); b3.setFont(f1); 
		b4=new JButton("Clear");  b4.setFont(f1); 
		l1=new JLabel("Reg No.");  l1.setFont(f1);
		l2=new JLabel("Name");  l2.setFont(f1);
		t1=new JTextField();  t1.setFont(f2); t1.setBackground(Color.lightGray);
		t2=new JTextField();  t2.setFont(f2); t2.setBackground(Color.lightGray);
		p1=new JPanel();   p1.setBackground(Color.pink);
		p2=new JPanel();   p2.setBackground(Color.pink);
		ta=new JTextArea(); ta.setFont(f2); ta.setBackground(Color.pink);
		p1.setLayout(new GridLayout(4,2));
		p2.setLayout(new FlowLayout());
		p1.add(l1); p1.add(t1);
		p1.add(l2); p1.add(t2);
		p1.add(b1); p1.add(b2);
		p1.add(b3); p1.add(b4);
		p2.add(ta);
		add(p1); add(p2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
			al.add(new Student(Integer.parseInt(t1.getText()),t2.getText()));
		if(ae.getSource()==b2)
		{
			int a=Integer.parseInt(t1.getText());
			String n=t2.getText();
			for(Student s:al)
			{
                if(s.reg==a && n.equals(s.name))
				{
					al.remove(s);
					break;
				}
			}
		}
		
		if(ae.getSource()==b3)
		{
			StringBuilder sb=new StringBuilder();
			for(Student s:al)
				sb.append(s.toString());
			ta.setText(sb.toString());
			ta.setEditable(false); //to unable the user to edit text areaa
		}
		if(ae.getSource()==b4)
		{
			t1.setText("");
			t2.setText("");
			ta.setText("");
		}
	}
	public static void main(String ar[])
	{
		new StuDetails();
	}
}
