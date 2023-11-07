import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void pattern11(int n){
        int num = 1;
        for(int cr = 1 ; cr <= n ; cr++) { // current row 
            for(int cc = 1 ; cc <= cr ; cc++) { // current column
                System.out.print(num++ + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = scr.nextInt();

        pattern11(n);
    }
}