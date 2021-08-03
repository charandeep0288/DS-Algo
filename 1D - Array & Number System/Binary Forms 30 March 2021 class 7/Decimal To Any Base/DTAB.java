 import java.util.*;

public class DTAB {
     // decimal to any base

     public static Scanner scr = new Scanner(System.in);

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
        int n = scr.nextInt();
        int b = scr.nextInt();
        int ans = decimalToAnyBase(n, b);
        System.out.println(ans);
    }
}


// javac DTAB.java && java DTAB 
    
