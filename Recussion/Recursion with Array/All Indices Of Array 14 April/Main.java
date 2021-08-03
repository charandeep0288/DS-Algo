import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices( int[] arr, int data, int i, int count )
    {
        if( i == arr.length )
            return new int[count];

        if( arr[i] == data )
            count++;

        int[] recAns = allIndices(arr, data, i + 1, count);
        if( arr[i] == data )
            recAns[count - 1] = i;
        
        return recAns;    
    }

}