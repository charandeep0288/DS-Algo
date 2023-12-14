import java.util.ArrayList;
import java.util.Scanner;

public class l001 {

  public static Scanner scr = new Scanner(System.in);

  // ----------------------------------------
  // Q1 Get Subsequence
  public static ArrayList<String> getSubsequence(String str) {
    if (str.length() == 0) { // base case
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    char ch = str.charAt(0);

    ArrayList<String> recAns = getSubsequence(str.substring(1));
    ArrayList<String> myAns = new ArrayList<>();

    // ArrayList<String> myAns = new ArrayList<>(recAns); // constructor -> as it is ArrayList me add kar dega, behave same as for loop after this line
    for (String s : recAns) {
      myAns.add(s);
    }

    for (String s : recAns) {
      myAns.add(ch + s);
    }

    return myAns;
  }

  // ----------------------------------------
  // Q2 Get KPC - Nokia Problem
  public static String[] nokiaKeys = {
    ".;",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tu",
    "vwx",
    "yz",
  };

  public static ArrayList<String> getKPC(String str) {
    if (str.length() == 0) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    char ch = str.charAt(0);
    String code = nokiaKeys[ch - '0'];

    ArrayList<String> recAns = getKPC(str.substring(1));
    ArrayList<String> myAns = new ArrayList<>();

    for (int i = 0; i < code.length(); i++) {
      for (String s : recAns) {
        myAns.add(code.charAt(i) + s); // '' + "" -> ""
      }
    }

    return myAns;
  }

  // ----------------------------------------
  // Q3 Decoded Ways - Leetcode - 91 ( NOT ON PORTAL )
  // check for these test cases => 11283, 11023, 0, 11341011
  public static ArrayList<String> decodedWays(String str) {
    if (str.length() == 0) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    if (str.charAt(0) == '0') {
      return new ArrayList<>(); // ans not possible return emty ArrayList
    }

    char ch1 = str.charAt(0);

    ArrayList<String> myAns = new ArrayList<>();
    ArrayList<String> recAnsFor1Len = decodedWays(str.substring(1));

    for (String s : recAnsFor1Len) {
      myAns.add((char) ('a' + ch1 - '1') + s);
    }

    if (str.length() > 1) {
      int num = (ch1 - '0') * 10 + (str.charAt(1) - '0');
      if (num <= 26) {
        ArrayList<String> recAnsFor2Len = decodedWays(str.substring(2));
        for (String s : recAnsFor2Len) {
          myAns.add((char) ('a' + num - 1) + s);
        }
      }
    }

    return myAns;
  }

  // ----------------------------------------
  // Q4 Decoded Ways 2
  public static String[] nokiaKeys2 = {
    ".;",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tu",
    "vwx",
    "yz",
    "+-*",
    "<>/%",
  };

  public static ArrayList<String> decodedWays2(String str) {
    if (str.length() == 0) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    char ch1 = str.charAt(0);
    String word = nokiaKeys2[ch1 - '0'];

    ArrayList<String> myAns = new ArrayList<>();
    ArrayList<String> recAnsFor1Len = decodedWays2(str.substring(1));

    for (int i = 0; i < word.length(); i++) {
      for (String s : recAnsFor1Len) {
        myAns.add(word.charAt(i) + s);
      }
    }

    if (str.length() > 1) {
      int num = (ch1 - '0') * 10 + (str.charAt(1) - '0');
      if (num == 10 || num == 11) {
        word = nokiaKeys2[num];
        ArrayList<String> recAnsFor2Len = decodedWays2(str.substring(2));

        for (int i = 0; i < word.length(); i++) {
          for (String s : recAnsFor2Len) {
            myAns.add(word.charAt(i) + s);
          }
        }
      }
    }

    return myAns;
  }

  // ----------------------------------------
  // Q5 get Stair Paths
  public static ArrayList<String> getStairPaths(int n) {
    if (n == 0) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> myAns = new ArrayList<>();

    for (int i = 1; i <= 3 && (n - i) >= 0; i++) {
      ArrayList<String> recAns = getStairPaths(n - i);
      for (String s : recAns) {
        myAns.add(i + s);
      }
    }

    return myAns;
  }

  // ----------------------------------------
  // Q6 Board Path
  public static ArrayList<String> boardPath(int n) {
    if (n == 0) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> myAns = new ArrayList<>();
    for (int dice = 1; dice <= 6 && (n - dice) >= 0; dice++) {
      ArrayList<String> recAns = boardPath(n - dice);
      for (String s : recAns) {
        myAns.add(dice + s);
      }
    }

    return myAns;
  }

  // ----------------------------------------
  // Q7 Board Path on Array
  public static ArrayList<String> boardPathOnArray(int n, int[] moves) {
    if (n == 0) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> myAns = new ArrayList<>();
    for (int i = 0; i < moves.length && (n - moves[i]) >= 0; i++) {
      ArrayList<String> recAns = boardPathOnArray(n - moves[i], moves);
      for (String s : recAns) {
        myAns.add(moves[i] + s);
      }
    }

    return myAns;
  }

  // ----------------------------------------
  // Q8 Get Maze Path HV
  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static ArrayList<String> getMazePaths_HV(
    int sr,
    int sc,
    int dr,
    int dc
  ) {
    if (sr == dr && sc == dc) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> myAns = new ArrayList<>();

    if (sc + 1 <= dc) {
      ArrayList<String> horizontal = getMazePaths_HV(sr, sc + 1, dr, dc);
      for (String s : horizontal) {
        myAns.add('H' + s); // CPP : string(1, 'H') + s;
      }
    }

    if (sr + 1 <= dr) {
      ArrayList<String> vertical = getMazePaths_HV(sr + 1, sc, dr, dc);
      for (String s : vertical) {
        myAns.add('V' + s); // CPP : string(1, 'V') + s;
      }
    }

    return myAns;
  }

  // ----------------------------------------
  // Q9 Get Maze Path HVD
  public static ArrayList<String> getMazePath_HVD(
    int sr,
    int sc,
    int dr,
    int dc
  ) {
    if (sr == dr && sc == dc) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> myAns = new ArrayList<>();
    // horizontal
    if (sc + 1 <= dc) {
      ArrayList<String> horizontal = getMazePath_HVD(sr, sc + 1, dr, dc);
      for (String s : horizontal) {
        myAns.add('H' + s);
      }
    }

    // diagonal
    if (sr + 1 <= dr && sc + 1 <= dc) {
      ArrayList<String> diagonal = getMazePath_HVD(sr + 1, sc + 1, dr, dc);
      for (String s : diagonal) {
        myAns.add('D' + s);
      }
    }

    // vetical
    if (sr + 1 <= dr) {
      ArrayList<String> vertical = getMazePath_HVD(sr + 1, sc, dr, dc);
      for (String s : vertical) {
        myAns.add('V' + s);
      }
    }

    return myAns;
  }

  // ----------------------------------------
  // Q10 Get Maze Path with Jumps
  public static ArrayList<String> getMazePaths_MultiHDV(
    int sr,
    int sc,
    int dr,
    int dc
  ) {
    if (sr == dr && sc == dc) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> myAns = new ArrayList<>();
    for(int jump = 1 ; sc + jump <= dc ; jump++) {
        ArrayList<String> horizontal = getMazePaths_MultiHDV(sr, sc + jump, dr, dc);
        for(String s : horizontal) {
            myAns.add("H" + jump + s);
        }
    }

    for(int jump = 1 ; sr + jump <= dr && sc + jump <= dc ; jump++) {
        ArrayList<String> diagonal = getMazePaths_MultiHDV(sr + jump, sc + jump, dr, dc);
        for(String s : diagonal) {
            myAns.add("D" + jump + s);
        }
    }

    for(int jump = 1 ; sr + jump <= dr ; jump++) {
        ArrayList<String> vertical = getMazePaths_MultiHDV(sr + jump, sc, dr, dc);
        for(String s : vertical) {
            myAns.add("V" + jump + s);
        }
    }

    return myAns;
  }

  public static void main(String[] args) {
    String str = scr.nextLine();

    // System.out.println(getSubsequence("abcd"));

    // for (String s : getKPC("456")) {
    //   System.out.println(s);
    // }

    // System.out.println((int)'0'); // 48
    // System.out.println((int)'1'); // 49
    // System.out.println('1' + '0'); // 48 + 49 -> 97
    // System.out.println('3' + '4');// ascii value koo add kar raha hai -> 103
    // System.out.println('3' + '+' + '4');// ascii value of '3'(51) + ascii value of '+'(43) + ascii value of '4'(52) -> 146
    // System.out.println((char)('1' + '0')); // a

    // System.out.println("" + '1' + '0'); // 10
    // System.out.println('1' + "" + '0'); // 10
    // System.out.println('1' + '0' + ""); // 97

    // System.out.println('a' + 'b'); // 195
    // System.out.println('a' + "b"); // ab

    // System.out.println(decodedWays("0")); // 11283, 11023, 0, 11341011, 11230, 111220

    // for(String s : decodedWays2("110")) { // 0, 01, 110, 11011, 120
    //     System.out.println(s);
    // }

    // System.out.println(getStairPaths(5));

    // System.out.println(boardPath(7));
    // int[] arr = { 2, 3, 5 };
    // System.out.println(boardPathOnArray(8, arr));

    // System.out.println(getMazePaths_HV(0, 0, 3, 2));
    // System.out.println(getMazePath_HVD(0, 0, 3, 2));
    System.out.println(getMazePaths_MultiHDV(0, 0, 3, 3));
  }

}
// javac l001.java && java l001 < input.txt > output.txt
