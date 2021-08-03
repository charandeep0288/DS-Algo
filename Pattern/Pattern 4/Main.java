import java.util.*;

public class Main {
    
    public static void printPattern(int n)
    {
        int nst = n; // number of star
        int nsp = 0; // number of spaces
        
        for( int cr = 1 ; cr <= n ; cr++) // current row
        {
            for(int csp = 1 ; csp <= nsp ; csp++)   //current space
               System.out.print("\t");
              
            for( int cst = 1 ; cst <= nst ; cst++) // current star
               System.out.print("*\t");
               
            nsp++;
            nst--;
            System.out.println();
        }
    }
    

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // write ur code here
        int n = scr.nextInt();
        printPattern(n);
        scr.close();

    }
}

// javac Main.java && java Main
// javac Main.java && java Main > output4.txt