
 import java.util.*;
 public class Main3 {
     public static Scanner scr = new Scanner(System.in);
     
     public static void printMirrorPattern(int n )
     {
         int nst = 1; // number of stars
         int nsp = n-1; // number of spaces
         
         for( int cr = 1 ; cr <= n ; cr++) //current row
         {
            for(int csp = 1 ; csp <= nsp ; csp++) // current space
                System.out.print("\t");
                
            for( int cst = 1 ; cst <= nst ; cst++ ) // current star
                System.out.print("*\t");
            
            nsp--;
            nst++;
            System.out.println();
         }
     }
 public static void main(String[] args) {
     int n= scr.nextInt();
     printMirrorPattern(n);
 }
 }
 

// javac Main3.java && java Main3
// javac Main3.java && java Main3 > output3.txt 