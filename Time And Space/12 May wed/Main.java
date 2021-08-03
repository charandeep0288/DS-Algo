import java.util.Scanner;

public class Main {

    public static Scanner src = new Scanner(System.in);

    public static void swap( int[] arr, int i, int j )
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectionSort_01(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n - 1; j++) 
            {
                if (arr[j] < arr[i])
                    swap(arr, i, j);
            }
        }
    }

    // yaa vala code jada better hai
    public static void selectionSort_02(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) 
            {
                if ( arr[j] < arr[minIdx] )
                    minIdx = j;
            }        
                swap(arr, i, minIdx);
        }
    }


    public static void insertionSort(int[] arr)
    {
        int n = arr.length;

        for( int i = 1 ; i < n ; i++ )
        {
            for( int j = i ; j > 0 ; j-- )
            {
                if( arr[j - 1] > arr[j])
                   swap(arr, j, j - 1);

                else
                   break;   
            }
        }
    }

    // portal ques => insertion sort
    public static void insertionSort_01(int[] arr) {
        //write your code here
        int n = arr.length;
    
            for( int i = 1 ; i < n ; i++ )
            {
                for( int j = i ; j > 0 ; j-- )
                {
                    if( isGreater(arr,j - 1, j) )
                       swap(arr, j - 1, j);
    
                    else
                       break;   
                }
            }
      }
    
      // return true if jth element is greater than ith element
      public static boolean isGreater(int[] arr, int j, int i) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
          return true;
        } else {
          return false;
        }
      }


    public static int PartitionAnArray_01( int[] arr, int data )
    {
        int n = arr.length, p = -1, itr = 0;
        while( itr < n )
        {
            if( arr[itr] <= data )
               swap( arr, itr, ++p );

            itr++;   
        }
        return p;
    }

    public static int PartitionAnArray_02( int[] arr, int data )
    {
        int n = arr.length, p = n - 1, itr = 0;
        while( itr <= p )
        {
            if( arr[itr] <= data )
               itr++;
               
            else 
                swap( arr, itr, p-- );   
        }
        return p; // p pointer aur usase phala vala element sara data se chota hai && p+1 se aga ke sara element data se badra honga
    }
 
    public static void partitionOverPivot( int[] arr, int pivotIdx )
    { 
        int n = arr.length;
        swap(arr, pivotIdx, n - 1 );

        int itr = 0, p = -1, li = n - 1;
        while( itr < li )
        {
            if( arr[itr] <= arr[li])
               swap( arr, itr, ++p );

            itr++;   
        }
        swap(arr, ++p, li);
    }


    public static void display( int[] arr )
    {
        for( int ele : arr )
            System.out.print(ele + " ");

        System.out.println();    
    }
    public static void main(String[] args) 
    {
        int[] arr = { 15, 1, -23, 321, 2, 11, 3, 4, -1, 68, 123, 435};
        int data = 7;
        
        // insertionSort(arr);

        // selectionSort_01(arr); // better hai similarity ka lia
        // selectionSort_02(arr);

        // System.out.println( PartitionAnArray_01(arr, data) );
        // System.out.println( PartitionAnArray_02(arr, data) );
        
        partitionOverPivot(arr, 0);

        display(arr);
    }
}

// javac Main.java && java Main
