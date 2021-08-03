import java.util.Scanner;

public class practice2 {

    public static Scanner scr = new Scanner(System.in);

    public static int decimalToBinary( int n )
    {
        int ans = 0, pow = 1;
        while( n != 0 )
        {
            int lastDigit = n % 2;
            ans += (lastDigit * pow );
            n /= 2;
            pow *= 10;
        }
        return ans;
    }

    public static int decimalToAnyBase( int n, int b )
    {
        int ans = 0, pow = 1;
        while( n != 0 )
        {
            int lastDigit = n % b;
            ans += (lastDigit * pow);
            n /= b;
            pow *= 10;
        }
        return ans;
    }

    public static int binaryToDecimal( int n )
    {
        int ans = 0, pow = 1;

        while( n != 0 )
        {
            int rem = n % 10;
            ans += ( rem * pow );
            n /= 10;
            pow *= 2;
        }
        return ans;
    }

    public static int AnyBaseToDecimal( int n, int b )
    {
        int ans = 0, pow = 1;

        while(n != 0 )
        {
            int rem = n % 10;
            ans += (rem * pow);
            n /= 10;
            pow *= b;
        }
        return ans;
    }

    public static int AnyBaseToAnyBase( int n, int b1, int b2 )
    {
        int decimal = AnyBaseToDecimal(n, b1);
        int finalAns = decimalToAnyBase(decimal, b2);

        return finalAns;
    }

    // ANY BASE ADDITION
    public static int getSum( int n1, int n2, int b)
    {
        int ans = 0, pow = 1, carry = 0;

        while( n1 > 0 || n2 > 0 || carry != 0 )
        {
            int sum = carry + ( n1 % 10 ) + ( n2 % 10 );

            n1 /= 10;
            n2 /= 10;

            int digit = sum % b;
            carry = sum / b;

            ans += (digit * pow);

            pow *= 10;
        }
        return ans; 
    }

    public static int ABSubtration( int n1, int n2, int b )
    {
        int ans = 0, pow = 1, borrow = 0;

        while( n2 > 0 )
        {
            int diff = borrow + ( n2 % 10 ) - ( n1 % 10 );
            if( diff < 0 )
            {
                diff += b;
                borrow = -1;
            }
            else
            {
                borrow = 0;
            }

            n1 /= 10;
            n2 /= 10;

            ans += ( diff * pow );

            pow *= 10;
        }
        return ans;
    }


    public static int[] input( int n )
    {
        int [] arr = new int[n];
        for( int i = 0 ; i < n ; i++ )
        {
            arr[i] = scr.nextInt();
        }
        return arr;
    }

    // SUB ARRAY
    public static void printInRange( int [] arr, int si, int ei )
    {
        while( si <= ei )
        {
            System.out.print(arr[si] + "\t");
            si++;
        }
    }

    public static void subArray( int [] arr )
    {
        int n = arr.length;

        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = i ; j < n ; j++ )
            {
                printInRange(arr, i, j);
                System.out.println();
            }
        }
    } 

    public static int binarySearch( int [] arr, int data )
    {
        int n = arr.length;

        int si = 0, ei = n - 1;
        while( si <= ei )
        {
            int mid = ( si + ei ) / 2;

            if( arr[mid] == data)
               return mid;

            else if( data < arr[mid] )
                ei = mid - 1;
                
            else 
                si = mid + 1;       
        }
        return -1; // data nahi mila array ka kisi bhi index pai
    }

    public static int firstIdx( int [] arr, int data )
    {
        int n = arr.length;

        int si = 0, ei = n - 1;
        while( si <= ei )
        {
            int mid = ( si + ei ) / 2;

            if( arr[mid] == data)
            {
                if( mid - 1 >= 0 && arr[mid - 1] == data)
                    ei = mid - 1;
                
                else
                    return mid;     
            }

            else if( data < arr[mid] )
                ei = mid - 1;
                
            else 
                si = mid + 1;       
        }
        return -1; // data nahi mila array ka kisi bhi index pai
    }

    public static int lastIdx( int [] arr, int data )
    {
        int n = arr.length;

        int si = 0, ei = n - 1;
        while( si <= ei )
        {
            int mid = ( si + ei ) / 2;

            if( arr[mid] == data)
            {
                if( (mid + 1) < n && arr[mid + 1] == data )
                    si = mid + 1;

                else
                   return mid;    
            }

            else if( data < arr[mid] )
                ei = mid - 1;
                
            else 
                si = mid + 1;       
        }
        return -1; // data nahi mila array ka kisi bhi index pai
    }
    public static void firstIndexAndLastIndex( int [] arr, int data )
    {
        int fi = firstIdx( arr, data );
        if( fi == -1 ) // data hai hi nahi array mai
        {
            System.out.println(fi);
            System.out.println("-1");
        }
        else
        {
            int li =  lastIdx( arr, data );
            System.out.println(fi);
            System.out.println(li);
        }
    }
    public static void main(String [] args)
    {
        // int n1 = scr.nextInt();
        // int n2 = scr.nextInt();
        // int b1 = scr.nextInt();


        // System.out.println( decimalToBinary(n1) );

        // System.out.println( decimalToAnyBase(n1, b1) );
 
        // System.out.println( binaryToDecimal(n1) );

        // System.out.println( AnyBaseToDecimal(n1, b1) );

        // int b2 = scr.nextInt();        
        // System.out.println( AnyBaseToAnyBase(n1, b1, b2) );

        // ANY BASE ADDITION
        // System.out.println( getSum( n1, n2, b1) );

        // System.out.println( ABSubtration( n1, n2, b1) );

//----------------------------------------------------------------------------

        // SUBARRAY
        // int [] arr = input(scr.nextInt());
        // subArray(arr);

        // int [] arr = input(scr.nextInt());
        // System.out.println( binarySearch(arr, scr.nextInt()) );

        // int [] arr = input(scr.nextInt());
        // firstIndexAndLastIndex(arr, scr.nextInt());
    }
}

// javac practice2.java && java practice2 < input.txt