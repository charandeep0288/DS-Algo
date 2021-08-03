import java.util.*;

public class DTB {
     // dicimal to binary 

     public static Scanner scr = new Scanner(System.in);

     public static int decimalToBianry( int n)
     {
         int ans = 0, pow = 1;

         while( n != 0 )
         {
             int rem = n % 2;
             ans += (rem * pow);
             n /= 2;
         
             pow *= 10;
         }
         return ans;

     }



    public static void main( String [] args)
    {
        int n = scr.nextInt();
        int ans = decimalToBianry(n);
        System.out.println(ans);
    }
}


// javac DTB.java && java DTB 