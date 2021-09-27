public class l005_CutSet {
    
    // ---------------------------------------------------------
    // leetcode 312. Burst Ballon
    public int maxCoins(int[] nums, int si, int ei, int[][] dp){
        if(dp[si][ei] != 0)
            return dp[si][ei];

        int lele = si == 0 ? 1 : nums[si - 1];
        int rele = ei == nums.length - 1 ? 1 : nums[ei + 1];

        int maxCoins = 0;
        for(int cut = si ; cut <= ei ; cut++){
            int lcost = cut == si ? 0 : maxCoins(nums, si, cut - 1, dp);
            int rcost = cut == ei ? 0 : maxCoins(nums, cut + 1, ei, dp);

            maxCoins = Math.max(maxCoins, lcost + lele * nums[cut] * rele + rcost);
        }

        return dp[si][ei] = maxCoins;
    }

    public int maxCoins(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];

        return maxCoins(nums, 0, n - 1, dp);
    }

    // ------------------------------------------------------
    // https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
    public static class pairBoolean {
        long totalTrue = 0;
        long totalFalse = 0;

        pairBoolean(long totalTrue, long totalFalse) {
            this.totalFalse = totalFalse;
            this.totalTrue = totalTrue;
        }

        pairBoolean() {

        }
    }

   public static void evaluateTrue(pairBoolean left, pairBoolean right, pairBoolean res, char operator) {
        long mod = 1003;
        long totalTF = ((left.totalTrue + left.totalFalse) * (right.totalTrue + right.totalFalse)) % mod; // totalTF
        long totalTrue = 0, totalFalse = 0;

        if(operator == '|'){
            totalFalse = (left.totalFalse * right.totalFalse) %  mod;
            totalTrue = (totalTF - totalFalse + mod) % mod;
        } else if(operator == '^'){
            totalTrue = (left.totalFalse * right.totalTrue) % mod + (left.totalTrue * right.totalFalse) % mod;
            totalFalse = (totalTF - totalTrue + mod) % mod;
        } else if(operator == '&'){
            totalTrue = (left.totalTrue * right.totalTrue) % mod;
            totalFalse = (totalTF - totalTrue + mod) % mod;
        }

        res.totalFalse = (res.totalFalse + totalFalse) % mod;
        res.totalTrue = (res.totalTrue + totalTrue) % mod;
    }

    public static pairBoolean countWays(String S, int si, int ei, pairBoolean[][] dp){
        if(si == ei){
            char ch = S.charAt(si);
            int t = ch == 'T' ? 1 : 0;
            int f = ch == 'F' ? 1 : 0;

            return dp[si][ei] = new pairBoolean(t, f);
        }

        if(dp[si][ei] != null){
            return dp[si][ei];
        }

        pairBoolean res = new pairBoolean();
        for(int cut = si + 1 ; cut < ei ; cut += 2){
            pairBoolean lres = countWays(S, si, cut - 1, dp);
            pairBoolean rres = countWays(S, cut + 1, ei, dp);

            evaluateTrue(lres, rres, res, S.charAt(cut));
        }

        return dp[si][ei] = res;
    }

    public static int countWays(int N, String S) {
        pairBoolean[][] dp = new pairBoolean[N][N];
        
        return (int)countWays(S, 0, N - 1, dp).totalTrue;
    }

    // ------------------------------------------------------
    // https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
    // Optimal Binary Search Tree
    // 1st Solution 
    public static int obst(int[] val, int[] freq, int si, int ei, int[][] dp){
        if(dp[si][ei] != 0)
            return dp[si][ei];
        
        int minCost = (int)1e9;

        int sum = 0;

        for(int i = si ; i <= ei ; i++)
            sum += freq[i];

        for(int cut = si ; cut <= ei ; cut++){
            int lres = cut == si ? 0 : obst(val, freq, si, cut - 1, dp);
            int rres = cut == ei ? 0 : obst(val, freq, cut + 1, ei, dp);
            // sum += freq[cut];
            minCost = Math.min(minCost, lres + sum + rres); // sum : sumOfRange(freq, si, ei);
        }

        return dp[si][ei] = minCost; // minCost + sum
    }

    // 2nd solution 
    public static int obst_02(int[] val, int[] freq, int si, int ei, int[][] dp){
        if(dp[si][ei] != 0)
            return dp[si][ei];
        
        int minCost = (int)1e9;

        int sum = 0;
        for(int cut = si ; cut <= ei ; cut++){
            int lres = cut == si ? 0 : obst_02(val, freq, si, cut - 1, dp);
            int rres = cut == ei ? 0 : obst_02(val, freq, cut + 1, ei, dp);
            sum += freq[cut];
            minCost = Math.min(minCost, lres + (0) + rres); // sum : sumOfRange(freq, si, ei);
        }

        return dp[si][ei] = minCost + sum;
    }


}
