import java.util.Scanner;

public class l001 {

  public static Scanner scr = new Scanner(System.in);

  public static void ppppppp(int a, int b) {
    return;
  }

  public static void pppppp(int a, int b) {
    System.out.println(a);
    ppppppp(a + 1, b);
    System.out.println("Hi \t " + a);
  }

  public static void ppppp(int a, int b) {
    System.out.println(a);
    pppppp(a + 1, b);
    System.out.println("Hi \t " + a);
  }

  public static void pppp(int a, int b) {
    System.out.println(a);
    ppppp(a + 1, b);
    System.out.println("Hi \t " + a);
  }

  public static void ppp(int a, int b) {
    System.out.println(a);
    pppp(a + 1, b);
    System.out.println("Hi \t " + a);
  }

  public static void pp(int a, int b) {
    System.out.println(a);
    ppp(a + 1, b);
    System.out.println("Hi \t " + a);
  }

  public static void p(int a, int b) {
    System.out.println(a);
    pp(a + 1, b);
    System.out.println("Hi \t " + a);
  }

  // Program ne run hote hua kitna PEEK SPACE li wo Space Complexity hoti hai

  // ---------------------------------------------
  // Q1 Print Increasing - O(n)
  // pre
  public static void printIncreasing(int a, int b) {
    // base case
    if (a > b) {
      return;
    }

    System.out.println(a);
    printIncreasing(a + 1, b); // recursion call
  }

  // post
  public static void printIncreasing_01(int a, int b) {
    if (a > b) {
      return;
    }

    printIncreasing_01(a, b - 1);
    System.out.println(b);
  }

  // post
  public static void printIncreasing_02(int n) { // with one function argument
    if (n == 0) {
      return;
    }

    printIncreasing_02(n - 1);
    System.out.println(n);
  }

  // ---------------------------------------------
  // Q2 Print Decreasing - O(n)
  // post
  public static void printDecreasing(int a, int b) {
    // base case
    if (a > b) {
      return;
    }
    printDecreasing(a + 1, b);
    System.out.println(a);
  }

  // pre
  public static void printDecreasing_01(int a, int b) {
    if (a > b) {
      return;
    }

    System.out.println(b);
    printDecreasing(a, b - 1);
  }

  // pre
  public static void printDecreasing_02(int n) { // with one function argument
    if (n == 0) {
      return;
    }

    System.out.println(n);
    printDecreasing_02(n - 1);
  }

  // ---------------------------------------------
  // Q3 Print Decreasing Increasing - O(n)
  public static void printDecInc(int a, int b) {
    if (a > b) {
      return;
    }

    System.out.println(b);
    printDecInc(a, b - 1);
    System.out.println(b);
  }

  // ---------------------------------------------
  // Q4 Print Increasing Decreasing - O(n)
  public static void printIncDec(int a, int b) {
    if (a > b) {
      return;
    }

    System.out.println(a);
    printIncDec(a + 1, b);
    System.out.println(a);
  }

  // ---------------------------------------------
  // Q5 Print Increasing Even Decreasing Odd - O(n)
  public static void printIncEvenDecOdd(int a, int b) {
    if (a > b) {
      return;
    }

    if (a % 2 == 0) System.out.println(a);
    printIncEvenDecOdd(a + 1, b);
    if (a % 2 != 0) System.out.println(a);
  }

  // ---------------------------------------------
  // Q6 Factorial - Time - O(n), Space - O(n)
  public static int factorial(int n) {
    if (n == 0) {
      return 1; // 0! = 1, So returned value 1
    }

    return factorial(n - 1) * n;
  }

  public static int factorial_01(int n) {
    return n == 0 ? 1 : factorial_01(n - 1) * n;
  }

  // ---------------------------------------------
  // Q7 Power Linear - Time - O(b)
  // Space Complexity(Peek space occupied by this recursion fn) - O(b)
  public static int powerLiner(int a, int b) {
    if (b == 0) {
      return 1; // x^0 = 1
    }

    int recAns = powerLiner(a, b - 1);
    return recAns * a;
  }

  public static long powerLiner_01(int a, int b) {
    return (b == 0) ? 1 : powerLiner_01(a, b - 1) * a;
  }

  // ---------------------------------------------
  // Q8 Power Logarithmic - Time & Space O(log(b))
  public static int powerLogrithmic(int a, int b) {
    if (b == 0) {
      return 1;
    }
    int recAns = powerLogrithmic(a, b / 2);
    recAns *= recAns;

    return b % 2 == 0 ? recAns : recAns * a;
  }

  // ---------------------------------------------
  // Q9 Print Zig Zag - O(n)
  public static void printZigZag(int n) {
    if (n == 0) {
      return;
    }

    System.out.print(n + "\t");
    printZigZag(n - 1);
    System.out.print(n + "\t");
    printZigZag(n - 1);
    System.out.print(n + "\t");
  }

  // ---------------------------------------------
  // Q10 Tower of Hanoi
  // t1id -> Source, t2id -> Destination, t3id -> Helper
  public static void toh(int n, int t1id, int t2id, int t3id) {
    if (n == 0) return;

    toh(n - 1, t1id, t3id, t2id);
    System.out.println(n + "[" + t1id + " -> " + t2id + "]");
    toh(n - 1, t3id, t2id, t1id);
  }

  // ---------------------------------------------
  // Q11 Fibonacci Series
  public static int fibo(int n) {
    if(n <= 1) {
      return n;
    }

    int count = 0;
    count += fibo(n - 1);
    count += fibo(n - 2);

    return count;
  }

  // ---------------------------------------------
  // Practice Recursion Tree for this -> for n = 6
  public static int recursionTreeint(int n) {
    if(n <= 1) {
      System.out.println("Base: " + n);
      return n + 1;
    }

    int count = 0;

    System.out.println("Pre: " + n);
    count += recursionTreeint(n - 1);

    System.out.println("In1: " + n);
    count += recursionTreeint(n - 2);

    System.out.println("In2: " + n);
    count += recursionTreeint(n - 3);

    System.out.println("Post: " + n);

    return (count + 3);
  } 

  public static void main(String[] args) {
    // p(2, 7);

    // int a = scr.nextInt();
    // int b = scr.nextInt();
    int n = scr.nextInt();

    // printIncreasing(a, b); // pre
    // printIncreasing_01(a, b); // post
    // printIncreasing_02(n); // post - with one function argument

    // printDecreasing(a, b); // pre
    // printDecreasing(a, b); // post
    // printDecreasing_02(n); // pre - with one function argument

    // printDecInc(a, b);

    // printIncDec(a, b);

    // printIncEvenDecOdd(a, b);

    // int fact = factorial(n);
    // int fact = factorial_01(n);
    // System.out.println("Factorial of number " + n + " -> " + fact);

    // int powerLiner = powerLiner(a, b);
    // long powerLiner = powerLiner_01(a, b);
    // System.out.println(powerLiner);

    // int powerLogrithmic = powerLogrithmic(a, b);
    // System.out.println(powerLogrithmic);

    // printZigZag(n);

    // toh(n, 10, 11, 12);

    recursionTreeint(6);
  }
}

// javac l001.java && java l001 < input.txt > output.txt
