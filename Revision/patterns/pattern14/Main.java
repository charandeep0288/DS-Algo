import java.util.Scanner;

public class Main {
    public static Scanner scr = new Scanner(System.in);

    public static void pattern14(int n) {
        for (int cr = 1 ; cr <= 10 ; cr++) {
            System.out.println(n + "\t*\t" + cr + "\t=\t" + (cr * n));
        }
    }

    public static void main(String[] args) {
        int n = scr.nextInt();
        
        pattern14(n);
    }
}