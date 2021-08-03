import java.util.Scanner;

public class spiralDisplayQues{

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

    public static void spiralDisplay( int[] [] arr)
    {
        int n = arr.length; // number of rows
        int m = arr[0].length; // number of columns
        int rmin = 0;
        int rmax = n - 1;
        int cmin = 0;
        int cmax = m - 1;
        int tne = n * m; // total number of elements 

        while( tne > 0 )
        {
            // left wall
            for( int r = rmin ; r <= rmax && tne > 0 ; r++ )
            {
                System.out.println(arr[r][cmin]);
                tne--;
            }
            cmin++;

            // bottom wall
            for( int c = cmin ; c <= cmax && tne > 0 ; c++ )
            {
                System.out.println(arr[rmax][c]);
                tne--;
            }
            rmax--;

            // left wall
            for( int r = rmax ; r >= rmin && tne > 0 ; r-- )
            {
                System.out.println(arr[r][cmax]);
                tne--;
            }
            cmax--;

            // top wall
            for( int c = cmax ; c >= cmin && tne > 0 ; c-- )
            {
                System.out.println(arr[rmin][c]);
                tne--;
            }
            rmin++;
        }
    }
    public static void main(String [] args)
    {
        int [][] arr = new int [scr.nextInt()][scr.nextInt()];

        input(arr);

        spiralDisplay(arr);
    }

}

// javac spiralDisplayQues.java && java spiralDisplayQues < input.txt > output.txt