import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void pattern9(int n) {
        for( int cr = 1 ; cr <= n ; cr++) { // current row
            for (int cc = 1 ; cc <= n ; cc++) { // current column
                if(cc == cr || cr + cc == n + 1){
                    System.out.print("*\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = scr.nextInt();

        pattern9(n);
    }
}

// javac Main.java && java Main > output.txt