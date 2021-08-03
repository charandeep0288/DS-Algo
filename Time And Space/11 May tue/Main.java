import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);
    
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort01( int [] arr)
    {
        int p = -1, itr = 0;
        while(itr < arr.length)
        {
            if(arr[itr] == 0)
                swap(arr, itr, ++p);
            itr++;    
        }
    }

    public static void sort012( int[] arr )
    {
        int n = arr.length, p1 = -1, p2 = n - 1, itr = 0;
        
        while( itr <= p2 )
        {
            if( arr[itr] == 0 )
               swap(arr, itr++, ++p1);
            
            else if( arr[itr] == 2 )
                swap(arr, itr, p2--);
                
            else
                itr++;    
        }
    }

    // better than other 2 merge sorts nicha vala
    public static int[] mergeTwoSortedArray_01( int[] arr1, int[] arr2 )
    {
        int n = arr1.length;
        int m = arr2.length;
        int o = n + m;

        int[] ans = new int[o];

        int i = 0, j = 0, k = 0; 
        while( i < n && j < m )
        {
            if( arr1[i] < arr2[j])
                ans[k++] = arr1[i++]; 

            else // if( arr1[i] >= arr2[j] )
                ans[k++] = arr2[j++];
        }

        while( i < n )
          ans[k++] = arr1[i++];

        while( j < m )
           ans[k++] = ans[j++];

        return ans;   
    }


    public static int[] mergeTwoSortedArray_02( int[] arr1, int[] arr2 )
    {
        int n = arr1.length;
        int m = arr2.length;
        int len = n + m;
        int[] ans = new int[len];

        long val1 = 0, val2 = 0;
        int i = 0, j = 0, k = 0;
        while( k < len ) // i < n || j < m 
        {
            val1 = i < n ? arr1[i] : (long)1e18;
            val2 = j < m ? arr2[j] : (long)1e18;
            if( val1 < val2)
            {
                ans[k++] = (int) val1;
                i++;
            }
            else
            {
                ans[k++] = (int) val2;
                j++;
            }

        }
        return ans;
    } 

    public static int[] mergeTwoSortedArray_03( int[] arr1, int[] arr2 )
    {
        int n = arr1.length, m = arr2.length;
        int len = n + m;
        int[] ans = new int[len];
        int i = 0, j = 0, k = 0;

        while( k < len ) // i < n || j < m
        {
            if( i == n )
               ans[k++] = arr2[j++];

            else if( j == m )
                ans[k++] = arr1[i++];  
                
            else if( arr1[i] < arr2[j] )
               ans[k++] = arr1[i++];
               
            else
               ans[k++] = arr2[j++];   
        }

        return ans;
    } 

    public static void display( int[] arr ) 
    {
        int n = arr.length;
        for(int i = 0 ; i < n ; i++ )
        {
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort( int[] arr)
    {
        int n = arr.length;
        //  li => last index

        for( int li = n - 1 ; li > 0 ; li-- )
        {
            for( int i = 1 ; i <= li ; i++ )
            {
                if( arr[i - 1] > arr[i] )
                   swap(arr, i, i - 1);
            }
        }
    }

    // bubble sort optimized version 
    public static void bubbleSort_optimised( int[] arr)
    {
        int n = arr.length;
        //  li => last index

        for( int li = n - 1 ; li > 0 ; li-- )
        {
            boolean isSwapDone = false;
            for( int i = 1 ; i <= li ; i++ )
            {
                if( arr[i - 1] > arr[i] )
                {
                   swap(arr, i, i - 1);
                   isSwapDone = true;
                }   
            }
            if(!isSwapDone)
               break;
        }
    }


    public static void main(String[] args)
    {
        int[] arr1 = {1,2,32,54,532,3432};
        int[] arr2 = {32,43,323,450};

        // int [] arr = mergeTwoSortedArray_01(arr1, arr2);
        // int [] arr = mergeTwoSortedArray_02(arr1, arr2);
        // int [] arr = mergeTwoSortedArray_03(arr1, arr2);
        
        int[] arr = {2, -1, 2, -32, 54, 532, -50, 332, 20, 500, 0, 54, 2};
        // bubbleSort(arr);
        // bubbleSort_optimised(arr);
        
        display(arr);
    }
}

// javac Main.java && java Main