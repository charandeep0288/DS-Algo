// n => is odd in input
// 1 <= n <= 100
import java.util.*;

public class Main {

    public static Scanner scr = new Scanner(System.in);
    
    public static void halfDiamand( int n )
    {
        int nst = 1; //number of star
        int nsp = (n-1); // number of spaces  (n-1)
        int nor = n; // number of rows
        
        for( int cr = 1 ; cr <= nor ; cr++) // current row
        {
            for(int csp = 1 ; csp <= nsp ; csp++) // current space
               System.out.print("\t");
            
            for( int cst = 1 ; cst <= nst ; cst++) // current star
               System.out.print("*\t");
            
            nsp--;
            nst += 2;
            System.out.println();
        }
        
    }

    public static void fullDiamand( int n )
    {
        int nst = 1; //number of star
        int nsp = (n/2); // number of spaces  (n-1)
        int nor = n; // number of rows
        
        for( int cr = 1 ; cr <= nor ; cr++) // current row
        {
            for(int csp = 1 ; csp <= nsp ; csp++) // current space
               System.out.print("\t");
            
            for( int cst = 1 ; cst <= nst ; cst++) // current star
               System.out.print("*\t");
            
            if(cr <= nor/2 ) // upper half 
            {
                nsp--;
                nst += 2;
            }
            else             // lower half
            {
                nsp++;
                nst -= 2;
            }
            System.out.println();
        }
        
    }
    

    public static void main(String[] args) {

        // write ur code here
        int n = scr.nextInt();
        //halfDiamand(n);
        fullDiamand(n);

    }
}

// javac Main.java && java Main
// javac Main.java && java Main > output5.txt


/*
Output :-
		*	
	*	*	*	
*	*	*	*	*	
	*	*	*	
		*	
*/