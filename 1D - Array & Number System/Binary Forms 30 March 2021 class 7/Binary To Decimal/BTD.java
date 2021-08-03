import java.util.*;

public class BTD {
     // binary to decimal

     public static Scanner scr = new Scanner(System.in);

     public static int binaryToDecimal( int n)
     {
         int ans = 0, pow = 1;

         while( n != 0 )
         {
             int rem = n % 10;
             ans += (rem * pow); 
             n /= 10;

             pow *= 2;

         }
         return ans;
     }



    public static void main( String [] args)
    {
        int n = scr.nextInt();
        int ans = binaryToDecimal(n);
        System.out.println(ans);
    }
}


// javac BTD.java && java BTD 