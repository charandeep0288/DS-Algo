public class l002_stringSet {
    
    // 115


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
