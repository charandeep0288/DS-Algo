import java.util.Scanner;
import java.util.Random;

public class QuickSort {

    public static Scanner scr = new Scanner(System.in);
    public static Random rand = new Random();

    public static void swap(int[] arr, int i, int j )
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partitionOverPivot( int[] arr, int si, int ei, int pIdx)
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
    
    public static void quickSort( int[] arr, int si, int ei )
    {       
        if( si >= ei )
           return;

        int pIdx = ei; 
        // int pIdx = rand.nextInt(ei - si + 1) + si // (int)(Math.random() * (ei - si) + si ) pivot as random index of array 
        // int pIdx = si; // pivot as starting index of array
        // int pIdx = (si + ei) / 2; // taking mid index of array as pivot

        int p = partitionOverPivot(arr, si, ei, pIdx);

        quickSort(arr, si, p - 1); // left call
        quickSort(arr, p + 1, ei); // right call
    }

    public static void main(String[] args)
    {
        int[] arr = { -12, 2, 7, 4, 34, 23, 0, 1, -1, -50, 16, 23, 7, 4, 2, 3 };

        quickSort(arr, 0, arr.length - 1);
        // quickSort(arr, 4, arr.length - 4);

        for( int ele : arr )
        {
            System.out.print(ele + " ");
        }
    }
}


// javac QuickSort.java&& java QuickSort


