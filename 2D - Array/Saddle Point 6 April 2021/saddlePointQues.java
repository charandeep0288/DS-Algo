 
 import java.util.Scanner;

public class saddlePointQues{

    public static Scanner scr = new Scanner(System.in);

    public static void input( int [][] arr )
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

    public static int maxInCol( int[][] arr, int j)
    {
        int maxVal = -(int) 1e9; // -10^9
        int r = -1;

        for( int i = 0 ; i < arr.length ; i++ )
        {
            if( arr[i][j] > maxVal )
            {
                maxVal = arr[i][j]; 
                r = i;
            }
        }
        return r;
    }

    public static void saddlePoint( int [][] arr )
    {
        int n = arr.length;
        int m = arr[0].length;
        boolean flag = false;

        for( int i = 0 ; i < n ; i++ )
        {
            // finding minimum in row
            int minVal = (int) 1e9; // 10^9
            int col = -1;
            for( int j = 0 ; j < m ; j++ )
            {
                if( arr[i][j] < minVal )
                {
                    minVal = arr[i][j];
                    col = j;

                }
            }

            int row = maxInCol( arr, col);
            
            if( row == i )
            {
                System.out.print(arr[row][col]);
                flag = true;
            }
        }
        if(!flag)
        {
            System.out.println("Invalid input");
        }
    }
    public static void main(String [] args)
    {
        int [][] arr = new int[scr.nextInt()][scr.nextInt()];

        input(arr);

        saddlePoint(arr);

        // THERE WILL BE ONE SADDLE POINT IN A MATRIX OR NONE
    }
}


// javac saddlePointQues.java && java saddlePointQues < input.txt > output.txt