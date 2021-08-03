import java.util.ArrayList;
import java.util.List;

public class l003_Recursion {

    // ======================================================
    // nCr Solutions

    // ----------------------------------------------------
    // asf -> answer soo far
    public static int infiPermuation(int[] coins, int target, String asf) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                count += infiPermuation(coins, target - coins[i], asf + coins[i] + " "); // asf + i
            }
        }

        return count;
    }

    // ----------------------------------------------------
    // asf -> answer soo far
    public static int infiCombination(int[] coins, int target, int idx, String asf) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                count += infiCombination(coins, target - coins[i], i, asf + coins[i] + " ");
            }
        }

        return count;
    }

    // ----------------------------------------------------
    // asf -> answer soo far
    public static int singleCombination(int[] coins, int target, int idx, String asf) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                count += singleCombination(coins, target - coins[i], i + 1, asf + coins[i] + " "); // to print coins value
                // count += singleCombination(coins, target - coins[i], i + 1, asf + i + " "); // to print indexes of the coins
            }
        }

        return count;
    }

    // ----------------------------------------------------
    // asf -> answer soo far
    // METHOD-1 -> without boolean visited array (changes done in that particular array for mark and unmark)
    public static int singlePermutation(int[] coins, int target, String asf){
        if(target == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for(int i = 0 ; i < coins.length ; i++){
            if(coins[i] > 0 && target - coins[i] >= 0){
                int val = coins[i]; // confusion naa hoo iss lia + positive coins[i] ko phala alag kar lia & isa hi use kara gai

                coins[i] = -coins[i]; // mark
                
                count += singlePermutation(coins, target - val, asf + val + " ");

                coins[i] = -coins[i]; // unmark
            }
        }

        return count;
    }

    // METHOD-2 -> with boolean visited array
    public static int singlePermutation(int[] coins, int target, String asf, boolean[] vis) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (!vis[i] && target - coins[i] >= 0) {
                vis[i] = true; // mark
                count += singlePermutation(coins, target - coins[i], asf + coins[i] + " ", vis);
                vis[i] = false; // unmark
            }
        }

        return count;
    }

    // ======================================================
    // SubSequence Solutions

    // ----------------------------------------------------
    public static int singleCombination_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += singleCombination_subseq(coins, tar - coins[idx], idx + 1 , asf + coins[idx] + " ");
        count += singleCombination_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    // ----------------------------------------------------
    public static int infiCombination_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += infiCombination_subseq(coins, tar - coins[idx], idx , asf + coins[idx] + " ");
        count += infiCombination_subseq(coins, tar, idx + 1, asf);
 
        return count;
    }

    // ----------------------------------------------------
    public static int infiPermutation_subseq(int[] coins, int tar,int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += infiPermutation_subseq(coins, tar - coins[idx], 0 , asf + coins[idx] + " ");
        count += infiPermutation_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    // ----------------------------------------------------
    public static int singlePermutation_subseq(int[] coins, int target, int idx, boolean[] vis, String asf){
        if (target == 0 || idx >= coins.length) {
            if (target == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (!vis[idx] && target - coins[idx] >= 0){
            vis[idx] = true; // mark
            count += singlePermutation_subseq(coins, target - coins[idx], 0, vis, asf + coins[idx] + " ");
            vis[idx] = false; // unmark
        }
        count += singlePermutation_subseq(coins, target, idx + 1, vis, asf);

        return count;
    }


    // HomeWork => leetcode numbers
    // 40
    // 216
    // 322
    // 77
    // 377
    // 51
    // 52


    public static void coinChange(){
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10; // target
        boolean[] vis = new boolean[coins.length]; // visited array
        String asf = ""; // answer soo far
        

        // this is for Queen Combination 1D -> call single combination with this coins array and target -> we will get 35 combination
        // int[] coins = { 1, 1, 1, 1, 1, 1, 1 }; // 7 boxes 
        // int tar = 4; // target
        // String asf = ""; // answer soo far

        // System.out.println(infiPermuation(coins, tar, asf));
        // System.out.println(infiCombination(coins, tar, 0, asf));
        // System.out.println(singleCombination(coins, tar, 0, asf));
        // System.out.println(singlePermutation(coins, tar, asf)); // without visited array 
        // System.out.println(singlePermutation(coins, tar, asf, vis)); // with visited array

        // System.out.println(singleCombination_subseq(coins, tar, 0, asf));
        // System.out.println(infiCombination_subseq(coins, tar, 0, asf));
        // System.out.println(infiPermutation_subseq(coins, tar, 0, asf));
        System.out.println(singlePermutation_subseq(coins, tar, 0, vis, asf)); // with visited array

    }

    // ------------------------------------------------------
    // leetcode-39
    public void combinationSum(int[] arr, int tar, int idx, List<List<Integer>> ans, List<Integer> smallAns ){
        if(tar == 0){
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base); // shallow copy
            return;
        }
        
        for(int i = idx ; i < arr.length ; i++){
            if(tar - arr[i] >= 0){
                smallAns.add(arr[i]);
                combinationSum(arr, tar - arr[i], i, ans, smallAns);
                smallAns.remove(smallAns.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        
        combinationSum(candidates, target, 0, ans, smallAns);
        return ans;
    }

    // HomeWork -> 
    // https://www.interviewbit.com/problems/subset/

    public static void main(String[] args) {
       coinChange();
    }

}

// javac l003_Recursion.java && java l003_Recursion > output.txt