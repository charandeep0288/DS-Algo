import java.util.*;

public class rotateANumber {
  public static Scanner scr = new Scanner(System.in);

  public static int countDigitsInANumber(int n)
  {
      int len = 0;
      while(n != 0)
      {
          len++;
          n /= 10;
      }
      return len;
  }
  
  public static int rotateANumber01(int n, int r)
  {
      int len =  countDigitsInANumber(n);

      r %= len;
      if(r < 0)
      {
          r += len;
      }

      int mul = 1;
      int div = 1;
       
      for(int i = 1 ; i <= len ; i++ )
      {
          if(i <= r)
            div *= 10;

          else
            mul *= 10; 
      }

      int a = n%div;
      int b = n/div;

      return (a*mul) + b;
  }
  public static void main(String [] args)
  {
      int n = scr.nextInt();
      int r = scr.nextInt();  // k
      
      int res = rotateANumber01(n, r);
      System.out.println(res);
  }
}

// javac rotateANumber.java && java rotateANumber
