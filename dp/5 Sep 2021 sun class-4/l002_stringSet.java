public class l002_stringSet {
    
    // ----------------------------------------
    // leetcode 115.  Distinct Subsequences
    // memorization
    public int numDistinct_memo(String s, String t, int n, int m, int[][] dp){
        if(m == 0){ // jis string ko dhund raha hai & agar uska size 0 ho jai tho matlab ik ans mil gya hai
            return dp[n][m] = 1;
        }

        if(n < m){ // jis string mai data dund raha hai agar uska size jiss string ko dund raha usa kam ho gya tho ans kabi nahi mila gaa huma, tho return 0; 
            return dp[n][m] = 0;
        }

        if(dp[n][m] != -1) // 0 ans kaa part ban raha hai tho, -1 kaa check lagya gai
            return dp[n][m];

        int a = numDistinct_memo(s, t, n - 1, m - 1, dp); 
        int b = numDistinct_memo(s, t, n - 1, m, dp);

        if(s.charAt(n - 1) == t.charAt(m - 1))
            return dp[n][m] = a + b; // dono characters equal hai tho a & b vali dono calls laga gii
        else
            return dp[n][m] = b;
    }

    // tabulation
    public int numDistinct_DP(String s, String t, int N, int M, int[][] dp){
        for(int n = 0 ; n <= N ; n++){
            for(int m = 0 ; m <= M ; m++){
                if(m == 0){ // jis string ko dhund raha hai & agar uska size 0 ho jai tho matlab ik ans mil gya hai
                    dp[n][m] = 1;
                    continue;
                }
        
                if(n < m){ // jis string mai data dund raha hai agar uska size jiss string ko dund raha usa kam ho gya tho ans kabi nahi mila gaa huma, tho return 0; 
                    dp[n][m] = 0;
                    continue;
                }
        
                int a = dp[n - 1][m - 1]; // numDistinct_memo(s, t, n - 1, m - 1, dp); 
                int b = dp[n - 1][m]; // numDistinct_memo(s, t, n - 1, m, dp);
        
                if(s.charAt(n - 1) == t.charAt(m - 1))
                    dp[n][m] = a + b; // dono characters equal hai tho a & b vali dono calls laga gii
                else
                    dp[n][m] = b;
            }
        }
        
        return dp[N][M]; // jaha sa ans manga hai yaha pai hi final ans mila gaa 
    }

    public int numDistinct(String s, String t){
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        // int ans = numDistinct_memo(s, t, n, m, dp); // memorization
        int ans = numDistinct_DP(s, t, n, m, dp); // tabulation

        return ans;
    }

    // ------------------------------------------------------
    // leetcode 72 (HW of last class)
    public int minDistance(String word1, String word2, int n, int m, int[][] dp){
        if(n == 0 || m == 0) {
            return dp[n][m] = (n == 0 ? m : n); // tino cases handle hoo raha hai humara 
        }

        if(dp[n][m] != -1)
            return dp[n][m];

        int insert = minDistance(word1, word2, n, m - 1, dp);
        int delete = minDistance(word1, word2, n - 1, m, dp);
        int replace = minDistance(word1, word2, n - 1, m - 1, dp);

        if(word1.charAt(n - 1) == word2.charAt(m - 1))
            return dp[n][m] = replace;
        else
            return dp[n][m] = Math.min(Math.min(insert, delete), replace) + 1;
    }

    public int minDistance(String s, String t){
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int d : dp)
            Arrays.fill(d, -1);

        int ans = minDistance(s, t, n, m, dp);

        return ans;
    }

    // leetcode 44.
    public int 

    public int isMatch(String s, String p, int n, int m, int[][] dp){
        if(n == 0 || m == 0){
            
        }

        if(dp[n][m] != -1)
            return dp[n][m];
        char ch1 = s.charAt(n - 1);
        char ch2 = p.charAt(n - 1);

        if(ch1 == ch2 || ch == '?'){

        } else if(ch2 == '*'){

        } else {

        }

    }
}
