class Resource 
{
    String name;
    Resource(String n)
    {
        name=n;
    }
}
class task extends Thread
{
    Resource r1,r2;
    task(Resource R1,Resource R2)
    {
        r1=R1;
        r2=R2;
    }
    public void run()
    {
        synchronized(r1)
        {
            System.out.println(Thread.currentThread().getName()+" locked "+r1.name);
        }
        try {
           Thread.sleep(100); 
        } catch(InterruptedException e) {
        }
        synchronized(r2)
        {
            System.out.println(Thread.currentThread().getName()+" locked "+r2.name);
        }
    }
}
class DeadLock 
{
    public static void main (String[] args) {
        
        Resource r1=new Resource("res1");
        Resource r2=new Resource("res2");
        task t1=new task(r1,r2);
        task t2=new task(r2,r1);
        t1.start(); t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
}