 import java.util.Scanner;
 import java.util.ArrayList;

public class ArrayList1 {

    public static Scanner scr = new Scanner(System.in);
    
    public static void basicFunction()
    {
        ArrayList <Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(20);
        arr.add(30);

        System.out.println(arr);

        // when we write int instead of Integer 
        // it means we are typecasting each Integer ArrayList element to int
        for(Integer e : arr ) // prefered Interger to use
        {
            System.out.println(e);
        }
        System.out.println(arr.size()); // return size of that arraylist

        System.out.println(arr.get(1)); // to get that index element og arraylist

        arr.remove(1); // O(n)
        System.out.println(arr);
    }

    public static void input(ArrayList<Integer> arr)
    {
        for( int i = 0 ; i < 15 ; i++ )
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

    public static void removeData()
    {
        ArrayList<Integer> arr = new ArrayList<>();

        // Input in ArrayList 
        for( int i = 0 ; i < 15 ; i++ )
        {
            int a = scr.nextInt();
            arr.add(a);
        }

        int data = scr.nextInt();

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
    public static void main(String [] args)
    {
        // Input in ArrayList 
        ArrayList<Integer> arr = new ArrayList<>();

        input(arr);
        // basicFunction();

        // removeData();
        removePrimes(arr);

        System.out.print(arr);

    }
}

// javac ArrayList1.java && java ArrayList1 < input.txt
