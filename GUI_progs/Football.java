/** Football board wants to maintain the player's profile and find the top  goalkeepers based on 
their shot stopping rate and also finds top  fieldplayers based on their number of goals shot. For 
these purpose  create a class called "Human" which has three data members "Name" of string 
datatype, "count" of int type to mention the number of matches played by the player, "id" of 
int type is used to identify the player uniquely. Create subclass called "Goalkeeper" which is 
derived from "Human" which includes data member "Total_stopping_shots" of int type to 
mention the total number of shots stopped so far, another data member "stoprate" of int type 
and it is calculated by dividing Total_stopping_shots by count. Create another subclass 
"FieldPlayer" from “Human” which includes data member "goal_count" of int type. Create a 
GUI with the following Swing components. 

1.Two Radio button with caption "Field Player" and "Goalie" 
2.Four text fields to receive name, id, match count, total stopping shots(if Goalie) /  goals count 
(if Fieldplayer) 
3.One text area to display the player details 
4.Seven buttons with caption "Insert", "search", "best player", "<<", "<", ">", ">>" 
To get the field player details, first press the radio button "Field Player", enter the details in the 
corresponding text field then add the details in the Arraylist1 by pressing "Insert" button. 
To get the Goalie details, first press the radio button "Goalie", enter the details in the 
corresponding text field then add the details in the Arraylist2 by pressing "Insert" button. Check 
that all required fields are filled or not before pressing the "Insert" button. If it is not properly 
filled out, throw the user-defined Exception. 
When we press the "search" button, Search the player details based on the id. When we press 
the button "bestplayer" displays the best Field player details based on goal count and best goalie 
details based on the stop rate in the text area. 
When we press the "<<" button shows the first field player details in the text area. 
When we press "<", ">", ">>" these buttons show the previous, next, last field player details 
respectively in the text area. **/

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InsufficcientDetailsException extends Exception
{
	InsufficcientDetailsException(String msg)
	{
		super(msg);
	}
}

