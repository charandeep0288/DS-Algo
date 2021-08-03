
 import java.util.*;

public class Main {
    public static Scanner scr = new Scanner(System.in);

    public static void input1( int [] arr )
    {
        int n = arr.length;
        for( int i = 0 ; i < n ; i++)
        {
            arr[i] = scr.nextInt(); //set 
        }

    }

    public static void display2( int [] arr )
    {
        for( int ele : arr) // fast and easy to write
        {
            System.out.print(ele + " "); 
        }
    }

    public static void swap(int [] arr, int i, int j)
    {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }

       // 10,20,30,40,50,60 -> 60,50,40,30,20,10
       public static void reverseOfArray(int[] arr){
         int i = 0 , j = arr.length-1;

         while(i < j )
         {
             swap(arr, i , j);
             i++;
             j--;
         }
        }

        public static void main(String [] args)
        {
            int n = scr.nextInt();
            int [] arr = new int[n]; 
            input1(arr);
            reverseOfArray(arr);
            display2(arr);
        }
}

// javac Main.java && java Main
// javac Main.java && java Main < input.txt > output.txt