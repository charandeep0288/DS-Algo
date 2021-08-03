 import java.util.*;

public class subArray{
    
    public static Scanner scr = new Scanner(System.in);
    
    public static int[] input( int n )
    {
        int [] arr = new int[n];
        
        for( int i = 0 ; i < n ; i++ )
        {
            arr[i] = scr.nextInt();
        }
        return arr;
    }
    
    public static void printInRange( int [] arr, int si, int ei )
    {
        while( si <= ei)
        {
            System.out.print(arr[si] + "\t");
            si++;
        }
        System.out.println();
    }
    
    public static void printAllSubArray( int [] arr )
    {
        for( int i = 0 ; i < arr.length ; i++ )
        {
            for( int j = i ; j < arr.length ; j++ )
            {
                printInRange( arr, i, j );
            }
        }
    }

public static void main(String[] args) throws Exception {
    // write your code here
    int n = scr.nextInt();
    
    int[] arr = input(n);
    
    printAllSubArray(arr);
 }

}

// javac subArray.java && java subArray