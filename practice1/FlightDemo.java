import java.util.*;
abstract class Flight
{
    int fno;
    String dest;
    int seatsAvail;
    static String airlineName="Air India";
    Flight(int f,String d, int a)
    {
        fno=f;
        dest=d;
        seatsAvail=a;
    }
    abstract void calcFare(int n);
    void bookSeat(int n)
    {
    System.out.println(n+"seats booked");
    seatsAvail-=n;
    }
    void cancelBook(int n)
    {
        System.out.println(n+"seats cancelled");
        seatsAvail+=n;
    }
    static void GenerateBookingId()
    {
        System.out.println("booking id: "+airlineName+"123");
    }
}
class DomesticFlight extends Flight
{
    final float base_fare=10000;
    float fare;
    final int max_seats=300;
    DomesticFlight(int f,String d, int a)
    {
        super(f,d,a);
    }
    void calcFare(int n)
    {
        fare=n*base_fare;
    }
    void disp()
    {
        System.out.println("DOMESTIC FLIGHT BOOKING DETAILS: ");
        System.out.println("flight no.: "+fno+"\ndestination: "+dest+"total fare: "+fare);
    }
}
class InternationalFlight extends Flight
{
    final float base_fare=20000;
    final int max_seats=250;
    float fare;
    InternationalFlight(int f,String d, int a)
    {
       super(f,d,a);
    }
    void calcFare(int n)
    {
        fare=n*base_fare;
    }
    void disp()
    {
        System.out.println("INTERNATIONAL FLIGHT BOOKING DETAILS: ");
        System.out.println("flight no.: "+fno+"\ndestination: "+dest+"total fare: "+fare);
    }
}
class FlightDemo 
{
    public static void main (String[] args) 
    {
     DomesticFlight df=new DomesticFlight(35,"dubai",40);
     InternationalFlight inf=new InternationalFlight(45,"singapore",50);
     System.out.println("domestic flight booking");
     df.bookSeat(2);
     Flight.GenerateBookingId();
     df.calcFare(2);
     System.out.println("international flight booking");
     inf.bookSeat(3);
     Flight.GenerateBookingId();
     inf.calcFare(3);
     System.out.println("domestic flight cancelling");
     df.cancelBook(1);
     df.disp();
     inf.disp();
    }
}