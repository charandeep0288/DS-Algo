
 // n2 > n1
import java.util.*;

public class ABSubtraction {

    public static Scanner scr = new Scanner(System.in);

    public static int AnyBaseSubtraction( int n1, int n2, int b )
    {
        int pow = 1, res = 0, borrow = 0;
        
        // n2 > n1
        while( n2 != 0 )
        {
            int diff = borrow + (n2 % 10) - (n1 % 10);
            n1 /= 10;
            n2 /= 10;

            if( diff < 0 )
            {
                diff += b; // 10 for base decimal
                borrow = -1;
            }
            else
            {
                borrow = 0;
            }
            res += (diff * pow);
            pow *= 10; 

        }

        return res;
    }

    public static void main( String [] args)
    {
        int b = scr.nextInt();
        int n1 = scr.nextInt();
        int n2 = scr.nextInt(); 

        System.out.println(AnyBaseSubtraction(n1, n2, b));
    }
    
}


// javac ABSubtraction.java && java ABSubtraction