import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static int [] input( int  n)
    {
        int [] arr = new int[n];

        for( int i = 0 ; i < n ; i++ )
        {
            arr[i] = scr.nextInt();
        }
        return arr;
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

    public static void main(String [] args )
    {
        int n = scr.nextInt();

        int [] arr = input(n);

        int data = scr.nextInt();

        System.out.println( findData(arr, 0, data) );

        // System.out.println( findData_01(arr, 0, data) );
    }
}

// javac Main.java && java Main < input.txt
