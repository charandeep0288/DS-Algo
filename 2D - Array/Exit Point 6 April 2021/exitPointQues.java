import java.util.Scanner;

public class exitPointQues{

    public static Scanner scr = new Scanner(System.in);

    public static void input( int [][] arr)
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

    public static void exitPoint( int[][] arr)
    {
        int n = arr.length; // number of rows 
        int m = arr[0].length; // number of columns 
        int dir = 0; // direction 
        int r = 0; // row
        int c = 0; // coloumn

        while(true)
        {
            dir = ( dir + arr[r][c]) % 4;

            if( dir == 0 ) // North
            {
                c++;
                if( c == m )
                {
                    System.out.println( r + "\n" + ( c - 1 ) );
                    break;
                }
            }
            else if( dir == 1) // East
            {
                r++;
                if( r == n )
                {
                    System.out.println( (r -1) + "\n" + c);
                    break;
                }
            }
            else if( dir == 2 ) // South
            { 
                c--;
                if( c == -1)
                {
                    System.out.println(r + "\n" + (c + 1) );
                    break;
                }
            }
            else // West
            {
                r--;
                if( r == -1 )
                {
                    System.out.println( (r + 1) + "\n" + c );
                    break;
                }
            }
        }
    }
    public static void main(String [] args)
    {
        int [][] arr = new int [scr.nextInt()][scr.nextInt()];

        input(arr);

        exitPoint(arr);

    }
}

// javac exitPointQues.java && java exitPointQues < input.txt > output.txt