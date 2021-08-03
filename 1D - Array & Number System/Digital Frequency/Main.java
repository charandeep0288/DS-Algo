import java.util.Scanner;

public class Main{
    
    public static Scanner scr = new Scanner(System.in);
    
    public static int digitFrequency( int n, int data )
    {
        int count = 0;
        while( n != 0 )
        {
            int lastdigit = n % 10;
            n /= 10;  
            
            if( lastdigit == data )
                count++;
        }
        return count;
    }
    public static void main(String [] args )
    {
        int n = scr.nextInt();
        int d = scr.nextInt();
        
        int f = digitFrequency( n, d );
        System.out.println(f);
    }
}

// javac Main.java && java Main