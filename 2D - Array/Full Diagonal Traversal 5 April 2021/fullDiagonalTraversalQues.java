 import java.util.*;

public class fullDiagonalTraversalQues {

    public static Scanner scr = new Scanner(System.in);

    public static void input( int [] [] arr)
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                arr[i][j] = scr.nextInt();
            }
        }
    }

    public static void fullDiagonalTraversal( int [][] arr)
    {
        int n = arr.length; 
        int m = arr[0].length;

        for( int gap = n - 1 ; gap >= 1 ; gap-- )
        {
            for( int i = gap, j = 0 ; i < n && j < m ; i++, j++ )
            {
                System.out.println(arr[i][j]);
            }
        }

        for( int gap = 0 ; gap < m ; gap++ )
        {
            for( int i = 0, j = gap ; i < n && j < m ; i++, j++ )
            {
                System.out.println(arr[i][j]);
            }
        }
    }
    public static void main(String[] args)
    {
        int [][] arr = new int[scr.nextInt()][scr.nextInt()];

        input(arr);

        fullDiagonalTraversal(arr);
    }
    
}

// javac fullDiagonalTraversalQues.java && java fullDiagonalTraversalQues < input.txt > output.txt
