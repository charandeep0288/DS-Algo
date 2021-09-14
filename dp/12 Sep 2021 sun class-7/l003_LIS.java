public class l003_LIS {
    
    // leetcode 300
    // LIS -> Longest Increasing Subsequence
    // memorization
    public static int LIS_memo(int[] arr, int ei, int[] dp){
        if(dp[ei] != 0)
            return dp[ei];

        int maxLen = 1; // ik array ka element bhi apna aap mai ik lis hai
        for(int i = ei - 1 ; i >= 0 ; i--){
            if(arr[i] < arr[ei]){
                int recLen = LIS_memo(arr, i, dp);
                maxLen = Math.max(maxLen, recLen + 1);
            }
        }

        return dp[ei] = maxLen;
    }

     // tabulation
     public static int LIS_LR(int[] arr, int[] dp){
        int n = arr.length, maxLen = 0;
        for(int i = 0 ; i < n ; i++){
            dp[i] = 1;
            for(int j = i ; j >= 0 ; j--){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }

    public int lengthofLIS(int[] arr){
        // good test case
        // int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 11, 7, 15, 14 };
        int[] dp = new int[arr.length];
        
        // ----- for memorization ---------
        int maxLen = 0;
        for(int i = 0 ; i < arr.length ; i++){
            maxLen = Math.max(maxLen, LIS_memo(arr, i, dp));
        }

        return maxLen;

        // ------- for tabulation ---------
        // return LIS_LR(arr, dp);
    }

    // ------------------------------------------------------
    // https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
   
    public static int bitonicSequence(int[] arr){
        int n = arr.length, maxLen = 0;
        int[] LIS = new int[n];
        int[] LDS = new int[n];

        LIS_LR(arr, LIS);
        LIS_RL(arr, LDS);

        for(int i = 0 ; i < n ; i++){
            maxLen = Math.max(maxLen, LIS[i] + LDS[i] - 1);
        }

        return maxLen;
    }



    // https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1

    // https://practice.geeksforgeeks.org/problems/maximum-sum-bitonic-subsequence1857/1

    // minimnum deletion required to make array sorted.
    public static int minDeletion(int[] arr){

    }

    // leetcode - 673. 
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length, maxLen = 0, maxCount = 0;
        int[] dp = new int[n];
        
    }


    // https://www.geeksforgeeks.org/dynamic-programming-building-bridges/

}
