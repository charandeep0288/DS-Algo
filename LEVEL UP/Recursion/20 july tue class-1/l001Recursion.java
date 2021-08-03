import java.util.Scanner;
import java.util.ArrayList;

public class l001Recursion {

    // -------------------------------------------------
    public static void pppppp(int a) {
        System.out.println("I am Base case: " + a);
        return; // yaa return likha yaa naa likha ik hi baat hai
    }

    public static void ppppp(int a) {
        System.out.println("hi" + a);
        pppppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void pppp(int a) {
        System.out.println("hi" + a);
        ppppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void ppp(int a) {
        System.out.println("hi" + a);
        pppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void pp(int a) {
        System.out.println("hi" + a);
        ppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void p(int a) {
        System.out.println("hi" + a);
        pp(a + 1);
        System.out.println("Bye: " + a);
    }

    // -------------------------------------------------
    public static void recursionPattern(int a, int b) {
        if (a == b) {
            System.out.println("I am Base Case: " + a);
            return;
        }

        System.out.println("Hi" + a);
        recursionPattern(a + 1, b);
        System.out.println("Bye" + a);
    }

    // -------------------------------------------------
    public static void printIncreasing(int a, int b) {
        if (a > b)
            return;

        System.out.println(a);
        printIncreasing(a + 1, b);
    }

    // -------------------------------------------------
    public static void printDecreasing(int a, int b) {
        if (a > b)
            return;

        printDecreasing(a + 1, b);
        System.out.println(a);
    }

    // -------------------------------------------------
    public static void printIncreasingDecreasing(int a, int b) {
        if (a > b)
            return;

        System.out.println(a);
        printIncreasingDecreasing(a + 1, b);
        System.out.println(a);
    }

    // -------------------------------------------------
    public static void oddEven(int a, int b) {
        if (a > b)
            return;

        if (a % 2 != 0)
            System.out.println(a);

        oddEven(a + 1, b);

        if (a % 2 == 0)
            System.out.println(a);
    }

    // -------------------------------------------------
    public static int factorial(int n) {
        if (n == 0)
            return 1;

        int fact = factorial(n - 1);

        return fact * n;
    }

    // better
    public static int factorial_01(int n) {
        if (n == 0)
            return 1;

        return factorial_01(n - 1) * n;
    }

    // -------------------------------------------------
    public static int power(int a, int b) {
        if (b == 0)
            return 1;

        int recAns = power(a, b - 1);
        return recAns * a;
    }

    // better
    public static int power_01(int a, int b) {
        if (b == 0)
            return 1;

        return power_01(a, b - 1) * a; 
    }

    // -------------------------------------------------
    // O(log n)
    public static int powerBtr(int a, int b) {
        if (b == 0)
            return 1;

        int recAns = powerBtr(a, b / 2);

        if (b % 2 != 0)
            return recAns * recAns * a;

        return recAns * recAns;
    }

    // better
    public static int powerBtr_01(int a, int b) {
        if (b == 0)
            return 1;

        int recAns = powerBtr_01(a, b / 2);
        recAns *= recAns;
        
        return b % 2 == 0 ? recAns : recAns * a;
    }

    // -------------------------------------------------
    // https://leetcode.com/problems/powx-n/
    private double myPow_(double x, int n){
        
        if( n == 0) return 1;        
        double recAns = myPow_(x,(int)(n/2));
        return ( n % 2 == 0 ? recAns * recAns : recAns * recAns * x);
            
    }
    
    public double myPow(double x, int n) {
        
        double ans =  myPow_(x,Math.abs(n));                           
        if(n < 0 ) return 1 / ans;   
        return ans;
        
    }

    // ============================================== 
    // RECURSION IN ARRAY  
    // ============================================== 

    // -------------------------------------------------
    public static void printArray(int[] arr, int idx) {
        if (idx >= arr.length)
            return;

        System.out.println(arr[idx]);
        printArray(arr, idx + 1);
    }

    // -------------------------------------------------
    public static void printArrayReverse(int[] arr, int idx) {
        if (idx >= arr.length)
            return;

        printArrayReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    // -------------------------------------------------
    public static int maximumInAnArray(int[] arr, int idx) {
        if (idx >= arr.length)
            return -(int) 1e9;

        int maxSoFar = maximumInAnArray(arr, idx + 1);
        if (arr[idx] > maxSoFar)
            maxSoFar = arr[idx];

        return maxSoFar;
    }

    // better
    public static int maximumInAnArray_01(int[] arr, int idx) {
        if (idx >= arr.length)
            return -(int) 1e9;

        int maxValue = maximumInAnArray_01(arr, idx + 1);

        return Math.max(maxValue, arr[idx]);
    }

    // -------------------------------------------------
    public static int minimumInAnArray(int[] arr, int idx) {
        if (idx >= arr.length)
            return (int) 1e9; // agar array ka size 0 hoga tho kia karo gai

        int minSoFar = minimumInAnArray(arr, idx + 1);
        if (arr[idx] < minSoFar)
            minSoFar = arr[idx];

        return minSoFar;
    }

    // better
    public static int minimumInAnArray_01(int[] arr, int idx) {
        if (idx >= arr.length)
            return (int) 1e9;

        int minValue = minimumInAnArray_01(arr, idx + 1);

        return Math.min(minValue, arr[idx]);
    }

    // -------------------------------------------------
    public static boolean find(int[] arr, int idx, int data) {
        if (idx >= arr.length)
            return false;

        boolean recAns = find(arr, idx + 1, data);
        if (!recAns && arr[idx] == data)
            recAns = true;

        return recAns;
    }

    public static boolean find_01(int[] arr, int idx, int data) {
        if (idx >= arr.length)
            return false;

        boolean recAns = find_01(arr, idx + 1, data);
        if (recAns)
            return recAns;

        return arr[idx] == data;
    }

    // better
    public static boolean find_02(int[] arr, int idx, int data) {
        if (idx >= arr.length)
            return false;

        return arr[idx] == data || find_02(arr, idx + 1, data);
    }

    // -------------------------------------------------
    public static int firstIndex(int[] arr, int idx, int data) {
        if (idx >= arr.length)
            return -1;

        if (arr[idx] == data)
            return idx;

        return firstIndex(arr, idx + 1, data);
    }

    // better
    public static int firstIndex_01(int[] arr, int idx, int data) {
        if (idx >= arr.length)
            return -1;

        return (arr[idx] == data) ? idx : firstIndex_01(arr, idx + 1, data);
    }

    // -------------------------------------------------
    public static int lastIndex(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return -1;

        int recAns = lastIndex(arr, idx + 1, data);
        if (recAns == -1 && arr[idx] == data)
            return idx;

        return recAns;
    }

    // better
    public static int lastIndex_01(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return -1;

        int recAns = lastIndex_01(arr, idx + 1, data);
        if (recAns != -1)
            return recAns;

        return arr[idx] == data ? idx : -1;
    }

    // -------------------------------------------------
    public static int[] allIndex(int[] arr, int idx, int data, int count){
        if(idx >= arr.length)
            return new int[count];

        if(arr[idx] == data)
            count++;

        int[] recArr = allIndex(arr, idx + 1, data, count);
        if(arr[idx] == data)
            recArr[count - 1] = idx; 

        return recArr;
    }
    

    // =============================================
    // RECURSION WITH ARRAYLIST
    // =============================================

    // -------------------------------------------------
    // top to bottom approach -> matlab upar se nicha ata hua ans create kar raha hai (will be used in DP(Dynamic Programing))
    public static ArrayList<String> subsequence(String str, int idx){
        if(idx >= str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }

        char ch = str.charAt(idx);

        ArrayList<String> recAns = subsequence(str, idx + 1);

        ArrayList<String> myAns = new ArrayList<>(recAns); // character add nahi hona chata hai ans mai

        for(String s : recAns)
            myAns.add(ch + s); // character add hona chata hai ans mai

        return myAns;
    }
    
    // -------------------------------------------------
    // bottom to top approach ( nicha se uper jata hua ans bana raha hai hum )
    // void type method
    // asf -> answer soo far
    public static int subsequence_01(String str, int idx, String asf, ArrayList<String> ans){
        if(idx >= str.length()){
            ans.add(asf); // base case mai huma ik ans mila hai 
            return 1; // matlab ik ans mil gia hai
        }

        int count = 0;
        count += subsequence_01(str, idx + 1, asf, ans);
        count += subsequence_01(str, idx + 1, asf + str.charAt(idx), ans);

        return count;
    }

    // -------------------------------------------------
    public static String[] nokiaKeys = {".,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> nokiaKeyPad(String str, int idx){
        if(idx >= str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }

        char ch = str.charAt(idx);
        String code = nokiaKeys[ch - '0'];

        ArrayList<String> recAns = nokiaKeyPad(str, idx + 1); // virtually string ko break kar raha hai

        ArrayList<String> myAns = new ArrayList<>();
        for(int i = 0 ; i < code.length() ; i++){
            for(String s : recAns){
                myAns.add(code.charAt(i) + s);
            }
        }
        
        return myAns;
    }

    public static int stairPath(int n, String psf, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
            count += stairPath(n - jump, psf + jump, ans);
        }

        return count;
    }

    public static int boardPath(int n, String psf, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int dice = 1; dice <= 6 && n - dice >= 0; dice++) {
            count += boardPath(n - dice, psf + dice, ans);
        }

        return count;
    }

    public static int boardPath(int[] arr, int n, String psf, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int i = 1; i < arr.length && n - arr[i] >= 0; i++) {
            count += boardPath(arr, n - arr[i], psf + arr[i], ans);
        }

        return count;
    }

    public static int mazePath_HVD(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans, int[][] dir,
            String[] dirS) {
        if (sr == er && sc == ec) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += mazePath_HVD(r, c, er, ec, psf + dirS[d], ans, dir, dirS);
            }
        }

        return count;
    }

