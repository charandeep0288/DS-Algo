import java.util.Scanner;
// Problem 1 :- https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/

// Problem 2 :- https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/

// Problem 3 :- https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/

// Problem 4 :- https://www.geeksforgeeks.org/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed/?ref=rp

class Main{
    public static Scanner scr = new Scanner(System.in);

    // public static int floodFill( int sr, int sc, int[][] maze, String ans, int[][] dir, String[] dirS)
    // {
    //     int n = maze.length;
    //     int m = maze[0].length; 
    //     if( sr == n - 1 && sc == m - 1 )
    //     {
    //         // System.out.println(ans);
    //         res.add(ans);
    //         return 1;
    //     }

    //     // block
    //     maze[sr][sc] = 0;
    //     int count = 0;

    //     for( int d = 0 ; d < dir.length ; d++ )
    //     {
    //         int r = sr + dir[d][0];
    //         int c = sc + dir[d][1];

    //         if( r >= 0 && c >= 0 && r < n && c < m  && maze[r][c] == 1 )
    //         {
    //             count += floodFill(r, c, maze, ans + dirS[d], dir, dirS, res);
    //         }
    //     }

    //     // unblock
    //     maze[sr][sc] = 1;
    //     return count;
    // }

    // public static ArrayList<String> findPath( int[][] arr, int n )
    // {
    //     ArrayList<String> res = new ArrayList<>();
    // }


    // int mod = (int)1e9 + 7;
    // public static int floodFill( int sr, int sc, int[][] arr, int[][] dir)
    // {
    //     int n = arr.length;
    //     int m = arr[0].length;
    //     if( sr == n - 1 && sc == m - 1 )
    //     {
    //         return 1;
    //     }

    //     arr[sr][sc] = 1; // block
    //     int count = 0;
    //     for( int d = 0 ; d < dir.length ; d++ )
    //     {
    //         int r = sr + dir[d][0];
    //         int c = sc + dir[d][1];

    //         if( r >= 0 && c >= 0 && r < n && c < m && arr[r][c] == 0 )
    //         {
    //             count = ( count % mod + floodFill(r, c, arr, dir) % mod ) & mod;
    //         }
    //     }

    //     arr[sr][sc] = 0; // free
    //     return count;
    // } 

    // public static int FindWays( int n, int m, int[][] blocked_cells )
    // {
    //     int[][] arr = new int[n][m];
    //     // 1 index base array ko 0 base index array mai convert kar lia
    //     for( int[] cell : blocked_cells )
    //     {
    //         int i = cell[0] - 1;
    //         int j = cell[1] - 1;

    //         arr[i][j] = 1; // block kar dia ( 1 base index vala matrix ka lia )
    //     }

    //     if( arr[n - 1][m - 1] == 1 || arr[0][0] == 1 ) // jaha se chalna hai aur jaha puchna hai woo agar blocked hai tho chalna ka koi fida nahi
    //     {
    //         return 0;
    //     }

    //     int[][] dir = { { 0, 1 }, { 1, 0 } };
    //     int count = floodFill( 0, 0, arr, dir );
    //     return count;
    // }

    public static int longestPath( int sr, int sc, int[][] board, int[][] dir, int len, int maxLen )
    {
        int n = board.length;
        int m = board[0].length;  
        if( sr == n - 1 && sc == m - 1 )
        {
            return 1;
        }

        len = 0;
        for( int d = 0 ; d < dir.length ; d++ )
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if( r >= 0 && c >= 0 && r < n && c < m )
            {
                if( board[r][c] == 0)
                   len += longestPath(r, c, board, dir, len + 1, maxLen);
            }
        }

        return maxLen;
    }
    public static void main(String [] args )
    {
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };

        int [][] dir = { { 0, 1 }, { 1, 0 } };
        String[] dirS = { "H", "V" };                 
        // System.out.println( problem1( 0, 0, maze, "", dir,dirS ) );

        int[][] board = new int[3][3];
        System.out.println( longestPath(0, 0, board, dir, 0, 0) );
    } 
}

// javac Main.java && java Main > output.txt