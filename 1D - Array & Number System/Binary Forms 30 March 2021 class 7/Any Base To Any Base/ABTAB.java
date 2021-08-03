 import java.util.*;

public class ABTAB {
     // Any Base To Any Base

     public static Scanner scr = new Scanner(System.in);

     public static int AnyBaseToDecimal( int n, int b )
     {
         int ans = 0, pow = 1;

         while( n != 0 )
         {
             int rem = n % 10;
             ans += (rem * pow); 
             n /= 10;
             pow *= b;

         }
         return ans;
     }

     public static int decimalToAnyBase( int n, int base)
     {
         int ans = 0, pow = 1;

         while( n != 0 )
         {
             int rem = n % base;
             ans += (rem * pow); 
             n /= base;
             pow *= 10;

         }
         return ans;
     }

    public static void main( String [] args)
    {
        int num = scr.nextInt(); 
        int b1 = scr.nextInt();
        int b2 = scr.nextInt();
        int decimalNumber = AnyBaseToDecimal( num, b1);
        System.out.println(decimalToAnyBase( decimalNumber, b2) );
    }
}

// javac ABTAB.java && java ABTAB