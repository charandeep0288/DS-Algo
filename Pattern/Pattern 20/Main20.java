import java.util.*;

public class Main20 {
    public static void printWPattern( int n )
    {
        for(int cr = 1 ; cr <= n ; cr++)
        {
            for( int cc = 1 ; cc <= n ; cc++ )
            {
                if( (cr+cc == n+1 || cc == cr ) && cr > n/2 || cc == 1 || cc == n )
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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        printWPattern(n);
        scn.close();

    }
}

 // javac Main20.java && java Main20
// javac Main20.java && java Main20 > output20.txt