package shape;
public class rect implements shape2d
{
int l,b;
public rect(int a,int c)
{
l=a;b=c;
}
public double area()
{
return l*b;
}
public double peri()
{
return 2*(l+b);
}
}