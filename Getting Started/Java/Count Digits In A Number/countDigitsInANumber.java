import java.util.*;

public class countDigitsInANumber
{
    public static Scanner scr = new Scanner(System.in);

    public static int countDigitsOfNumber(int n)
    {
        int len = 0;
        while( n != 0 )
        {
            n /= 10;
            len++;
        }
        return len;
    }
    public static void main(String [] args)
    {
        int n = scr.nextInt();
        int res = countDigitsOfNumber(n);
        System.out.println(res);
    }
}

// javac countDigitsInANumber.java && java countDigitsInANumber