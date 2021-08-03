 import java.util.*;

public class lecture10 {
    
    public static Scanner scr= new Scanner(System.in);

    public static void input( int [] [] arr )
    {
        for( int i = 0 ; i < arr.length ; i++ )
        {
            for( int j = 0 ; j < arr[0].length ; j++ )
            {
                arr[i][j] = scr.nextInt();
            }
        }
    } 

    public static void display( int [][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void printSpiralMatrix( int [][] arr)
    {
        int rmin = 0, cmin = 0;
        int rmax = arr.length - 1;
        int cmax = arr[0].length - 1;
        int tne = arr.length * arr[0].length; // total number of element

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

            // right wall
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

    public static void exitPonit( int [][] arr )
    {
        int n = arr.length;
        int m = arr[0].length;
        int r = 0; // row
        int c = 0; // coloumn
        int dir = 0; // direction

        while(true)
        {
            dir = (dir + arr[r][c]) % 4;

            if(dir == 0) // North
            {
                c++;
                if( c == m )
                {
                    System.out.println( r +"\n" + (c - 1));
                    break;
                }
            }
            else if( dir == 1 ) // East 
            {
                r++;
                if(r == n)
                {
                    System.out.println( (r - 1) + "\n" + c );
                    break;
                }
            }
            else if( dir == 2 ) // South
            {
                 c--;
                 if( c == -1 )
                {
                    System.out.println( r + "\n" + (c + 1));
                    break;
                }
            }
            else if( dir == 3 ) // West
            {
                r--;
                if( r == -1 )
                 {
                     System.out.println( (r + 1) + "\n" + c);
                     break;
                 }
            }
        }
    }
    


    public static void swap( int [][] arr, int i1, int j1, int i2, int j2 )
    {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;

    }

    public static void rotateBy90( int [][] arr )
    {
        int n = arr.length;
        int m = arr[0].length;

        // Transpose
        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = i ; j < m ; j++ )
            {
                swap(arr, i, j, j, i);
            }
        }

        // Column shifting
        int si = 0;
        int ei = m - 1;

        while( si < ei )
        {
            for( int i = 0 ; i < n ; i++ )
            {
                swap(arr, i, si, i, ei);
            }
            // Always write these values first si and ei ( increment aur decrement vali value)
            si++;
            ei--;
        }
    }


    
    public static int maxInCol(int [][] arr, int col)
    {
        int max = -(int) 1e9;
        int r = -1; 

        for( int i = 0 ; i < arr.length ; i++ )
        {
            if( arr[i][col] > max )
            {
                max = arr[i][col];
                r = i;
            }
        }
        return r;
    }

    public static void SaddlePoint( int [] [] arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        boolean flag= false;

        for( int i = 0 ; i < n ; i++ )
        {
            // finding minimum in the row
            int minVal = (int)1e9; // 10^9
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
        int [][] arr = new int [scr.nextInt()][scr.nextInt()];

        input(arr);

        // printSpiralMatrix(arr);

        // exitPonit(arr);

        // rotateBy90(arr);
        // display(arr);

        SaddlePoint(arr);

    }
}


// javac lecture10.java && java lecture10 <input.txt> output.txt