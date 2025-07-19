/* 2. Write a java program to demonstrate below mentioned string manipulations methods.
a. length()  b. indexOf(), lastIndexOf()  c. charAt() d. equals(), equalsIgnoreCase()
e. startsWith(), endsWith()  f. compareTo()  g. substring()  h. contains()  
i. replace(), replaceFirst(), replaceAll()  j. toUpperCase(), toLowerCase()
k. trim()  l. format()  m. split() */

import java.util.*;
class StringDemo 
{
    public static void main (String[] args) 
    {
        String s="programming in Java!";
        // length()
        System.out.println(s.length());
        // indexOf(), lastIndexOf()
        System.out.println(s.indexOf('a'));
        System.out.println(s.lastIndexOf('a'));
        // charAt()
        System.out.println(s.charAt(7));
        // equals(), equalsIgnoreCase()
        String s1="PROGRAMMING IN JAVA!";
        System.out.println(s.equals(s1));
        System.out.println(s.equalsIgnoreCase(s1));
        // startsWith(), endsWith()
        System.out.println(s.startsWith("p"));
        System.out.println(s.endsWith("!"));
        // compareTo()
        System.out.println(s.compareTo(s1));
        // substring()
        System.out.println(s.substring(0,4));
        // contains() 
        System.out.println(s.contains("J"));
        // replace(), replaceFirst(), replaceAll()
        System.out.println(s.replace("a","@"));
        System.out.println(s.replaceFirst("a","@"));
        System.out.println(s.replaceAll("a","@"));
        // toUpperCase(), toLowerCase()
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        //trim()
        String s3=" Programming in Java  ";
        System.out.println(s3.trim());
        // format()
        String name="Maga";
        int age=25;
        System.out.println(String.format("name: %s, age: %d",name,age));
        //split()
        String s2="Hello World";
        String str[]=s2.split(" ");
        for(String sg:str)
         System.out.println(sg);
        // regionMatches()
        
    }
}