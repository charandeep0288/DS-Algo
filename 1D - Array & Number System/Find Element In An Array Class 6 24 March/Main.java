import java.util.*;

public class Main{
    
    public static Scanner scr = new Scanner(System.in);
    
    public static int findElementInArray(int [] arr, int data)
    {
        int foundAtIndex = -1; // Matlab Nahi mila abi element 
        for( int i = 0 ; i < arr.length ; i++)
        {
            if( arr[i] == data)
            {
                foundAtIndex = i; // element found at index i 
                break;
            }
        }
        return foundAtIndex;
    }

public static void main(String[] args) throws Exception {
    // write your code here
    int n = scr.nextInt();
    int [] arr = new int[n];
    
    for( int i = 0 ; i < n ; i++ )
    {
        arr[i] = scr.nextInt();
    }
    int data = scr.nextInt();
    
    int res = findElementInArray(arr, data);
    System.out.println(res);
 }

}

// javac Main.java && java Main < input.txt > output.txt