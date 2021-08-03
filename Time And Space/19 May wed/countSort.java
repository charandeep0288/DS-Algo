import java.util.*;

public class countSort {
    public static void countSum( int[] arr, int q )
    {
        int n = arr.length;
        int[] freq = new int[q];

        for( int i = 0 ; i < n ; i++ )
        {
            freq[arr[i]]++;
        }

        for( int i = 0 ; i < freq.length ; i++ )
        {
            for( int j = 0 ; j < freq[i] ; j++ )
            {
                System.out.print(i + " ");
            }
        }
    }

    public static void countSumForNeg( int[] arr )
    {
        int maxNum = -(int)1e9;
        int minNum = (int)1e9;

        for( int ele : arr )
        {
            maxNum = Math.max(maxNum, ele);
            minNum = Math.min(minNum, ele);
        }

        int range = maxNum - minNum + 1;
        int[] freq = new int[range];
        for( int ele : arr )
        {
            freq[ele - minNum]++;
        }

        int idx = 0;
        
    }


    public static void main(String[] args )
    {
    //     int[] arr = {17, 9, 8, 5, 1, 2, 9, 3, 17, 6, 0, 20, 4, 5, 3, 11, 3, 2 };
    //     countSum( arr, 20);   

        // int [] arr1 = { 5, -3, -2, 1, 10, 5, 6, 7, 8, -1, -2, -3, 0};
        // countSumForNeg(arr1, -3, 10);
    }
}

// javac countSort.java && java countSort