 import java.util.*;

public class waveTraversal{
    
    public static Scanner scr = new Scanner(System.in);
    
    public static void input( int [][] arr )
    {
        int n = arr.length;  // number of rows
        int m = arr[0].length; // number of coloums
        
        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                arr[i][j] = scr.nextInt();
            }
        }
    }
    
    public static void wakanda1( int [][] arr )
    {
        int n = arr.length;  // number of rows
        int m = arr[0].length; // number of coloums
        
        for( int j = 0 ; j < m ; j++ )
        {
            if( j % 2 == 0 )
            {
                for( int i = 0 ; i < n ; i++ )
                   System.out.println(arr[i][j]);
            }
            else
            {
                for( int i = n - 1 ; i >= 0 ; i-- )
                   System.out.println(arr[i][j]);
            }
        }
    }

public static void main(String[] args) throws Exception {
    // write your code here
    // int n = scr.nextInt();
    // int m = scr.nextInt();
    // int [] [] arr = new int[n][m];
    
    int [] [] arr = new int[scr.nextInt()][scr.nextInt()];
    
    input(arr);
    
    wakanda1(arr);
 }

}

// javac waveTraversal.java && java waveTraversal < input.txt > output.txt