import shape2d.*;
class ShapeDemo
{
public static void main(String ar[])
{
Shape ref1,ref2,ref3;
ref1=new Square(3.2);
ref2=new Rectangle(1.0,1.5);
ref3=new Circle(5.2);
double sa,sp,ra,rp,ca,cp;
sa=ref1.displayArea();
sp=ref1.displayPerimeter();
ra=ref2.displayArea();
rp=ref2.displayPerimeter();
ca=ref3.displayArea();
cp=ref3.displayPerimeter();
System.out.println("Square area: "+sa);
System.out.println("Square perimeter: "+sp);
System.out.println("Rectangle area: "+ra);
System.out.println("Rectangle area: "+rp);
System.out.println("Circle area: "+ca);
System.out.println("Circle area: "+cp);
}
}