import java.util.*;

public class diagonalTraversalQues {

    public static Scanner scr = new Scanner(System.in);

    public static void input( int [][] arr)
    {
        int n = arr.length; // number of rows
        int m = arr[0].length; // number of coloums
        
        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                arr[i][j] = scr.nextInt();
            }
        }
    }
    
    public static void diagonalTraversal( int [][] arr )
    {
        int n = arr.length; // number of rows
        int m = arr[0].length;  // number of coloums
        
        for( int gap = 0 ; gap < m ; gap++ )
        {
            for( int i = 0, j = gap ; i < n && j < m ; i++, j++ )
            {
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        int [][] arr = new int[scr.nextInt()][scr.nextInt()];
        
        input(arr);
        
        diagonalTraversal(arr);
    }
    
}



// javac diagonalTraversalQues.java && java diagonalTraversalQues < input.txt > output.txt