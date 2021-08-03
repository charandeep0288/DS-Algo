import java.util.*;

public class print_table
{
    public static Scanner scr = new Scanner(System.in);

    public static void printTable(int n)
    {
        for(int i = 1 ; i <= 10 ; i++)
        {
            System.out.println( n + " * " + i + " = " + (n*i) );
        }
        System.out.println();

    }

    public static void printMultipleTables(int p)
    {
        for(int i = 1 ; i <= p ; i++)
        {
            printTable(i);
        }

    }
    public static void main(String[] args)
    {
 
        // int n = scr.nextInt();
        // printTable(n);

        int q = scr.nextInt();
        printMultipleTables(q);
    }
}

// javac print_table.java && java print_table