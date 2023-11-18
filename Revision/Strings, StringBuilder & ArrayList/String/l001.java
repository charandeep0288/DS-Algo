import java.util.Scanner;

public class l001 {

  public static Scanner scr = new Scanner(System.in);

  public static void stringBasics() {
    String str = "abcdefg"; // String --in--> Double Coats
    //            0123456
    char ch = str.charAt(3);
    System.out.println(ch); // d

    String str1 = str.substring(1, 5 + 1); // si, ei + 1
    System.out.println(str1); // bcdef

    System.out.println("String length -> " + str.length());

    String str2 = new String("qwerty");

    char character = 's'; // char --in--> Single Coats
    char[] arr = { 'a', 'b', 'c' };

    String str3 = scr.next(); // picks String upto the first space in a line
    String str4 = scr.nextLine(); // picks String in that whole line
    // Input values -> vf dv f cdscds
    System.out.println("picks String upto the first space in a line --> " + str3); // vf
    System.out.println("picks String in that whole line --> " + str4); // dv f cdscds

    String s = "abc, def, ghi, jkl, mn"; // literal
    String[] parts = s.split(", ");
    for(int i = 0 ; i < parts.length; i++) {
        System.out.println(parts[i]);
    }

    // str.charAt(0) = 'z'; // wouldn't work // set nahi kar sakte uske liye String Builder hai 
    str += 'z'; // this would work 


    String str5 = "hello";   
    String str5_ = "hello"; // Interning concept -> new string is not created but address of the existing string is stored in the Stack if this string exists in the Inter/pool

    String str6 = "hello " + str5 + " World!";
    str5 += 'w';
    str5 += 34567;
    System.out.println("str5 -> " + str5); // str5 -> hellow34567
    System.out.println("str6 -> " + str6); // str6 -> hello hello World!


    // evalution is from left to right
    System.out.println("hello" + 10 + 20); // hello1020
    System.out.println(10 + 20 + "hello"); // 30hello


    // -----------------------------------------
    String str11 = "hello";
    String str12 = "hello";
    String str13 = new String("hello");

    // == compares the address of the String not the actual value
    System.out.println("str11 == str12  " + str11 == str12); // true
    System.out.println("str11 == str13  " + str11 == str13); // false

    // So we use the .equals()
    // 1. Firstly check address of both String if same return true
    // 2. If address is not same, then it checks String character by character
    System.out.println("str11.equals(str12) " + str11.equals(str12)); // true 
    System.out.println("str11.equals(str13) " + str11.equals(str13)); // true

    // -----------------------------------------
    String str21 = "abc";
    for(int i = 0 ; i < str.length() ; i++) { // O(n^2)
      str21 += i; // Each time loop runs, a new String is created, performace is reduced because of this, So to overcome this problem we use "STRING BUILDER"
    }
    System.out.println("str21 -> " + str21);

  }


  // -------------------------------------------------------
  // Q1 String Compression-1 (Remove Duplicate) - not on portal -> Time - O(n)
  // Space - O(n) where n is number of unique characters in the String
  // aaabbcdddeffff -> abcdef
  public static void removeDuplicate(String str) {
    int n = str.length();
    if(n == 0) {
        return;
    }

    String ans =  str.charAt(0) + "";
    int i = 1;
    int changes = 0;
    while(i < n) {
        while(i < n && str.charAt(i) == ans.charAt(ans.length() - 1)) { // will use this kind of logic in Stack & Queue, Graph and Window Technique
            i++;
        } 

        changes++;
        if(i < n) {
            ans += str.charAt(i);
        }
        i++;
    }

    System.out.println("Changes -> " + changes);
    System.out.println("Result -> " + ans);
  }

  // -------------------------------------------------------
  // Q2 String Comparision-2 (Remove Duplicate Insert Count)
  public static void removeDuplicateInsertCount(String str) {
    int n = str.length();
    if(n == 0) {
        return;
    }

    String ans = "" + str.charAt(0);
    int count = 1, changes = 0;
    int i = 1;
    while(i < n) {
        count = 1;
        while(i < n && str.charAt(i) == ans.charAt(ans.length() - 1)) {
            i++;
            count++;
        }
        changes++;

        if(count > 1) {
            ans += count;
        }

        if(i < n) {
            ans += str.charAt(i); 
        }
        i++;
    }

    System.out.println("Changes -> " + changes);
    System.out.println("Result -> " + ans);
  }

