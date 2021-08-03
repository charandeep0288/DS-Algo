
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scr.nextInt();
        
        int [] arr = input(n);
        
        int data = scr.nextInt();
        
        System.out.println( lastIndex(arr, 0, data) );
        System.out.println( lastDataIdx_01(arr, arr.length - 1, data) );

    }

    public static int[] input( int n )
    {
        int [] arr = new int[n];
        
        for( int i = 0 ; i < n  ; i++ )
        {
            arr[i] = scr.nextInt();
        }
        return arr;
    }

    public static int lastDataIdx_01( int [] arr, int idx, int data )
    {
        if( idx == -1 )
           return -1;


        if( arr[idx] == data )
           return idx;   

        return lastDataIdx_01(arr, idx - 1, data);  
    }
    
    public static int lastIndex(int[] arr, int idx, int data){
        
        if( idx == arr.length)
           return -1;
           
        int recAns = lastIndex( arr, idx + 1, data);
        
        if( recAns != -1 )
           return recAns;
           
        return ( arr[idx] == data )? idx : -1;     
    }

}

// javac Main.java && java Main
