 import java.util.*;
    
    public class Main{
        public static Scanner scr = new Scanner(System.in);
    
    public static void printGCDandLCM(int n1, int n2)
    {
        int rem = 0;
        int temp1 = n1, temp2 = n2;
        while(temp1 % temp2 != 0 )
        {
            rem = temp1 % temp2;
            temp1 = temp2;
            temp2 = rem;
        }
        int gcd = temp2;
        int lcm = (n1*n2) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
    
    public static void main(String[] args) {
      // write your code here
      int num1 = scr.nextInt();
      int num2 = scr.nextInt();
      printGCDandLCM(num1, num2);
     }
    }

    // javac Main.java && java Main