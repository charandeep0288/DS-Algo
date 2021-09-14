import java.util.Arrays;

public class l002_stringSet {

    // ---------------------------------------------------
    // leetcode 516. Longest Palindromic Subsequence
    // memorization
    // lpss -> longest palindromic subsequence
    public static int lpss(String s, int i, int j, int[][] dp) {
        if (i >= j)
            return dp[i][j] = (i == j ? 1 : 0);

        if (dp[i][j] != 0)
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) // agar characters equal hai tho kara gai
            return dp[i][j] = lpss(s, i + 1, j - 1, dp) + 2;
        else // agar characters unequal hai tho kya kara gai
            return dp[i][j] = Math.max(lpss(s, i + 1, j, dp), lpss(s, i, j - 1, dp));
    }

    // tabulation
    public static int lpss_DP(String s, int I, int J, int[][] dp){
        int n = s.length();
        for(int gap = 0 ; gap < n ; gap++){
            for(int i = 0, j = gap ; j < n ; i++, j++){
                if(i >= j){
                    dp[i][j] = (i == j ? 1 : 0);
                }

                if(s.charAt(i) == s.charAt(j)) // agar characters equal hai tho kara gai
                    dp[i][j] = dp[i + 1][j - 1] + 2; // lpss(s, i + 1, j - 1, dp) + 2; 
                else // agar characters unequal hai tho kya kara gai
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // Math.max(lpss(s, i + 1, j, dp), lpss(s, i, j - 1, dp));
            }
        }
        
        return dp[I][J];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // int ans = lpss(s, 0, n - 1, dp); // memorization
        int ans = lpss_DP(s, 0, n - 1, dp); // tabulation

        return ans;
    }

   // ---------------------------------------------------------
    // leetcode 1146. Longest Common Subsequence
    // NOTE :- STRING KA HAR QUESTION MAI ABB SA PALINDROME KA ALAWA WALA MAI ULTA HI KAM KARA GAI n & m saa
    // lcss -> longest common substring
    // memorization
    public static int lcss(String str1, String str2, int n, int m, int[][] dp){
        if(n == 0 || m == 0){ // m & n mai sa koi bhi zero ho jai, yaa fir dono ik sath hi zero ho jai tho return 0 kar doo
            return dp[n][m] = 0;
        }

        if(dp[n][m] != -1) // 0 humara answer kaa part hoo sakta hai(jab dono mai saa koi bhi string kahli hoo jai tab) iss lai hum 'dp' ko -1 sa fill kar raha hai & -1 ka check laga raha hai
            return dp[n][m];

        if(str1.charAt(n - 1) == str2.charAt(m - 1))
            dp[n][m] = lcss(str1, str2, n - 1, m - 1, dp) + 1; // +1 iss lia kio ki huma ik character same mil gya hai uska name kaa
        else 
            dp[n][m] = Math.max(lcss(str1, str2, n - 1, m, dp), lcss(str1, str2, n, m - 1, dp));

    }

     // tabulation
     public static int lcss_dp(String str1, String str2, int N, int M, int[][] dp){
        for(int n = 0 ; n <= N ; n++){
            for(int m = 0 ; m <= M ; m++){
                if(n == 0 || m == 0){ // m & n mai sa koi bhi zero ho jai, yaa fir dono ik sath hi zero ho jai tho return 0 kar doo
                    dp[n][m] = 0;
                    continue;
                }
        
                if(str1.charAt(n - 1) == str2.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + 1; // lcss(str1, str2, n - 1, m - 1, dp) + 1; // +1 iss lia kio ki huma ik character same mil gya hai uska name kaa
                else 
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]); // Math.max(lcss(str1, str2, n - 1, m, dp), lcss(str1, str2, n, m - 1, dp));
            }
        }
        
        return dp[N][M]; // N & M saa jawab manga hai fn mai, tho usi pai hi muja javab mila gaa final
    }


    public int longestCommonSubsequence(String text1, String text2){
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1]; // 'dp' n + 1 & m + 1 size ki bana gi kioki hum n & m ko as a index use kar raha hai
        
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        // int ans = lcss(text1, text2, n, m, dp); // memorization
        int ans = lcss_dp(text1, text2, n, m, dp); // tabulation

        return ans;
    }


    // HomeWork ->
    // 72

    public static void main(String[] args) {

    }
}

// javac