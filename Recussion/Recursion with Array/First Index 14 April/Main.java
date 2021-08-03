
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scr.nextInt();
        
        int [] arr = input(n);
        
        int data = scr.nextInt();
        
        System.out.println( firstIndex(arr, 0, data) );
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
    
    public static int firstIndex(int[] arr, int idx, int data){
        
        if( idx == arr.length)
           return -1;
           
        if( arr[idx] == data )
            return idx;
            
        return firstIndex( arr, idx + 1, data);
    }

}

// javac Main.java && java Main
