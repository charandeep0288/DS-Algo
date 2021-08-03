import java.util.Scanner;
  
  public class Main{
  
  public static Scanner scr = new Scanner(System.in);
  
  public static boolean isPrime( int n )
  {
      for( int div = 2 ; div * div <= n ; div++ )
      {
          if( n % div == 0 )
          {
              return false;
          }
      }
      return true;
  }
  
  public static void solve()
  {
      int n = scr.nextInt();
      // boolean res = isPrime(n);
      if( isPrime(n) )// if(res == true)
      {
          System.out.println("prime");
      }
      else
      {
          System.out.println("not prime");
      }
  }
  public static void main(String[] args) {
     int t = scr.nextInt();
     for( int i = 0 ; i < t ; i++ )
     {
         solve();
     }
  
       // write ur code here
  
   }
  }

  // javac Main.java && java Main