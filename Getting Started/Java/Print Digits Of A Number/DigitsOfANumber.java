import java.util.*;

public class DigitsOfANumber {
  public static Scanner scr = new Scanner(System.in);

  public static int powerEqualDigits(int n)
  {
    int pow = 1;    
                    // n /= 10;
    while(n >= 10)  // while(n > 0)  while(n != 0)
    {
      pow *= 10;
      n /= 10; 
    }
    return pow;
  }

  public static void printDigitsOfANumber(int n)
  {
    int pow = powerEqualDigits(n);
    
    while(pow != 0) // for special case   n=10000
    {
      int digit = n/pow;
      n = n%pow;
      pow /= 10;
      System.out.println(digit);
    }

  }
  public static void main(String [] args)
  {
    int n = scr.nextInt();
    printDigitsOfANumber(n);

  }
}

// javac DigitsOfANumber.java && java DigitsOfANumber