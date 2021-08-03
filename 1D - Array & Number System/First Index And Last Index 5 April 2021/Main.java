import java.util.Scanner;

public class Main{

    public static Scanner scr = new Scanner(System.in);

    public static void input( int [] arr)
    {
        int n = arr.length;

        for( int i = 0 ; i < n ; i++ )
        {
            arr[i] = scr.nextInt();
        }
    }

    
    public static int firstIndex( int [] arr, int data)
    {
        int si = 0;
        int ei = arr.length -1;
        while(si <= ei )
        {
            int mid = (si + ei ) / 2;

            if( arr[mid] == data )
            {
                if(mid - 1 >= 0 && arr[mid-1] == data )
                    ei = mid - 1;
                    
                else
                    return mid;
            }
            
            else if( arr[mid] < data )
            {
                si = mid + 1;
            }
            
            else
            {
                ei = mid - 1;
            }
        }
        return -1;
    }

    public static int lastIndex( int [] arr, int data)
    {
        int si = 0;
        int ei = arr.length -1;
        while(si <= ei )
        {
            int mid = (si + ei ) / 2;

            if( arr[mid] == data )
            {
                if( (mid + 1) < arr.length && arr[mid + 1] == data )
                    si = mid + 1;

                else
                   return mid;   

            }
            
            else if( arr[mid] < data )
            {
                si = mid + 1;
            }
            
            else
            {
                ei = mid - 1;
            }
        }
        return -1;
    }


    public static void firstIndexAndLastIndex( int [] arr, int data )
    {
        int fi = firstIndex(arr, data);
        if( fi == -1 )
        {
            System.out.println(fi);
            System.out.println(-1);
        }
        else
        {
            System.out.println(fi);
            int li = lastIndex(arr, data);
            System.out.println( li );
        }
    }
    public static void main(String[] args)
    {
        int [] arr = new int[scr.nextInt()];

        input(arr);
        int data = scr.nextInt();
        
        firstIndexAndLastIndex(arr, data);
    }
}
