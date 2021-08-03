import java.util.Scanner;

public class QuickSort {

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
        while( itr <= ei)
        {
            if(arr[itr] <= arr[ei])
               swap(arr, ++p, itr);

            itr++;   
        } 
        return p;
    }

    public static void QuickSort( int[] arr, int si, int ei)
    {
        if( si > ei )
           return;

        int pivot = ei;   
        int p = segregate(arr, si, ei, pivot);

        QuickSort(arr, si, p - 1);
        QuickSort(arr, p + 1, ei);
    }
    public static void main(String[] args)
    {

    }
}
