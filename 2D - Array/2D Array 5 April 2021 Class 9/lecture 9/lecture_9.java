 
 import java.util.*;

public class lecture_9 {

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

    public static void display( int [] [] arr )
    {
        int n = arr.length; // number of rows 
        int m = arr[0].length; // number of coloumns

        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void display1( int [] [] arr )
    {
        // int n = arr.length; // number of rows 
        // int m = arr[0].length; // number of coloumns

        // FOR EACH LOOP 
        for( int [] ar : arr )
        {
            for( int e : ar )
            {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static int maximum( int [][] arr )
    {
        int maxValue = -(int)1e9;
        int n = arr.length; // number of rows 
        int m = arr[0].length; // number of coloumns

        for(int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                if( arr[i][j] > maxValue )
                {
                    // maxValue = arr[i][j];
                    maxValue = Math.max(maxValue, arr[i][j]);
                }
            }
        }
        return maxValue;
    }

    public static int minimum( int[] [] arr )
    {
        int minValue = (int)1e9;
        int n = arr.length;
        int m = arr[0].length;

        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                if( arr[i][j] < minValue )
                {
                    // min = arr[i][j];
                    minValue = Math.min(minValue, arr[i][j]);
                }
            }
        }
        return minValue;
    }

    // FIND ELEMENT IN 2-D ARRAY SOLUTION 1
    public static boolean find( int [] [] arr, int data )
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                if( arr[i][j] == data )
                {
                    return true;
                }
            }
        }
        return false;
    }

    // FIND ELEMENT IN 2-D ARRAY SOLUTION 2
    public static boolean find1( int [] [] arr, int data )
    {
        int n = arr.length;
        int m = arr[0].length;

        boolean res = false; 

        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                res = (arr[i][j] == data);
                if( res )
                {
                    return res;
                    //break; 
                    // break;
                }
            }
        }
        return false;
    }

     // ( WAVE TRAVERSAL HORIZONTAL )
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
 

    //Ques.  THE STATE OF WAKANDA - 1 
    // // ( WAVE TRAVERSAL VERTICAL )
    public static void stateOfWakanda1( int [] [] arr )
    {
        int n = arr.length; // number of rows 
        int m = arr[0].length; // number of coloumns

        for( int j = 0 ; j < m ; j++ )
        {
            if( j % 2 == 0 )
            {
                for( int i = 0 ; i < n ; i++ )
                    System.out.println(arr[i][j] + " ");
            }
            else
            {
                for( int i = n - 1 ; i >= 0 ; i-- )
                    System.out.println(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Ques. THE STATE OF WAKANDA - 2 
    public static void diagnalPrint( int [][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int gap = 0 ; gap < m ; gap++ )
        {
            for( int i = 0, j = gap ; i < n && j < m ; i++, j++ )
            {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static void fullDiagonalPrint( int [][] arr )
    {
        int n = arr.length;
        int m = arr[0].length;

        for( int gap = n - 1 ; gap > 0 ; gap -- )
        {
            for( int i = gap, j = 0 ; i < n && j < m ; i++, j++ )
            {
                System.out.print(arr[i][j] + " ");
            }
        }

        for( int gap = 0 ; gap < m ; gap++ )
        {
            for( int i = 0, j = gap ; i < n && j < m ; i++, j++ )
            {
                System.out.print(arr[i][j] + " ");
            }
        }
    }


    public static void main(String args[])
    {
        int[][] arr = new int[scr.nextInt()][scr.nextInt()];
        
        input(arr);
        
        // display(arr);
        // display1(arr);
        
        // // FIND MAXIMUM ELEMENT IN 2-D ARRAY
        // int ans1 = maximum(arr);
        // System.out.println(ans1);

        // FIND MINIMUM ELEMENT IN 2-D ARRAY
        // int ans2 = minimum(arr);
        // System.out.println(ans2);

        // // FIND ELEMENT IN AN ARRAY
        // int data = scr.nextInt();
        // boolean ans = find(arr, data); 
        // System.out.print(ans);

        // // FIND ELEMENT IN AN ARRAY
        // int data = scr.nextInt();
        // boolean ans = find1(arr, data); 
        // System.out.print(ans);

        // ( WAVE TRAVERSAL HORIZONTAL )
        // waveTraversal1(arr);

        // STATE OF WAKANDA - 1
        // ( WAVE TRAVERSAL VERTICAL )
        // stateOfWakanda1(arr);

        // TO PRINT DIAGONAL TRAVERSAL
        // diagnalPrint(arr);


        // TO PRINT FULL DIAGONAL
        // fullDiagonalPrint(arr);
    }
    
}


// javac filename.java && java filename < input.txt > output.txt
// javac lecture_9.java && java lecture_9 < input.txt > output.txt