
import java.util.*;
interface Person
{
    void getName();
    void getId();
}
interface Student extends Person
{
    void attendClass();
    void getGPA();
}
interface Employee extends Person
{
    void getSalary();
    void performDuties();
}
interface Researcher extends Person
{
    void conductResearch();
    void publishPaper();
}

class PhDStudent implements Student ,Researcher
{ 
    Scanner ob=new Scanner(System.in);
    String name;
    int id,n_res,n_pp;
    float attend,cgpa;
    public void getName()
    {
        System.out.print("name? ");
         name=ob.next();
    }
    public void getId()
    {
        System.out.print("id? ");
         id=ob.nextInt();
    }
    public void attendClass()
    {
        System.out.print("Attendance? ");
         attend=ob.nextFloat();
    }
    public void getGPA()
    {
        System.out.print("cgpa? ");
         cgpa=ob.nextFloat();
    }
    public void conductResearch()
    {
        System.out.print("Research conducted? ");
        n_res=ob.nextInt();
    }
    public void publishPaper()
    {
        System.out.print("paper Published? ");
        n_pp=ob.nextInt();
    }
    void disp()
    {
        System.out.println("name: "+name+"\nid:"+id+"\nattendance:"+attend+"\ncgpa: "+cgpa+"\nnumber of research conducted"+n_res+"\nnumber of paper published: "+n_pp);
    }
}
class TeachingAssistant implements Student ,Employee
{
    Scanner ob=new Scanner(System.in);
    String name,duty;
    int id;
    float attend,cgpa,sal;
    public void getName()
    {
        System.out.print("name? ");
         name=ob.next();
    }
    public void getId()
    {
        System.out.print("id? ");
         id=ob.nextInt();
    }
    public void attendClass()
    {
        System.out.print("Attendance? ");
         attend=ob.nextFloat();
    }
    public void getGPA()
    {
        System.out.print("cgpa? ");
         cgpa=ob.nextFloat();
    }
    public void getSalary()
    {
        System.out.print("Salary? ");
        sal=ob.nextFloat();
    }
    public void performDuties()
    {
     System.out.print("Duty? ");   
     duty=ob.next();
    }
    void disp()
    {
        System.out.println("name: "+name+"\nid:"+id+"\nattendance:"+attend+"\ncgpa: "+cgpa+"\nsalary: "+sal+"\nduty: "+duty);
    }
}
class Professor implements Employee ,Researcher
{
    Scanner ob=new Scanner(System.in);
    String name,duty;
    float sal;
    int id,n_res,n_pp;
   public void getName()
    {
        System.out.print("name? ");
         name=ob.next();
    }
    public void getId()
    {
        System.out.print("id? ");
         id=ob.nextInt();
    }
    public void getSalary()
    {
        System.out.print("Salary? ");
        sal=ob.nextFloat();
    }
    public void performDuties()
    {
     System.out.print("Duty? ");   
     duty=ob.next();
    }
    public void conductResearch()
    {
        System.out.print("Research conducted? ");
        n_res=ob.nextInt();
    }
    public void publishPaper()
    {
        System.out.print("paper Published? ");
        n_pp=ob.nextInt();
    }
    void disp()
    {
        System.out.println("name: "+name+"\nid:"+id+"\nsalary: "+sal+"\nduty: "+duty+"\nnumber of research conducted"+n_res+"\nnumber of paper published: "+n_pp);
    }
}
class PersonDemo 
{
    public static void main (String[] args) 
    {
        System.out.println("PhDStudent:");
        PhDStudent ph=new PhDStudent();
        ph.getName(); ph.getId();
        ph.attendClass(); ph.getGPA();
        ph.conductResearch(); ph.publishPaper();
        System.out.println("TeachingAssistant:");
        TeachingAssistant ta=new TeachingAssistant();
        ta.getName(); ta.getId();
        ta.attendClass(); ta.getGPA();
        ta.getSalary(); ta.performDuties();
        System.out.println("Professor:");
        Professor pr=new Professor();
        pr.getName(); pr.getId();
        pr.getSalary(); pr.performDuties();
        pr.conductResearch(); pr.publishPaper();
        System.out.println("***DETAILS***");
        System.out.println("PhDStudent:");
        ph.disp();
        System.out.println("TeachingAssistant:");
        ta.disp();
        System.out.println("Professor:");
        pr.disp();
    }
}








