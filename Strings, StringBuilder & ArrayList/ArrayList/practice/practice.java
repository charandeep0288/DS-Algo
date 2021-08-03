import java.util.Scanner;
import java.util.ArrayList;

public class practice {
    
    public static Scanner scr = new Scanner(System.in);

    public static ArrayList<Integer> input( int n )
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for( int i = 0 ; i < n ; i++ )
        {
            arr.add(scr.nextInt());
        }
        return arr;
    }

    public static void swap( ArrayList<Integer> arr, int i, int j )
    {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j,temp);
    }
    public static void removeData(ArrayList<Integer> arr, int data)
    {
        int i = arr.size() - 1;
        while( i >= 0 )
        {
            if( arr.get(i) == data)
            {
                swap(arr, i, arr.size() - 1);
                arr.remove(arr.size() - 1);
            }
            i--;
        }
        System.out.println(arr);
    }

    public static boolean isPrime( int n )
    {
        if( n == 1 )
        {
            return false;
        }
        for( int div = 2 ; div * div <= n ; div ++ )
        {
            if( n % div == 0 )
               return false;
        }
        return true;
    }

    public static void removePrime( ArrayList<Integer> arr )
    {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, n = arr.size() - 1;
        while( i <= n )
        {
            if( !isPrime( arr.get(i) ) )
            {
                ans.add(arr.get(i));
            }
            i++;
        }

        arr.clear(); // O(n)
        for( Integer ele : ans )
             arr.add(ele);
        System.out.println(arr);
    }
    public static void main( String[] args )
    {
        int n = scr.nextInt();
        ArrayList<Integer> al = input(n);
        int data = scr.nextInt();

        // removeData(al, data);

        removePrime(al);
    }
}

// javac practice.java && java practice < input.txt