  // -------------------------------------------------------
  // Q3 Print all Palindromic Substring -> Time - O(n^3), Space - O(1)
  public static boolean isPalindrome(String str, int si, int ei) {
    while(si < ei) {// si <= ei OR si < ei(It doesn't matter but it is better - because we have reduced the one check) 
      if(str.charAt(si) != str.charAt(ei)){
        return false;
      }
      
      si++;
      ei--;
    }
    return true;
  }

  public static void printString(String str, int si, int ei){
    for(int i = si ; i <= ei ; i++) {
      System.out.print(str.charAt(i));
    }
    System.out.println();
  }

  public static void subString(String str) {
    int n = str.length();

    for(int i = 0 ; i < n ; i++) {
      for(int j = i ; j < n ; j++) {
        if(isPalindrome(str, i, j)) {
          // printString(str, i, j);
          //    ---- OR ----   we can print using .substring(si, ei + 1) fn
          String s = str.substring(i, j + 1);
          System.out.println(s);
        }
      }
    }
  }

  public static void printAllPalindromicSubstring(String str) {
    subString(str);
  }

  // -------------------------------------------------------
  // Q4 Count Hi (Coding Bat - https://codingbat.com/prob/p147448)
  public static int countofHi(String str) {
    int n = str.length();
    int i = 0, count = 0;

    while(i < n - 1) {
      if(str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') { 
        count++;
        i += 2;
      } else {
        i++;
      }
    }

    return count;
  }

  // -------------------------------------------------------
  // Q5 Remove Hit and Count Hi
  public static int countHiWithoutHit(String str) {
    int n = str.length();
    int i = 0, count = 0;
    
    while(i < n - 1) { //  i < n - 1 OR  i + 1 < n 
      if(str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
        if( i < n - 2 && str.charAt(i + 2) == 't') { // i < n - 2 OR i + 2 < n
          i += 3;
        } else {
          i += 2;
          count++;
        }
      } else {
        i++;
      }
    }

    return count; // and we can print number of Hi based in it's count 
  }

  // -------------------------------------------------------
  // Q6 Remove all hi
  public static String removeAllHi(String str) {
    int n = str.length();
    int i = 0;

    String ans = "";
    
    while(i < n) {
      if(i < n - 1 && str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') { // i < n - 1 OR i + 1 < n
        i += 2;
      } else {
        ans += str.charAt(i);
        i++;
      }
    }

    return ans;
  }

  // -------------------------------------------------------
  // Q7 Remove all 'hi' expect 'hit'
  public static String hitWithoutHit(String str) {
    int n = str.length();
    int i = 0, count = 0;

    String ans = "";
    while(i < n) {
      if(i < n - 1 && str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') { // i < n - 1 OR i + 1 < n
        if(i < n - 2 && str.charAt(i + 2) == 't') { // i < n - 2 OR i + 2 < n
          ans += str.substring(i, i + 3);
          i += 3;
          count++;
        } else {
          i += 2;
        }
      } else {
        i++;
      }
    }

    // System.out.println("Count of the hit Without hi -> " + count);
    return ans;
  }

  public static void main(String[] args) {
    // stringBasics();

    String str = scr.nextLine();
    
    // removeDuplicate(str);
    // removeDuplicateInsertCount(str);
    // printAllPalindromicSubstring(str);
    
    // int countHi = countofHi(str);
    // System.out.println("Count of Hi String -> " + countHi);

    // int countHiWithoutHit = countHiWithoutHit(str);
    // System.out.println("Count of Hi String without Hit -> " + countHiWithoutHit);

    // String stringWithoutHi = removeAllHi(str);
    // System.out.println("String without Hi -> " + stringWithoutHi); 

    String stringhiWithoutHit = hitWithoutHit(str);
    System.out.println("String hi without hit -> " + stringhiWithoutHit);
  }
}
// javac l001.java && java l001 < input.txt > output.txt
