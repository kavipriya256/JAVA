package p2;
import p1.*;
import java.util.*;
public class book extends publication
{
int pg_count;
Scanner ob=new Scanner(System.in);
public void get()
{
super.get();
System.out.print("pg count?: ");
pg_count=ob.nextInt();
}
public void put()
{
super.put();
System.out.println("pg count: "+pg_count);
}
}
