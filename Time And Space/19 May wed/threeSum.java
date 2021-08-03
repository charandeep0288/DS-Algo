import java.util.ArrayList;
import java.util.Scanner;

public class threeSum {
    
    public static Scanner scr = new Scanner(System.in);

    public static void swap( int[] arr, int i, int j )
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int segregate( int[] arr, int si, int ei, int pivot )
    {
        swap(arr, pivot, ei);

        int p = si - 1, itr = si;
        while( itr <= ei )
        {
            if(arr[itr] <= arr[ei] )
               swap(arr, ++p, itr);
            
               itr++;
        }
        return p;
    }

    public static void QuickSort( int[] arr, int si, int ei )
    {
        if( si >= ei)
           return;
        
        int pivot = ei;   
        int pIdx = segregate(arr, si, ei, pivot);

        QuickSort(arr, si, pIdx - 1);
        QuickSort(arr, pIdx + 1, ei);
    }

    // int[] arr = {2, 3, 4, 5, 6, 7};
    // O()
    public static ArrayList<int[]> twoSum( int[] arr, int target, int si, int ei )
    {
        ArrayList<int[]> ans = new ArrayList<>(); // arrayList store Address of Array of size 2

        while( si < ei )
        {
            int sum = arr[si] + arr[ei];
            if( sum == target )
            {
                ans.add(new int[]{ arr[si++], arr[ei--] });
            }

            else if( sum > target )
                ei--;
            
            else 
               si++;    
        } 
        return ans;
    }

    public static ArrayList<int[]> threeSum( int[] arr, int target, int si, int ei )
    {
        ArrayList<int[]> ans = new ArrayList<>();

        for( int i = si ; i <= ei ; i++ )
        {
           ArrayList<int[]> smallAns = twoSum(arr, target - arr[i], i + 1 , ei );

           for( int[] a : smallAns )
           {
               ans.add( new int[] { arr[i], a[0], a[1]} );
           }
        }
        return ans;
    }
    
    public static void threeSum( int[] arr, int target)
    {
        int n = arr.length;
        QuickSort(arr, 0, n - 1);

        ArrayList<int[]> ans = threeSum(arr, target, 0, n - 1);

        for( int[] a : ans )
        {
            System.out.println( a[0] + ", " + a[1] + ", " + a[2]);
        }
    }
    
    public static void main(String[] args)
    {
        // int[] arr = { -2, -3, 7, 5, 6, 15, 3, 2, 9, 10, 19 };
        // threeSum(arr, 25);

        // int[] arr ={ 1, 1, 1, 2, 2, 3, 3 };
        // threeSum(arr, 6);

        int[] arr ={ 2, 3, 4, 5, 6 };
        threeSum(arr, 11);
    }
}


// javac threeSum.java && java threeSum