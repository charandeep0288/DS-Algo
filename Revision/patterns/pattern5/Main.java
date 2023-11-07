import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  public static void halfDiamond(int n) {
    int nor = n; // number of rows
    int nsp = n - 1; // number of spaces
    int nst = 1; // number of stars

    for (int cr = 1; cr <= nor; cr++) {
      for (int csp = 1; csp <= nsp; csp++) {
        System.out.print(" \t");
      }

      for (int cst = 1; cst <= nst; cst++) {
        System.out.print("*\t");
      }

      System.out.println();
      nsp--;
      nst += 2;
    }
  }

  public static void fullDiamond(int n) {
    int nor = n; // number of rows
    int nsp = n / 2; // number of spaces
    int nst = 1; // number of stars

    for (int cr = 1; cr <= nor; cr++) {
      for (int csp = 1; csp <= nsp; csp++) {
        System.out.print(" \t");
      }

      for (int cst = 1; cst <= nst; cst++) {
        System.out.print("*\t");
      }

      if (cr <= n / 2) {
        nsp--;
        nst += 2;
      } else {
        nsp++;
        nst -= 2;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = scr.nextInt();

    // halfDiamond(n);
    fullDiamond(n);
  }
}

// javac Main.java && java Main > outputHalfDiamond.txt
