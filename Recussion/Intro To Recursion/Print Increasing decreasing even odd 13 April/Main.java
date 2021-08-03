
import java.util.Scanner;

 public class Main {
     
     public static Scanner scr = new Scanner(System.in);
 
     public static void main(String[] args) throws Exception {
         // write your code here
         int n = scr.nextInt();
 
         printIncreasingDecreasingEvenOdd(1, n);
     }
 
     public static void printIncreasingDecreasingEvenOdd(int a, int b){
         if( a  > b )
            return;

         if( a % 2 == 0 )   // even
            System.out.println(a);   

         printIncreasingDecreasingEvenOdd(a + 1, b);

         if(a % 2 != 0)   // odd
            System.out.println(a);    
     }
 
 }
 
 // javac Main.java && java Main