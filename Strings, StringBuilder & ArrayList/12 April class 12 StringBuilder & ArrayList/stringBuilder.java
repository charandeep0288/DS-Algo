 import java.util.Scanner;

public class stringBuilder {

    public static Scanner scr = new Scanner(System.in);

    // string Immutable test
    public static void stringImmutableTest()
    {
        String str1 = "";
        for( int i = 0 ; i < (int)1e5 ; i++ )
        {
            str1 += i;
        }
        System.out.println(str1);
    }

    // String Bulider Immutable test
    public static void stringBuilderImmutableTest()
    {
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; i < (int)1e6 ; i++ )
        {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }

    public static void stringBuilderBasicFunction()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("a"); // to add at the last of the string O(1)
        sb.append("bcd").append("str"); // O(n) where n is length of the string which I want to append

        System.out.println(sb.toString()); // O(n) to convert character to the string
        
        sb.setCharAt(2, 'e'); // O(1) to set character at particular index
        System.out.println(sb.toString()); //O(n) to convert character to the string

        sb.deleteCharAt(2);// O(n) to delete element from stringBuilder at particular index
        System.out.println(sb.toString()); // to convert character to the string

    }

    public static String toggleCase( String str )
    {
        StringBuilder sb = new StringBuilder();
        int n = str.length();

        for( int i = 0 ; i < n ; i++ )
        {
            char ch = str.charAt(i);
            // to upper
            if( ch >= 'a' && ch <= 'z')
            {
                sb.append((char)(ch - 'a' + 'A'));
            }
            // to lower
            else
            {
                sb.append((char)(ch - 'A' + 'a'));
            }
        }
        return sb.toString();
    }

    // string With hDiff Of Every Two Consecutive Character
    public static String asciiDiff( String str)
    {
        StringBuilder sb = new StringBuilder();
        int n = str.length();

        sb.append(str.charAt(0));

        for( int i = 1 ; i< n ; i++ )
        {
            sb.append(str.charAt(i) - str.charAt(i-1));
            sb.append(str.charAt(i));

        }
        return sb.toString();
    }

    public static void main(String [] args)
    {
        // long start = System.currentTimeMillis();
        // stringImmutableTest();
        // long end = System.currentTimeMillis();
        // System.out.println( end - start );

        long start = System.currentTimeMillis();
        stringBuilderBasicFunction();
        long end = System.currentTimeMillis();
        System.out.println( end - start );

        // typecasting
        // System.out.println((char)97); // a
        // System.out.println((int)'d'); // ascii value of d

        // String str = "abecd";

        // System.out.println((char)('x' - 'a' + 'A'));

        // // System.out.println(toggleCase(str));

        // System.out.println(asciiDiff(str));
    }
}

// javac stringBuilder.java && java stringBuilder 
// javac stringBuilder.java && java stringBuilder > output.txt