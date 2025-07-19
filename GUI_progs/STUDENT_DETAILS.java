import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InvaildMarkException extends Exception
{
InvaildMarkException(String m)
{
super(m);
}
}

class STUDENT_DETAILS extends JFrame implements ActionListener
{
JComboBox<String> jc;
String arr[]={"Course Id:","101BCA","201MCA","301MBA"};
JRadioButton r1,r2;
ButtonGroup grp;
JTextField t1,t2,t3,t4,t5,t6,t7,t8;
JLabel l1,l2,l3,l4,l5,l6,l7;
JButton b1,b2;
JTextArea ta;
JPanel p1,p2;
JScrollPane jp;
STUDENT_DETAILS()
{
Font f1=new Font("arial",Font.BOLD,15);
setVisible(true); setTitle("StudentDetails");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new GridLayout(1,2));
setSize(800,800);
p1=new JPanel();
p2=new JPanel();
p1.setLayout(new GridLayout(10,2));
p2.setLayout(new FlowLayout());
jc=new JComboBox<String>(arr);
r1=new JRadioButton("Under Graduate"); r1.setFont(f1);
r2=new JRadioButton("Post Graduate"); r2.setFont(f1);
grp=new ButtonGroup();
grp.add(r1); grp.add(r2);
l1=new JLabel("Name"); l1.setFont(f1);
t1=new JTextField();
l2=new JLabel("Number"); l2.setFont(f1);
t2=new JTextField();
l3=new JLabel("Mark1"); l3.setFont(f1);
t3=new JTextField();
l4=new JLabel("Mark2"); l4.setFont(f1);
t4=new JTextField();
l5=new JLabel("Mark3"); l5.setFont(f1);
t5=new JTextField();
l6=new JLabel("Mark4"); l6.setFont(f1);
t6=new JTextField();
l7=new JLabel("Mark5"); l7.setFont(f1);
t7=new JTextField();
t8=new JTextField();
b1=new JButton("Submit"); b1.setFont(f1);
b2=new JButton("Clear"); b2.setFont(f1);
ta=new JTextArea(30,30); ta.setFont(f1);
jp=new JScrollPane(p2);
p1.setBackground(Color.pink);
p2.setBackground(Color.pink);
t1.setBackground(Color.lightGray);
t2.setBackground(Color.lightGray);
t3.setBackground(Color.lightGray);
t4.setBackground(Color.lightGray);
t5.setBackground(Color.lightGray);
t6.setBackground(Color.lightGray);
t7.setBackground(Color.lightGray);
ta.setBackground(Color.lightGray);
r1.setBackground(Color.pink);
r2.setBackground(Color.pink);
jc.setBackground(Color.pink);
p1.add(l1); p1.add(t1);
p1.add(l2); p1.add(t2);
p1.add(l3); p1.add(t3);
p1.add(l4); p1.add(t4);
p1.add(l5); p1.add(t5);
p1.add(l6); p1.add(t6);
p1.add(l7); p1.add(t7);
p1.add(r1); p1.add(r2);
p1.add(jc); p1.add(t8);
p1.add(b1); p1.add(b2);
p2.add(ta);
add(p1); add(jp);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
String n,no;
int m1,m2,m3,m4,m5;
if(ae.getSource()==b1)
{
n=t1.getText();
no=t2.getText();
m1=Integer.parseInt(t3.getText());
m2=Integer.parseInt(t4.getText());
m3=Integer.parseInt(t5.getText());
m4=Integer.parseInt(t6.getText());
m5=Integer.parseInt(t7.getText());
boolean err=false;
if(n.length()>50)
{
JOptionPane.showMessageDialog(p2,"name cant be more than 50 characters");
err=true;
}
else if(no.length()<10 || no.length()>10)
{
JOptionPane.showMessageDialog(p2,"number should be of 10 digits");
err=true;
}
else
{
try
{
if(m1<=0||m2<=0||m3<=0||m4<=0||m5<=0)
{
err=true;
throw new InvaildMarkException("marks cant be zero or negative");
}
}
catch(InvaildMarkException e)
{
JOptionPane.showMessageDialog(p2,e.getMessage());
}
}
if(err==false)
{
String cid,cl;
if(m1>=50&&m2>=50&&m3>=50&&m4>=50&&m5>=50)
{
t8.setBackground(Color.green);
t8.setText("APPLIED");
}
else
{
t8.setBackground(Color.red);
t8.setText("NOT APPLIED");
}
cid=(String)jc.getSelectedItem();
if(r1.isSelected())
cl="Under Graduate";
else
cl="Post Graduate";
StringBuilder sb=new StringBuilder();
sb.setLength(0);
sb.append("Name: "+n+"\n");
sb.append("Number: "+no+"\n");
sb.append("Mark1: "+m1+"\n");
sb.append("Mark2: "+m2+"\n");
sb.append("Mark3: "+m3+"\n");
sb.append("Mark4: "+m4+"\n");
sb.append("Mark5: "+m5+"\n");
sb.append("Course Level: "+cl+"\n");
sb.append("Course ID: "+cid+"\n");
ta.setText(sb.toString());
}
}
if(ae.getSource()==b2)
{
t1.setText(""); t2.setText("");
t3.setText(""); t4.setText("");
t5.setText(""); t6.setText("");
t7.setText(""); t8.setText("");
ta.setText(""); grp.clearSelection();
jc.setSelectedItem("Course Id:");
t8.setBackground(Color.white);
}
}
public static void main(String ar[])
{
new STUDENT_DETAILS();
}
}