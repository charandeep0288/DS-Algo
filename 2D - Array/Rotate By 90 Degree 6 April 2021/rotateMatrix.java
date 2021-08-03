 import java.util.Scanner;

public class rotateMatrix{

    public static Scanner scr = new Scanner(System.in);

    public static void input(int [][] arr)
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

    public static void display( int[] [] arr)
    {
        for( int i = 0 ; i < arr.length ; i++ )
        {
            for( int j = 0 ; j < arr[0].length ; j++ )
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int[][] arr, int i1, int j1, int i2, int j2)
    {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }

    public static void rotateBy90( int[] [] arr)
    {
        int n = arr.length; // number of rows
        int m = arr[0].length; // number of coloumns   
        
        // Transpose
        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = i ; j < m ; j++ )
            {
                swap(arr, i, j, j, i );
            }
        }

        // Coloumn shifting
        int si = 0; // starting index
        int ei = m - 1; // ending index

        while( si < ei )
        {
            for( int i = 0 ; i < n ; i++ )
            {
                swap( arr, i, si, i, ei );
            }
            // Always write these values first si and ei ( increment aur decrement vali value)
            si++;
            ei--;
        }

    }
    public static void main(String [] args)
    {
        int [][] arr = new int [scr.nextInt()][scr.nextInt()];

        input(arr);

        rotateBy90(arr);

        display(arr);
    }
}

// javac rotateMatrix.java && java rotateMatrix <input.txt> output.txt