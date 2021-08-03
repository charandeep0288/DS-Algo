
 import java.util.*;
 public class Main2 {
     public static Scanner scr = new Scanner(System.in);
     
     public static void printPattern(int n )
     {
         int nst = n; // number of stars
         int nr = n; // number of rows
         
         for( int cr = 1 ; cr <= nr ; cr++) // current row
         {
            for( int cst = 1 ; cst <= nst ; cst++ ) // current star
                System.out.print("*\t");
            
            nst--;
            System.out.println();
         }
     }
 public static void main(String[] args) {
     int n= scr.nextInt();
     printPattern(n);
 }
 }

 
 // javac Main2.java && java Main2
// javac Main2.java && java Main2 > output2.txt 