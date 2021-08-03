
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scr.nextInt();
        
        // printIncreasingDecreasing(n);

        // printIncreasingDecreasing_01(2, 7);

        printIncreasingDecreasing_02(1, n);
    }

    // without repeated digits in middle
    public static void printIncreasingDecreasing_03(int a, int b){
        if(a > b)
        {
            return;
        }
        System.out.println(a);

        printIncreasingDecreasing_03(a+1, b);

        if( a != b)
            System.out.println(a);
    }

    public static void printIncreasingDecreasing_02(int a, int b){
        if(a > b)
        {
            return;
        }
        System.out.println(b);

        printIncreasingDecreasing_02(a, b - 1);

        System.out.println(b);
    }

    public static void printIncreasingDecreasing_01(int a, int b){
        if(a > b)
        {
            return;
        }
        System.out.println(a);

        printIncreasingDecreasing_01(a+1, b);

        System.out.println(a);
    }

    public static void printIncreasingDecreasing(int n){
        if( n == 0 )
          return;
          
        System.out.println(n);
        
        printIncreasingDecreasing( n - 1 );
        
        System.out.println(n);
    }

}

// javac Main.java && java Main