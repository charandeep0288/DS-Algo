import java.util.Arrays;

public class l004_stringSet {

    public static void diplay(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele);
        }
    }

    public static void display2D(int[][] arr) {
        for (int[] d : arr) {
            display(d);
            System.out.println();
        }
    }

    // ------------------------------------------------
    // memorization
    public static int permutation(int[] arr, int tar, int[] dp) {
        if (dp[tar] == 0)
            return dp[tar] = 1;

        if (dp[tar] != -1) // 0 ans kaa part ban sakta hai humara
            return dp[tar];

        int count = 0;
        for (int ele : arr) {
            if (tar - ele >= 0)
                count += permutation(arr, tar - ele, dp);
        }

        return dp[tar] = count;
    }

    // tabulation
    public static int permutation_DP(int[] arr, int Tar, int[] dp) {
        dp[0] = 1; // yaha pai
        for (int tar = 1; tar <= Tar; tar++) {
            // if (dp[tar] == 0) // yaa base case upar likh diya hai
            // return dp[tar] = 1;

            int count = 0;
            for (int ele : arr) {
                if (tar - ele >= 0)
                    count += dp[tar - ele]; // permutation(arr, tar - ele, dp);
            }

            dp[tar] = count;
        }

        return dp[Tar];
    }

    // ------------------------------------------------
    // memorizartion
    public static int combination(int[] arr, int n, int tar, int[][] dp) {
        if (tar == 0)
            return dp[n][m] = 1;

        if (dp[n][tar] != -1)
            return dp[n][tar];

        int count = 0;
        for (int i = n; i >= 0; i--) {
            if (tar - arr[i - 1] >= 0)
                count += combination(arr, i, tar - arr[i - 1], dp);
        }

        return dp[n][tar] = count;
    }

    // tabulation
    public static int combination_DP(int[] arr, int Tar, int[] dp) {
        dp[0] = 1;
        for (int ele : arr) {
            for (int tar = ele; tar <= Tar; tar++) {
                if (tar - ele >= 0)
                    dp[tar] += dp[tar - ele];
            }
        }

        return dp[Tar];
    }

    public static void fill(int[] dp) {
        Arrays.fill(dp, -1);
    }

    public static void fill2D(int[][] dp) {
        for (int[] d : dp)
            fill(d);
    }

    public static void target() {
        int[] arr = { 2, 3, 5, 7 };
        int tar = 10;
        // int[] dp = new int[tar + 1];
        // fill(dp);

        int[][] dp = new int[arr.length + 1][tar + 1];
        fill2D(dp);

        // System.out.println(permutation(arr, tar, dp));
        System.out.println(combination(arr, arr.length, tar, dp));

        display(dp);
        display2D(dp);
    }

    // -------------------------------------------------
    // leetcode 377. Combination Sum II
    // dp solution
    public int combinationSum4(int[] arr, int Tar) {
        int[] dp = new int[Tar + 1];
        dp[0] = 1; // yaha pai
        for (int tar = 1; tar <= Tar; tar++) {
            // if (dp[tar] == 0) // yaa base case upar likh diya hai
            // return dp[tar] = 1;

            int count = 0;
            for (int ele : arr) {
                if (tar - ele >= 0)
                    count += dp[tar - ele]; // permutation(arr, tar - ele, dp);
            }

            dp[tar] = count;
        }

        return dp[Tar];
    }

    // ------------------------------------------------------
    // leetcode 322.
    public int coinChange(int[] arr, int Tar) {
        int[] dp = new int[Tar + 1];
        Arrays.fill(dp, (int) 1e9);

        dp[0] = 0; // recursion kaa base case for loop sa hata kai yaha likh dia
        for (int tar = 1; tar <= Tar; tar++) {
            for (int ele : arr) {
                if (tar - ele >= 0)
                    dp[tar] = Math.min(dp[tar - ele] + 1, dp[tar]);
            }
        }

        return dp[Tar] != (int) 1e9 ? dp[Tar] : -1;
    }

    // ---------------------------------------------------------
    // https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&page=4&query=category[]Dynamic%20Programmingpage4category[]Dynamic%20Programming
    // -1 : not explored, 0 : false, 1 : true
    // memorization
    public static int targetSum(int[] arr, int n, int tar, int[][] dp) {
        if (n == 0 || tar == 0) {
            return dp[n][tar] = (tar == 0 ? 1 : 0);
        }

        if (dp[n][tar] != -1)
            return dp[n][tar];

        boolean res = false;
        if (tar - arr[n - 1] >= 0)
            res = res || targetSum(arr, n - 1, tar - arr[n - 1], dp) == 1;
        res = res || targetSum(arr, n - 1, tar, dp) == 1;

        return dp[n][tar] = (res ? 1 : 0);
    }

    public static Boolean isSubsetSum(int N, int[] arr, int sum) {
        int[][] dp = new int[N + 1][sum + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int ans = targetSum(arr, N, sum, dp);

        // display2D(dp);
        return ans == 1;
    }

    // ==================================================
    // tabulation for backEnginnering (because memorizatoin mai kuch state asi bhi hongi joo kabhi visit nahi hui hongi tho ans sahi nahi aa pai gaa)
    public static boolean targetSum_DP(int[] arr, int N, int Tar, boolaen[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int tar = 0; tar <= Tar; tar++) {
                if (n == 0 || tar == 0) {
                    dp[n][tar] = (tar == 0 ? 1 : 0);
                    continue;
                }

                if (tar - arr[n - 1] >= 0)
                    dp[n][tar] = dp[n][tar] || dp[n - 1][tar - arr[n - 1]]; // targetSum(arr, n - 1, tar - arr[n - 1], dp) == 1;
                dp[n][tar] = dp[n][tar] || dp[n - 1][tar]; // targetSum(arr, n - 1, tar, dp) == 1;
            }
        }

        return dp[N][Tar];
    }

    //back Engineering
    public static int targetSum_path(int[] arr, int N, boolean[][] dp, int tar, String psf){ // psf -> path soo far


    }

    // -------------------------------------------------
    // 0/1 Knapsack Problem -> subsequence vala method se karta hai yaa
    // O(n * W)
    public static int KnapSack(int W, int wt[], int val, int n, int[][] dp) {
        if (n == 0 || W == 0) {
            return dp[n][W] = 0;
        }

        if (dp[n][W] != -1)
            return dp[n][W];

        int maxAns = 0;
        if (W - wt[n - 1] >= 0)
            maxAns = Math.max(maxAns, KnapSack(W - wt[n - 1], wt, val, n - 1, dp) + val[n - 1]);
        maxAns = Math.max(maxAns, KnapSack(W - wt[n - 1], wt, val, n - 1, dp) + val[n - 1]);

        return dp[n][W] = maxAns;
    }

    public static int KnapSack(int W, int wt[], int val[], int N) {
        int[][] dp = new int[N + 1][M + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return knapSack(W, wt, val, N, dp);
    }

    public static void main(String[] args) {
        target();
    }

}
