import java.util.*;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void printPattern( int n )
    {
        
        for(int cr = 1 ; cr <= n ; cr++) // current row 
        {
            for(int cc = 1 ; cc <= cr ; cc++) // current coloumn
            {
                if( cr == cc )
                   System.out.print("*\t");
                else
                   System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // write ur code here
        int n = scr.nextInt();
        printPattern(n);

    }
}

// javac Main.java && java Main
// javac Main.java && java Main > output7.txt