
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scr.nextInt();
        int m = scr.nextInt();
        
        printMazePath_HV(0, 0, n - 1 , m - 1 , "" );

    }

    // sr => starting row
    // sc => starting column
    // dr => destination row
    // dc => destination column
    public static int printMazePath_HV( int sr, int sc, int dr, int dc, String ans )
    {
        if( sr == dr && sc == dc )
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        if( sc + 1 <= dc )
            count += printMazePath_HV(sr, sc + 1, dr, dc, ans + "h");

        if( sr + 1 <= dr )
            count += printMazePath_HV(sr + 1, sc, dr, dc, ans + "v");
          
        return count;    
    }
    
    
    // sr => starting row
    // sc => starting column
    // dr => destination row
    // dc => destination column
    public static int printMazePath_HDV( int sr, int sc, int dr, int dc, String ans )
    {
        if( sr == dr && sc == dc )
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        if( sc + 1 <= dc )
            count += printMazePath_HDV(sr, sc + 1, dr, dc, ans + "H");

        if( sr + 1 <= dr && sc + 1 <= dc)     
            count += printMazePath_HDV(sr + 1, sc + 1, dr, dc, ans + "D");
        
        if( sr + 1 <= dr )
            count += printMazePath_HDV(sr + 1, sc, dr, dc, ans + "V");
          
        return count;    
    }

}

// javac Main.java && java Main