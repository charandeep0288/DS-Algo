 //Array 
 import java.util.*;

public class class_006
{
    public static Scanner scr = new Scanner(System.in);

    public static void test1(int n)
    {

        // type [] nameOfArray = new type[size]; with default value 0 
        int [] arr = new int[n];   // Array store default value => 0 

        for( int i = 0 ; i < n ; i++)
        { 
            System.out.print(arr[i]);
        }
    }

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
        // for each loop used for :- 
        // 1. only for get, if you try to set value you will gat a beautiful error 
        // 2. automatically increment by 1
        // 3. always move in forward direction
        // 4. range of loop [0, n-1]
        // cannot increment by 2, 3, 4 .....

        for( int ele : arr) // fast and easy to write
        {
            System.out.println(ele + " "); 
            // arr[3] =255; error do not do this in for each loop
        }
        System.out.println(arr); // display address of array

    }

    public static void display1( int [] arr )
    {
        int n = arr.length;
        for( int i = 0 ; i < n ; i++)
        {
            System.out.println(arr[i] + " "); // get
        }
        System.out.println(arr); // display address of array

    }

//----------------------------------------------------------------------------------------------------------------------
    // CLASS 6 24 MARCH, 2021
    // Q1  Find Maximum in an array
    public static int maximum(int [] arr )
    {
        if( arr.length == 0 )
        {
            return Integer.MAX_VALUE;
        }
        // int maxELe = Integer.MIN_VALUE;
        int maxEle = arr[0]; // -10^9
        for( int ele : arr )
        {
            if( ele > maxEle)
            {
                maxEle = ele;
            }
        }
        // System.out.println(maxELe);
        return maxEle;
    }

    public static void maximum2(int [] arr )
    {
        // int maxELe = Integer.MIN_VALUE;
        int maxEle = -(int)1e9; // -10^9
        for( int ele : arr )
        {
            maxEle = Math.max(maxEle, ele);
        }
        System.out.println(maxEle);

    }
    // Q2  Find Minimum in an array
    public static void minimum(int [] arr )
    {
        int min = arr[0];
        for( int i = 1 ; i < arr.length-1 ; i++)
        {
            if( arr[i] < min)
            {
                min = arr[i];
            }
        }
        System.out.println(min);

    }

    // Q3  Find Element in an array return index, otherwise -1;
    public static int findElement(int [] arr, int data )
    {
        int foundAtIndex = -1; // Matlab Nahi mila abi element 
        for( int i = 0 ; i < arr.length-1 ; i++)
        {
            if(arr[i] == data)
            {
                foundAtIndex = i;
                break;
            }
        }
        //System.out.println(foundAtIndex);

        return foundAtIndex;
    }

    public static int spanOfArray(int[] arr)
    {
        int maxEle = -(int)1e9;
        int minEle = (int)1e9;
        for( int ele : arr )
        {
            maxEle = Math.max(maxEle, ele);
            minEle = Math.min(minEle, ele);

        }

        return maxEle - minEle;
    }

    public static void swap(int [] arr, int i, int j)
    {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }

       // 10,20,30,40,50,60 -> 60,50,40,30,20,10
       public static void reverseOfArray(int[] arr)
       {
         int i = 0 , j = arr.length-1;

         while(i < j )
         {
             swap(arr, i , j);
             i++;
             j--;
         }
        }


    // 
    public static int[] InverseOfAnArray( int [] arr )
    {
        int n = arr.length;
        int [] ans = new int[n];

        for( int i = 0 ; i < n ; i++ )
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
        int [] arr1 = new int[100]; //hard code => means size coder ne set kia hai ( BUT WE DONOT DO THIS)
        input1(arr);
         display1(arr);
        //display2(arr1);

        maximum(arr);
        
    }
}

// javac class_006.java && java class_006
// javac class_006.java && java class_006 > outputclass_006.txt
// javac class_006.java && java class_006 < input.txt > outputclass_006.txt