import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void pattern3(int n) {
        int nst = 1; // number of stars
        int nsp = n - 1; // number of spaces
        int nor = n; // number of rows

        for(int cr = 1 ; cr <= nor ; cr++) { // currnet row
            for(int csp = 1 ; csp <= nsp ; csp++) { // current space
                System.out.print(" \t");
            }

            for(int cst = 1 ; cst <= nst ; cst++) { // current star
                System.out.print("*\t");
            }
            nsp--;
            nst++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = scr.nextInt();

        pattern3(n);
    }
}