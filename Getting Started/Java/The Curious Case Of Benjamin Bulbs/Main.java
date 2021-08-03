import java.util.*;
  
  public class Main{
      public static Scanner scr = new Scanner(System.in);
      
      public static void benjaminBulb(int n )
      {
        for(int i = 1 ; i*i <= n ; i++)
        {
            System.out.println(i*i);
        }
      }
  
  public static void main(String[] args) {
    // write your code here  
    int n = scr.nextInt();
    benjaminBulb(n);
    
   }
  }

    // javac Main.java && java Main