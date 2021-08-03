 import java.util.Scanner;

public class Main {
 
    public static Scanner scr = new Scanner(System.in);

    public static int [] input(int n)
    {
        int [] arr = new int[n];

        for( int i = 0 ; i < n ; i++ )
        {
            arr[i] = scr.nextInt();
        }
        return arr;
    }

    public static void printReverseArray( int [] arr, int idx )
    {
        if( idx == arr.length )
           return;

        printReverseArray(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    public static void printReverseArray_01( int [] arr, int idx)
    {
        if( idx == -1 )
           return;

        System.out.println(arr[idx] + "\t");   
        printReverseArray_01(arr, idx - 1);   
    }

    public static void main(String [] args)
    {
        int n = scr.nextInt();

        int [] arr = input(n);


        // printReverseArray(arr, 0);
        printReverseArray_01(arr, n - 1);
    }
}

// javac Main.java && java Main
