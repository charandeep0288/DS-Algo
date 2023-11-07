import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  public static void pattern10(int n) {
    int onst = n / 2; // outter number of stars
    int inst = 1; // inner number od stars

    for (int cr = 1; cr <= n; cr++) { // current row
      for (int curronst = 1; curronst <= onst; curronst++) { // current outter number of stars
        System.out.print(" \t");
      }

      System.out.print("*\t");

      if(cr == 2) inst = 1;
      
      for (int currinst = 1; currinst <= inst; currinst++) { // current inner number of stars
        System.out.print(" \t");
      }

      if (cr > 1 && cr < n) System.out.print("*\t");

      if (cr <= n / 2) {
        onst--;
        if (cr > 1 && cr < n) inst += 2;
      } else {
        onst++;
        inst -= 2;
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = scr.nextInt();

    pattern10(n);
  }
}
