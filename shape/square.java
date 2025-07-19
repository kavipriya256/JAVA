package shape;
public class square implements shape2d
{
int s;
public square(int a)
{
s=a;
}
public double area()
{
return s*s;
}
public double peri()
{
return 4*s;
}
}