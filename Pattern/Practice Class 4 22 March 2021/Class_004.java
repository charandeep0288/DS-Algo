// Class Work => 1, 2, 3, 4, 5, 6, 7, 8, 9, 15 Ques
// Home Work => 10, 11, 12 Ques

import java.util.*;

public class Class_004 {
    public static Scanner scr = new Scanner(System.in);

    public static void printPattern(int n)
    {
        int nst = n; // Number of Star

        for(int row = 1 ; row <= n ; row++ )
        {
            for(int cst = 1 ; cst <= nst ; cst++ )
               System.out.print("*");

             nst = n;
             System.out.println();  
        }
        /* 
        5
*****
*****
*****
*****
*****
        */
    }


    public static void printTrianglePattern(int n)
    {
        int nst = 1; // Number of Star

        for(int row = 0 ; row <= n ; row++ )
        {
            for(int cst = 1 ; cst <= nst ; cst++ )// count of star
               System.out.print("*");

             nst++;
             System.out.println();  
        }
        /*
        5
*
**
***
****
*****
******
        */
    }


    public static void printInvertedTrianglePattern(int n)
    {
        int nst = n; // Number of Star

        for(int row = 0 ; row <= n ; row++ )
        {
            for(int cst = 1 ; cst <= nst ; cst++ )
               System.out.print("*");

             nst--;
             System.out.println();  
        }
        /*
        5
*****
****
***
**
*
        */
    }

    public static void printMirrorPattern(int n)
    {
        int nst = 1; // number of star
        int nsp = n-1; // number of space

        for(int row = 1 ; row <= n ; row++)
        {
            for(int csp = 1 ; csp <= nsp ; csp++)
                System.out.print("\t");

            for(int cst = 1 ; cst <= nst ; cst++ )
                System.out.print("*\t");
                
            nst++;
            nsp--;
            System.out.println();    

        }
        /*
        5
                                *
                        *       *
                *       *       *
        *       *       *       *
*       *       *       *       *

        */
    }

    
    public static void main(String[] args)
    {
        int n = scr.nextInt();
        // printPattern(n);
        // printTrianglePattern(n);
        // printInvertedTrianglePattern(n);
        printMirrorPattern(n);

    }
}

// javac Class_004.java && java Class_004
