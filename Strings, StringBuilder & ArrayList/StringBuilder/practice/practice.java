import java.util.Scanner;

class practice{

    public static Scanner scr = new Scanner(System.in);
 
    public static String toggleCases( String str )
    {
        StringBuilder sb = new StringBuilder();
        int n = str.length();

        for( int i = 0 ; i < n ; i++ )
        {
            char ch = str.charAt(i);
            if( ch >= 'a' && ch <= 'z' )
                 sb.append( (char)(ch - 'a' + 'A') );

            else 
                sb.append( (char)(ch - 'A' + 'a') );     
        }
        return sb.toString();
    }

    // String With Difference Of Every Two Consecutive Characters
    public static String asciiDiff( String str )
    {
        StringBuilder sb = new StringBuilder();
        int n = str.length();

        sb.append(str.charAt(0));

        for(  int i = 1 ; i < n ; i++ )
        {
            sb.append(str.charAt(i) - str.charAt(i - 1));
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        // System.out.println( toggleCases("abCDefG") );

        System.out.println( asciiDiff("abecd") );
    }
}


// javac practice.java && java practice