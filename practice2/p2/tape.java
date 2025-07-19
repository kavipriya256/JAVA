package p2;
import p1.*;
import java.util.*;
public class tape extends publication
{
Scanner ob=new Scanner(System.in);
float playtime;
public void get()
{
super.get();
System.out.print("playing time?: ");
playtime=ob.nextFloat();
}
public void put()
{
super.put();
System.out.println("playing time: "+playtime);
}
}