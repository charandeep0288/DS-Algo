import java.util.*;

public class Main11 {
    
    public static void printPattern(int n)
    {
        int num = 1;
        for(int cr = 1 ; cr <= n ; cr++)
        {
            for( int cc = 1 ; cc <= cr ; cc++ )
            {
                System.out.print(num++ + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // write ur code here
        int n = scr.nextInt();
        printPattern(n);
        scr.close();

    }
}

 // javac Main11.java && java Main11
// javac Main11.java && java Main11 > output11.txt
