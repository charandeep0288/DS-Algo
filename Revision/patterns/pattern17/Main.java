import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  public static void pattern17(int n) {
    int nor = n; // number of rows
    int nst = 1; // number of stars
    int nsp = n / 2; // number of spaces

    for (int cr = 1; cr <= nor; cr++) { // current row
      for (int csp = 1; csp <= nsp; csp++) { // current space
        if (cr == (n / 2) + 1) {
          System.out.print("*\t");
        } else {
          System.out.print(" \t");
        }
      }

      for (int cst = 1; cst <= nst; cst++) { // current star
        System.out.print("*\t");
      }

      if (cr <= n / 2) {
        nst++;
      } else {
        nst--;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = scr.nextInt();

    pattern17(n);
  }
}
