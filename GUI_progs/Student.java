import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Student extends JFrame implements ActionListener , ItemListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1,b2;
	JTextField t1,t2,t3;
	JCheckBox c1,c2,c3;
	JRadioButton r1,r2;
	JPanel p1,p2,p3,p4,p5;
	ButtonGroup grp;
	StringBuilder sb1=new StringBuilder();
	StringBuilder sb2=new StringBuilder();
	Student()
	{
		Font f1 =new Font("arial",Font.PLAIN,25);
		setSize(500,700);  
		setTitle("Student Details");
		setVisible(true);
		setLayout(new GridLayout(5,1)); 
		l1=new JLabel("Name"); l1.setFont(f1);  
		l2=new JLabel("Branch"); l2.setFont(f1); 
		l3=new JLabel("Sem"); l3.setFont(f1);    
		l4=new JLabel("Gender"); l4.setFont(f1); 
		l5=new JLabel("Hobbies"); l5.setFont(f1);  
		l6=new JLabel("None");  l6.setFont(f1); 
		b1=new JButton("Submit");  b1.setFont(f1);  
		b2=new JButton("Clear");   b2.setFont(f1);  
		c1=new JCheckBox("Music");  c1.setFont(f1);  c1.setBackground(Color.pink);
		c2=new JCheckBox("Games");  c2.setFont(f1);  c2.setBackground(Color.pink);
		c3=new JCheckBox("Art");   c3.setFont(f1);  c3.setBackground(Color.pink);
		r1=new JRadioButton("Male"); r1.setFont(f1);  r1.setBackground(Color.pink);
		r2=new JRadioButton("Female"); r2.setFont(f1);  r2.setBackground(Color.pink);
		grp=new ButtonGroup();
		grp.add(r1); grp.add(r2);
		t1=new JTextField(); t1.setBackground(Color.lightGray);
		t2=new JTextField(); t2.setBackground(Color.lightGray);
		t3=new JTextField(); t3.setBackground(Color.lightGray);
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p1.setLayout(new GridLayout(3,2));   p1.setBackground(Color.pink);
        p2.setLayout(new GridLayout(1,3));  p2.setBackground(Color.pink);
        p3.setLayout(new GridLayout(1,4));  p3.setBackground(Color.pink);
        p4.setLayout(new GridLayout(1,2));  p4.setBackground(Color.pink);
        p5.setLayout(new FlowLayout());	p5.setBackground(Color.cyan);
        p1.add(l1); p1.add(t1);
		p1.add(l2); p1.add(t2);
		p1.add(l3); p1.add(t3);
		p2.add(l4); p2.add(r1); p2.add(r2);
        p3.add(l5); p3.add(c1); p3.add(c2); p3.add(c3);
        p4.add(b1); p4.add(b2);	
		p5.add(l6);
		add(p1); add(p2); add(p3); add(p4); add(p5);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addActionListener(this);
		b2.addActionListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
	    if(ae.getSource()==b1)
		{
		sb1.setLength(0);
		sb1.append("DETAILS:");
        sb1.append(t1.getText());
		sb1.append(t2.getText());
		sb1.append(t3.getText());
		sb1.append("Gender:");
		if(r1.isSelected())
			sb1.append("Male");
		if(r2.isSelected())
		    sb1.append("Female");
		sb1.append("Hobbies:");
		sb1.append(sb2);
		l6.setText(sb1.toString());
		}
		if(ae.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			grp.clearSelection();
			c1.setSelected(false);
			c2.setSelected(false);
			c3.setSelected(false);
			l6.setText("");
		}	
	}
	public void itemStateChanged(ItemEvent ie)
	{
		sb2.setLength(0);
		if(c1.isSelected())
			sb2.append("Music");
		if(c2.isSelected())
			sb2.append("Games");
		if(c3.isSelected())
			sb2.append("Art");
	}
	public static void main(String arg[])
	{
		new Student();
	}
}

