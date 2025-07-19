import java.util.*;
class Factorial extends Thread 
{
    int num; // Factorial of num to be found
    Factorial(int n)
    {
        num=n;
    }
    public void run()
    {
        int f=1;
        for(int i=1;i<num;i++)
           f=f*i;
        System.out.println("Factorial: "+f);
    }
}
class SumOfSeries extends Thread  
{
    int num; // num upto which natural nos has to be summed up
    SumOfSeries(int n)
    {
        num=n;
    }
    public void run()
    {
        int s=0;
        for(int i=1;i<num;i++)
         s=s+i;
        System.out.println("SumOfSeries: "+s);
    }
}
class MultiplicationTable extends Thread 
{
    int num; // num for which multi table has to be printed
    MultiplicationTable(int n)
    {
        num=n;
    }
    public void run()
    {
        int m=1;
        for(int i=1;i<10;i++)
         System.out.println(num+"*"+i+"="+(num*i));
    }
}
class multithread1 
{
    public static void main (String[] args) 
    {
        int fn,sn,mn;
        Scanner ob=new Scanner(System.in);
        System.out.println("enter 3num: for factorial, sum of nos, MultiplicationTable");
        fn=ob.nextInt();
        sn=ob.nextInt();
        mn=ob.nextInt();
        Factorial fob= new Factorial(fn);
        SumOfSeries sob=new SumOfSeries(sn);
        MultiplicationTable mob=new MultiplicationTable(mn);
        fob.setPriority(1);
        sob.setPriority(5);
        mob.setPriority(10);
        fob.start(); sob.start(); mob.start();
        try 
        {
            fob.join(); sob.join(); mob.join();
        } catch(InterruptedException e)
        {
            System.out.println("Main interrupted");
        }
        System.out.println("Factorial status: "+fob.isAlive());
        System.out.println("SumOfSeries status: "+sob.isAlive());
        System.out.println("MultiplicationTable status: "+mob.isAlive());
        try 
        {
            Thread.sleep(1000);
        } catch(InterruptedException ie)
        {
            System.out.println("Main interrupted");
        }
        ob.close();
        System.out.println("main thread has finished");
    }
}
