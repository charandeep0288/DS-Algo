import java.util.Scanner;

public class reverseNumber {
    public static Scanner scr = new Scanner(System.in);

    public static void reverseOfANumber(int n )
    {
        while( n != 0)
        {
            int rem = n%10;
            n /= 10;
            System.out.println(rem);
        }
    }
    public static void main(String [] args)
    {
        int n = scr.nextInt();
        reverseOfANumber(n);
    }
}

// javac reverseNumber.java && java reverseNumber