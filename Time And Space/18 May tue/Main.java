import java.util.Scanner;

public class Main {

    public static void swap( int[] arr, int i, int j )
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int segregate( int[] arr, int si, int ei, int pIdx )
    {
        swap(arr, pIdx, ei);

        int p = si - 1, itr = si;
        while( itr <= ei )
        {
            if( arr[itr] <= arr[ei] )
               swap(arr, itr, ++p);

            itr++;   
        }
        return p;
    }
    
    public static void quickSelect( int[] arr, int si, int ei, int idx )
    {
        if( si >= ei )
           return;

        int pivot = ei;
        int pIdx = segregate( arr, si, ei, pivot );
        if(pIdx == Idx)
          return;
        
        else if( idx > pIdx ) 
           quickSelect(arr, pIdx + 1, si, idx);
           
        else 
           quickSelect(arr, si, PIdx - 1, idx);
    }

    public static int quickSelect( int[] arr, int k )
    {
        int n = arr.length, idx = n - k;
        quickSelect(arr, 0, n - 1, idx);

        return arr[idx];
    }

    public static in[] mergeTwoSortedArray( int[] A, int [] B )
    {
        if(A.length == 0 || B.length == 0 )
           return A.length == 0 ? B : A;

        int i = 0, j = 0, k = 0;
        int n = A.length, m = B.length, len = n + m;
        int[] ans = new int[len];
        
        
    }
    public static int[] mergeSort( int[] arr, int si, int ei )
    {
        if( si == ei )
        {
            // int[] base = {arr[si]};
            // return base;
            return new int[] {arr[si]};
        }

        int mid = (si + ei) / 2;

        int[] left = mergeSort(arr, si, mid);
        int[] right = mergeSort(arr, mid + 1, ei);

        return mergeTwoSortedArray(left, right);
    }

    public static int targetSumPair( int[] arr, int target )
    {
        
    }
    public static void main(String[] args)
    {

    }
}
