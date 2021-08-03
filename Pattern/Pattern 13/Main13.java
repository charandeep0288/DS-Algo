// ncr = n! / ((n-r)! * r!)
import java.util.*;

public class Main13 {

    public static Scanner scr = new Scanner(System.in);

    public static void binomialPattern(int num)
    {
        int nst = 1; // number of stars
        int nor = num; // number of rows

        for( int n = 0 ; n < nor ; n++ ) // n => current row
        {
            int ncr = 1;
            for( int r = 0 ; r < nst ; r++) // r => current column
            {
                System.out.print(ncr + " ");
                int ncrpo = (( n- r ) *ncr)/ (r+1);
                ncr = ncrpo;
            }
            nst++;
            System.out.println();
        }
    }

    public static void main( String [] args)
    {
        int n = scr.nextInt();
        binomialPattern(n);
    }
}

 // javac Main13.java && java Main13
// javac Main13.java && java Main13 > output13.txt  