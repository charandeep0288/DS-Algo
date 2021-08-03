
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);
    
    public static void input(ArrayList<Integer> arr, int n)
    {
        for( int i = 0 ; i < n ; i++ )
        {
            arr.add(scr.nextInt());
        }
    }

    public static boolean isPrime( int num )
    {
        for(int div = 2 ;num >= div * div ; div++)
            if( num % div == 0 )
                return false;

        return true;
    }
    // with extra space
    public static void removePrimes(ArrayList<Integer> arr)
    {
         // WITH EXTRA SPACE
        ArrayList<Integer> ansArr = new ArrayList<>();

        for( Integer ele : arr )
        {
            if( !isPrime(ele) )
            {
                ansArr.add(ele);
            }
        }
        // arr.clear(); // O(n)
        while(arr.size() != 0) arr.remove(arr.size() - 1);
    
        for( int ele1 : ansArr )
           arr.add(ele1);
    }
    
	public static void main(String[] args) {
	
		int n = scr.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		input(al, n);
		removePrimes(al);
		System.out.println(al);
	}

}

// javac Main.java && java Main