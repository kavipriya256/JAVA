/** Implement a java program for online purchasing in agriculture shop for the following scenario. 
Create a class called "Agriculture" with data member "name” of String type. Create a subclass 
"Pesticides" from "Agriculture" with data member "Volatility" of type boolean. Create another 
subclass "Fertilizer" from "Agriculture" which includes the data member "type" of String type. 
Create a class called "FeedBack" with data members "yield" of double type, "cropname" of 
string type, object of Pesticides and object of Fertilizer. Create a GUI with the following Swing 
components  
1.Three List boxes to display the names of the Fertilizer, Pesticides and crops. The Fertilizer 
list and pesticides list must be displayed with the prize (Ex: AAA 20) 
2.Two text fields to enter the  quantity of Fertilizer and Pesticides  
3.Two buttons with caption  "Feedback" and "Purchase." 
4.Two text areas for viewing the current purchased details and feedback suggestion 
Create Feedback objects with some constant values for some crops (ex: cropname: basmatirice 
Pesticides:AAA Volatility :true Fertilizer:BBB type:Organic yield:99.2%) and store it in 
ArrayList.( Note:The array list should contain only one Feedback object for each crop, which 
should provide feedback on which fertilizers and pesticides can give the maximum yield for 
that particular crop.) 
Customer must select the crop name, pesticides, fertilizer and enter the quantity for pesticides 
and fertilizer in the text field, then click the “Feedback” button. After clicking the Feedback 
button  get the feedback details of selected crop for yielding. If the feedback is not available 
for the corresponding crop, show the message "The feedback is not available for this particular 
crop" in the feedback suggestion text area. If available, show the feedback details. 
(Note: It is the customer's choice whether or not to take this suggestion) 
While pressing the “Purchase” button, if crop is not selected, then throw the user-defined 
exception “select a crop”. If the quantities are not entered for the selected Pesticides and 
fertilizer, throw the user-defined exception with the message "Enter quantity for selected items" 
and if the quantity is entered without selecting an item, throw the user-defined Exception with 
the message "Select an item first ". All these messages have to be displayed in text area. 
otherwise display the current purchased details with the total cost. **/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class CropNotSelectedException extends Exception
{
	CropNotSelectedException(String msg)
	{
		super(msg);
	}
}
class QuantityNotSelectedException extends Exception
{
	QuantityNotSelectedException(String msg)
	{
		super(msg);
	}
}
class ItemNotSelectedException extends Exception
{
	ItemNotSelectedException(String msg)
	{
		super(msg);
	}
}

