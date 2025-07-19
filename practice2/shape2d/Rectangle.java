package shape2d;
public class Rectangle implements Shape
{
double l,b;
public Rectangle(double x, double y)
{
l=x;
b=y;
}
public double displayArea()
{
return l*b;
}
public double displayPerimeter()
{
return 2*(l+b);
}
}