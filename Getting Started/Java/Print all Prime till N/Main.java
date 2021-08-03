 import java.util.Scanner;

public class Main{
    
    public static Scanner scr = new Scanner(System.in);
    
    public static boolean isPrime( int n )
    {
        for( int div = 2 ; div * div <= n ; div++ )
        {
            if( n % div == 0 )
               return false;
        }
        return true;
    }
    
    public static void allPrimes( int n )
    {
        if( isPrime(n) == true )
           System.out.println(n);
           
    }
    public static void solve()
    {
        int low = scr.nextInt();
        int high = scr.nextInt();
        
        for( int i = low ; i <= high ; i++ )
        {
            allPrimes(i);
        }
    }
    
    public static void main(String[] args) {
        // write your code here
        solve();
    }
}

// javac Main.java && java Main