class Human 
{
	String name;
	int id,count;
	Human(String n,int i,int c)
	{
		name=n;
		id=i;
		count=c;
	}
	
}
class GoalKeeper extends Human 
{
	int total_stopping_shots;
	int stoprate;
	GoalKeeper(String n,int i,int c,int t)
	{
		super(n,i,c);
		total_stopping_shots=t;
	}
	void calcStopRate()
	{
		stoprate=total_stopping_shots/count;
	}
	public String toString()
	{
		return ("Name: "+name+"\nId: "+id+"\nCount: "+count+"\nTotalStoppingShots: "+total_stopping_shots+"\nStopRate"+stoprate+"\n\n");
	}
}
class FieldPlayer extends Human 
{
	int goal_count;
	FieldPlayer(String n,int i,int c,int g)
	{
		super(n,i,c);
		goal_count=g;
	}
	public String toString()
	{
		return ("Name: "+name+"\nId: "+id+"\nCount: "+count+"\nGoalCount: "+goal_count+"\n\n");
	}
}
class Football extends JFrame implements ActionListener 
{
	JRadioButton r1,r2;
	ButtonGroup grp;
	JTextField t1,t2,t3,t4;
	JLabel l1,l2,l3,l4;
	JTextArea ta;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	JPanel p1,p2;
	ArrayList<FieldPlayer> al1; 
	ArrayList<GoalKeeper> al2;
	Football()
	{
		al1=new ArrayList<FieldPlayer>();
		al2=new ArrayList<GoalKeeper>();
		r1=new JRadioButton("Field Player");
		r2=new JRadioButton("Goalie");
		grp=new ButtonGroup();
		grp.add(r1); grp.add(r2);
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		l1=new JLabel("name");
		l2=new JLabel("id");
		l3=new JLabel("count");
		l4=new JLabel("totalStoppingShorts(Goalie)/goal count(FieldPlayer)");
		ta=new JTextArea(20,20);
		b1=new JButton("Insert");  
		b2=new JButton("search");
		b3=new JButton("best player");
		b4=new JButton("<<");
		b5=new JButton("<");
		b6=new JButton(">");
		b7=new JButton(">>");
		b8=new JButton("clear");
		p1=new JPanel();
		p2=new JPanel();
		p1.setLayout(new GridLayout(9,2));
		p2.setLayout(new GridLayout(1,1));
		p1.add(l1);  p1.add(t1);
		p1.add(l2);  p1.add(t2);
		p1.add(l3);  p1.add(t3);
		p1.add(l4);  p1.add(t4);
		p1.add(r1);  p1.add(r2);
		p1.add(b1);  p1.add(b2);
		p1.add(b3);  p1.add(b4);
		p1.add(b5);  p1.add(b6);
		p1.add(b7);  p1.add(b8);
		p2.add(ta);
		b1.addActionListener(this);   b2.addActionListener(this);
		b3.addActionListener(this);   b4.addActionListener(this);
		b5.addActionListener(this);   b6.addActionListener(this);
		b7.addActionListener(this);   b8.addActionListener(this);
		add(p1); add(p2);
		setSize(500,500);
		setLayout(new GridLayout(1,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Football");
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s="unknown";
		if(r1.isSelected())
			s="FieldPlayer";
		else if(r2.isSelected())
			s="Goalie";
		if(ae.getSource()==b1) //insert
		{                                       
			String n,si,sc,sa;
			int i,c,a;
			n=t1.getText();
			si=t2.getText();
			sc=t3.getText();
			sa=t4.getText();
			try
			{
				if(n.isEmpty() || si.isEmpty()|| sc.isEmpty() || sa.isEmpty()) 
					throw new InsufficcientDetailsException("Enter all the details");
			}
			catch(InsufficcientDetailsException e)
			{
				ta.setText(e.getMessage());
			}
			i=Integer.parseInt(si);
			c=Integer.parseInt(sc);
			a=Integer.parseInt(sa);
			if(s.equals("FieldPlayer"))
				al1.add(new FieldPlayer(n,i,c,a));
			if(s.equals("Goalie"))
			{
				GoalKeeper ob=new GoalKeeper(n,i,c,a);
				al2.add(ob);
				ob.calcStopRate();
			}
		}
	    if(ae.getSource()==b2) //search
		{
			int i=Integer.parseInt(t2.getText());
			boolean found=false;
            if(s.equals("FieldPlayer"))
            {
				for(FieldPlayer f:al1)
				{
					if(f.id==(i))
					{
						ta.setText(f.toString());
						found=true;
						break;
					}
				}
				if(found==false)
					ta.setText("Player not found");
			}	
            if(s.equals("Goalie"))
            {
				for(GoalKeeper g:al2)
				{
					if(g.id==(i))
					{
						ta.setText(g.toString());
						found=true;
						break;
					}
				}
				if(found==false)
					ta.setText("Player not found");
			}				
		}
		if(ae.getSource()==b3)  //best player
		{
			int fp,gk;
			fp=gk=0;
			int fpmax,gkmax;
			fpmax=al1.get(0).goal_count;
			gkmax=al2.get(0).total_stopping_shots;
			for(int i=0;i<al1.size();i++)
			{
				if(al1.get(i).goal_count>fpmax)
				{
					fp=i;
					fpmax=al1.get(i).goal_count;
				}
			}
			for(int i=0;i<al2.size();i++)
			{
				if(al2.get(i).total_stopping_shots>fpmax)
				{
					gk=i;
					gkmax=al2.get(i).total_stopping_shots;
				}
			}
			StringBuilder sb=new StringBuilder();
			sb.setLength(0);
			sb.append("BestPlayers:");
			sb.append("FieldPlayer:\n"+al1.get(fp).toString());
			sb.append("GoalKeeper:\n"+al2.get(gk).toString());
			ta.setText(sb.toString());
		} 
		if(ae.getSource()==b4)  //<<
		{
			if(s.equals("FieldPlayer"))
				ta.setText(al1.get(0).toString());
			if(s.equals("Goalie"))
				ta.setText(al2.get(0).toString());
		}
		if(ae.getSource()==b5)  //<
		{
			String ss=ta.getText();
			System.out.println(ss);
			String arr[]=ss.split("\n");
			String name[]=arr[0].split(" ");
			String playername=name[1];
			System.out.println(arr.length);
			System.out.println(playername);
			int i,pos;
			if(arr.length==5)//goal keeper (5 parameters)
			{	
		        i=0;pos=-1;
				for(GoalKeeper g:al2)
				{
					if(g.name.equals(playername))
					{
						pos=i;
						break;
					}
					i++;
				}
				if(pos<=0) //if pos=0, then to pos!=-1 so else part varum, then pos-1  =-1 so exception.
					ta.setText("no prev players");
				else
				    ta.setText(al2.get(pos-1).toString());
			}
			if(arr.length==4)
			{
				i=0; pos=-1;
				for(FieldPlayer f:al1)
				{
					if(f.name.equals(playername))
					{
						pos=i;
						break;
					}
					i++;
				}
				if(pos<=0)
					ta.setText("no prev players");
				else 
				    ta.setText(al1.get(pos-1).toString());
				
			}
			
		}
		if(ae.getSource()==b6)  //>
		{
			String ss=ta.getText();
			String arr[]=ss.split("\n");
			String name[]=arr[0].split(" ");
			String playername=name[1];
			if(arr.length==5)//goal keeper (5 parameters)
			{
				ListIterator<GoalKeeper> i=al2.listIterator();
				while(i.hasNext()) //finding which player is on screen currently , use list iterator itself as so after finding the right index iterator stays at that pos
				{
					if(playername.equals(i.next().name))
						break;
				}
				if(i.hasNext())                         
					ta.setText(i.next().toString());
				else
					ta.setText("Soli Mudinchu");
			}
			if(arr.length==4)
			{
				ListIterator<FieldPlayer> i=al1.listIterator();
				while(i.hasNext()) 
				{
					if(playername.equals(i.next().name))
						break;
				}
				if(i.hasNext())                         
					ta.setText(i.next().toString());
				else
					ta.setText("Ambuttu dhan");
			}
		}
		if(ae.getSource()==b7) //>>
		{
			if(s.equals("FieldPlayer"))
			{
				int j1=al1.size()-1;
				ta.setText(al1.get(j1).toString());
			}
			if(s.equals("Goalie"))
			{
				int j2=al2.size()-1;
				ta.setText(al2.get(j2).toString());
			}
		}
		if(ae.getSource()==b8) //clear
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			ta.setText("");
			grp.clearSelection();
		}
	}
	public static void main(String ar[])
	{
		new Football();
	}
} 