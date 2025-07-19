/* 
base class named Product that includes methods for core operations
such as calculate Price(), display Details(), and manageStock(). 
The base methods will provide default or placeholder implementations 
that can be overridden by subclasses. Derived Classes: Create derived classes 
Electronics, Clothing, and Perishable that extend the Product class. Override the methods
in each derived class to handle specific operations: 
Electronics: Apply specific price calculations, show warranty details, and manage electronic stock. 
Clothing: Handle seasonal discounts, display fabric details, and manage clothing stock. 
Perishable: Include expiration date handling, cold storage management, and quick price adjustments. 
The system dynamically determines the type of product and performs operations 
like price calculation, stock management, and displaying details using dynamic method dispatch.
*/

abstract class Product 
{
    String name;
    float p;
    int stock;
    int num;
    Product(String n,int nu,float price, int s)
    {
        name=n;
        p=price;
        stock=s;
        num=nu;
    }
    abstract void calcPrice();
    abstract void disp();
    abstract void manageStock();
}
class Electronics extends Product
{
    int wy; // warrenty years... 
    Electronics(String n,int nu, float p, int s, int y)
    {
        super(n,nu,p,s);
        wy=y;
    }
    void calcPrice()
    {
        p=p*num;
    }
    void disp()
    {
       System.out.println("Name: "+name+"\tPrice: "+p+"\tnumber: "+num+"\tStock: "+stock+"\twarrenty yrs: "+wy);
    }
    void manageStock()
    {
        stock=stock-num;
    }
}
class Clothings extends Product 
{
    String fabric,season;
    Clothings(String n,int nu, float p, int s,String f,String se)
    {
       super(n,nu,p,s);
       fabric=f;
       season=se;
    }
    void calcPrice()
    {
        p=p*num;
        if(season=="summer")
        p=p*30/100;
        else if(season=="winter")
        p=p*20/100;
        else if(season=="rainy")
        p=p*15/100;
        else
        p=p*5/100;
    }
    void disp()
    {
       System.out.println("Name: "+name+"\tnumber: "+num+"\tfabric: "+fabric+"\tseason: "+season+"\tPrice: "+p+"\tStock: "+stock); 
    }
    void manageStock()
    {
        stock=stock-num;
    }
} 
class Perishables extends Product 
{
    String exp; //expiary date... 
    Perishables(String n,int nu, float p,int s,String ex)
    {
        super(n,nu,p,s);
        exp=ex;
    }
    void calcPrice()
    {
     p=p*num;   
     if(stock>100)
     p=p*30/100;
     if(stock>50 && stock<100)
     p=p*15/100;
    }
    void disp()
    {
        System.out.println("Name: "+name+"\tnumber: "+num+"\tPrice: "+p+"\tStock: "+stock+"\texpiary date: "+exp); 
    }
    void manageStock()
    {
        stock=stock-num;
        System.out.println("managing cold storage");
    }
}

class ProductDemo
 
{
    public static void main(String ar[])
    {
     Product p1=new Electronics("fan",4,300,250,4);
     Product p2=new Clothings("shirt",2,400,500,"cotton","summer");
     Product p3=new Perishables("milk",4,100,100,"29-05-2025");
     System.out.println("***ELECTRONICS***");
     p1.calcPrice(); p1.disp(); p1.manageStock();
     System.out.println("***CLOTHINGS***");
     p2.calcPrice(); p2.disp(); p2.manageStock();
     System.out.println("***PERISHABLES***");
     p3.calcPrice(); p3.disp(); p3.manageStock();
    }
}