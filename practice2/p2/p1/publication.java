package p1;

import java.util.Scanner;

public class publication {
   String title;
   float price;
   Scanner ob;

   public publication() {
      this.ob = new Scanner(System.in);
   }

   public void get() {
      System.out.print("title & price?: ");
      this.title = this.ob.nextLine();
      this.price = this.ob.nextFloat();
   }

   public void put() {
      System.out.println("title: " + this.title + "\nprice: " + this.price);
   }
}