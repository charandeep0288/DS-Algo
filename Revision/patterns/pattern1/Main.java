package pattern1;

import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  public static void pattern_1(int n) {
    int nst = n; // number of stars
    int nr = n; // number of rows

    for (int cr = 0; cr < nr; cr++) { // current row
      for (int cst = 0; cst < nst; cst++) { // current start
        System.out.print("*\t");
      }
      System.out.println();
    }
  }

  public static void pattern_001(int n) {
    int nst = 1; // number of stars
    int nor = n; // number of rows

    for (int cr = 0; cr < nor; cr++) { // current row
      for (int cst = 0; cst < nst; cst++) { // current star
        System.out.print("*\t");
      }
      nst++;
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = scr.nextInt();

    // pattern_1(n);

    pattern_001(n);

    scr.close();
  }
}
// javac Main.java && java Main > output.txt
