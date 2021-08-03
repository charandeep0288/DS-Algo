public class Main {
    
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

        // // hard code
        int [][] dir4 = {{ -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1} };
        String[] dir4S = {"t", "r", "d", "l"};

        int[][] dir8 = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -1 }, { 1, -1 }, { 1, 1 }, { -1, 1 } };
        String[] dir8S = { "u", "r", "d", "l", "n", "w", "s", "e" };

        int[][] board = new int[3][3];
        int n = board.length;
        int m = board[0].length;
        
        // System.out.println(floodFill_Jumps(0, 0, board, "", dir4, dir4S, Math.max(n, m)) );
        System.out.println(floodFill_Jumps(0, 0, board, "", dir8, dir8S, 3) ); // for radius = 3 in 8 direction, 2374 path aya gai 

    }
}
