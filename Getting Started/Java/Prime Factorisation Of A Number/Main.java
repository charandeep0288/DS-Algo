 import java.util.*;

public class Main{
    
 public static Scanner scr = new Scanner(System.in);
 
 
 public static void printPrimeFactorizationOfANumber(int n)
 {
     int div = 2;
     while(div*div <= n)
     {
         if( n % div == 0 )
         {
             System.out.print(div + " ");
             n /= div;
         }
         else 
         {
            div++;
         }
     }
         if( n != 0 )
         {
             System.out.print(n);
         }
 }
 
public static void main(String[] args) {
  // write your code here  
  int n = scr.nextInt();
  printPrimeFactorizationOfANumber(n);
 }
}

// javac Main.java && java Main