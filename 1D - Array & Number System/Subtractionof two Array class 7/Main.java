import java.util.*;

public class Main {

    public static  Scanner scr = new Scanner(System.in);

    
    
    public static void subtractionOfTwoArray ( int [] arr1, int [] arr2 )
    {
        int n = arr1.length;
        int m = arr2.length;
        int [] ans = new int[m];

        int borrow = 0;
        int i = arr1.length - 1, j = arr2.length - 1, k = m - 1;

        while( j >= 0 ) // k >= 0
        {
            int diff = borrow + arr2[j] - (i >= 0 ? arr1[i] : 0 );

            if( diff < 0 )
            {
                diff += 10;
                borrow = -1;
            }
            else
            {
                borrow = 0;
            }

            ans[k] = diff;

            i--; 
            j--;
            k--;
        }

        boolean nonZeroFound = false;
        for( int ele : ans)
        {
            if( ele != 0 )
            {
                nonZeroFound = true;
            }

            if(nonZeroFound)
            {
                System.out.println(ele);
            }   
        }
    }
    public static void main( String[] args)
    {
        int [] arr1 = input(scr.nextInt());
        int [] arr2 = input(scr.nextInt());

        subtractionOfTwoArray( arr1, arr2 );

    }
}
