public class l004_stringSet {
    

    // HW of last class ->
    // https://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/
    // https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

    public static int unbondedKnapsack(int[] wt, int val, int bagWeight){
        return 0;
    }

    // -------------------------------------------------
    // leetcode 416. 
    public boolean targetSum_DP(int[] arr, int N, int Tar, boolean[][] dp){
        for(int n = 0 ; n <= N ; n++){
            for(int tar = 0 ; tar <= Tar ; tar++){
                if(n == 0 || tar == 0){
                    dp[n][tar] = (tar == 0);
                    continue;
                }
                
                if(tar - arr[n - 1] >= 0)
                    dp[n][tar] = dp[n][tar] || dp[n - 1][tar - arr[n - 1]];
                dp[n][tar] = dp[n][tar] || dp[n - 1][tar];

            }
        }    
        
        return dp[N][Tar];
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums)
            sum += ele;
        
        if(sum % 2 != 0)
            return false;
        
        int tar = sum / 2, n = nums.length;
        boolean[][] dp = new boolean[n + 1][tar + 1];
        return targetSum_DP(nums, n, tar, dp);
    }

    // 494

    // 698

}
