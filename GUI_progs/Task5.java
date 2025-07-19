/*
1.Create a Student class to represent individual students. Include attributes such as name, roll
number, grade, and any other relevant details.
2.Implement a StudentManagementSystem class to manage the collection of students. Include
methods to add a student, remove a student, search for a student, and display all students.
3 . Design the user interface for the Student Management System. This can be a console-based
interface or a graphical user interface (GUI) using libraries like Swing or JavaFX.
4. Implement methods to read and write student data to a storage medium, such as a file or a
database.
5. Allow users to interact with the Student Management System by providing options such as
adding a new student, editing an existing student's information, searching for a student, displaying all
students, and exiting the application.
6. Implement input validation to ensure that required fields are not left empty and that the student
data is in the correct format
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class InsufficientDetailException extends Exception
{
	InsufficientDetailException(String msg)
	{
		super(msg);
	}
}
class Student 
{
	String name,roll,grade;
	Student(String n, String r,String g)
	{
		name=n;
		roll=r;
		grade=g;
	}
	public String toString()
	{
		return ("Name: "+name+"\nRollNo.: "+roll+"\nGrade: "+grade+"\n\n");
	}
}

class Task5 extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6;
	JTextField t1,t2,t3;
	JLabel l1,l2,l3;
	JTextArea ta;
	JScrollPane jp;
	JPanel p1,p2;
	ArrayList<Student> al;
	Task5()
	{
		setSize(700,700);
		setTitle("StudentManagementSystem");
		setLayout(new GridLayout(1,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f1 =new Font("arial",Font.BOLD,15);
		Font f2 =new Font("arial",Font.PLAIN,15);
		al=new ArrayList<Student>();
		b1=new JButton("Add");    b1.setFont(f1);   b1.setForeground(Color.GRAY); 
		b2=new JButton("Remove"); b2.setFont(f1);   b2.setForeground(Color.GRAY); 
		b3=new JButton("Edit");   b3.setFont(f1);   b3.setForeground(Color.GRAY); 
		b4=new JButton("Search"); b4.setFont(f1);   b4.setForeground(Color.GRAY); 
		b5=new JButton("Display");b5.setFont(f1);   b5.setForeground(Color.GRAY); 
		b6=new JButton("Clear");  b6.setFont(f1);   b6.setForeground(Color.GRAY); 
		l1=new JLabel("Name");    l1.setForeground(Color.GRAY);   l1.setFont(f1);
		l2=new JLabel("RollNo");  l2.setForeground(Color.GRAY);   l2.setFont(f1);
		l3=new JLabel("Grade");   l3.setForeground(Color.GRAY);   l3.setFont(f1);
		t1=new JTextField();  
		t2=new JTextField();
		t3=new JTextField();
		ta=new JTextArea(20,20);  ta.setFont(f2);
		jp=new JScrollPane(ta);
		p1=new JPanel();   p1.setBackground(Color.PINK);
		p2=new JPanel();   p2.setBackground(Color.lightGray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		p1.setLayout(new GridLayout(6,2));
		p2.setLayout(new FlowLayout());
		p1.add(l1); p1.add(t1);
		p1.add(l2); p1.add(t2);
		p1.add(l3); p1.add(t3);
		p1.add(b1); p1.add(b2);
		p1.add(b3); p1.add(b4);
		p1.add(b5); p1.add(b6);
		p2.add(jp);
		add(p1); add(p2);
		ta.setEditable(false);
		setVisible(true);
	}
	void addStudent() throws InsufficientDetailException
	{
		String name,roll,grade;
		name=t1.getText();
		roll=t2.getText();
		grade=t3.getText();
		if(name.isEmpty()||roll.isEmpty()||grade.isEmpty())
			throw new InsufficientDetailException("Enter appropriate detials");
		else
		{
			al.add(new Student(name,roll,grade));
			ta.setText("Added a student!");
		}
	}
	void removeStudent()
	{
		String name,roll;
		name=t1.getText();
		roll=t2.getText();
		boolean found=false;
		//removing using roll number of student
		if(name.isEmpty()) 
		{
			for(Student s:al)
			{
				if(roll.equals(s.roll))
				{
					found=true;
					al.remove(s);
					break;
				}
			}
			if(found==false)
				ta.setText("Roll number not available");
			else 
				ta.setText("Removed student "+roll);
		}
		//removing using name of student
		else
		{
			for(Student s:al)
			{
				if(name.equals(s.name))
				{
					found=true;
					al.remove(s);
					break;
				}
			}
			if(found==false)
				ta.setText("Name not available");
			else
				ta.setText("Removed student "+name);
		}
	}
	void editStudent()
	{
		String name,roll,grade;
		name=t1.getText();
		roll=t2.getText();
		grade=t3.getText();
		boolean found=false;
		//editing grade using roll number of student
		if(name.isEmpty()) 
		{
			for(Student s:al)
			{
				if(roll.equals(s.roll))
				{
					found=true;
					s.grade=grade;
					break;
				}
			}
			if(found==false)
				ta.setText("Roll number not available");
			else 
				ta.setText("Edited the information of student "+roll);
		}
		//editing grade using name of student
		else
		{
			for(Student s:al)
			{
				if(name.equals(s.name))
				{
					found=true;
					s.grade=grade;
					break;
				}
			}
			if(found==false)
				ta.setText("Name not available");
			else
				ta.setText("Edited the information of student "+ name);
		}
	}
	void searchStudent()
	{
		String name,roll;
		name=t1.getText();
		roll=t2.getText();
		boolean found=false;
		//searching using roll number of student
		if(name.isEmpty()) 
		{
			for(Student s:al)
			{
				if(roll.equals(s.roll))
				{
					found=true;
					ta.setText(s.toString());
					break;
				}
			}
			if(found==false)
				ta.setText("Roll number not available");
		}
		//searching using name of student
		else
		{
			for(Student s:al)
			{
				if(name.equals(s.name))
				{
					found=true;
					ta.setText(s.toString());
					break;
				}
			}
			if(found==false)
				ta.setText("Name not available");
		}
	}
	void displayStudents()
	{
		StringBuilder sb=new StringBuilder();
		sb.setLength(0);
		for(Student s:al)
			sb.append(s.toString());
		ta.setText(sb.toString());
		if(sb.toString().isEmpty())
			ta.setText("No student details available");
	}
	void clearFields()
	{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		ta.setText("");
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try 
			{
				addStudent();
			}
			catch(InsufficientDetailException e)
			{
				ta.setText(e.getMessage());
			}
		}
		else if(ae.getSource()==b2)
			removeStudent();
		else if(ae.getSource()==b3)
			editStudent();
		else if(ae.getSource()==b4)
			searchStudent();
		else if(ae.getSource()==b5)
			displayStudents();
		else  // Button b6 is pressed 
			clearFields();
	}
	public static void main(String ar[])
	{
		new Task5();
	}
}

