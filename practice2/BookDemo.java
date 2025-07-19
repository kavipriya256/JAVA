import java.util.*;
class IncorrectInputException extends Exception
{
    IncorrectInputException(String msg)
	{
		super(msg);
	}
}
class Book 
{
    String author,title,publisher;
    float price;
    int stock;
}

class bookshop 
{
    Book b[]=new Book[10];
    int i=0;
    void setaDetails(String a,String t,String p,float pr,int st)
    {
        b[i]=new Book();
        b[i].author=a; b[i].title=t; b[i].publisher=p;
        b[i].price=pr; b[i].stock=st;
        i++;
    }
    int search(String a,String t)
    {
        for(int j=0;j<i;j++)
        {
            if(b[j].author.equals(a) && b[j].title.equals(t))
                return j;
        }
        return -1;
    }
    void disp(int j)
    {
        System.out.println("Author: "+b[j].author+"\nTitle: "+b[j].title+"\nPublisher: "+b[j].publisher+"\nPrice: "+b[j].price);
    }
    void bkno(int n,int j)throws IncorrectInputException
    {
        if(n>0)
        {
            if(b[j].stock>=n)
            System.out.println("total cost: "+(b[j].price*n)+"Rs");
            else
            System.out.println(n+" copies are not available. Available copies: "+b[j].stock);
        }
        else
            throw new IncorrectInputException("Number of copies cant be negative");
    }
}
class BookDemo 
{
    public static void main(String ar[])
    {
        bookshop b=new bookshop();
        b.setaDetails("collen","verity","penguin",150,10);
        b.setaDetails("marx","cousins","scholastic",200,15);
        b.setaDetails("sally","normalpeople","pearson",250,18);
        String op;
        Scanner ob=new Scanner(System.in);
        do
        {
        System.out.println("enter book's author and title: ");
        String a=ob.next();
        String t=ob.next();
        int index=b.search(a,t);
        if(index!=-1)
        {
            System.out.println("Book is available");
            b.disp(index);
            System.out.print("enter number of copies: ");
            int n=ob.nextInt();
            try
            {
               b.bkno(n,index);
            }
            catch(IncorrectInputException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
           System.out.println("Book is not available");
         System.out.println("another book?(yes/no)");
         op=ob.next();
		 System.out.println();
        }while(!op.equals("no"));
		
    }
}