public class Questions {

    // ------------------------------------------------
    // https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1
    int mod = (int)1e9 + 7;
    // memorization
    public long countFriendsPairings(int n, long[] dp){

        long single = countFriendsPairings(n - 1, dp);
        long pairUp = n - 2 >= 0 ? countFriendsPairings(n - 2, dp) : 0;

        return dp[n] = (single + pairUp % mod) % mod;
    }

    public long countFriendsPairings(int n){
        if(n == 0)  return 0;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        return countFriendsPairings(n, dp);
    }

    // FORMULA ==> (a + b) % c = ((a % c) + (b % c) % c);

    // optimization -> observation karna kaa baad aya hai yaa solution 
    public lonf countFriendsPairings_opti(int n) {
        long a = 1, b = 1;
        for( int i = 2 ; i <= n ; i++){
            long sum = b + (a * (i - 1)) % mod; // pahala (a * (i - 1)) iss value ko mod karka range mai lai, then usmai 'b' value add kar dii
            a = b;
            b = sum % mod; // abb joo 'b' value add ki hai uski vaja se value out of range hoo gai hogi dubara, isi lia 'sum' ko dubara 'mod'(integer ki max value) se mod kar diya -> value ko range mai lana ka lia 
        }
    }



    // -----------------------------------------------------
    // 
    public static int divideInKGroup(int n, int k, int[][] dp){
        

        int selfGroup = divideInKGroup(n - 1, k - 1, dp); // mai leader banu gaa
        int partOfGroup = divideInKGroup(n - 1, k, dp);
    }

    // tabulation
    public static int divideInKGroup_DP(int N, int K, int[][] dp){
        for(int n = 1 ; n <= N ; n++){
            for(int  k= 0 ; k <= K ; k++){
                if(n == k || k == 1){
                    dp[n][k - 1] = 1;
                    continue;
                }

                int selfGroup = dp[n - 1][k - 1];
                int partOfGroup = dp[n - 1][k - 1];

                dp[n][k] = selfGroup + partOfGroup;
            }
        }

        return dp[N][K];
    }

}
