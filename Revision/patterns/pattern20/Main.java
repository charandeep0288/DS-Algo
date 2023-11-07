import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void pattern20(int n) {
        for ( int cr = 1 ; cr <= n ; cr++){
            for(int cc = 1 ; cc <= n ; cc++) {
                if(cr > n / 2  && (cr == cc || cc + cr == n + 1) || cc == 1 || cc == n) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = scr.nextInt();

        pattern20(n);
    }
}