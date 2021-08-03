 //Array 
 import java.util.*;

public class class_005 
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
    public static void main(String [] args)
    {
        int n = scr.nextInt();

        int [] arr = new int[n];
        int [] arr1 = new int[100]; //hard code => means size coder ne set kia hai ( BUT WE DONOT DO THIS)
        input1(arr);
         display1(arr);
        //display2(arr1);
        

    }
}

// javac class_005.java && java class_005
// javac class_005.java && java class_005 > outputclass_005.txt
// javac class_005.java && java class_005 < input.txt > outputclass_005.txt