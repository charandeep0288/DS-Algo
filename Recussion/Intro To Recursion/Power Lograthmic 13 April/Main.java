
import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        // write your code here
        int a = scr.nextInt();
        int b = scr.nextInt();
        
        // System.out.println( powerLog(a, b) );
        
        System.out.println( powerLog_01(a, b) );
    }
    
    public static int powerLog_01(int a, int b)
    {
        if( b == 0 )
           return 1;
           
        int recAns = powerLog_01(a, b/2);   
        recAns *= recAns;
        
        return (b % 2 == 0) ? recAns : recAns * a;
    }

    public static int powerLog(int a, int b){
        
        if( b == 0)
          return 1;
          
        int recAns = powerLog(a, b/2);
        recAns *= recAns;
        
        if( b % 2 == 0) 
           return recAns;
           
        else   
           return recAns * a;
    }

}

// javac Main.java && java Main

