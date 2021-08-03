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
     
    // Mark
    // for all unvisited neighbours
    // ------> call dfs for neighbours
    // unMark

    // 0 -> empty cell, 1-> blocked cell
    public static int floodFill( int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS )
    {
        int n = board.length;
        int m = board[0].length;
        if( sr == n - 1 && sc == m - 1 )
        {
            System.out.println(ans);
            return 1;
        }

        // mark
        board[sr][sc] = 1;

        int count = 0;
        // d => direction in which we want to move
        for( int d = 0 ; d < dir.length ; d++ )
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if( r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 0 ) 
            {
                count += floodFill( r, c, board, ans + dirS[d], dir, dirS );
            } 
        }

        // unmark
        board[sr][sc] = 0;
        return count;
    }



    // GENERIC CODE
    // 0 -> empty cell, 1-> blocked cell
    public static int floodFill_Jumps( int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS, int Radius )
    {
        int n = board.length;
        int m = board[0].length;
        if( sr == n - 1 && sc == m - 1 )
        {
            System.out.println(ans);
            return 1;
        }

        // mark
        board[sr][sc] = 1;

        int count = 0;
        // d => direction in which we want to move
        for( int d = 0 ; d < dir.length ; d++ )
        {
            for(int rad = 1 ; rad <= Radius ; rad++ )
            {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if( r >= 0 && c >= 0 && r < n && c < m ) 
                {
                    if ( board[r][c] == 0 )
                        count += floodFill_Jumps( r, c, board, ans + rad + dirS[d], dir, dirS, Radius );
                }
                else
                {
                    break;
                }
            }
        }

        // unmark
        board[sr][sc] = 0;
        return count;
    }
    
    public static void main( String [] args )
    {

        // int [][] dir = {{ 0, 1 }, { 1, 1 }, { 1, 0 } };
        // String[] dirS = {"H", "D", "V"};
        // System.out.println( MazePath( 0, 0, 2, 2, "", dir, dirS) );


        // // hard code
        int [][] dir4 = {{ -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1} };
        String[] dir4S = {"t", "r", "d", "l"};
        int[][] board = new int[3][3];
        // System.out.println( floodFill( 0, 0, board, "", dir4, dir4S) );

        int[][] dir8 = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -1 }, { 1, -1 }, { 1, 1 }, { -1, 1 } };
        String[] dir8S = { "u", "r", "d", "l", "n", "w", "s", "e" };
        // System.out.println(floodFill(0, 0, board, "", dir8, dir8S));

        int n = board.length;
        int m = board[0].length;
        // System.out.println(floodFill_Jumps(0, 0, board, "", dir4, dir4S, Math.max(n, m)) );
        System.out.println(floodFill_Jumps(0, 0, board, "", dir8, dir8S, 3) ); // for radius = 3 in 8 direction, 2374 path aya gai 

    }
}

// javac Main.java && java Main > output.txt