    public static int mazePath_HVD_multi(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans, int[][] dir,
            String[] dirS) {
        if (sr == er && sc == ec) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= Math.max(er, ec); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    count += mazePath_HVD_multi(r, c, er, ec, psf + dirS[d] + rad, ans, dir, dirS);
                } else
                    break;
            }
        }

        return count;
    }

    public static void mazePath() {
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
        String[] dirS = { "H", "V", "D", "U" };

        ArrayList<String> ans = new ArrayList<>();
        System.out.println(mazePath_HVD_multi(0, 0, 2, 2, "", ans, dir, dirS));

        System.out.println(ans);
    }


    // // -------------------------------------------------
    // public static ArrayList<String> stairPath(int n){
    //     if(n == 0){
    //         ArrayList<String> base = new ArrayList<>();
    //         base.add(" ");
    //         return base;
    //     }

    //     ArrayList<String> myAns = new ArrayList<>();
    //     for(int jump = 0; jump <= 3 && n - jump >= 0 ; i++){
    //         ArrayList<String> recAns = stairPath(n - jump);
    //         for(String s : recAns){
    //             myAns.add(jump + s);
    //         }
    //     }

    //     return myAns;
    // }
    // // psf -> path soo far
    // public static int stairPath(int n, String psf, ArrayList<String> ans){

    // }

    // // -------------------------------------------------
    // public static int boardPath(int n, String psf, ArrayList<String> ans){

    // }

    // // -------------------------------------------------
    // public static int boardPath(int[] arr, int n, String ans){

    // }

    // // -------------------------------------------------
    // public static int mazePath_HVD(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans){

    // }

    // // -------------------------------------------------
    // public static int mazePath_HVD_multi(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans){

    //     for( int d = 0 ; d < dir.length ; d++){
    //         int r = sr + dir[d][0];
    //         int c = sc + dir[d][1];

    //         if(r >= 0 && c >= 0 && r <= er && c <=  )
    //     }
    // }

    // public static void mazePath(){
    //     int[][] dir = { {0, 1}, {1, 0}, {1, 1}};
    //     String[] dirS = {"H", "V", "D"};

    //     ArrayList<String> ans  = new ArrayList<>();
    //     System.out.println(0, 0, 2, 2, "", )
    // }

    public static void main(String[] args) {
        // p(1);
        // recursionPattern(1, 6);

        // printIncreasing(2, 7);

        // printDecreasing(2, 7);
        
        // oddEven(2, 7);

        // System.out.println(factorial(5));
        // System.out.println(factorial_01(5));

        // System.out.println(power(2, 10));
        // System.out.println(power_01(2, 10));

        // System.out.println(powerBtr(2, 20)); // O(log n)
        // System.out.println(powerBtr_01(2, 20)); // O(log n)

        // ---------------------- RECURSION WITH ARRAY ----------------------
        // index ->   0  1  2  3  4  5  6  7   8  9  10 11 12  13  14  15  16
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 78, 6, 4, 32, 6, 7, 32, 42, 21, 6};
        printArray(arr, 0);
        // printArrayReverse(arr, 0);

        // System.out.println(maximumInAnArray(arr, 0));
        // System.out.println(maximumInAnArray_01(arr, 0));

        // System.out.println(minimumInAnArray(arr, 0));
        // System.out.println(minimumInAnArray_01(arr, 0));

        // System.out.println(find(arr, 0, 5));
        // System.out.println(find_01(arr, 0, 5));
        // System.out.println(find_02(arr, 0, 5));

        // System.out.println(firstIndex(arr, 0, 7));
        // System.out.println(firstIndex_01(arr, 0, 7));

        // System.out.println(lastIndex(arr, 0, 6));
        // System.out.println(lastIndex_01(arr, 0, 6));

        // int[] ans = allIndex(arr, 0, 6, 0);
        // for( int ele : ans)
        //     System.out.println(ele);

        // ---------------------- RECURSION WITH ARRAYLIST ----------------------
        
        // subsequence 
        ArrayList<String> ans = subsequence("abc", 0);  // top to bottom approach
        for(String s : ans)
            System.out.println(s);

        // subsequence (void method)
        ArrayList<String> res = new ArrayList<>();
        int NoOfSubsequence = subsequence_01("abc", 0, "", ans);
        for(String s : res)
            System.out.print(s + "  ");
        System.out.println(NoOfSubsequence);


    }
}

// javac l001Recursion.java && java l001Recursion