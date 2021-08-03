
 import java.util.*;

public class Main {

    public static Scanner scr = new Scanner(System.in);
     
    public static int [] input( int n )
    {
        int [] arr = new int[n];
        for( int i = 0 ; i< n ; i++) 
        {
            arr[i] = scr.nextInt();
        }
        return arr;
    }

    public static int binarySearch( int [] arr, int data )
    {
        int low = 0; // starting index
        int high = arr.length - 1;    // ending index 

        while( low <= high )
        {
            int mid = ( low + high ) / 2;

            // System.out.println("mid" + mid);
            if( data == arr[mid])
            {
                return mid;
            }

            if(data < arr[mid])
            {
                high = mid - 1;
            }
            else if( data > arr[mid] )
            {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = scr.nextInt();

        int[] arr = input(n);

        // System.out.println(arr); // [I@4cdbe50f
        int data =scr.nextInt();

        int res = binarySearch( arr, data);
        System.out.println(res);
    }
}

// javac Main.java && java Main < input.txt > output.txt 
