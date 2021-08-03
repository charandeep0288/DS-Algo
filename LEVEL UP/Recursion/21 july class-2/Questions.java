import java.util.ArrayList;
import java.util.Arrays;

public class Questions{

    // Q1
    // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
    // lexographical order mai chahia ans
    public static int ratInMaze(int sr, int sc, int[][] mat, String psf, int[][] dir, String[] dirS,
            ArrayList<String> res) {

        int n = mat.length, m = mat[0].length;
        if (sr == n - 1 && sc == m - 1) {
            res.add(psf);
            return 1;
        }

        mat[sr][sc] = 0; // block
        
        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && mat[r][c] == 1) {
                count += ratInMaze(r, c, mat, psf + dirS[d], dir, dirS, res);
            }
        }

        mat[sr][sc] = 1; // free
        return count;
    }

    public static ArrayList<String> findPath(int[][] mat, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0 || mat[n - 1][n - 1] == 0 || mat[0][0] == 0)
            return ans;

        int[][] dir = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        String[] dirS = { "D", "L", "R", "U" };  // by creating direction vector like this we will get ans in lexicographically increasing order, 

        int count = ratInMaze(0, 0, mat, "", dir, dirS, ans);

        return ans; //  returns the list of paths in lexicographically increasing order
    }

    // Q2
    // https://practice.geeksforgeeks.org/problems/special-matrix4201/1#F
    // true -> blocked, false -> unblocked
    public static int specialMatrix(int sr, int sc, boolean[][] mat, String psf, int[][] dir, String[] dirS,  ArrayList<String> ans){
        int n = mat.length, m = mat[0].length;
        if (sr == n - 1 && sc == m - 1){ 
            ans.add(psf);
            return 1;
        }
        
        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r > 0 && c > 0 && r < n && c < m && !mat[r][c]) {
                count += specialMatrix(r, c, mat, psf + dirS[d], dir, dirS, ans );
            }
        }

        return count;
    }
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        // Code here
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0 || blocked_cells[n - 1][n - 1] == 0 || blocked_cells[0][0] == 0)
            return 0;

            int[][] dir = {{0, 1}, {1, 0}};
            String[] dirS = {"R", "D"};  // by creating direction vector like this we will get ans in lexicographically increasing order, 

        boolean[][] mat = new boolean[n][m];
        for(int[] cell : blocked_cells){
            mat[cell[0] - 1][cell[0] - 1] = true; // blocked marked
        }

        int count = specialMatrix(0, 0, mat, "", dir, dirS, ans);

        // System.out.println(ans); // to print all answers

        return count; //  returns the list of paths in lexicographically increasing order
    }


    // Q3
    // https://www.geeksforgeeks.org/a-variation-of-rat-in-a-maze-multiple-steps-or-jumps-allowed/?ref=rp


    
}