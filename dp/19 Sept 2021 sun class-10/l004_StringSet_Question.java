public class l004_StringSet_Question {

    // -------------------------------------------------------
    // https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
    // https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
    public static int mcm_memo(int[] arr, int si, int ei, int[][] dp){
        if(ei - si == 1){
            return dp[si][ei] = 0;
        }

        if(dp[si][ei] != 0)
            return dp[si][ei];

        int minRes = (int)1e9;
        // yaa cut -> si + 1 se less than ei tak chala gaa
        for(int cut = si + 1 ; cut < ei ; cut++){
            int leftRes = mcm_memo(arr, si, cut, dp);
            int rightRes = mcm_memo(arr, cut, ei, dp);

            minRes = Math.min(minRes, leftRes + arr[si] * arr[cut] * arr[ei] + rightRes);
        }

        return dp[si][ei] = minRes;
    }
    
    public static int mcm_DP(int[] arr, int SI, int EI, int[][] dp){
        int n = arr.length;
        String[][] sdp = new String[n][n]; // String dp

        for(int gap = 1 ; gap < n ; gap++){
            for(int si = 0, ei = gap ; ei < n ; si++, ei++){
                if(ei - si == 1){
                    dp[si][ei] = 0;
                    continue;
                }
        
                int minRes = (int)1e9;
                String minStr = "";
                // yaa cut -> si + 1 se less than ei tak chala gaa
                for(int cut = si + 1 ; cut < ei ; cut++){
                    int leftRes = dp[si][cut]; // mcm_memo(arr, si, cut, dp);
                    int rightRes = dp[cut][ei]; // mcm_memo(arr, cut, ei, dp);
        
                    if(leftRes + arr[si] * arr[cut] * arr[ei] + rightRes < minRes){
                        minRes = leftRes + (arr[si] * arr[cut] * arr[ei]) + rightRes;
                        minStr = "(" + sdp[si][cut] + sdp[cut][ei] + ")"; 
                    }
                }
        
                dp[si][ei] = minRes;
                sdp[si][ei] = minStr;
            }
        }

        System.out.println(sdp[SI][EI]);
        return dp[SI][EI];
    }

    public static void mcm(){
        int[] arr = { 40, 20, 30, 10, 30};
        int n = arr.length;
        int[][] dp = new int[n][n];

        System.out.println(mcm_memo(arr, 0, n - 1, dp));
        System.out.println(mcm_DP(arr, 0, n - 1, dp));
    }

    
    
    // ---------------------------------------------------------
    // https://www.geeksforgeeks.org/minimum-maximum-values-expression/
    public static class pairmm{ // pair minimum maximum
        int min = (int) 1e9;
        int max = 0; // max ko zero laa sakta hai -> koi ki Question mai sirf +ve numbers mai hoo sakta hai input mai
        
        pairmm(){

        }

        pairmm(int val) {
            this.max = this.min = val;
        }
    }

    public static pairmm evaluateMinMax(pairmm leftRes, pairmm rightRes, char operator){
        pairmm pair = new pairmm();
        if(operator == '+'){
            pair.min = leftRes.min + rightRes.min;
            pair.max = leftRes.max + rightRes.max;
        } else if(operator == '*'){
            pair.min = leftRes.min * rightRes.min;
            pair.max = leftRes.max * rightRes.max; 
        }

        return pair;
    }

    public static pairmm minMax(String str, int si, int ei, pairmm[][] dp){
        if(si == ei){
            return dp[si][ei] = new pairmm((str.charAt(si) - '0'));
        }

        if(dp[si][ei] != null)
            return dp[si][ei];

        pairmm myRes = new pairmm();
        // iss Question mai hum cut si + 1 ---se--> ei tak jai gaa
        for(int cut = si + 1; cut < ei; cut += 2){
            pairmm leftRes = minMax(str, si, cut - 1, dp);
            pairmm rightRes = minMax(str, cut + 1, ei, dp);
            pairmm  pair = evaluateMinMax(leftRes, rightRes, str.charAt(cut));

            myRes.min = Math.min(myRes.min, pair.min);
            myRes.max = Math.max(myRes.min, pair.max);
        }

        return dp[si][ei] = myRes;
    }
    
    public static void minMax(){
        String str = "1+2*3+4*5";
        int n = str.length();
        pairmm[][] dp = new pairmm[n][n];

        pairmm res = minMax(str, 0, n, dp);

        System.out.println("Min value: " + res.min);
        System.out.println("Max value: " + res.max);
    }
    
    // ---------------------------------------------------------
    // https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1

    // (HW) --------------------------------------------------
    // leetcode 312 ( AMAZON )

    public static void main(String[] args){
        mcm();
    }
}
