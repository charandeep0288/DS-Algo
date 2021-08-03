
 import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scr.nextInt();
        
        // System.out.println( factorial(n) );

        System.out.println( factorial_01(n) );
    }

    public static int factorial_01( int n )
    {
        return n == 0 ? 1 : factorial_01(n - 1) * n;
    }
    public static int factorial(int n){
        if( n == 0 )
           return 1;
           
        int recAns = factorial(n - 1);
        
        return recAns * n;
    }
}

// javac Main.java && java Main