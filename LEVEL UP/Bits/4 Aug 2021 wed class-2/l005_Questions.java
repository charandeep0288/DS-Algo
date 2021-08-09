import java.util.*;

public class l005_Questions{

    public class pair {
        int r = 0;
        int c = 0;

        pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public boolean isValidToPlaceNumber(char[][] borad, int r, int c, int num){

        // row
        for(int i = 0 ; i < 9 ; i++)
            if(board[r][i] - '0' == num)
                return false;

        // col
        for(int i = 0 ; i < 9 ; i++)
            if(board[i][c] - '0' == num)
                return false;

        // mat 
        r = (r / 3) * 3;
        c = (c / 3) * 3;

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(board[r + i][c + j] - '0' == num)
                    return false;
            }
        }

        return true;
    }

    public boolean solveSudoku(char[][] board, int idx, ArrayList<pair> arr ){
        if(idx == arr.size()){
            return true;
        }

        pair p = arr.get(idx);
        int r = p.r;
        int c = p.c;

        for(int num = 1 ; num <= 9 ; num++){
            if(isValidToPlaceNumber(board, r, c, num)){
                board[r][c] = (char) (num + '0');
                if(solveSudoku(board, idx + 1, arr))
                    return true;
                board[r][c] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board){
        ArrayList<pair> arr = new ArrayList<>();

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(boad[i][j] == '.')
                    arr.add(new pair(i, j)); // i * 8 + j
            }
        }

        solveSudoku(board, 0, arr);
    }


    // ==================================================
    // 9 Aug 2021 bits class -3
    // ==================================================

    // ------------------------------------------------------
    public static int[] row, col;
    public static int[][] mat;

    public boolean solveSudokuUsingBits(char[][] board, int idx, ArrayList<pair> arr){
        if(idx == arr.size()){
            return true;
        }

        pair p = arr.get(idx);
        int r = p.r;
        int c = p.c;

        for(int num = 1 ; num <= 9 ; num++){
            int mask = (1 << num);
            if((row[r] & mask) == 0 && (col[c] & mask) == 0 && (mat[r / 3][c / 3] & mask) == 0){
                
                board[r][c] = (char)(num + '0');
                // set
                row[r] ^= mask;
                col[c] ^= mask;
                mat[r / 3][c / 3] ^= mask;

                if(solveSudokuUsingBits(board, idx + 1, arr))
                    return true;

                // unset
                row[r] ^= mask; 
                col[c] ^= mask;
                mat[r / 3][c / 3] ^= mask;
            }
        }
        return false;
    }

    public void solveSudokuUsingBits(char[][] borad){
        ArrayList<pair> arr = new ArrayList<>();
        row = new int[9];
        col = new int[9];
        mat = new int[9][9];

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(borad[i][j] == '.'){
                    arr.add(new pair(i, j)); // i * 9 + j
                } else{
                    int mask = (1 << (board[i][j] - '0'));
                    row[i] ^= mask;
                    col[j] ^= mask;
                    mat[i / 3][j / 3] ^= mask;
                }
            }
        }        

        solveSudokuUsingBits(borad, 0, arr);
    }

    // leetcode 37

    // leetcode 36. Valid Sudoku 
    public boolean isValidSudoku(char[][] box) {
        int[]row = new int[9];
        int[]col = new int[9];
        int[][]mat = new int[3][3];
         
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (box[i][j] == '.')
                    continue;
                else {
                    int mask= (1 << (box[i][j] - '0'));
                    if((row[i] & mask) == 0 && (col[j] & mask) == 0 && (mat[i / 3][j / 3] & mask) == 0){
                    
                        row[i] ^= (mask);
                        col[j] ^= (mask);
                        mat[i / 3][j / 3] ^= (mask); 
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

  
    // ------------------------------------------------------
    // cryptoarithmitic (on portal)
    public static int stringToInt(String str, HashMap<Character, Integer> charIntMap){
        int res = 0;
        for(int i = 0 ; i < str.length() ; i++){
            res = res * 10 + charIntMap.get(str.charAt(i));
        }

        return res;
    }

    public static void crypto(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, String s1, String s2, String s3){
        if(idx == unique.length()){
            int x = stringToInt(s1, charIntMap);
            int y = stringToInt(s2, charIntMap);
            int z = stringToInt(s3, charIntMap);

            if(x + y == z){
                for(int i = 0 ; i < 26 ; i++){
                    char ch = (char) (i + 'a');
                    if(charIntMap.containsKey(ch))
                        System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                }
                System.out.println();
            }
            return;
        }

        char ch = unique.charAt(idx);
        for( int num = 0 ; num < 10 ; num++){
            if(!usedNumbers[num]){
                usedNumbers[num] = true;
                charIntMap.put(ch, num);

                crypto(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);

                charIntMap.remove(ch);
                usedNumbers[num] = false;
            }
        }
    }

    // --------------------------------------------------
    // 2 set of equal sum
    public static int equalSet(int[] arr, int idx, int sum1){
        if(idx == arr.length){
            if(sum1 == sum2) {
                System.out.println(set1 + " = " + set2);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += equalSet(arr, idx + 1, sum1 + arr[idx], set1 + arr[idx] + " ", sum2, set2);
        count += equalSet(arr, idx + 1, sum1, set1, sum2 + arr[idx], set2 + arr[idx] + " ");

        return count;
    }

    // ---------------------------------------------------
    public static void equalSet(int[] arr, int idx, int sum, ArrayList<ArrayList<Integer>> ans){

    }

    public static void equalSet(int[] arr, int idx){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < 2 ; i++)
            ans.add(new ArrayList<>());

        int sum = 0;
        for(int ele : arr)
            sum += ele;

        if((sum & 1) != 0)
            return;

        equalSet(arr, 0, sum / 2, ans);
        System.out.println(ans);
    }


    public static void main(String [] args){
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };
        equalSet(arr, 0, 0, "", 0, "");
        // equalSet(arr, 1, 10, "10 ", 0, ""); // humna first vala number ko fix kar dia woo sirf ik hi set mai hi aya gaa 
    }
}
