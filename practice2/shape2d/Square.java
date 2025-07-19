package shape2d;
public class Square implements Shape
{
double side;
public Square(double s)
{
side=s;
}
public double displayArea()
{
return side*side;
}
public double displayPerimeter()
{
return 4*side;
}
}