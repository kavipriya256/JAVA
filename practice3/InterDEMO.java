interface animal 
{
    void sound();
    static void eat()
    {
        System.out.println("eat");
    }
    default void sleep()
    {
        System.out.println("sleep");
    }
}
class dog implements animal
{
   public void sound()
    {
        System.out.println("dog sound");
    }
}
class lion implements animal
{
    public void sound()
    {
        System.out.println("lion sound");
    }
}
class InterDEMO 
{
public static void main (String[] args) 
{
dog d=new dog();
d.sleep();d.sound();
lion l=new lion();
l.sleep();l.sound();
animal.eat();
}
}