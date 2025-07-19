/* Imagine a publishing company that markets both book and audiocassette versions of
its works. Create a class publication that stores the title (a string) and price (type float) of a
publication. From this class derive two classes book, which adds a page count (type int); and
tape, which adds a playing time in minutes (type float). Each of these three class should have
a get data () method to initialize its data and a put data () method to display its data. Write a
java program to test the book and tape classes by creating five instances of them, asking the
user to fill in their data with get data (), and then display the data with put data (). */ 

import java.util.*;
class publication
{
Scanner ob=new Scanner(System.in);
String title;
float price;
void get()
{
System.out.println("enter title & price");
title=ob.nextLine();
price=ob.nextInt();
}
void put()
{
System.out.println("title: "+title+"\nprice: "+price+"Rs");
}
}
class book extends publication
{
int pgno;
void get()
{
super.get();
System.out.println("enter page count");
pgno=ob.nextInt();
}
void put()
{
super.put();
System.out.println("pg count: "+pgno);
}
}
class tape extends publication
{
float play_time;
void get()
{
super.get();
System.out.println("enter playing time");
play_time=ob.nextFloat();
}
void put()
{
super.put();
System.out.println("playing time: "+play_time+" min");
}
}
class publicationDemo
{
public static void main(String ar[])
{
publication p1[]=new publication[2];
publication p2[]=new publication[2];
for(int i=0;i<2;i++)
{
p1[i]=new book();
p1[i].get();
}
for(int i=0;i<2;i++)
{
p2[i]=new tape();
p2[i].get();
}
System.out.println();
for(int i=0;i<2;i++)
{
System.out.println("details of book"+(i+1)+":");
p1[i].put();
}
System.out.println();
for(int i=0;i<2;i++)
{
System.out.println("details of tape"+(i+1)+":");
p2[i].put();
}
}
}