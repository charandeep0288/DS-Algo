import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  public static void pattern7(int n) {
    for (int cr = 1; cr <= n; cr++) { // current row
      for (int cc = 1; cc <= n; cc++) { // current column
        if (cr == cc) {
          System.out.print("*\t");
        } else {
          System.out.print(" \t");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int num = scr.nextInt();

    pattern7(num);
  }
}
