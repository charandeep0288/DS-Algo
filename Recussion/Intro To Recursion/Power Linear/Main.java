
 import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        // write your code here
        int a = scr.nextInt();
        int b = scr.nextInt();
        
        // System.out.println(power(a, b));
         System.out.println(power_01(a, b));
        
    }
    
    public static int power_01( int a, int b )
    {
        return b == 0 ? 1 : power_01(a, b - 1) * a;
    }

    public static int power(int a, int b) 
    {
        
        if( b == 0 )
           return 1;
           
        int recAns = power(a, b - 1);
        
        return recAns * a;
    }

}

// javac Main.java && java Main