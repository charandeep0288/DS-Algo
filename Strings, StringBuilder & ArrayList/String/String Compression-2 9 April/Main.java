
 import java.util.Scanner;

public class Main{
    public static Scanner scr = new Scanner(System.in);

    public static void removeDuplicateInsertCount( String str )
    {
        if(str.length() == 0)
        {
            return;
        }

        String ans = str.charAt(0) + "";
        int n = str.length();
        int i = 1;
        int count = 0; // count each variable
        int changes = 0;

        while( i < n )
        {
            count = 1;
            while( i < n && ans.charAt( ans.length() - 1 ) == str.charAt(i))
            {
                i++;
                count++;
            }
            changes++;

            if( count > 1 )
               ans += count;

            if( i < n )
            {
                ans += str.charAt(i);
            }
            i++;
        }
        System.out.println(ans);
        System.out.println(changes);
    }
    public static void main(String[] args)
    {
        String str = "aaabbbcddefffghiiiiiiij";

        removeDuplicateInsertCount(str);
    }
}

// javac Main.java && java Main