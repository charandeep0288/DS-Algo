import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void pattern11(int n) {
        int a = 0, b = 1, sum;

        for(int cr = 1 ; cr <= n ; cr++) { // current row
            for(int cc = 1 ; cc <= cr ; cc++) { // current column
                System.out.print(a + "\t");
                sum = a + b;
                a = b;
                b = sum;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = scr.nextInt();
        
        pattern11(n);
    }
}