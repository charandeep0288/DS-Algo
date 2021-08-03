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

    public static void printArray( int [] arr, int idx )
    {
        if( idx == arr.length )
           return;
           
        System.out.println(arr[idx]);
        printArray(arr, idx + 1);

    }

    public static void main(String [] args)
    {
        int n = scr.nextInt();

        int [] arr = input(n);


        printArray(arr, 0);
    }
}

// javac Main.java && java Main
