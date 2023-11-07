import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  public static void pattern16(int n) {
    int nos = 1; // number of stars
    int nsp = (n * 2) - 3;

    for (int cr = 1; cr <= n; cr++) {
      for (int cs = 1; cs <= nos; cs++) {
        System.out.print(cs + "\t");
      }

      for (int csp = 1; csp <= nsp; csp++) {
        System.out.print(" \t");
      }

      if (cr == n) {
        nos--;
      }

      for (int cs = nos; cs >= 1; cs--) {
        System.out.print(cs + "\t");
      }

      nos++;
      nsp -= 2;
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = scr.nextInt();

    pattern16(n);
  }
}
