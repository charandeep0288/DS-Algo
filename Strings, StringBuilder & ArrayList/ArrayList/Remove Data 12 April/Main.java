 import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void input(ArrayList<Integer> arr, int n)
    {
        for( int i = 0 ; i < n ; i++ )
        {
            int a = scr.nextInt();
            arr.add(a);
        }
    }


    public static void swap(ArrayList<Integer> arr, int i, int j )
    {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void removeData( ArrayList<Integer> arr, int data)
    {
        int i = arr.size() - 1;

        while( i >= 0 )
        {
            if( arr.get(i) == data )
            {
                swap(arr, i, arr.size() - 1 );
                arr.remove(arr.size() - 1 );
            }
            i--;
        } 
        
        for( Integer ele : arr)
        {
            System.out.print(ele + " ");
        }
    }

    public static void main( String [] args)
    {
        int n = scr.nextInt();

        ArrayList<Integer> al = new ArrayList<>();
        input(al, n);

        int data = scr.nextInt();

        removeData(al, data);
    }

}

// javac Main.java && java Main
