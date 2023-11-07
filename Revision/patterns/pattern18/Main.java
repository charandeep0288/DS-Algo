import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  public static void pattern18(int n) {
    int nosp = 0; // number of outter space
    int nisp = n / 2; // number of inner space
    int nst = n; // number of star

    for (int cr = 1; cr <= n; cr++) {
      for (int csp = 1; csp <= nosp; csp++) {
        System.out.print(" \t");
      }

      for (int cst = 1; cst <= nst; cst++) {
        if (cr != 1 && cr <= n / 2 && cst != 1 && cst != nst) {
          System.out.print(" \t");
        } else {
          System.out.print("*\t");
        }
      }

      if (cr <= n / 2) {
        nst -= 2;
        nosp++;
      } else {
        nst += 2;
        nosp--;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = scr.nextInt();

    pattern18(n);
  }
}
