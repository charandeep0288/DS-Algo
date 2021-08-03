import java.util.*;
  
  public class Main{
      public static Scanner scr = new Scanner(System.in);
      
      public static boolean pythagoreanTriplet01(int a, int b, int c)
      {
          int max = Math.max(Math.max(a, b), c);
          
          if(max == a && ((a*a) == (b*b) + (c*c)) )  return true;
          
          else if(max == b && ((b*b) == (c*c) + (a*a)) )  return true;
          
          else if(max == c && ((c*c) == (b*b) + (a*a)) )  return true;
          
          else    return false;
      }
      
      public static boolean pythagoreanTriplet02(int a, int b, int c)
      {

   return ((a*a) == (b*b) + (c*c)) || ((b*b) == (c*c) + (a*a)) || ((c*c) == (b*b) + (a*a));
      }
      
  
  public static void main(String[] args) {
    // write your code here 
    int a = scr.nextInt(), b = scr.nextInt(), c = scr.nextInt();
    // boolean res = pythagoreanTriplet01(a, b, c);
    boolean res = pythagoreanTriplet02(a, b, c);
    System.out.println(res);
   }
  }
  
  
  // package Getting Started.Java.Pythagorean Triplet;
  
  
  
  