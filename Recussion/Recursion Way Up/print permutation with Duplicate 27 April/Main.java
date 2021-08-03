
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in); 

    public static void main(String[] args) throws Exception {
        
        String str = scr.nextLine();
        
        permutation(str, "");

    }

    public static int permutation( String str, String ans )
    {
        if( str.length() == 0 )
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for( int i = 0 ; i < str.length() ; i++ )
        {
            String ros = str.substring(0, i) + str.substring(i + 1);
            count += permutation(ros, ans + str.charAt(i));
        }
        return count;
    }
}