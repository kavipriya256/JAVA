import pkg.*;
import java.util.*;
class Test implements Inter1,Inter2
{
public void max_min(int a[])
{
int i,min,max;
// min 
i=0;
min=a[i];
for(i=0;i<10;i++)
{
if(a[i]<min)
min=a[i];
}
//max
i=0;
max=a[i];
for(i=0;i<10;i++)
{
if(a[i]>max)
max=a[i];
}
System.out.println("minimum element: "+min);
System.out.println("maximum element: "+max);
}
public static void main(String ar[])
{
Test t=new Test();
Scanner ob=new Scanner(System.in);
System.out.print("enter 10 elements: ");
for(int i=0;i<10;i++)
t.a[i]=ob.nextInt();
t.max_min(t.a);
}
}