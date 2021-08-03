import java.util.Scanner;

public class practice {
    
    public static Scanner scr = new Scanner(System.in);

    public static void printIncreasing(int a, int b)
    {
        if( a > b )
           return;
        System.out.println(a);

        printIncreasing(a + 1, b);
    }
    public static void printIncreasing( int n )
    {
        if(n == 0)
          return;

        printIncreasing(n - 1);

        System.out.println(n);

    }

     
    public static void printIncDec_03( int a, int b )
    {
        if( a > b )
            return;
            
        System.out.println(a);
        printIncDec_03(a + 1, b);
        System.out.println(a);
    }

    public static void printIncDec_01( int i, int n )
    {
        if( i > n )
           return;

        System.out.println(i);
        printIncDec_01(i + 1, n);
        System.out.println(i);   
        
    }

    // without repeated digits in middle
    public static void printIncDec_02( int a, int b )
    {
        if( a > b )
           return;

        System.out.println(a);
        printIncDec_02(a + 1, b);
        
        if(a != b)
            System.out.println(a);   
    }

    public static void printDecInc_01( int n )
    {
        if( n == 0 )
           return;

        System.out.println(n);
        printDecInc_01( n - 1 ); 
        System.out.println(n);   
    }

    public static void printDecInc_02( int a, int b )
    {
        if( a > b )
           return;
        
        System.out.println(b);
        printDecInc_02(a, b - 1);
        System.out.println(b);   
    }


    public static void printIncDecEvenOdd( int a, int b )
    {
        if( a > b )
           return;

        if(a % 2 == 0 )
           System.out.println(a);
           
        printIncDecEvenOdd(a + 1, b);
        
        if( a % 2 != 0 )
            System.out.println(a);
    }

    public static int factorial_01( int n)
    {
        if( n == 0 )
            return 1;

        int recAns = factorial_01( n - 1 );

        return recAns * n;
    }

    public static int factorial_02( int fact, int n)
    {
        if( fact > n )
            return 1;

        int recAns = factorial_02( fact + 1, n );

        return recAns * fact;
    }

    public static int factorial_03( int n )
    {
        return n != 0 ? n * factorial_03( n - 1 ) : 1;
    }

    public static int powerLinear_01( int a, int b )
    {
        if( b == 0 )
            return 1;

        int recAns = powerLinear_01( a, b - 1);

        return recAns * a;
    }

    public static int powerLinear_02( int a, int b )
    {
        return b != 0 ? a * powerLinear_02( a, b - 1 ) : 1;
    }

    public static int powerLograthmic_01( int a, int b )
    {
        if( b == 0 )
           return 1;

        int recAns = powerLograthmic_01(a, b/2);
        if( b % 2 != 0 )
           return recAns * recAns * a;   

        return recAns * recAns;   
    }

    public static int powerLograthmic_02( int a, int b )
    {
        if( b == 0 )
           return 1;

        int recAns = powerLograthmic_02(a, b / 2);
        recAns *= recAns;
        
        return b % 2 == 0 ? recAns : recAns * a;
    }
    public static void main(String [] args)
    {
        // printIncreasing(2, 7);
        // printIncreasing(5);

        // printIncDec_03(2, 7);
        // printIncDec_02(2, 7);
        // printIncDec_01(1, 5);

        // printDecInc_01(5);
        // printDecInc_02(1, 5);

        // printIncDecEvenOdd(2, 7);

        // System.out.println( factorial_01(5) );
        // System.out.println( factorial_02(1, 5) );
        // System.out.println( factorial_03(5) );

        // System.out.println( powerLinear_01(2, 5) ); 
        // System.out.println( powerLinear_02(2, 5) ); 

        System.out.println( powerLograthmic_01(2, 5) );
        System.out.println( powerLograthmic_02(2, 5) );
    }
}

// javac practice.java && java practice