import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static int MazePath( int sr, int sc, int er, int ec, String ans, int[][] dir, String[] dirS )
    {
        if( sr == er && sc == ec )
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        // d => direction in which we want to move
        for( int d = 0 ; d < dir.length ; d++ )
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if( r >= 0 && c >= 0 && r <= er && c <= ec ) // generic code likh raha hai isi lia r >= 0 && c >= 0 likha hai wasa koi jarurat nahi thi
            {
                count += MazePath( r, c, er, ec, ans + dirS[d], dir, dirS );
            } 
        }
        return count;
    }

    public static void main(String[] args)
    {
        int [][] dir = {{ 0, 1 }, { 1, 1 }, { 1, 0 } };
        String[] dirS = {"H", "D", "V"};

        System.out.println( MazePath( 0, 0, 2, 2, "", dir, dirS) );
    }
}


// javac Main.java && java Main