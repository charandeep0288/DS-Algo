
 import java.util.*;

public class waveTraversalQues {

     // SIR VALA QUESTION

    public static Scanner scr = new Scanner(System.in);

    public static void input( int [] [] arr )
    {
        int n = arr.length; // number of rows 
        int m = arr[0].length; // number of coloumns

        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                arr[i][j] = scr.nextInt();
            }
        }
    }

    // SIR SOLUTION
    public static void waveTraversal1( int [][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int i = 0 ; i < n ; i++ )
        {
           if( i % 2 == 0 )
           {
               for( int j = 0 ; j < m ; j++ )
                  System.out.print(arr[i][j] + " ");
           }
           else
           {
               for( int j = m - 1 ; j >= 0 ; j-- )
                  System.out.print(arr[i][j] + " ");
           }
           System.out.println();
        }
    }

    
     public static void main(String args[])
     {
         int[][] arr = new int[scr.nextInt()][scr.nextInt()];
         
         input(arr);
 
         // WAVE TRAVERSAL
         waveTraversal1(arr); // my solution
     }
}


// javac waveTraversalQues.java && java waveTraversalQues < input.txt > output.txt 
