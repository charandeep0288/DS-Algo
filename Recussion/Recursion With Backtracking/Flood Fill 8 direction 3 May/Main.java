import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        // int n = scn.nextInt();
        // int m = scn.nextInt();
        // int[][] board = new int[n][m];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         board[i][j] = scn.nextInt();
        //     }
        // }

        int[][] board = new int[3][3];
        
        int[][] dir8 = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -1 }, { 1, -1 }, { 1, 1 }, { -1, 1 } };
        String[] dir8S = { "u", "r", "d", "l", "n", "w", "s", "e" };
        System.out.println(floodFill(0, 0, board, "", dir8, dir8S));
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
}

// javac Main.java && java Main