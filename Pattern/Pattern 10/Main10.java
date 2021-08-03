
// 1 <= n <= 100
//  Also, n is odd

import java.util.*;

public class Main10{
    public static void printPattern(int n)
    {
        int nosp = n/2; // number of outer space
        int nisp = -1;   // number of inner space
        
        for(int cr = 1 ; cr <= n ; cr++)
        {
            for( int cosp = 1 ; cosp <= nosp ; cosp++ ) //current outer space
            {
                System.out.print("\t");
            }
            
                System.out.print("*\t");
            
            for( int cisp = 1 ; cisp <= nisp ; cisp++ ) //current inner space
            {
                System.out.print("\t");
            }
            
            if(cr > 1 && cr < n)
            {
                System.out.print("*\t");
            }
            
            if(cr <= n/2)
            {
                nosp--;
                nisp += 2;
            }
            else
            {
                nosp++;
                nisp -= 2;
            }
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

 // javac Main10.java && java Main10
// javac Main10.java && java Main10 > output10.txt

