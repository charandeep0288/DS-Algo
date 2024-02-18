import java.util.Scanner;

class l001 {
    public static Scanner scr = new Scanner(System.in);

    // -----------------------------------------------------------
    // 1. Maze Path
    public static int mazePath(int sr, int sc, int er, int ec, String ans, int[][] dir, String[] dirS) {
        if(sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        
        for(int d = 0 ; d < dir.length ; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += mazePath(r, c, er, ec, ans + dirS[d], dir, dirS);
            }
        }

        return count;
    }

    // Mark
    // for all unvisited Neighbour's
    // ---> call dfs for Neighbour's
    // unMark

    // -----------------------------------------------------------
    // 2. Flood Fill(with n number of directions)
    // 0 -> Empty cell, 1 -> Blocked cell
    public static int floodFill(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS) {
        int n = board.length, m = board[0].length;
        if(sr == n - 1 && sc == m - 1) {
            System.out.println(ans);
            return 1;
        }

        // mark
        board[sr][sc] = 1;
        
        int count = 0;
        for(int d = 0 ; d < dir.length ; d++) { // d -> direction in which we want to move
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 0) {
                count += floodFill(r, c, board, ans + dirS[d], dir, dirS);        
            }
        }

        // unmark
        board[sr][sc] = 0;
        return count;
    } 

    // -----------------------------------------------------------
    // 3. Flood Fill(with n number directions and jumps)
    public static int floodFill_Jumps(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS, int radius) { // if we want to expand upto a particular radius for that we have passed radius
        int n = board.length, m = board[0].length;
        if(sr == n - 1 && sc == m - 1) {
            System.out.println(ans);
            return 1;
        }

        // Mark
        board[sr][sc] = 1;
        
        int count = 0;
        for(int d = 0 ; d < dir.length ; d++) {
            for(int rad = 1 ; rad <= radius ; rad++) { // Math.max(n, m)
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if(r >= 0 && c >= 0 && r < n && c < m) {
                    if(board[r][c] == 0){
                        count += floodFill_Jumps(r, c, board, ans + rad + dirS[d], dir, dirS, radius);
                    }
                } else {
                    break;
                }
            }
        }

        // Unmark
        board[sr][sc] = 1;
        
        return count;
    }

    // -----------------------------------------------------------
    // 4. Longest path length
    public static int floodFill_longestLen(int sr, int sc, int[][] board, int[][] dir) {
        int n = board.length, m = board[0].length;
        if(sr == n - 1 && sc == m - 1) {
            return 0; // (2, 2) se (2, 2) tak jane ke path ki 0 length hai 
        }

        board[sr][sc] = 1; // block
        int longestLen = -1; // ans nahi ata toh usse pehechane ke liye ye -1 use kiya yaha pe 
        for(int d = 0 ; d < dir.length ; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 0) {
                int recAns = floodFill_longestLen(r, c, board, dir); // mere neighbour se dest tak ka path diya isne muje 
                if(recAns != -1 && recAns + 1 > longestLen) { // recAns != -1 matlab soln mila, recAns + 1 -> +1 iss liya kiya kyoki recAns ne neighbour se dest tak ka path hai - usme apne name ka +1 kiya jo mere se dest tak ke path bta raha hai 
                    longestLen = recAns + 1;
                }
            }
        }

        board[sr][sc] = 0; // free
        return longestLen;
    }

    // -----------------------------------------------------------
    // 5. Shortest path length
    public static int floodFill_shortestLen(int sr, int sc, int[][] board, int[][] dir) {
        int n = board.length, m = board[0].length;
        if(sr == n - 1 && sc == m - 1) {
            return 0; // (2, 2) se (2, 2) tak jane ke path ki 0 length hai 
        }


        board[sr][sc] = 1; // block
        int shortestLen = (int)1e9; // 
        for(int d = 0 ; d < dir.length ; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 0) {
                int recAns = floodFill_shortestLen(r, c, board, dir); // mere neighbour se dest tak ka path diya isne muje 
                if(recAns != (int)1e9 && recAns + 1 < shortestLen) { // Integer.MAX_VALUE ka check recAns != (int)1e9 lagya hai kyoki uske baad usme hum +1 kar rahe hai ... agar ye check(recAns != (int)1e9) nahi lagyege phele toh wo galat ho jayega(range se bahar chali jayegi value) 
                    shortestLen = recAns + 1;
                }
            }
        }
        board[sr][sc] = 0; // free
        return shortestLen;
    }

    public static void main(String[] args) {
        int[][] dir3 = {{0, 1}, {1, 1}, {1, 0}};
        String[] dir3S = {"H", "D", "V"};

        int[][] dir2 = {{0, 1}, {1, 0}};
        String[] dir2S = {"H", "V"};
        // System.out.println(mazePath(0, 0, 2, 2, "", dir3, dir3S));

        // int[][] board = new int[3][3];
        // int[][] board = {{0, 0, 0}, {1, 0, 1}, {0, 0, 0}};

        int[][] dir4 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        String[] dir4S = {"t", "r", "d", "l"};
        // System.out.println(floodFill(0, 0, board, "", dir4, dir4S));

        int[][] dir8 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {}, {}, {}, {}};
        String[] dir8S = {"u", "r", "d", "l", "n", "s", "e", "w"};

        // int n = board.length, m = board[0].length;
        // System.out.println(floodFill_Jumps(0, 0, board, "", dir8, dir8S, Math.max(n, m)));

        // ----------------------------------------
        int[][] board = {{0, 0, 0}, {0, 0, 1}, {0, 0, 0}};
        System.out.println(floodFill_longestLen(0, 0, board, dir4));
        
        System.out.println(floodFill_shortestLen(0, 0, board, dir4));
    }
}

// javac l001.java && java l001 < input.txt > output.txt