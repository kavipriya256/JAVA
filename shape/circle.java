package shape;
public class circle implements shape2d
{
int r;
public circle(int a)
{
r=a;
}
public double area()
{
return 3.14*r*r;
}
public double peri()
{
return 3.14*2*r;
}
}
