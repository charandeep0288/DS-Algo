import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class l001 {

    public static Scanner scr = new Scanner(System.in);

    // ---------------------------------------------------
    // Q1 Print Subsequence
    public static int subsequence(String ques, String ans, ArrayList<String> res) {
        if(ques.length() == 0) {
            System.out.println(ans);
            res.add(ans);
            return 1;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1); // rest of the question
        int count = 0;

        count += subsequence(roq, ans, res);
        count += subsequence(roq, ans + ch, res);

        return count;
    }

    // ---------------------------------------------------
    // Q2 Print KPC
    public static String[] nokiaKeys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static int nokiaKeyPad(String ques, String ans, ArrayList<String> res) {
        if(ques.length() == 0) {
            System.out.println(ans);
            res.add(ans);
            return 1;
        }

        char ch = ques.charAt(0);
        String word = nokiaKeys[ch - '0'];

        String roq = ques.substring(1);
        int count = 0;
        for(int i = 0 ; i < word.length() ; i++) {
            count += nokiaKeyPad(roq, ans + word.charAt(i), res);
        }

        return count;
    }


    public static int nokiaKayPad_01(String ques, String ans, ArrayList<String> res) {
        if(ques.length() == 0) {
            System.out.println(ans);
            res.add(ans);
            return 1;
        }

        char ch = ques.charAt(0);
        String word = nokiaKeys[ch - '0'];
        int count = 0;

        for(int i = 0 ; i < word.length() ; i++) 
            count += nokiaKayPad_01(ques.substring(1), ans + word.charAt(i), res);
        
        return count;
    }

    // ---------------------------------------------------
    // Q3 Stair Path
    public static int stairPath(int n, String ans) {
        if(n == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int jump = 1 ; jump <= 3 && (n - jump >= 0) ; jump++) {
            count += stairPath(n - jump, ans + jump);
        }

        return count;
    }

    public static int stairPath_01(int n, String ans) {
        if(n == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
            count += stairPath_01(n - jump, ans + jump);
        }

        return count;
     }

    // ---------------------------------------------------
    // Q4 Board Path
    public static int boardPath(int n, String ans) {
        if(n == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int dice = 1 ; dice <= 6 && (n - dice >= 0) ; dice++) {
            count += boardPath(n - dice, ans + dice);
        }

        return count;
    }   

    public static int boardPath_01(int si, int ei, String ans) {
        if(si == ei) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int dice = 1 ; dice <= 6 && (si + dice <= ei) ; dice++) {
            count += boardPath_01(si + dice, ei, ans + dice);
        }

        return count;
    }

    // ---------------------------------------------------
    // Q5 Board Path on Array
    public static int boardPathOnArray(int[] moves, int n, String ans) {
        if(n == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int jump : moves) {
            if(n - jump >= 0) {
                count += boardPathOnArray(moves, n - jump, ans + jump);
            }
        }

        return count;
    }

    // ---------------------------------------------------
    // Q6 Maze Path HDV
    public static int mazePathHDV(int sr, int sc, int dr, int dc, String ans) {
        if(sr == dr && sc == dc) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        if(sc + 1 <= dc) {
            count += mazePathHDV(sr, sc + 1, dr, dc, ans + "H");
        }

        if(sr + 1 <= dr && sc + 1 <= dc) {
            count += mazePathHDV(sr + 1, sc + 1, dr, dc, ans + "D");
        }
        if(sr + 1 <= dr) {
            count += mazePathHDV(sr + 1, sc, dr, dc, ans + "V");
        }

        return count;
    }

    // ---------------------------------------------------
    // Q7 Maze Path Multi HDV
    public static int mazePath_MultiHDV(int sr, int sc, int dr, int dc, String ans) {
        if(sr == dr && sc == dc) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        // horizontal
        for(int jump = 1 ; sc + jump <= dc; jump++) {
            count += mazePath_MultiHDV(sr, sc + jump, dr, dc, ans + "H" + jump);
        }

        // diagonal
        for(int jump = 1; sr + jump <= dr && sc + jump <= dc ; jump++) {
            count += mazePath_MultiHDV(sr + jump, sc + jump, dr, dc, ans + "D" + jump);
        }

        // vertical
        for(int jump = 1 ; sr + jump <= dr ; jump++) {
            count += mazePath_MultiHDV(sr + jump, sc, dr, dc, ans + "V" + jump);
        }

        return count;
    }

    // ---------------------------------------------------
    // Q8 Print Permutation with Duplicate
    public static int printPermutationWithDuplicate(String ques, String ans) {
        if(ques.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = 0 ; i < ques.length() ; i++ ) {
            String roq = ques.substring(0, i) + ques.substring(i + 1);
            char ch = ques.charAt(i);
            count += printPermutationWithDuplicate(roq, ans + ch);
        }

        return count;
    }

    // ---------------------------------------------------
    // Q9 Print Permutation Without Duplicate
    public static int printPermutationWithoutDuplicate(String ques, String ans) {
        if(ques.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        char prev = '$';
        for(int i = 0 ; i < ques.length() ; i++) {
            if(ques.charAt(i) != prev) {
                String roq = ques.substring(0, i) + ques.substring(i + 1);
                count += printPermutationWithDuplicate(roq, ans + ques.charAt(i));
            }
            prev = ques.charAt(i);
        }

        return count;
    }

    public static void printPermutationWithoutDuplicate(String str) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        
        for(int i = 0 ; i < str.length() ; i++)
            freq[str.charAt(i) - 'a']++;
        
        // O(n) => dono for loop ki time complexity 
        for(int i = 0 ; i < 26 ; i++) {
            for(int j = 0 ; j < freq[i] ; j++) {
                sb.append((char)(i + 'a')); // forcefully convert kia hai character mai
            }
        }

        System.out.println(printPermutationWithDuplicate(sb.toString(), "")); // O(n) -> sb.toString()
    }

    // ---------------------------------------------------
    // Q10 Print Encoding(Decoded Ways) 
    public static int decodedWays(String ques, String ans) {
        if(ques.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        char ch = ques.charAt(0);
        if(ch == '0') {
            return 0;
        }

        count += decodedWays(ques.substring(1), ans + (char)('a' + ch - '1'));
        if(ques.length() > 1) {
            int num = (ch - '0') * 10 + (ques.charAt(1) - '0');
            if(num <= 26) {
                count += decodedWays(ques.substring(2), ans + (char)('a' + num - 1));
            }
        }

        return count;
    }

    // ---------------------------------------------------
    // Q11 Leetcode-46 (Permutation)
    public static void permute(int[] nums, int count, List<Integer> ans, List<List<Integer>> res) {
        if(nums.length == count) {
            List<Integer> base = new ArrayList<>(ans);
            res.add(base);
        }

        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] > -11) {
                int val = nums[i];
                nums[i] = -11;
                ans.add(val);

                permute(nums, count + 1, ans, res);

                ans.remove(ans.size() - 1);
                nums[i] = val;
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        permute(nums, 0, ans, res);

        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> res = new ArrayList<>();

        // System.out.println(subsequence("abc", "", res));

        // System.out.println(nokiaKeyPad("679", "", res));

        // System.out.println("Total number of possible ans:- " + stairPath(5, ""));
        
        // System.out.println("Total number of possible ans:- " + boardPath(5, ""));
        // System.out.println("Total number of possible ans:- " + boardPath_01(0, 6, ""));

        // int[] moves = {1, 2, 3, 4, 5, 6};
        // System.out.println("Total number of possible ans:- " + boardPathOnArray(moves, 10, ""));

        // System.out.println((mazePathHDV(0, 0, 2, 2, "")));

        // System.out.println(mazePath_MultiHDV(0, 0, 2, 2, ""));

        // System.out.println("Total number of permutation possible with duplicate:- " + printPermutationWithDuplicate("abcdef", ""));

        // printPermutationWithoutDuplicate("aba");
        // decodedWays("112043", "");

        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
        

        System.out.println(res);
    }
}

// javac l001.java && java l001 > output.txt
// javap java.util.ArrayList -> to get all the funs of the class