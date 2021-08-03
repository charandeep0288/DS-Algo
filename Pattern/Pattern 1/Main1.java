import java.util.*;
 public class Main1 {
     public static Scanner scr = new Scanner(System.in);
     
     public static void printPattern(int n )
     {
         int nst = 1;
         int nr = n;
         
         for( int cr = 1 ; cr <= nr ; cr++)
         {
            for( int cst = 1 ; cst <= nst ; cst++ )
                System.out.print("*\t");
            
            nst++;
            System.out.println();
         }
     }
 public static void main(String[] args) {
     int n= scr.nextInt();
     printPattern(n);
 }
 }

 // javac Main1.java && java Main1
// javac Main1.java && java Main1 > output1.txt
