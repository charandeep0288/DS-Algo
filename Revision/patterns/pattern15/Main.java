import java.util.Scanner;

public class Main {
    public static Scanner scr = new Scanner(System.in);

    public static void pattern15(int n) {
        int nor = n; // number of rows
        int nst = 1; // number of stars 
        int nsp = n / 2; // number of spaces

        for(int cr = 1 ; cr <= nor ; cr++) {
            for(int csp = 1 ; csp <= nsp ; csp++) {
                System.out.print(" \t");
            }

            int val = 0;
            if(cr <= nor / 2) {
                val = cr;
            } else {
                val = n - cr + 1; 
            }

            for(int cst = 1 ; cst <= nst ; cst++) {
                System.out.print(val + "\t");
                if(cst <= nst / 2) {
                    val++;
                } else {
                    val--;
                }
            }

            if(cr <= n / 2) {
                nst += 2;
                nsp--; 
            } else {
                nst -= 2;
                nsp++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = scr.nextInt();

        pattern15(n);
    }
}