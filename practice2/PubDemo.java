import p1.*;
import p2.book;
import p2.tape;
class PubDemo
{
public static void main(String a[])
{
book b=new book();
tape t=new tape();
b.get();
t.get();
System.out.println();
b.put();
System.out.println();
t.put();
}
}