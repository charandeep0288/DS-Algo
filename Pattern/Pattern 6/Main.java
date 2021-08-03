// n => is odd in input
// 1 <= n <= 100

import java.util.*;

public class  Main
{
    public static Scanner scr = new Scanner(System.in);

    public static void printPattern( int n )
    {
        int nst = (n/2)+1;
        int nsp = 1;
        int nor = n;

        for( int cr = 1 ; cr <= nor ; cr++)
        {
            for( int cst = 1 ; cst <= nst ; cst++)
               System.out.print("*\t");

            for(int csp = 1 ; csp <= nsp ; csp++)
               System.out.print("\t");
            
            for( int cst = 1 ; cst <= nst ; cst++)
               System.out.print("*\t");

            if(cr <= nor/2)
            {
                nst--;
                nsp += 2;
            }   
            else
            {
                nst++;
                nsp -= 2;
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
// javac Main.java && java Main > output6.txt