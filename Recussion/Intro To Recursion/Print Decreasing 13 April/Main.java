
import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scr.nextInt();

        printDecreasing(n);
        
        printDecreasing_01(2, 7);
        
    }

    // post
    public static void printDecreasing_01(int a, int b){
        if(a > b)
        {
            return;
        }

        printDecreasing_01(a+1, b);

        System.out.println(a);
    }

    // pre
    public static void printDecreasing(int n){
        
        if( n == 0 )
          return;
          
        System.out.println(n);  
        printDecreasing(n - 1);  
    }

}

// javac Main.java && java Main