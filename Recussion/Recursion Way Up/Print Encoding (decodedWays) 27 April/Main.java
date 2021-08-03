
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        decodeWays( scr.nextLine(), "" );
    }

   // print Encoding
    public static int decodeWays(String str, String ans)
    {
        if( str.length() == 0 )
        {
            System.out.println(ans);
            return 1;
        } 

        int count = 0;
        char ch = str.charAt(0);
        if(ch == '0')
           return 0; // ik bhi ans nahi mila kio ki '0' ki mapping given nahi hai

        count += decodeWays(str.substring(1), ans + (char)('a' + ch - '1'));
        if( str.length() > 1)
        {
            int num = (ch - '0') * 10 + ( str.charAt(1) - '0' );
            if( num <= 26 )
                 count += decodeWays( str.substring(2), ans + (char)('a' + num - 1) );
        } 
        return count;
    }

}