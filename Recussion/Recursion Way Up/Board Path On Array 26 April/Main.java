
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static int[] input( int n )
    {
        int [] arr = new int[n];
        for( int i = 0 ; i < n ; i++ )
        {
            arr[i] = scr.nextInt();
        }
        return arr;
    }
    public static void main(String[] args) throws Exception {
        int n = scr.nextInt();
        int [] arr = input(n);

        int num = scr.nextInt();

        System.out.println( boardPathOnArray(arr, num, "") ); 
    }

    // board Path on Array
    public static int boardPathOnArray( int [] arr, int n, String ans )
    {
        if( n == 0 )
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for( int jump : arr )
        {
            if( n - jump >= 0 )
                count += boardPathOnArray( arr, n - jump , ans + jump);
        }
        
        return count;
    }

}

// javac Main.java && java Main < input.txt 