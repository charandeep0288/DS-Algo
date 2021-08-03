import java.util.*;

public class Main{
    
public static Scanner scr = new Scanner(System.in);

public static int power(int num)
{
    int power = 1;
    while(num > 0)
    {
        power *= 10;
        num--;
    }
    return power;
}

public static int inverseOfANumber(int n )
{
    int cd = 0; // Count Digits
    int newnum = 0, rem;
    while( n != 0 )
    {
        cd++;
        rem = n%10;
        int pow = power(rem - 1 );
        newnum += cd * pow;
        n /= 10; 
    }
    return newnum;
}

public static void main(String[] args) {
  // write your code here
  int n = scr.nextInt();
  int res = inverseOfANumber(n);
  System.out.println(res);
 }
}

// javac Main.java && java Main