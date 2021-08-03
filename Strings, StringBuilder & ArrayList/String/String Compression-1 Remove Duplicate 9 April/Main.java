import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static void removeDuplicate(String str)
    {
        if( str.length() == 0)
        {
            return;
        }
        int n = str.length();

        String ans = str.charAt(0) + ""; // to convert character to string  
        int i = 1;
        int changes = 0;

        while( i < n )
        {
            while( i < n && ans.charAt(ans.length() - 1) == str.charAt(i) )
            {
                i++;
            }
            changes++;

            if( i < n )
            {
                ans += str.charAt(i);
            }
            i++;
        }
        System.out.println(ans);
        System.out.println(changes);
    }
    public static void main(String [] args)
    {
        String str = "aaabbbcddefffghiiiiiiij";

        removeDuplicate(str);
    }
}

// javac Main.java && java Main