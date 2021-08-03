public class l004NqueenSet{

    public static boolean isSafeToPlaceQueen(boolean[][] box, int sr, int sc){
        int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        int n = box.length, m = box[0].length;

        for(int d = 0 ; d < dir.length ; d++){
            for(int rad = 1 ; rad <= n ; rad++){
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if(r >= 0 && c >= 0 && r < n && c < m){
                    if(box[r][c])
                        return false;
                } 
                else
                    break;
            }
        }

        return true;
    }

    public static boolean isSafeToPlaceQueen_Permute(boolean[][]box, int sr, int sc){
        int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

        int n = box.length, m = box[0].length;

        for(int d = 0 ; d < dir.length ; d++){
            for(int rad = 1 ; rad < n ; rad++){
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];
                if(r >= 0 && c >= 0 && r < n && c < m){
                    if(box[r][c])
                        return false;
                }
                else
                    break;
            }
        }
        return true;
    }

    // combiantions
    public static int nQueen_01(boolean[][] box, int bno, int tnq, String asf){
        if(tnq == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        int n = box.length, m = box[0].length;
        for(int b = bno ; b < n * m ; b++ ){
            int r = b / m;
            int c = b % m;

            if(isSafeToPlaceQueen(box, r, c)){ // queen safe hai ki nahi iss jaga pai place karna
                box[r][c] = true; // mark
                count += nQueen_01(box, b + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false; // unmark
            }
        }
        return count;
    }

    // permutations
    public static int nQueen_02_Permute(boolean[][] box, int bno, int tnq, String asf, boolean[][] vis){
        if(tnq == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for(int b = 0 ; b < n * m ; b++){
            int r = b / m;
            int c = b % m;

            if(!vis[r][c]){
                vis[r][c] = true; // mark

                if(isSafeToPlaceQueen_Permute(box, r, c)){
                vis[r][c] = true; // mark
                
                count += nQueen_02_Permute(box , b + 1, tnq - 1, asf + "(" + r + "," + c + ") ", vis);

                vis[r][c] = false; // unmark

                }
            }
        }

        return count;
    }

    // ========================================================
    // 28 july, 2021
    // ========================================================

    static boolean[] row, col, diag, adiag;
    static int call = 0;
   
    // isSafe optimization. , combiantion
    public static int nQueen_03(int n, int m, int bno, int tnq, String asf){
        if(tnq == 0){
            System.out.println(asf);
            return 1;
        }

        call++; // for checking the number of call kitni lag rahi hai (only for testing) 
        int count = 0;
        
        for(int b = bno; b < n * m ; b++){
            int r = b / n;
            int c = b % m;
            
            if(!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]){

                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true; // mark

                count += nQueen_03(n, m, b + 1, tnq - 1, asf + "(" + r + "," + c + ") ");

                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false; // unmark
            }
        }

        return count;
    }

    // isSafe optimization, Permutation
    public static int nQueen_04(int n, int m, int tnq, String asf){
        if(tnq == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        
        for(int b = 0 ; b < n * m ; b++){
            int r = b / m;
            int c = b % m;

            if(!row[r] && col[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true; // mark

                count += nQueen_04(n, m, tnq - 1, asf + "(" + r + "," + c + ") ");

                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false; // unmark
            }
        }

        return count;
    }

    // combination_optimizated
    public static int nQueen_05(int n, int m, int floor, int tnq, String asf){
        // if(tnq == 0 || floor >= n){
            if(tnq == 0){
                System.out.println(asf);
                return 1;
            }
            // return 0;
        // }

        call++;
        int count = 0;

        for(int room = 0 ; room < m ; room++){
            int r = floor, c = room;
            if(!col[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                col[c] = diag[r + c] = adiag[r - c + m - 1] = true; // mark

                count += nQueen_05(n, m, floor + 1, tnq - 1, asf + "(" + r + "," + c + ") ");

                col[c] = diag[r + c] = adiag[r - c + m - 1] = false; // unmark
            }
        }

        // count += nQueen_05(n, m, floor + 1, tnq, asf);

        return count;
    }

    // permutation_optimized
    public static int nQueen_06(int n, int m, int floor, int tnq, String asf){
        if(tnq == 0 || floor >= n){
            if(tnq == 0){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        call++;
        int count = 0;

        for(int room = 0 ; room < m ; room++){
            int r = floor, c = room;
            if(!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true; // mark

                count += nQueen_06(n, m, 0, tnq - 1, asf + "(" + r + "," + c + ") ");

                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false; // unmark
            }
        }

        count += nQueen_06(n, m, floor + 1, tnq, asf);

        return count;
    }


    public static void nQueen(){
        // int n = 4, tnq = 4; // tnq: total number of queen
        // boolean[][] box = new boolean[n][n];
        // boolean[][] vis = new boolean[n][n];
        
        // System.out.println(nQueen_01(box, 0, tnq, ""));
        // System.out.println(nQueen_02_Permute(box, 0, tnq, "", vis));

        // --------------------------------------------------
        // ----------- 28 july, 2021 wed -------------------
        int n = 10, m = 10;
        int tnq = 10; // total number of queens
        row = new boolean[n];
        col = new boolean[m];
        diag = new boolean[n + m - 1];
        adiag = new boolean[n + m - 1];

        // System.out.println(nQueen_03(n, m, 0, tnq, ""));
        // System.out.println(nQueen_05(n, m, 0, tnq, ""));
        System.out.println(nQueen_06(n, m, 0, tnq, ""));

        System.out.println("calls: " + call);
    }
    public static void main(String[] args){
        nQueen();
    }
}

// javac l004NqueenSet.java && java l004NqueenSet > output.txt