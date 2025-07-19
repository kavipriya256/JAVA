class Counter 
{
    int c;
    Counter()
    {c=0;}
    synchronized void inc()
    {
        c++;
    }
    int getCount()
    {
        return c;
    }
}
class Cthread extends Thread
{
    Counter ob;
    Cthread(Counter obj)
    {
        ob=obj;
    }
    public void run()
    {
        for(int i=0;i<10000;i++)
         ob.inc();
    }
}


class Main 
{
    public static void main (String[] args) 
    {
        Counter ob1=new Counter();
		Counter ob2=new Counter();
		Counter ob3=new Counter();
        Cthread t1=new Cthread(ob1);
        Cthread t2=new Cthread(ob2);
        Cthread t3=new Cthread(ob3);
        t1.start(); t2.start(); t3.start();
        try
        {
            t1.join(); t2.join(); t3.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
        System.out.println("final count: "+ob1.getCount());
		System.out.println("final count: "+ob2.getCount());
		System.out.println("final count: "+ob3.getCount());
    }
}
