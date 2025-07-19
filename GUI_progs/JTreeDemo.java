//see JTable - maga pdf

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class JTreeDemo extends JFrame implements TreeSelectionListener
{
	JLabel l1;
	DefaultMutableTreeNode top,a,a1,a2,b,b1,b2,b3;
	JTree jt;
	JScrollPane jsp;
	JTreeDemo()
	{
		setSize(300,400);
		setTitle("JTreeDemo");
		setLayout(new BorderLayout());
		setVisible(true);
		l1=new JLabel("none");
		top=new DefaultMutableTreeNode("options");
		a=new DefaultMutableTreeNode("A");
		a1=new DefaultMutableTreeNode("A1");
		a2=new DefaultMutableTreeNode("A2");
		b=new DefaultMutableTreeNode("B");
		b1=new DefaultMutableTreeNode("B1");
		b2=new DefaultMutableTreeNode("B2");
		b3=new DefaultMutableTreeNode("B3");
		top.add(a); top.add(b);
        a.add(a1); a.add(a2); 
		b.add(b1); b.add(b2); b.add(b3);
		jt=new JTree(top);
		jsp=new JScrollPane(jt);
		jt.addTreeSelectionListener(this);
		add(jsp);
		add(l1);
		add(jt,BorderLayout.CENTER);
		add(l1, BorderLayout.SOUTH);
	}
	public void valueChanged(TreeSelectionEvent te)
	{
		TreePath t=jt.getSelectionPath(); //TreePath=te.getPath();
		String s=t.toString();
		l1.setText(s);
	}
	public static void main(String arg[])
	{
		new JTreeDemo();
	}
}