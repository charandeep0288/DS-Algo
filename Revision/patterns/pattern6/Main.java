import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  public static void pattern6(int n) {
    int nor = n; // number of rows
    int nst = (n / 2) + 1; // number of stars
    int nsp = 1; // number of spaces

    for (int cr = 1; cr <= nor; cr++) { // current row
      for (int cst = 1; cst <= nst; cst++) { // current star
        System.out.print("*\t");
      }

      for (int csp = 1; csp <= nsp; csp++) {
        System.out.print(" \t");
      }

      for (int cst = 1; cst <= nst; cst++) {
        System.out.print("*\t");
      }

      if (cr <= n / 2) {
        nst--;
        nsp += 2;
      } else {
        nst++;
        nsp -= 2;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int num = scr.nextInt();

    pattern6(num);
  }
}
// javac Main.java && java Main > output.txt
