/*  Write a java program to create a student examination database system that prints the
mark sheet of students. Accept Student’s name and Marks in six subjects as input from
command line for 10 students. These marks should be between 0 and 100.If the marks are
not in the specified range, raise a range exception, else find the total marks and print the
percentage of marks  */

class MarksOutOfRangeException extends Exception
{
	MarksOutOfRangeException(String ms)
	{
		super(ms);
	}
}

class Marks
{
void total(String name,int m[]) throws MarksOutOfRangeException
{
  int tot=0;
  for(int i=0;i<6;i++)
  {
	  if(m[i]<0 || m[i]>100)
		  throw new MarksOutOfRangeException("range of marks is 0 to 100");
	  else
		  tot=tot+m[i];
  }
  System.out.println("name: "+name+"\ntotal marks: "+tot);
}
}

class MarkDemo
{
	public static void main(String ar[])
	{
		Marks mo=new Marks();
		int m[]=new int[6];
		String n=ar[0];
		for(int i=0;i<6;i++)
		{
			m[i]=Integer.parseInt(ar[i+1]);
		}
		try
		{
		mo.total(n,m);
		}
		catch(MarksOutOfRangeException mor)
		{
			System.out.println(mor.getMessage());
		}
	}
}