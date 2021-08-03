import java.io.*;
import java.util.*;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scr.nextInt();
        int m = scr.nextInt();
        
        printMazePath_MultiHVD( 0, 0, n - 1, m - 1, "" );
    }

    // sr => starting row
    // sc => starting column
    // dr => destination row
    // dc => destination column
    public static int printMazePath_MultiHVD( int sr, int sc, int dr, int dc, String ans )
    {
        if( sr == dr && sc == dc )
        {
            System.out.println(ans); 
            return 1;
        }

        int count = 0;

        // horizontal
        for( int jump = 1; sc + jump <= dc ; jump++ )
            count += printMazePath_MultiHVD(sr, sc + jump, dr, dc, ans + "h" + jump);

        
        // vertical    
        for( int jump = 1; sr + jump <= dr ; jump++ )
            count += printMazePath_MultiHVD(sr + jump, sc, dr, dc, ans + "v" + jump);
        
         // diagonal    
        for( int jump = 1; sr + jump <= dr && sc + jump <= dc ; jump++ )   
            count += printMazePath_MultiHVD(sr + jump, sc + jump, dr, dc, ans + "d" + jump);  
        return count;    
    }

}

// javac Main.java && java Main