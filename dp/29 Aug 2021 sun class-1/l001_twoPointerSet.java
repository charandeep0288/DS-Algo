public class l001_twoPointerSet{
    // 1_Faith
    // 2_Recursive_Tree
    // 3_RecursiveCode -> Memorization
    // 4_Observation
    // 5_Tabulation
    // 6_Optimization

    public static void display(int[] dp){
        for(int ele : dp){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] dp) {
        for(int[] d : dp){
            display(d);
        }
        System.out.println();
    }

    // ============================================================
    public static int fibo_recursion(int n){
        if(n <= 1)
            return n;
        
        int recAns = fibo_recursion(n - 1) + fibo_recursion(n - 2);
        return recAns;
    }

    // yaa recursion huma kabhi Time complexity nahi batati memorization ki (kio ki muja nahi pata ki kitni calls lagi recursion & uska baad kis state pa recursion ki calls ruki)
    // memorization
    public static int fibo_memo(int n, int[] dp) {
        if(n <= 1)
            return dp[n] = n;

        if(dp[n] != 0) // har bar ik swal pucha jai gaa call lagana se pahala, kya iss state ka answer apka pass present hai, aggar hn tho -> return kar doo woo value 
            return dp[n];

        // recursion ki doo faith calls 
        int ans = fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
        return dp[n] = ans; // last mai ans return karta  hua dp[n] mai ans store bhi kara gai
    }

    // --------------------------------------
    // tabulation vala method mai -> 
    // return ki jaga continue
    // --------------------------------------

    // yaa huma time complexity bata dai gii 
    // T : O(n), S : O(n)
    public static int fibo_tabu(int N, int[] dp){
        // 1. fn argument mai 'n' ki jaga 'N' aya jai gaa taki fn ka andar 'n' as a vaiable use kar pai
        //  2. fn ka andar woo variable use karna joo memorization mai kiya tha
        // 3. memorization mai joo recursion kaa 'return' hota hai -> woo yaha tabulation mai 'continue' hoo jai gaa 
        for(int n = 0 ; n <= N ; n++){ 
            if(n <= 1){
                dp[n] = n; 
                continue;
            }
 
            // dp ki doo faith calls 
            int ans = dp[n - 1] + dp[n - 2]; // fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
            dp[n] = ans; // yaha return hata kai continue lagana kaa koi matlab nahi, kio ki for loop wasa bhi upar iss line kaa baad jaa raha hai
        }

        return dp[N]; // dp ka last index pai ans mila gaa muja
    }

    // yaa bhi huma time complexity bata dai gaa
    // T : O(n), S : O(1)
    public static int fibo_opti(int N){
        if(N <= 1)
            return N;
        int a = 0, b = 1;
        for(int i = 2 ; i <= N ; i++){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // isma base case lagna ki jarurat nahi hai, (sab handled hai yaha)
    public static int fibo_opti_02(int N){
        int a = 0, b = 1;
        for(int i = 2 ; i <= N ; i++){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a; // 
    }

    public static void fibo(){
        int n = 10;
        int[] dp = new int[n + 1]; // dp -> n + 1 size ki bana gii

        // System.out.println(fibo_recursion(n));
        // System.out.println(fibo_memo(n, dp));
        // System.out.println(fibo_tabu(n, dp));
        System.out.println(fibo_opti(n));

        display(dp);
    }

    // ============================================================
    // Maze Path with 1 JUMP
    // (0, 0) -> se -> (2, 2) tak jaa raha hai
    public static int mazePath_memo_01(int sr, int sc, int er, int ec, int[][] dp, int[][] dir){
        if(er == sr && ec == sc){
            return dp[sr][sc] = 1; // return 1; matlab -> ik rasta mil gya source se destination tak kaa
        }

        if(dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for(int[] d : dir){
            int r = sr + d[0], c = sc + d[1]; // yaa add karna jaruri hai next recursion call lagana se phala kio ki infinite call lag jai gii nahi tho 
            if(r >= 0 && c >= 0 && r < dp.length && c < dp[0].length){
                count += mazePath_memo_01(r, c, er, ec, dp, dir);
            }
        }

        return dp[sr][sc] = count;
    }

    // (2, 2) se -> (0, 0) tak jaa raha hai (peffer this method because it will help in String set of dp)
    public static int mazePath_memo_02(int sr, int sc, int er, int ec, int[][] dp, int[][] dir){
        if(er == 0 && ec == 0){
            return dp[er][ec] = 1; // return 1; matlab -> ik rasta mil gya source se destination tak kaa
        }

        if(dp[er][ec] != 0)
            return dp[er][ec];

        int count = 0;
        for(int[] d : dir){
            int r = er + d[0], c = ec + d[1]; // yaa add karna jaruri hai next recursion call lagana se phala kio ki infinite call lag jai gii nahi tho 
            if(r >= 0 && c >= 0 && r < dp.length && c < dp[0].length){ // r < dp.length && c < dp.length <= iss condition ki jarurat nahi thi but genric code likh raha hai tho sara check lagyai gai
                count += mazePath_memo_02(sr, sc, r, c, dp, dir);
            }
        }

        return dp[er][ec] = count;
    }

    // (0, 0) -> se -> (2, 2) tak jaa raha hai -> iss recursion mai tho iss dependency ko resolve karna haa lia hum loop (ER, EC) -> (2, 2) se (SR, SC) -> (0, 0) tak chalai gai
    public static int mazePath_tabu_01(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir){
        // sr & sc huma SR & SC tak chalana chahia for ower knowledge
        for(int sr = ER ; sr >= SR ; sr--){
            for(int sc = EC ; sc >= SC ; sc--){
                if(ER == sr && EC == sc){
                    dp[sr][sc] = 1;
                    continue;
                }
        
                int count = 0;
                for(int[] d : dir){
                    int r = sr + d[0], c = sc + d[1]; 
                    if(r >= 0 && c >= 0 && r < dp.length && c < dp[0].length){
                        count += dp[r][c]; // mazePath_memo(r, c, er, ec, dp, dir);
                    }
                }
                
                dp[sr][sc] = count;
            }
        }

        // dp[SR][SC] se dp[ER][EC] tak ans manga hai -> tho ans bhi huma dp[SR][SC] pai mila gaa
        return dp[SR][SC]; 
    }

    // (2, 2) se -> (0, 0) tak jaa raha hai -> iss recursion mai tho iss dependency ko resolve karna haa lia hum loop  (SR, SC) -> (0, 0) se (ER, EC) -> (2, 2) tak chalai gai
    public static int mazePath_tabu_02(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir){
        for(int er = SR ; er <= ER ; er++){
            for(int ec = SC ; ec <= EC ; ec++){
                if(er == 0 && ec == 0){
                    dp[er][ec] = 1; // return 1; matlab -> ik rasta mil gya source se destination tak kaa
                    continue;
                }
        
                int count = 0;
                for(int[] d : dir){
                    int r = er + d[0], c = ec + d[1]; // yaa add karna jaruri hai next recursion call lagana se phala kio ki infinite call lag jai gii nahi tho 
                    if(r >= 0 && c >= 0 && r < dp.length && c < dp[0].length){ // r < dp.length && c < dp.length <= iss condition ki jarurat nahi thi but genric code likh raha hai tho sara check lagyai gai
                        count += dp[r][c]; // mazePath_memo_02(sr, sc, r, c, dp, dir);
                    }
                }
        
                dp[er][ec] = count;
            }
        }

        // dp[ER][EC] se dp[SR][SC] tak ans manga hai -> tho ans bhi huma dp[ER][EC] pai mila gaa
        return dp[ER][EC]; 
    }

    // ----------------------------------------------
    // Maze Path with INFINITE JUMPS
    public static int mazePathJumps_memo(int sr, int sc, int er, int ec, int[][] dp, int[][] dir){
        if(er == sr && ec == sc){
            return dp[sr][sc] = 1;
        }

        if(dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for(int[] d : dir){
            int r = sr + d[0], c = sc + d[1];
            while(r >= 0 && c >= 0 && r < dp.length && c < dp[0].length){
                count += mazePathJumps_memo(r, c, er, ec, dp, dir);
                r += d[0];
                c += d[1];
            }
        }

        return dp[sr][sc] = count;
    }

    public static int mazePathJumps_tabu(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir){
        for(int sr = ER ; sr >= SR ; sr--){
            for(int sc = EC ; sc >= SC ; sc--){
                if(ER == sr && EC == sc){
                    dp[sr][sc] = 1;
                    continue;
                }
        
                int count = 0;
                for(int[] d : dir){
                    int r = sr + d[0], c = sc + d[1];
                    while(r >= 0 && c >= 0 && r < dp.length && c < dp[0].length){
                        count += dp[r][c]; // mazePathJumps_memo(r, c, er, ec, dp, dir);
                        r += d[0];
                        c += d[1];
                    }
                }
        
                dp[sr][sc] = count;
            }
        }
        
        return dp[SR][SC];
    }

    
    
    public static void mazePath(){
        // sr -> source row, er -> ending row
        // sc -> source column, ec -> ending column
        int sr = 0, sc = 0, er = 2, ec = 2;
        int[][] dp = new int[er + 1][ec + 1]; // (0, 0) se (2, 2) kaa sara indexes use karna hai tho er + 1 & ec + 1 size ki dp bana gii

        // direction array
        int[][] dir = { { 1, 0}, { 1, 1}, { 0, 1 } }; // direction array when we are moving from (0, 0) to (2, 2)
        int[][] dir_02 = { { -1, 0}, { 0, -1}, { -1, -1 } };  // direction array when we are moving from (2, 2) to (0, 0) 
        
        // ----------- MAZE PATH WITH 1 JUMP ------------------
        // System.out.println(mazePath_memo_01(sr, sc, er, ec, dp, dir) ); //  (0, 0) to (2, 2) ki call vali recursion
        // System.out.println(mazePath_memo_02(sr, sc, er, ec, dp, dir_02) ); // (2, 2) to (0, 0) ki call vali recursion
        // System.out.println(mazePath_tabu_01(sr, sc, er, ec, dp, dir) ); // (2, 2) to (0, 0) ki call lag rahi hai idar
        // System.out.println(mazePath_tabu_02(sr, sc, er, ec, dp, dir_02) ); // (2, 2) to (0, 0) ki call lag rahi hai idar

        // ----------- MAZE PATH WITH INFINITE JUMP ------------------
        // 3 X 3 matrix kaa lia -> 188 answers honga total
        // System.out.println(mazePathJumps_memo(sr, sc, er, ec, dp, dir));
        System.out.println(mazePathJumps_tabu(sr, sc, er, ec, dp, dir));

        display2D(dp);
    }

    // ----------------------------------------------
    // leetcode 62. Unique Paths
     public static int mazePath_tabu_uniquePaths(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir){
        // sr & sc huma SR & SC tak chalana chahia for ower knowledge
        for(int sr = ER ; sr >= SR ; sr--){
            for(int sc = EC ; sc >= SC ; sc--){
                if(ER == sr && EC == sc){
                    dp[sr][sc] = 1;
                    continue;
                }
        
                int count = 0;
                for(int[] d : dir){
                    int r = sr + d[0], c = sc + d[1]; 
                    if(r >= 0 && c >= 0 && r < dp.length && c < dp[0].length){
                        count += dp[r][c]; // mazePath_memo(r, c, er, ec, dp, dir);
                    }
                }
                
                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC]; 
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        int[][] dir = {{ 0, 1 }, { 1, 0 }};
        
        return mazePath_tabu_uniquePaths(0, 0, m - 1, n - 1, dp, dir);
    }

    // --------------------------------------------------
    // leetcode 63. Unique Paths II
    public int mazePath_tabu_Obstacles(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir, int[][] obstacleGrid){
        for(int sr = ER ; sr >= SR ; sr--){
            for(int sc = EC ; sc >= SC ; sc--){
                if(ER == sr && EC == sc){
                    dp[sr][sc] = 1;
                    continue;
                }
                
                int count = 0;
                for(int[] d : dir){
                    int r = sr + d[0], c = sc + d[1];
                    if(r >= 0 && c >= 0 && r < dp.length && c < dp[0].length && obstacleGrid[r][c] == 0){
                        count += dp[r][c];
                    }
                }
                
                dp[sr][sc] = count;
            }
        }
        
        return dp[SR][SC];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        
        // jaha jana vala hai & jaha pucha gai woo jaga hi block hai tho return kar jao waha sa
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) // obstacleGrid[n - 1][m - 1] == 1 <= yaa vala case recursion mai handle ho raha hai
            return 0;
        
        int[][] dp = new int[n][m]; // n & m humara ik jada hi hi honga 'dp' kaa lia joo hona chahia
        
        
        int[][] dir = {{0, 1}, {1, 0}};
        
        return mazePath_tabu_Obstacles(0, 0, n - 1, m - 1, dp, dir, obstacleGrid);
    }

    // -------------------------------------------------------
    // leetcode 70. Clibing Stairs
    public int climbStairs_Memo(int n, int[] dp){
        if(n <= 1)
            return dp[n] = 1;

        if(dp[n] != 0)  
            return dp[n];
 
        int ans = climbStairs_Memo(n - 1, dp) + climbStairs_Memo(n - 2, dp);
        return dp[n] = ans;
    }
    
     public int climbStairs_tabu(int N, int[] dp){
         for(int n = 0 ; n <= N ; n++){
             if(n <= 1){
                dp[n] = 1;
                continue;
             }
             
            int ans = dp[n - 1] + dp[n - 2]; // climbStairs_tabu(n - 1, dp) + climbStairs_tabu(n - 2, dp);
            dp[n] = ans;
         }
         
        return dp[N];
    }
    
    public int climbStairs_opti(int n){
        int a = 1, b = 1;
        for(int i = 2 ; i <= n ; i++){
            int sum = a + b;
            a = b;
            b = sum;
        }
        
        return b;
    }
    
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        
        // return climbStairs_Memo(n, dp);
        // return climbStairs_tabu(n, dp);
        return climbStairs_opti(n);
    }

    // ------------------------------------------------------
    // leetcode 746. Min Cost Climbing Stairs
    


    // Board Path. =========================================



    public static void main(String[] args){
        // fibo();
        mazePath();
    }
}

// javac l001_twoPointerSet.java && java l001_twoPointerSet > output.txt
