import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void pattern4(int n) {
        int nst = n; // number of stars
        int nor = n; // number of rows
        int nsp = 0; // number of spaces

        for(int cr = 1 ; cr <= nor ; cr++) { // current row
            for(int cst = 1 ; cst <= nst ; cst++) { // current star
                System.out.print("*\t");
            }  

            for(int csp = 1 ; csp <= nsp ; csp++) {
                System.out.print("\t");
            }
            System.out.println();
            nst--;
            nsp++;
        }
    }

    public static void main(String[] args) {
        int n = scr.nextInt();

        pattern4(n);
    }
}