class Agriculture
{
	String name;
}
class Pesticides extends Agriculture
{
	boolean volatility;
}
class Fertilizer extends Agriculture
{
	String type;
}
class FeedBack 
{
	double yield;  
    String cropname;  
	Pesticides pob;
	Fertilizer fob;
	FeedBack(String c,String p,boolean v,String f,String t,double y)
	{
		pob=new Pesticides();
		fob=new Fertilizer();
		cropname=c;
		yield =y;
		pob.name=p;
		pob.volatility=v;
		fob.name=f;
		fob.type=t;
	}
	public String toString()
	{
		return ("CropName: "+cropname+"\nPesticide: "+pob.name+" Volatality: "+pob.volatility+"\nFertilizer: "+fob.name+" Type: "+fob.type);
	}
}
	class AgriDemo extends JFrame implements ActionListener,Runnable
	{
		JList<String> l1,l2,l3;
	    JButton b1,b2;
	    JTextField t1,t2;
	    JTextArea ta1,ta2;
	    JLabel la1,la2,lb;
		JPanel p1,p2,p3,p4,p5,p6;
	    ArrayList <FeedBack>al;
		String banner;
		Thread t;
		AgriDemo()
		{
		banner=" WELCOME TO AGRI SHOP ";
		t=new Thread(this);
		t.start();
		lb=new JLabel(banner);
		String s1[]={"Fertilizers:","Manure Rs.200","PotasiumNitrate Rs.350","CalciumNitrate  Rs.300"};
		l1=new JList<String>(s1);
		l1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String s2[]={"Pesticides:","Herbicide Rs.350","Insecticide Rs.280","Fungicide Rs.300"};
		l2=new JList<String>(s2);
		l2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String s3[]={"CropName:","SugarCane","Paddy","Maize"};
		l3=new JList<String>(s3);
		l3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		l1.setBackground(Color.GRAY);  l1.setForeground(Color.WHITE);
		l2.setBackground(Color.GRAY);  l2.setForeground(Color.WHITE);
		l3.setBackground(Color.GRAY);  l3.setForeground(Color.WHITE);
		la1=new JLabel("Fertilizer Quantity:");
		t1=new JTextField();
		la2=new JLabel("Pesticide Quantity:");
		t2=new JTextField();
		b1=new JButton("Feedback");
		b2=new JButton("Purchase");
		ta1=new JTextArea(); //purchased details 
		ta1.setBackground(Color.lightGray);
		ta2=new JTextArea(); //feedback 
		ta2.setBackground(Color.pink);
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		al=new ArrayList<FeedBack>();
		al.add(new FeedBack("SugarCane","Herbicide",true,"Manure","Organic",91.34));
		al.add(new FeedBack("Maize","Insecticide",false,"PotasiumNitrate","Inorganic",85.81));
		al.add(new FeedBack("Paddy","Herbicide",true,"CalciumNitrate","Inorganic",91.34));
		setLayout(new BorderLayout());
		setTitle("AgriDemo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		p1.setLayout(new GridLayout(3,1));
		p1.add(l1); p1.add(l2); p1.add(l3);
		p2.setLayout(new GridLayout(3,2));
		p2.add(la1); p2.add(t1); 
		p2.add(la2); p2.add(t2); 
		p2.add(b1); p2.add(b2); 
		p3.setLayout(new GridLayout(2,1));
		p6.setPreferredSize(new Dimension(300,80));
		p3.add(p1); p3.add(p2);
		p4.setLayout(new GridLayout(2,1));
		p4.add(ta1);  p4.add(ta2);
		p5.setLayout(new GridLayout(1,2));
		p5.add(p3);   p5.add(p4);
		p6.add(lb,BorderLayout.CENTER);
		p6.setBackground(Color.pink);  lb.setForeground(Color.MAGENTA);
		add(p6,BorderLayout.NORTH);
		add(p5,BorderLayout.CENTER);
		b1.addActionListener(this);   b2.addActionListener(this);
		setVisible(true);
		}
		public void run()
		{
			while(true)
			{
			//right to left
			banner=banner.substring(1)+banner.charAt(0);
			lb.setText(banner);
			/*
			left to right 
			String banner=banner.charAt(banner.length()-1)+substring(0,banner.length()-1);
			*/
			try 
			{Thread.sleep(300);}
			catch(InterruptedException e)
			{System.out.println("Thread interrupted");}
			}
		}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b2)
			{
				String c,p,f,pq,fq;
				c=p=f=pq=fq=""; 
				try   
				{ 
				c=l3.getSelectedValue(); //returns null if nothing is selected
				if(c==null)
					throw new CropNotSelectedException("Select a crop");
				}
				catch(CropNotSelectedException e)
				{ ta1.setText(e.getMessage());
				  return;
				}
				
				try 
				{
					fq=t1.getText();
				    pq=t2.getText();
					if(pq.isEmpty()&&fq.isEmpty())
						throw new QuantityNotSelectedException("Enter quantity for selected items");
				}
				catch(QuantityNotSelectedException e)
				{ ta1.setText(e.getMessage());
				 return;
				}
				
				try 
				{
					p=l2.getSelectedValue();
					f=l1.getSelectedValue(); 
					if((p==null)&& (f==null))
						throw new ItemNotSelectedException("Select an item first");
				}
				catch(ItemNotSelectedException e)
				{ ta1.setText(e.getMessage());
				 return;
				}
				
				StringBuilder sb=new StringBuilder();
				sb.append("PURCHASED DETAILS:"+"\nCropName: "+c);
				if(p==null) //fertilizer is selected
					sb.append("\nFertilizer: "+f+"\nQuantity: "+fq);
                else if(f==null) //pesticide is selected	
                    sb.append("\nPesticide: "+p+"\nQuantity: "+pq);				
			    ta1.setText(sb.toString());
			}
			if(ae.getSource()==b1)
			{
				boolean found=false;
				String c=l3.getSelectedValue();
				for(FeedBack f:al)
				{
					if(f.cropname.equals(c))
					{
						ta2.setText(f.toString());
						found=true;
						break;
					}
				}
				if(found==false)
					ta2.setText("Feedback is not available for crop "+c);
			}
		}
		public static void main(String arg[])
		{
			new AgriDemo();
		}
	}