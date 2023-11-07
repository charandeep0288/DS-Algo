import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void pattern13(int num) {
        int nor = num; // number of row
        int nst = 1; // number of stars

        for(int n = 0 ; n < nor ; n++) { // n represent current row
            int ncr = 1; // nCr
            for(int r = 0 ; r < nst ; r++) { // r represent current column
                System.out.print(ncr + "\t" );
                int ncrpo = (ncr * (n-r))/(r+1); // nCr+1
                ncr = ncrpo;
            }
            nst++;
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int n = scr.nextInt();

        pattern13(n);
    }  

}