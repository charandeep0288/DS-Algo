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

    public static int fibo_recursion(int n){
        if(n <= 1)
            return n;
        
        int recAns = fibo_recursion(n - 1) + fibo_recursion(n - 2);
        return recAns;
    }

    // yaa recursion huma kabhi Time complexity nahi batati 
    public static int fibo_memo(int n, int[] dp) {
        if(n <= 1)
            return dp[n] = n;

        if(dp[n] != 0)
            return dp[n];

        int ans = fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
        return dp[n] = ans; // last mai ans return karta  hua dp[n] mai ans store bhi kara gai
    }

    // --------------------------------------
    // tabulation vala method mai ->
    // return ki jaga continue

    // yaa huma time complexity bata dai gii 
    // T : O(n), S : O(n)
    public static int fibo_tabu(int N, int[] dp){
        // fn argument mai 'n' ki jaga 'N' aya jai gaa taki fn ka andar 'n' as a vaiable use kar pai
        for(int n = 0 ; n <= N ; n++){
            if(n <= 1){
                dp[n] = n; 
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];
            dp[n] = ans;
        }
        return dp[N];
    }

    // yaa bhi huma time complexity bata dai gaa
    // T : O(n), S : O(1)
    public static int fibo_opti(int N){
        int a = 0, b = 1;
        for(int i = 2 ; i <= N ; i++){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void fibo(){
        int n = 5;
        int[] dp = new int[n + 1];

        System.out.println(fibo_recursion(n));
        System.out.println(fibo_memo(n, dp));
        System.out.println(fibo_tabu(n, dp));
        System.out.println(fibo_opti(n));
    }

    // ---------------------------------------
    // Maze Path
    public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] dp, int[][] dir){
        if(er == sr && ec == sc){
            return dp[sr][sc] = 1;
        }

        if(dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for(int[] d : dir){
            int r = sr + d[0], c = sr + d[1]; // yaa add karna jaruri hai next recursion call lagana se phala kio ki infinite call lag jai gii nahi tho 
            if(r >= 0 && c >= 0 && r < dp.length && c < dp.length){
                count += mazePath_memo(r, c, er, ec, dp, dir);
            }
        }

        return dp[sr][sc] = count;
    }

    public static int mazePath_tabu(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir){
        // sr & sc huma SR & SC tak chalana chahia for ower knowledge
        for(int sr = ER ; sr >= SR ; sr--){
            for(int sc = EC ; sc >= SC ; sc--){
                if(ER == sr && EC == sc){
                    dp[sr][sc] = 1;
                    continue;
                }
        
                int count = 0;
                for(int[] d : dir){
                    int r = sr + d[0], c = sr + d[1]; 
                    if(r >= 0 && c >= 0 && r < dp.length && c < dp.length){
                        count += dp[r][c]; // mazePath_memo(r, c, er, ec, dp, dir);
                    }
                }
                
                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    public static void mazePath(){
        int sr = 0, sc = 0, er = 3, ec = 3;
        int[][] dp = new int[er + 1][ec + 1];

        int[][] dir = { { 1, 0}, { 0, 1}, { 1, 1 } };
        System.out.println(mazePath_memo(sr, sc, er, ec, dp, dir) );

        display2D(dp);
    }

    // leetcode 62, 63


    // leetcode 70
    // leetcode 746


    // Board Path. =========================================



    public static void main(String[] args){
    }
}

// javac l001_twoPointerSet.java && java l001_twoPointerSet > output.txt
