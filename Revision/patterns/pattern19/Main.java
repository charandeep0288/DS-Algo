import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  public static void pattern19(int n) {
    for (int cr = 1; cr <= n; cr++) {
      for (int cc = 1; cc <= n; cc++) {
        if (cr == 1) { // 1
          if (cc <= n / 2 + 1 || cc == n) {
            System.out.print("*\t");
          } else {
            System.out.print(" \t");
          }
        }

        if (cr > 1 && cr <= n / 2) { // 2
          if (cc == (n / 2) + 1 || cc == n) {
            System.out.print("*\t");
          } else {
            System.out.print(" \t");
          }
        }

        if (cr == (n / 2) + 1) { // 3
          System.out.print("*\t");
        }

        if (cr > (n / 2) + 1 && cr < n) { // 4
          if (cc == 1 || cc == (n / 2) + 1) {
            System.out.print("*\t");
          } else {
            System.out.print(" \t");
          }
        }

        if (cr == n) { // 5
          if (cc == 1 || cc > n / 2) {
            System.out.print("*\t");
          } else {
            System.out.print(" \t");
          }
        }
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = scr.nextInt();

    pattern19(n);
  }
}
