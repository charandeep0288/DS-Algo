import java.util.Scanner;

public class l001 {
    public static Scanner scr = new Scanner(System.in);


    // String Immitable Test
    public static void stringImmitableTest() {
        String str = "";

        for(int i = 0 ; i <= (int)1e5 ; i++) {
            str += i;
        }
        // System.out.println(str);
    }

    // StringBuilder Immitable Test
    public static void stringImmuitableTest() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < (int)1e5 ; i++) {
            sb.append(i);
        } 
    }

    public static void immitableTest() {
        // --------------------------------------------
        // String Immitable Test
        long start = System.currentTimeMillis();
        stringImmitableTest();
        long end = System.currentTimeMillis();

        System.out.println(end - start); // 3.143 sec approx

        // --------------------------------------------
        // String Builder Immitable Test
        long start1 = System.currentTimeMillis();
        stringImmuitableTest();
        long end1 = System.currentTimeMillis();

        // 1 second -> 0.001 mili seconds
        System.out.println(end1 - start1); // 0.005 sec OR 5 mili second
    }

    public static void basics() {
        StringBuilder sb = new StringBuilder("hello");
        System.out.println("sb -> " + sb);

        // 1. To insert an element at an index -> insert(index, value) - O(n)
        sb.insert(2, 'z'); 
        System.out.println("sb after insertion -> " + sb);

        StringBuilder sb1 = new StringBuilder();
        // 2. To insert element at the end of the String Builder - O(n)
        sb1.append("a"); 
        sb1.append("bcd").append("str");

        // 3. To print StinngBuilder value we have to cover sb1 to String - O(n)
        System.out.println("sb1 -> " + sb1.toString());

        // 4. To set character value at an index - O(1) 
        sb1.setCharAt(1, 'z');
        System.out.println("sb1 -> " + sb1.toString());

        // 5. To delete character from an index in StringBuilder - O(n)
        sb1.deleteCharAt(3);
        System.out.println("After Deletion sb1 -> " + sb1.toString());

        // all other fns of String work here

        System.out.println((int)'A'); // 65 <- ASCII Code
        System.out.println((char)97); // a <- character 
    }

    // ------------------------------------------------
    // Q1 Toggle Case 
    // abCDEfGHi -> ABcdeFghI
    public static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder();
        
        int n = str.length();
        for(int i = 0 ; i < n ; i++) {
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z'){ 
                sb.append((char)(ch - 'a' + 'A')); // to upper
            } else {
                sb.append((char)(ch - 'A' + 'a')); // to lower
            }
        }
        
        return sb.toString();
    }

    // ------------------------------------------------
    // Q2 String with Diiference of Every Two Consecutive Charaters / ASCII Difference
    public static String asciiDiff(String str) {
        int n = str.length();
        if(n == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        
        sb.append(str.charAt(0));
        for(int i = 1 ; i < n ; i++) {
            sb.append(str.charAt(i) - str.charAt(i - 1));
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // basics();
        // immitableTest();

        String str = scr.nextLine();

        // String ans = toggleCase(str);
        // System.out.println("String after toggle case value -> " + ans);

        String asciiDiff = asciiDiff(str);
        System.out.println("String after ASCII Diff -> " + asciiDiff);
    }
}

// javac l001.java && java l001 < input.txt > output.txt