 import java.util.*;

public class sum{
    public static Scanner scr = new Scanner(System.in);
    
    public static int[] input(int n)
    {
        int [] arr = new int[n];
        
        for( int i = 0 ; i < n ; i++ )
        {
            arr[i] = scr.nextInt();
        }
        return arr;
    }
    
    public static int[] sumOfTwoArray( int [] arr1, int [] arr2 )
    {
        int n = arr1.length;
        int m = arr2.length;
        int p = m + 1;
        int [] ans = new int[p];
        
        int i = arr1.length - 1, j = arr2.length - 1, k = ans.length - 1 ;
        
        int carry = 0;
        
        while( k >= 0)
        {
            int sum = carry + ( i >=0 ? arr1[i] : 0 ) + ( j >= 0 ? arr2[j] : 0 );
            
            ans[k] = sum % 10;
            carry = sum / 10;
            
            i--;
            j--;
            k--;
        }
    
        return ans;
    }
    
    public static void display( int [] ans )
    {
        for( int q = 0 ; q < ans.length ; q++ )
        {
            if( q == 0 && ans[q] == 0 )
            {
                continue;
            }
            System.out.println(ans[q]);
        }
    }

public static void main(String[] args) throws Exception {
    // write your code here
    int n1 = scr.nextInt();
    int [] arr2 = input(n1);
    
    int n2 = scr.nextInt();
    int [] arr1 = input(n2);
    
    int [] ans = sumOfTwoArray( arr1, arr2 );
    display(ans);
    
 }

}