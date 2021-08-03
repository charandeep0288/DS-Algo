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

   // post
   public static int minimum( int [] arr, int idx )
   {
       if(  idx == arr.length )
          return (int)1e9;

       int recMin = minimum(arr, idx + 1);
       
       return Math.min(recMin, arr[idx]);
       // if( arr[idx] < nextMin )
       //    nextMin = arr[idx];

       // return nextMin;   
   }


    public static void main(String [] args)
    {
        int n = scr.nextInt();

        int [] arr = input(n);

        System.out.println( minimum(arr, 0) );
    }
}

// javac Main.java && java Main
