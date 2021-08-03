import java.util.Scanner;

public class practice {

    public static Scanner scr = new Scanner(System.in);

    public static int [] input( int n )
    {
        int [] arr = new int[n];
        for( int i = 0 ; i < n ; i++ )
        {
            arr[i] = scr.nextInt();
        }
        return arr;
    }

    public static void display( int[] arr)
    {
        for( int ele : arr) 
        {
            System.out.println(ele);
        }
    }
    public static int maximum( int [] arr )
    {
        if( arr.length == 0 )
        {
            return -(int)1e9;
        }
        int max = -(int)1e9;

        int n = arr.length;
        for( int i = 0 ; i < n ; i++ )
        {
            if( arr[i] > max )
            {
                max = arr[i];
            }

        }
        return max;
    }

    public static int maximum_02( int [] arr )
    {
        int max = -(int)1e9;

        for( int ele : arr )
        {
            max = Math.max(ele, max);
        }
        return max;
    }

    public static int minimum( int [] arr )
    {
        int min = (int)1e9;

        for( int ele : arr )
        {
            min = Math.min(ele, min);
        } 
        return min;
    }

    public static int findInAnArray( int [] arr, int data)
    {
        int foundAtIdx = -1;

        int n = arr.length;
        for( int i = 0 ; i < n ; i++ )
        {
            if(arr[i] == data)
                foundAtIdx = i;
        }
        return foundAtIdx;
    }

    public static int spanOfAnArray( int[] arr )
    {
        int max = -(int)1e9;
        int min = (int)1e9;

        for( int ele : arr )
        {
            max = Math.max(ele, max);
            min = Math.min(ele, min);
        }
        return (max - min);
    }

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

    public static void swap( int [] arr, int i, int j )
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] reverseOfAnArray( int [] arr )
    {
        int n = arr.length; 

        int i = 0;
        int j = n - 1;
        while( i < j)
        {
            swap(arr, i, j);
            i++;
            j--;
        }
        return arr;
    }
    
    public static void reverseOfAnArray_01( int [] arr, int i, int j )
    {
        while( i < j )
        { 
            swap(arr, i, j);
            i++;
            j--;
        }
    }
  
    public static void rotateAnArray( int [] arr, int k )
      {
          int n = arr.length;
          k %= n;
          if( k < 0 )
          {
              k += n;
          }
          reverseOfAnArray_01( arr, 0, n - 1 );
          reverseOfAnArray_01( arr, 0, k - 1 );
          reverseOfAnArray_01( arr, k, n - 1 );
      }

    public static int maximum( int i, int j )
    {
        int max = j;
        if( i > max )
            max = i;
            
        return max;
    }
      public static void sumOfTwoArray( int [] arr1, int[] arr2 )
      {
          int n = arr1.length;
          int m = arr2.length;
          int p = maximum(n,m) + 1;
          
          int [] ans = new int[p];
          int sum = 0, carry = 0;
          int i = n-1, j = m - 1, k = p - 1;
          
          while( k >= 0 )
          {
              sum = carry + ( i >= 0 ? arr1[i] : 0 ) + ( j >= 0 ? arr2[j] : 0 );
              
              ans[k] = sum % 10;
              carry = sum / 10;
              
              i--;
              j--;
              k--;
          }
          
        for( i = 0 ; i < n ; i++ )
        {
             if( i == 0 && ans[i] == 0 )
                continue;
                
            System.out.println(ans[i]);
        }
      }


      public static void diffOfTwoArray( int [] arr1, int [] arr2 )
      {
          int n = arr1.length;
          int m = arr2.length; 
          int p = m;
          
          int [] ans = new int[p];
          
          int i = n - 1, j = m - 1, k = p - 1;
          int diff = 0, borrow = 0;
          
          while( k >= 0 )
          {
              diff = borrow + arr2[j] - ( i >= 0 ? arr1[i] : 0 );
              
              if( diff < 0 )
              {
                  borrow = -1;
                  diff += 10;
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
//--------------------------------------------------------------------------------------------------------
    // NUMBER SYSTEM
    public static int digitFrequency( int n, int data )
    {
        int count = 0;
        while( n != 0 )
        {
            int lastdigit = n % 10;
            if( lastdigit == data )
                count++;
                
            n /= 10;    
        }
        return count;
    }

    public static void digitFreqForQuery( long n, int [] query)
    {
        int [] freq = new int[10];

        while( n != 0 )
        {
            long digit =  n % 10;
            freq[(int)digit]++;  // typecasting
            n /= 10;
        }

        // DISPLAY
        for( int q : query)
        {
            System.out.println(q + " -> " + freq[q] + " times");
        }
    }

    public static void main(String [] args )
    {
        // int n = scr.nextInt();

        // int [] arr = input(n);
        // int data = scr.nextInt();

        // System.out.println( maximum(arr) );

        // System.out.println( minimum(arr) );
        
        // System.out.println( findInAnArray(arr, data));

        // System.out.println( spanOfAnArray( arr ) );

        // int [] ans =  InverseOfAnArray(arr);
        // display(ans);

        // int k = scr.nextInt();
        // rotateAnArray(arr, k);
        // display(arr);

        // System.out.println( reverseOfAnArray(arr) );
        // display(arr);

        // int [] arr1 = input(scr.nextInt());
        // int [] arr2 = input(scr.nextInt());
        // sumOfTwoArray(arr1, arr2);

        // diffOfTwoArray(arr1, arr2);

        // NUMBER SYSTEM ------------------------------------------------------
        // digitFrequency(scr.nextInt(), scr.nextInt());

        // int [] query = input(scr.nextInt());
        // digitFreqForQuery(scr.nextLong(), query);

    }
}

// javac practice.java && java practice < input.txt