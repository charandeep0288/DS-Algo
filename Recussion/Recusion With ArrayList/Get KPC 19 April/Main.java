import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str = scr.nextLine();
        
        System.out.print( getKPC(str) );

    }

    public static String[] nokiaKeys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    
    public static ArrayList<String> getKPC( String str )
    {
        if( str.length() == 0 )
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
         char ch = str.charAt(0);
         String code = nokiaKeys[ch - '0'];

         ArrayList<String> recAns = getKPC( str.substring(1) );

         ArrayList<String> myAns = new ArrayList<>();
         for( int i = 0 ; i  < code.length() ; i ++ )
         {
             for( String s : recAns )
                  myAns.add( code.charAt(i) + s );
         }

         return myAns;
    }
}
// javac Main.java && java Main