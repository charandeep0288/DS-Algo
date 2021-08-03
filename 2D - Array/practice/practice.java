import java.util.Scanner;

public class practice {
    
    public static Scanner scr = new Scanner(System.in);

    public static int[][] input( int n, int m )
    {
        int [][] arr = new int[n][m];
        for( int i = 0; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
                arr[i][j] = scr.nextInt();
        }
        return arr;
    }

    public static int maximumIn2DArray( int [][] arr )
    {
        int n = arr.length;
        int m = arr[0].length;
        int maxVal = -(int)1e9;

        for( int i = 0 ; i < n ; i ++ )
        {
            for( int j = 0 ; j < m ; j ++ )
            {
                maxVal = Math.max(maxVal, arr[i][j]);
            }
        }
        return maxVal;
    } 

    public static int minimumIn2DArray( int[] [] arr )
    {
        int minVal = (int)1e9;
        int n = arr.length;
        int m = arr[0].length;

        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                minVal = Math.min(minVal, arr[i][j]);
            }
        }
        return minVal;
    }

    public static String findElementIn2DArray_01( int [][] arr, int data )
    {
        int foundAtIdx_i = -1;
        int foundAtIdx_j = -1;
        int n = arr.length;
        int m = arr[0].length;

        for( int i = 0 ; i < n ; i ++ )
        {
            for( int j = 0 ; j < m ; j ++ )
            {
                if( arr[i][j] == data )
                {
                    foundAtIdx_i = i;
                    foundAtIdx_j = j; 
                }
            }
        }
        if( foundAtIdx_i == -1 )
           return "ELEMENT NOT FOUND";
           
        return "( " + foundAtIdx_i + " , " + foundAtIdx_j + " )"; 
    }

    public static boolean findElementIn2DArray_02( int [][] arr, int data )
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int i = 0 ; i < n ; i ++ )
        {
            for( int j = 0 ; j < m ; j ++ )
            {
                if( arr[i][j] == data )
                {
                    return true;
                }
            }
        }
           
        return false; 
    }

    public static void waveTraversal( int [][] arr )
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int i = 0 ; i < n ; i++ )
        {
            if( i % 2 == 0 )
            {
                for( int j = 0 ; j < m ; j++ )
                   System.out.print(arr[i][j] + "\t");
            }
            else
            {
                for( int j = m - 1 ; j >= 0 ; j-- )
                    System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void Wakanda_1( int [] [] arr)
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int j = 0 ; j < m ; j++ )
        {
            if( j % 2 == 0 )
            {
                for( int i = 0 ; i < n ; i++ )
                    System.out.print(arr[i][j] + "\t");
            }
            else
            {
                for( int i = n - 1 ; i >= 0 ; i-- )
                    System.out.print(arr[i][j] + "\t");
            }
        }
    }

    public static void stateOfWakanda_02( int [][] arr )
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int gap = 0 ; gap < n ; gap++ )
        {
            for( int i = 0, j = gap ; i < n && j < m ; i++, j++ )
            {
                System.out.print(arr[i][j] + "  ");
            }
        }
    }

    public static void fullDiagonalTraversal( int [][] arr )
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int gap = n - 1 ; gap > 0 ; gap-- )
        {
            for ( int i = gap, j = 0 ; i < n && j < m ; i++, j++ )
            {
                System.out.print(arr[i][j] + "  ");
            }
        }

        for( int gap = 0 ; gap < n ; gap++ )
        {
            for( int i = 0, j = gap ; i < n && j < m ; i++, j++ )
            {
                System.out.print(arr[i][j] +  "  ");
            }
        }
    }

    public static void spiralDisplay( int[][] arr )
    {
        int n = arr.length;
        int m = arr[0].length;

        int rmin = 0, cmin = 0;
        int rmax = n - 1, cmax = m - 1;
        int tne = n * m; // TOTAL NUMBER OF ELEMENT

        while( tne > 0 )
        {
            // left wall
            for( int r = rmin ; r <= rmax && tne > 0 ; r++ )
            {
                System.out.print(arr[r][cmin] + "  " );
                tne--;
            }
            cmin++;

            // bottom wall
            for( int c = cmin ; c <= cmax && tne > 0 ; c++ )
            {
                System.out.print(arr[rmax][c] + "  " );
                tne--;
            }
            rmax--;

            // right wall
            for( int r = rmax ; r >= rmin && tne > 0 ; r-- )
            {
                System.out.print(arr[r][cmax] + "  " );
                tne--;
            }
            cmax--;

            // top wall 
            for( int c = cmax ; c >= cmin && tne > 0 ; c-- )
            {
                System.out.print(arr[rmin][c] + "  " );
                tne--;
            }
            rmin++;
        }
    }

    public static void exitPoint( int [][] arr )
    {
        int dir = 0; // direction
        int n = arr.length; // number of rows
        int m = arr[0].length; // number of columns
        int r = 0; // coloumn
        int c = 0; // row 

        while( true )
        {
            dir = (dir + arr[r][c]) % 4; // direction 

            if( dir == 0 )
            {
                c++;
                if( c == m )
                {
                    System.out.print( r + "  " + (c - 1) );
                    break;
                }
            }
            else if( dir == 1 )
            {
                r++;
                if( r == n )
                {
                    System.out.print( (r - 1) + "  " + c );
                    break;
                }
            }
            else if( dir == 2 )
            {
                c--;
                if( c == -1 )
                {
                    System.out.print( r + "   " + (c + 1) );
                    break;
                }
            }
            else if( dir == 3 )
            {
                r--;
                if( r == -1 )
                {
                    System.out.println( (r - 1) + "  " + c );
                    break;
                }
            }    
        }    
    }

    public static void swap( int[][] arr, int i1, int j1, int i2, int j2 )
    {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }

    public static void rotateBy90( int[][] arr )
    {
        int n = arr.length;
        int m = arr[0].length;

        // Transpose
        for( int i= 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j <= i ; j++ )
            {
                swap( arr, i, j, j, i );
            }
        }

        // columns exchange
        int si = 0, ei = m - 1;
        while( si < ei )
        {
            for( int i = 0 ; i < n ; i++ )
                swap(arr, i, si, i, ei);
            si++;
            ei--;
        } 
    }

    public static void saddlePoint( int[][] arr )
    {
        int n = arr.length;
        int m = arr.length;
        int idx = -1;
        int rmin = 0, cmax = 0;

        for( int i = 0 ; i < n ; i++ )
        {
            rmin = (int)1e9;

            for( int j = 0 ; j < m ; j++ )
            {
                if( arr[i][j] < rmin )
                {
                    rmin = Math.min( rmin, arr[i][j] );
                    idx = j;
                }
            }

            cmax = -(int)1e9; 

            for( int r = 0 ; r < n ; r++ )
            {
                cmax = Math.max(cmax, arr[r][idx]);
            }
        }

        if( cmax == rmin)
            System.out.println( cmax );
        else
            System.out.println("Invalid Input");
    }

    public static void display( int [][] arr )
    {
        for( int [] ans : arr )
        {
            for( int ele : ans )
            {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    public static void main( String [] args )
    {
        // int n = scr.nextInt();
        // int m = scr.nextInt();

        int [][] arr = input( scr.nextInt(), scr.nextInt() );

        // System.out.println( maximumIn2DArray(arr) );
        // System.out.println( minimumIn2DArray(arr) );

        // System.out.println( findElementIn2DArray_01(arr, scr.nextInt()) );
        // System.out.println( findElementIn2DArray_02(arr, scr.nextInt()) );

        // waveTraversal(arr);

        // Wakanda_1(arr);

        // stateOfWakanda_02(arr); // Diagonal Traversal

        // fullDiagonalTraversal(arr);

        // spiralDisplay(arr);

        // exitPoint(arr);

        // rotateBy90(arr);

        saddlePoint(arr);
        // display(arr);
    }
    
}


// javac practice.java && java practice < input.txt