import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  public static void patter2(int n) {
    int nor = n; // number of rows
    int nst = n; // number of stars

    for (int cr = 0; cr < nor; cr++) { // current row
      for (int cst = 0; cst < nst; cst++) { // current star
        System.out.print("*\t");
      }
      nst--;
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = scr.nextInt();

    patter2(n);
  }
}
