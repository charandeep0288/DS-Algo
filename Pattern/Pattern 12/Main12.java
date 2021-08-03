
// Constraints
// 1 <= n <= 5
import java.util.*;

public class Main12 {
    
    public static void printfiboPattern(int n)
    {
        int a = 0, b = 1, sum = 0;
        for( int cr = 1 ; cr <= n ; cr++) // current row
        {
            for( int cc = 1 ; cc <= cr ; cc++) // current coloumn
            {
                System.out.print(a + "\t");
                sum = a+b;
                a = b;
                b = sum;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // write ur code here
        int n = scr.nextInt();
        printfiboPattern(n);
        scr.close();

    }
}

 // javac Main12.java && java Main12
// javac Main12.java && java Main12 > output12.txt  