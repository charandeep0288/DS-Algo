 
 import java.util.*;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void numberDiamond(int n)
    {
        int nst = 1;
        int nsp = n/2;
        int nor = n;
        int val = 0;

        for(int cr = 1 ; cr <= nor ; cr++)
        {
            for(int csp = 1 ; csp <= nsp ; csp++)
               System.out.print("\t");

            if(cr <= nor/2)
               val = cr;
            else if(cr > nor/2)
               val = n-cr+1;
            for(int cst = 1 ; cst <= nst ; cst++)
            {
                System.out.print(val + "\t");
                if(cst <= nst/2)
                {
                    val++;
                }
                else 
                {
                    val--;
                }
            }      
            
            if(cr <= nor/2)
            {
                nst += 2;
                nsp--;
            }   
            else
            {
                nst -= 2;
                nsp++;
            }
            System.out.println();
        }
    }
    public static void main(String [] args)
    {
        int n = scr.nextInt();
        numberDiamond(n);
    }


    
}

// javac Main.java && java Main
// javac Main.java && java Main > output15.txt