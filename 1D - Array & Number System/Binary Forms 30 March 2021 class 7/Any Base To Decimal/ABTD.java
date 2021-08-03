 import java.util.*;

public class ABTD {
     // any base to decimal

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



    public static void main( String [] args)
    {
        int n = scr.nextInt();
        int b = scr.nextInt();
        int ans = AnyBaseToDecimal(n, b);
        System.out.println(ans);
    }
}


// javac ABTD.java && java ABTD 