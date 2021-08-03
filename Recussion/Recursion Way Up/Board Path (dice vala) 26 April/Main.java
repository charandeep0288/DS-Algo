
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scr.nextInt();
        
        // System.out.println( boardPath(n, "") );  // ( 10 to 0 ) 
        System.out.println( boardPath(0, n, "") );  // ( 0 to 10 )

    }

    // board Path => dice vala ( 10 to 0 ) 
    // picha se chalna better mana jata hai
    public static int boardPath( int n, String ans )
    {
        // base case
        if( n == 0 )
        {
            System.out.println(ans);
            return 1; // base case mai ik ans mil gia
        }

        int count = 0;
        for( int dice = 1 ; dice <= 6 && ( n - dice ) >= 0 ; dice++ )
        {
            count += boardPath(n - dice , ans + dice);
        }
        return count;
    } 

    // board Path => dice vala ( 0 to 10 )
    public static int boardPath( int sp, int ep, String ans )
    {
        // base case
        if( sp == ep )
        {
            System.out.println(ans);
            return 1; // base case mai ik ans mil gia
        }

        int count = 0;
        for( int dice = 1 ; dice <= 6 && ( sp + dice ) <= ep ; dice++ )
        {
            count += boardPath(sp + dice, ep , ans + dice);
        }
        
        return count;
    }

}

// javac Main.java && java Main