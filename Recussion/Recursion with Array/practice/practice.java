import java.util.Scanner;

public class practice{

    public static Scanner scr = new Scanner(System.in);

    public static void printArray( int[] arr, int i )
    {
        if( arr.length == i )
             return;

        System.out.println(arr[i]);     
        printArray( arr, i + 1 ); 
    }

    public static void printArray_01(int[] arr, int i)
    {
     
        if( i < 0 )
           return;
           
        printArray_01(arr, i - 1);
        System.out.println(arr[i]);
    }

    public static void printReverseArray( int[] arr, int i )
    {
        if( i == arr.length )
            return;

        printReverseArray(arr, i + 1);
        System.out.println(arr[i]);
    }

    public static void printReverseArray_01(int[] arr, int i) 
    {
        if( i < 0 )
            return;
            
        System.out.println(arr[i]);    
        printReverseArray_01(arr, i - 1);    
    }

    public static int printMaxOfArray( int[] arr, int i )
    {
        if( arr.length == i )
            return -(int)(1e9);

        int recMax = printMaxOfArray(arr, i + 1);

        return recMax > arr[i] ? recMax : arr[i];
    }

    public static int printMinOfArray( int[] arr, int i )
    {
        if( i == arr.length )
            return (int)1e9;

        int recMin = printMinOfArray(arr, i + 1);
         
         return recMin < arr[i] ? recMin : arr[i];
    }

    public static boolean findElementInAnArray( int[] arr, int i, int data )
    {
        if( i == arr.length)
           return false;
           
        if( arr[i] == data )
           return true;
           
        return findElementInAnArray(arr, i + 1, data);   
    }

    public static boolean findElementInAnArray_02( int[] arr, int i, int data )
    {
        if( i == arr.length)
           return false;
           
        boolean recAns = findElementInAnArray_02(arr, i + 1, data);   
        if(recAns)
            return true;

        return ( arr[i] == data ) ? true : false;
    }

    public static boolean findElementInAnArray_01( int[] arr, int i, int data )
    {
        if( i < 0 )
           return false;
           
        boolean recAns = findElementInAnArray_01(arr, i - 1, data);   

        if( !recAns && arr[i] == data )
           recAns = true;

        return recAns; 
    }

    public static int firstDataIdxInAnArray( int[] arr, int i, int data )
    {
        if( i == arr.length )
           return -1;

        if( arr[i] == data )
           return i;

        return firstDataIdxInAnArray(arr, i + 1, data );      
    }

    public static int lastDataIdxInAnArray( int[] arr, int i, int data )
    {
        if( i == arr.length )
            return -1;

        int recAns = lastDataIdxInAnArray(arr, i + 1, data);
        if( recAns != -1 )
            return recAns;
            
         return arr[i] == data ? i : -1;   

    } 

    public static int[] allIndex( int[] arr, int i, int data, int count )
    {
        if( i == arr.length )
            return new int[count];

        if( arr[i] == data )
            count++;

        int[] recAns = allIndex(arr, i + 1, data, count);
        if( arr[i] == data )
            recAns[count - 1] = i;

        return recAns;    
    }

    public static void display( int[] arr )
    {
        int n = arr.length;
        for( int i = 0 ; i < n ; i++ )
            System.out.println(arr[i]);
    }

    public static boolean firstAndLastIdx( int[] arr, int idx, int data, int[] ans, boolean val)
    {
        if( arr.length == idx )
            return false;

        if( !val && arr[idx] == data ) 
        {
            ans[0] = idx;
            val = true;
        } 
          
        boolean recAns = firstAndLastIdx(arr, idx + 1, data, ans, val);
        if( recAns )
           return true;

        if( arr[idx] == data )
        {
            ans[1] = idx;
            return true;
        }    
        
        return false;   
    }
    public static void main(String[] args)
    {
        int[] arr = {2, 34, 254, 843, 3, 4, 315, 79, 8, 520, 2, 2, 3};

        // printArray(arr, 0);
        // printArray(arr, arr.length - 1);

        // printReverseArray(arr, 0);
        // printReverseArray(arr, arr.length - 1);

        // System.out.println( printMaxOfArray( arr, 0 ) );

        // System.out.println( printMinOfArray(arr, 0) );

        // System.out.println( findElementInAnArray(arr, 0, 3) );
        // System.out.println( findElementInAnArray_01(arr, arr.length - 1, 3) );

        // System.out.println( firstDataIdxInAnArray(arr, 0, 2) );

        // System.out.println( lastDataIdxInAnArray(arr, 0, 2) );

        // int [] ans = allIndex(arr, 0, 2, 0);
        // display(ans);

        int[] ans = new int[2];
        firstAndLastIdx(arr, 0, 3, ans, false);
        display(ans);
    }
}

// javac practice.java && java practice