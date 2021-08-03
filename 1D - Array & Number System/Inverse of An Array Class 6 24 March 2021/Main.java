
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
 
        // 10,20,30,40,50,60 -> 60,50,40,30,20,10
        public static int[] inverseOfArray(int[] arr)
        {
            int[] ans = new int[arr.length];
            for( int i = 0 ; i < arr.length ; i++)
            {
                int idx = arr[i];
                ans[idx] = i;
            }
            return ans;
         }
 
         public static void main(String [] args)
         {
             int n = scr.nextInt();
             int [] arr = new int[n]; 
             input1(arr);
             int[] arr1 = inverseOfArray(arr);
             display2(arr1);
         }
 }
 
 // javac Main.java && java Main < input.txt > output.txt