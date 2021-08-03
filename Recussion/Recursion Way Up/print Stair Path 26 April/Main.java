
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scr.nextInt();
        
        printStairPaths(n, "");

    }

    public static int printStairPaths(int n, String ans) {
        if( n == 0 )
        {
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        
        for( int jump = 1 ; jump <= 3 && ( n - jump ) >= 0 ; jump++)
        {
            count += printStairPaths( (n - jump), ans + jump );
        }
        return count;
    }

}