 
 import java.util.*;

public class AbAddition {

    public static Scanner scr = new Scanner(System.in);

    public static int AnyBaseAddition( int n1, int n2, int b )
    {
        int carry = 0, pow = 1, ans = 0;
         
        while( n1 > 0 || n2 > 0 || carry > 0 )
        {
            int sum = (carry + n1 % 10 + n2 % 10 );
            
            n1 /= 10;
            n2 /= 10;

            int digit = sum % b;
            carry = sum / b;
            
            ans += digit * pow;
            pow *= 10;

        }

        return ans;

    }

    public static void main( String [] args)
    {
        int b = scr.nextInt(); 
        int n1 = scr.nextInt();
        int n2 = scr.nextInt();

        System.out.println(AnyBaseAddition(n1, n2, b));
    }
    
}


// javac AbAddition.java && java AbAddition 