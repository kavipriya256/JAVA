package shape2d;
public class Circle implements Shape
{
double r;
public Circle(double x)
{
r=x;
}
public double displayArea()
{
return 3.14*r*r;
}
public double displayPerimeter()
{
return 2*3.14*r;
}
}