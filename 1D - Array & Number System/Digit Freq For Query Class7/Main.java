import java.util.*;

public class Main {

    public static Scanner scr = new Scanner(System.in);
     
    public static void digitFreq(long n , int [] query)
    {

        int [] freq = new int[10];

        while( n != 0 ) // O(18) or O(n) n => number of digits in number
        {
            long digit = n % 10;
            n /= 10;

            freq[(int) digit]++; // type casting
        }
        for( int q : query) // O(q)
        {
            System.out.println(q + " -> " + freq[q] + " times");
        }

        // TOTAL TIME COMPLEXITY => O(n) + O(q) => O(q) => number of Queriesgiven by user
        // SPACE COM => O(1)
    }
    public static void main( String[] args )
    {
        long n = scr.nextLong(); // number = > 94994698

        int [] query = new int[scr.nextInt()]; 

        for( int i = 0 ; i < query.length ; i++ )
        {
            query[i] = scr.nextInt();
        }
        
        digitFreq(n, query);

    }
}


// javac Main.java && java Main <input.txt> output.txt