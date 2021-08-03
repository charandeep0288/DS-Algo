 // n => is odd in input
// 1 <= n <= 100

 import java.util.*;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void printPattern(int n )
    {
        for( int cr = 1 ; cr <= n ; cr++)
        {
            for( int cc = 1 ; cc <= n ; cc++)
            {
                if( (cc == cr) || (cc+cr == n+1))
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
    public static void main(String [] args)
    {
        int n = scr.nextInt();
        printPattern(n);
    } 
}

// javac Main.java && java Main
// javac Main.java && java Main > output9.txt