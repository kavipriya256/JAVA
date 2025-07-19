/* Create a class called queue which has an array of integers, and front and rear position 
values to represent the front and rear of the queue, and two Boolean flags full and empty. 
Implement two synchronized methods get and put to retrieve next item to consume from the 
queue and to store the newly produced item into the queue. Set the flags appropriately 
according to the state of the queue. Create one object of the queue and two threads namely 
producer thread and consumer thread and share the queue for both the threads. Producer 
thread should produce items and place it in the queue and the consumer will consume the 
items one by one from the queue. If the queue is full the producer has to wait until one of the 
items is consumed by the consumer. Similarly if the queue is empty the consumer has to wait 
until the producer places at least one item into the queue */

import java.util.*;
class queue
{
    Scanner sc=new Scanner(System.in);
    int q[]=new int[30];
    int n,x;
    int front,rear;
    boolean full;
    boolean empty;
    queue()
    {
        System.out.print("enter maximum storage capacity: ");
        n=sc.nextInt();
        front=rear=-1;
        x=0;
    }
    synchronized void get() 
    {
        try 
        {
            Thread.sleep(1000);
        } catch(InterruptedException e) 
        {
           System.out.println("get Interrupted");
        }
        while(full())
        {
         System.out.println("queue is full.cant store items");
         try 
         {
            wait(); 
         } catch(InterruptedException e) 
         {
             System.out.println("get method Interrupted");
         }
        }
        rear++;
        q[rear]=x++;
        if(front==-1)
         front++;
        System.out.println("item produced: "+x);
        notify();
    }
    synchronized void put()
    {
        try 
        {
            Thread.sleep(500);
        } catch(InterruptedException e) 
        {
           System.out.println("put Interrupted");
        }
        while(empty())
        {
         System.out.println("queue is empty.wait");
         try 
         {
            wait(); 
         } catch(InterruptedException e) 
         {
             System.out.println("put method Interrupted");
         }
        }
        System.out.println("item consumed: "+x);
        if(front==rear)
         front=rear=-1;
        else
         front++;
        notify();
    }
    boolean empty()
    {
        if(front==-1)
         return true;
        else 
         return false;
    }
    boolean full()
    {
        if(rear==n-1)
         return true;
        else 
         return false;
    }
}
class producer extends Thread
{
    queue ob;
    producer(queue obj)
    {
        ob=obj;
    }
    public void run()
    {
       ob.get(); 
    }
}
class consumer extends Thread
{
    queue ob;
    consumer(queue obj)
    {
        ob=obj;
    }
    public void run()
    {
        ob.put();
    }
}
class multithread2 
{
    public static void main (String[] args) 
    {
        queue q=new queue();
        producer pob=new producer(q);
        consumer cob=new consumer(q);
        cob.start();
        pob.start();
    }
}