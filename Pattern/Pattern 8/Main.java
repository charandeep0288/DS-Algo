import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    
    public static void printPattern(int n )
    {
        int noc = n; // number of coloumn
        for( int cr = 1 ; cr <= n ; cr++) // current row
        {
            for( int cc = 1 ; cc <= noc ; cc++ ) // current coloumn
            {
                if(cc+cr == n+1)
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print("\t");
                }
            }
            noc--;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // write ur code here
        int n = scn.nextInt();
        printPattern(n);

    }
}

// javac Main.java && java Main
// javac Main.java && java Main > output8.txt