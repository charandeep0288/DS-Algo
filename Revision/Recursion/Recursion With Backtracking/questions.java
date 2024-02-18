import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class questions {
    
    public static Scanner scr = new Scanner(System.in);

    public static void display(int[][] arr) {
        int n = arr.length, m = arr[0].length;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                System.out.print(arr[i][j] + " \t");
            }
            System.out.println();
        }
    }

    // -----------------------------------------------------------------------------
    // problem 1 -> https://www.geeksforgeeks.org/rat-in-a-maze/
    // 0 -> blocked, 1 -> unblocked
    public static int floodFill(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS, List<String> res) {
        int n = board.length, m = board[0].length;
        if(sr == n - 1 && sc == m - 1) {
            res.add(ans);
            return 1;
        }

        board[sr][sc] = 0;

        int count = 0;
        for(int d = 0 ; d < dir.length ; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 1) {
                count += floodFill(r, c, board, ans + dirS[d], dir, dirS, res);
            }
        }

        board[sr][sc] = 1;
        return count;
    }
    
    public static ArrayList<String> findPath(int[][] mat, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        if (n == 0 || mat[n - 1][n - 1] == 0 || mat[0][0] == 0)
            return res;
        
        int[][] dir = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        String[] dirS = { "D", "L", "R", "U" }; // By defining Array like this we would get lexicographically increasing order, no need to sort the array then. 
 
        int count = floodFill(0, 0, mat, "", dir, dirS, res);
        
        // Collections.sort(res);
        return res;
    }

    // -----------------------------------------------------------------------------
    // problem 2(Special Matrix) -> https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
    // We would get Time Limit Exceed because its a DP question
    public static int mod = (int)1e9 + 7; // largest prime number in int range
    public static int floodFill(int sr, int sc, int[][] board, int[][] dir) {
        int n = board.length, m = board[0].length;
        if(sr == n - 1 && sc == m - 1) {
            return 1;
        }
        
        board[sr][sc] = 1; // block
        int count = 0;
        for(int d = 0 ; d < dir.length ; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 0) {
                count = (count % mod + floodFill(r, c, board, dir) % mod) % mod; // to control the overflow
            }
        }

        board[sr][sc] = 0; // free
        return count;
    }
    
    public int FindWays(int n, int m, int[][] blocked_cells) {
        int[][] board = new int[n][m];
        for(int[] cell : blocked_cells) {
            int i = cell[0] - 1;
            int j = cell[1] - 1;
            
            board[i][j] = 1;
        }
        
        if(board[0][0] == 1 || board[n - 1][m - 1] == 1) {
            return 0;
        }
        
        int[][] dir= {{0, 1}, {1, 0}};
        int count = floodFill(0, 0, board, dir);

        return count;
    }


    // -----------------------------------------------------------------------------
    // problem 3 -> https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/
    // https://www.geeksforgeeks.org/problems/rat-maze-with-multiple-jumps3852/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab
    public boolean floodFill_Jumps(int sr, int sc, int[][] board, int[][] sol, int[][] dir) {
        int n = board.length, m = board[0].length;
        if(sr == n - 1 && sc == m - 1) {
            sol[sr][sc] = 1; // we have reached the destination
            return true;
        }

        sol[sr][sc] = 1;
        boolean res = false;
        
        for(int rad = 1 ; rad <= board[sr][sc] ; rad++) {
            for(int d = 0 ; d < dir.length ; d++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if(r >= 0 && c >= 0 && r < n && c < m) {
                    if(sol[r][c] == 0)
                    res = res || floodFill_Jumps(r, c, board, sol, dir);
                    if(res) 
                        return true;
                }
            }
        }

        sol[sr][sc] = 0;
        return res;
    }
    
    public int[][] ShortestDistance(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] sol = new int[n][m];

        int[][] dir = {{0, 1}, {1, 0}};

        if(floodFill_Jumps(0, 0, matrix, sol, dir))
            return sol;

        int[][] resMat = {{-1}};
        return resMat;
    }

    // -----------------------------------------------------------------------------
    // problem 4(Same as problem 1) -> https://www.geeksforgeeks.org/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed/     

    // -----------------------------------------------------------------------------
    // problem 5 -> knight tour
    public static boolean knightTour(int sr, int sc, int[][] board, int move, int[] dirX, int[] dirY) {
        int n = board.length, m = board[0].length;
        board[sr][sc] = move; // board pe place karna hai hume last vale move ko bhi return karne se phele base case me, tabhi board pe move ko place karne vali line base case ke upar likhi  hai
        if(move == 63) {
            return true;
        }
        
        boolean res = false;
        for(int d = 0 ; d < 8 ; d++) {
            int r = sr + dirX[d];
            int c = sc + dirY[d];

            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == -1) {
                res = knightTour(r, c, board, move + 1, dirX, dirY);
                if(res) { // agar hum apne matrix ko change nahi hone dena chahte ik bar ans milne ke baad toh asse return kar denge 
                    return true;
                }
            }
        }

        board[sr][sc] = -1;
        return res;
    }

    public static void knightTour() {
        int n = 8;
        int[][] board = new int[n][n];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                board[i][j] = -1; // by default board pe -1 place kiya 
            }
        }

        // use this arrangement for the directions
        int dirX[] = { 2, 1, -1, -2, -2, -1, 1, 2 }; 
        int dirY[] = { 1, 2, 2, 1, -1, -2, -2, -1 }; 

        knightTour(0, 0, board, 0, dirX, dirY);

        display(board);
    }

    public static void main(String[] args) {
        // int[][] board = new int[3][3];

        int[][] board = {{1, 0, 0, 0},
                        {1, 1, 0, 1}, 
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};

        // System.out.println(findPath(board, board.length));

        knightTour();
    }
}

// javac questions.java && java questions < input.txt > output.txt