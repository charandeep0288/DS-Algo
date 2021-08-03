import java.util.*;

public class Main16{
    
    public static void printPattern( int n)
    {
        int nor = n; // number of rows
        int nst = 1; // number of stars
        int nsp = (2*n) - 3; // number of spaces
        int val = 1;
        
        for( int cr = 1 ; cr <= nor ; cr++ )  // current row
        {
            for( int cst = 1 ; cst <= nst ; cst++) // currrent star
            {
                System.out.print(val++ + "\t");
            }
            
            for( int csp = 1 ; csp <= nsp ; csp++) // current space
            {
                System.out.print("\t");
            }
            
            // if( cr == nor )
            // {
            //     nst--;
            //     val--;
            // }
            for( int cst = 1 ; cst <= nst ; cst++)
            {
                if( cr == nor && cst == 1)
                {
                    val--;
                    continue;
                }
                
                System.out.print(--val + "\t");
            }
            
            nst++;
            nsp -= 2;
            System.out.println();
        }
    }

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n = scn.nextInt();
     printPattern(n);
     scn.close();
 }
}

// javac Main16.java && java Main16
// javac Main16.java && java Main16 > output16.txt