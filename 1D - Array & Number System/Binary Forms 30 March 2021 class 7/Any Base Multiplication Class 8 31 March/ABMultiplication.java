
import java.util.*;

public class ABMultiplication  {

    public static Scanner scr = new Scanner(System.in);

    public static int AnyBaseAddition( int n1, int n2, int b ) // O( n2 )
    {
        int carry = 0, pow = 1, ans = 0;
         
        while( n1 != 0 || n2 > 0 || carry > 0 )
        {
            int sum = (carry + (n1 % 10) + (n2 % 10) );
            
            n1 /= 10;
            n2 /= 10;

            int digit = sum % b;
            carry = sum / b;
            
            ans += digit * pow;
            pow *= 10;

        }

        return ans;

    }

    public static int multiplyNumberWithDigit( int n, int d, int b ) // O(n)
    {
        int ans = 0, pow = 1, carry = 0;

        while( n != 0 || carry != 0 )
        {
            int prod = carry + ( (n % 10) * d ); // product
            n /= 10;

            int digit = prod % b;
            carry = prod / b;

            ans += (digit * pow);
            pow *= 10;

        }
        return ans;
    }

    // n2 > n1 (Given)
    public static int AnyBaseMultiplication( int n1, int n2, int b )  // O(n* n)
    {
        int ans = 0, pow = 1;

        while( n2 != 0 )
        {
            int d = n2 % 10; // digit of n2( number2 )
            n2 /= 10;

            int prodRes = multiplyNumberWithDigit(n1, d, b ) * pow;
            ans = AnyBaseAddition(ans, prodRes, b);
            pow *= 10;
        }

        return ans;

    }

    public static void main( String [] args)
    {
        int b = scr.nextInt();
        int n1 = scr.nextInt();
        int n2 = scr.nextInt(); 

        System.out.println(AnyBaseMultiplication(n1, n2, b));
    }
    
}


// javac ABMultiplication.java && java ABMultiplication