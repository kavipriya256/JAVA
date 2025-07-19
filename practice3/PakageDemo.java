import shape.*;
class PakageDemo
{
public static void main(String args[])
{
square s=new square(5);
rect r=new rect(3,5);
circle c=new circle(7);
System.out.println("sq area: "+s.area()+" sq peri: "+s.peri());
System.out.println("rt area: "+r.area()+" rt peri: "+r.peri());
System.out.println("cl area: "+c.area()+" cl peri: "+c.peri());
}
}