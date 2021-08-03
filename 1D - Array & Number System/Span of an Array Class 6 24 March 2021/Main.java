
import java.util.*;

public class Main{
    public static Scanner scr = new Scanner(System.in);
   
    public static int spanOfArray(int [] arr)
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

public static void main(String[] args) throws Exception {
    // write your code here
    int n = scr.nextInt();
    int [] arr = new int[n];
    for( int i = 0 ; i < n ; i++)
    {
        arr[i] = scr.nextInt();
    }
    
    int res = spanOfArray(arr);
    System.out.println(res);
 }

}
