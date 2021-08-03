
import java.util.Scanner;

public class Main {
    
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str = scr.nextLine();
        
        nokiaKeyPad(str, "");
    }

    // print KPC
    public static String[] nokiaKeys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static int nokiaKeyPad(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return 1;
        }

        char ch = str.charAt(0);
        int idx = ch - '0';
        String word = nokiaKeys[idx];
        int count = 0;

        for( int i = 0 ; i < word.length() ; i++ )
        {
            count += nokiaKeyPad(str.substring(1), ans + word.charAt(i));
        }

        return count;
    }

}