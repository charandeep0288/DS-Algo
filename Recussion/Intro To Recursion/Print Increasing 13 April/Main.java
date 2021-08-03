 
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scr.nextInt();
        
        printIncreasing(n);
        printIncreasing_01(1, n);
    }

    public static void printIncreasing_01(int a, int b){
        if(a > b)
        {
            return;
        }

        System.out.println(a);
        printIncreasing_01(a+1, b);
        // System.out.println("Hi " + a);
    }

    public static void printIncreasing(int n){
        if( n == 0 )
        return;
        
        printIncreasing(n - 1);
        System.out.println(n);
    }

}

// javac Main.java && java Main