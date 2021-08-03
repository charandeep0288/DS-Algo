import java.io.*;
import java.util.*;

public class Main {
    
    public static Scanner scn = new Scanner(System.in);

	public static String removeDuplicate( String str )
    {
        if( str.length() == 0 )
        {
            return "";
        }
        String ans = "";
        char ch = str.charAt(0);

        ans += ch;

        int i = 1, n = str.length();
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
                i++;
            }
        }

        // System.out.println(ans);
        // System.out.println(changes);
        
        return ans;
    }

	public static String removeDuplicateInsertCount( String str )
    {
        if( str.length() == 0 )
        {
            return "";
        }  

        String ans = str.charAt(0) + "";
        int i = 1, n = str.length();
        int changes = 0;
        int count = 0;

        while( i < n )
        {
            count = 1;
            while( i < n && ans.charAt(ans.length() - 1) == str.charAt(i) )
            {
                i++;
                count++;
            }
            // System.out.println(count);
            changes++;

            if( count > 1 )
                ans += "" + count;

            if( i < n )
            {
                ans += str.charAt(i);
            }
            i++;
        }

        // System.out.println( ans );
        // System.out.println(changes);
        
        return ans;
    }
	public static void main(String[] args) {
		
		String str = scn.next();
		System.out.println(removeDuplicate(str));
		System.out.println(removeDuplicateInsertCount(str));
	}

}