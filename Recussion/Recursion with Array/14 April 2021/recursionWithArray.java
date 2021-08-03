import java.util.Scanner;

public class recursionWithArray{

    public static Scanner scr = new Scanner(System.in);

    public static void printArray( int [] arr, int idx )
    {
        if( idx == arr.length )
           return;

        System.out.println(arr[idx] + "\t");
        printArray(arr, idx + 1);
    }

    public static void printReverseArray( int [] arr, int idx)
    {
        if( idx == -1 )
           return;

        System.out.println(arr[idx] + "\t");   
        printReverseArray(arr, idx - 1);   
    }

    public static void printReverseArray_01( int [] arr, int idx)
    {
        if( idx == arr.length )
           return;

        printReverseArray_01(arr, idx + 1);   
        System.out.print(arr[idx] + "\t");   
    }

    // post
    public static int maximum( int [] arr, int idx )
    {
        if( idx == arr.length )
           return -(int)1e9;
        
        int recMax = maximum(arr, idx + 1);

        return Math.max(recMax, arr[idx]);

        // if( arr[idx] > nextMax )
        //     nextMax = arr[idx];

        // return nextMax;
    }

    // post
    public static int minimum( int [] arr, int idx )
    {
        if(  idx == arr.length )
           return (int)1e9;

        int recMin = minimum(arr, idx + 1);
        
        return Math.min(recMin, arr[idx]);
        // if( arr[idx] < nextMin )
        //    nextMin = arr[idx];

        // return nextMin;   
    }

    // pre
    public static boolean findData( int [] arr, int idx, int data )
    {
        if( idx == arr.length)
            return false;

        if( arr[idx] == data)
           return true;
           
        return findData(arr, idx + 1, data);   

    }

    // pre
    public static boolean findData_01( int [] arr, int idx, int data )
    {
        if( idx == arr.length)
            return false;
           
        boolean recAns = findData_01(arr, idx + 1, data);   
        if(recAns)
            return true;

        return arr[idx] == data;
    }

    public static int firstDataIdx( int [] arr, int idx, int data )
    {
        if(idx == arr.length)
           return -1;

        if(arr[idx] == data)
          return idx;
          
        return firstDataIdx(arr, idx + 1, data);  
    }

    public static int lastDataIdx( int [] arr, int idx, int data )
    {
        if( idx == arr.length )
           return -1;

        int recAns = lastDataIdx(arr, idx + 1, data);
        
        if( recAns != -1 )
            return recAns;

        return ( arr[idx] == data ) ? idx : -1;    
    }

    public static int lastDataIdx_01( int [] arr, int idx, int data )
    {
        if( idx == -1 )
           return -1;


        if( arr[idx] == data )
           return idx;   

        return lastDataIdx_01(arr, idx - 1, data);  
    }

    public static int[] allIndex( int[] arr, int idx, int data, int count) // ?? => cannot be Array, ArrayList
    {
        if( idx == arr.length )
        {
            return new int[count];  // returing an array
        }  

        if( arr[idx] == data )
            count++;

        int [] recAns = allIndex(arr, idx + 1, data, count);
        if( arr[idx] == data)
            recAns[count - 1] = idx;
            
        return recAns;    
    }

    public static boolean firstAndLastIdx( int [] arr, int idx, int data, int [] ans)
    {
        if( idx == arr.length )
            return false;

        if( arr[idx] == data )
           ans[0] = idx;
           
        boolean recAns = firstAndLastIdx(arr, idx + 1, data, ans);
        if(recAns)
           return recAns;
           
        if(arr[idx] == data)
        {
            ans[1] = idx;
            return true;
        }   

        return false;
    }
    public static void main(String [] args)
    {
        int [] arr = {2, 3, 4, 56, 78, 98, -1, -3, -23, 456, 4564, 4, 2 };
                     
        // printArray(arr, 0);

        // printReverseArray(arr, arr.length - 1);
        // printReverseArray_01(arr, 0);

        System.out.println(maximum(arr, 0));

        System.out.println(minimum(arr, 0));

        System.out.println(findData(arr, 0, 2));

        System.out.println(firstDataIdx(arr, 0, 2));

        System.out.println(lastDataIdx(arr, 0, 2));
        System.out.println(lastDataIdx_01(arr, arr.length - 1, 2));

        int [] ans = allIndex( arr, 0, 2, 0 );
        for( int ele : ans )
        {
            System.out.println(ele);
        }

    }
}

// javac recursionWithArray.java && java recursionWithArray
// javac recursionWithArray.java && java recursionWithArray > output.txt