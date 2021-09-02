public class l001twoPointerSet {

    // ----------------------------------------------------
    // leetcode 91. Decoded Ways
    // memorization
    public static int numDecodings(String s, int idx, int[] dp) {
        if (idx == s.length()) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];

        char ch1 = s.charAt(idx);
        if (ch1 == '0')
            return dp[idx] = 0;
        int count = numDecodings(s, idx + 1, dp);

        if (idx < s.length() - 1) {
            char ch2 = s.charAt(idx + 1);
            int num = (ch1 - '0') * 10 + (ch2 - '0');
            if (num <= 26)
                count += numDecodings(s, idx + 2, dp);
        }

        return dp[idx] = count;
    }

    // tabulation
    public static int numDecodings_DP(String s, int IDX, int[] dp) {

        for (int idx = s.length() - 1; idx >= 0; idx++) { // loop ulta chala gaa observation se pata laga hai
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }

            char ch1 = str.charAt(idx);
            if (ch1 == '0') {
                dp[idx] = 0;
                continue;
            }

            int count = dp[idx + 1]; // numDecodings(s, idx + 1, dp);

            if (idx < str.length() - 1) {
                char ch2 = s.charAt(idx + 1);
                int num = (ch1 - '0') * 10 + (ch2 - '0');
                if (num < 26)
                    count += dp[idx + 2]; // numDecodings(s, idx + 2, dp);
            }

            dp[idx] = count;
        }

        return dp[IDX]; // final ans huma first index hai mil raha hai (observation sa pata laga)
    }

    // optimization
    public static int numDecodings_opti(String s) {
        int a = 1, b = 0;
        for (int idx = s.length() - 1; idx >= 0; idx++) {
            char ch1 = s.charAt(idx);
            int sum = 0; // sum ko har bar 0 se intialize kar raha hai
            if (ch1 != '0') {
                sum += a;

                if (idx < s.length() - 1) {
                    char ch2 = s.charAt(idx + 1);
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if (num < 26)
                        sum += b;
                }
            }

            b = a;
            a = sum;
        }

        return a;
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = numDecodings(s, 0, dp);
        display(ans);
        return ans;
    }


    // ----------------------------------------------------
    // leetcode 639. Decoded Ways-II
    // memorization
    int mod = (int) 1e9 + 7; // mod ki value Question mai given hai
    public long numDecodings_02_memo(String s, int idx, long[] dp){
        int n = str.length();
        if(idx == n){
            return dp[idx] = -1;
        }

        if(dp[idx] != -1)
            return dp[idx];

        char ch1 = str.charAt(idx);
        if(ch1 == '0')
            return dp[idx] = 0;
        
        long count = 0;
        if(ch1 == '*'){ // first character '*' hai tho kya kara gai
            count = (count + 9 * numDecodings_02_memo(str, idx + 1, dp)) % mod; // ik charachter ki call
            if(idx < n - 1){ // ik se jada 2 characters ki call
                char ch2 = str.charAt(idx + 1);
                if(ch2 >= '0' && ch2 <= '6')
                    count = (count + 2 * numDecodings_02_memo(str, idx + 2, dp)) % mod;
                else if(ch2 >= '7' && ch2 <= '9')
                    count = (count + 1 * numDecodings_02_memo(str, idx + 2, dp)) % mod;
                else 
                count = (count + 15 * numDecodings_02_memo(str, idx + 2, dp)) % mod;

            }
        } else { // first character 'c' hai tho kya kara gai
            count = (count + 1 * numDecodings_02_memo(str, idx + 1, dp)) % mod; // ik charachter ki call
            if(idx < n - 1){
                char ch2 = str.charAt(idx + 1);
                if(ch2 == '*' && ch1 == '1')
                    count += (count + 9 * numDecodings_02_memo(str, idx + 2, dp)) % mod; 
                else if(ch2 == '*' && ch1 == '2')
                    count += (count + 6 * numDecodings_02_memo(str, idx + 2, dp)) % mod; 
                else if(ch2 != "*"){
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if(num <= 26) // yaa tho gaeante hai ki number 9 se badra hoga
                        count += (count + 1 * numDecodings_02_memo(str, idx + 2, dp)) % mod; 

                }
            }
        }

        return dp[idx] = count;
    }

    // tabulation

    // optimization


    public int numDecoding(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        long ans = numDecodings_02_memo(s, 0, dp); // pahala ans koo overflow hona kaa moka tho doo, then usa integer mai convert kara gai
        return (int) ans; // long value ko int mai convert kar dia
    }


    // ------------------------------------------------------
    // https://www.geeksforgeeks.org/gold-mine-problem/
    // memorization
    public static int goldMine(int[][] arr, int sr, int sc, int[][] dir, int[][] dp){
        
        int maxGold = 0;
        for(int[] d : dir){
            int r = sr + d[0];
            int c = sc + d[1];

            if(r >= 0 && c >= 0 && r < n && c < m){
                maxGold = Math.max(maxGold, goldMine(arr, r, c, dir, dp) + arr[sr][sc]);
            }
        }

        return dp[sr][sc];
    }

    public static void goldMine(){
        int[][] arr = { { 10, 33, 13, 15}, { 22, 21, 04, 1}, { 5, 0, 2, 3}, { 0, 6, 14, 2}};
        int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };
        int n = arr.length, m = arr[0].length;
        int[][] dp = new int[n][m];

        for(int[] d : dp)
            Arrays.fill(d, -1);

        int maxGold = 0;
        for(int r = 0 ; r < n ; r++){
            maxGold = Math.max(maxGold, goldMine(arr, r, 0, dir, dp));
        }

        System.out.println(maxGold);
    }


    // ----------------------------------------------------
    // Home work ->
    // https://www.geeksforgeeks.org/min-cost-path-dp-6/

    public static void main(String[] args){


        // numDecoding("*325");
    }
}