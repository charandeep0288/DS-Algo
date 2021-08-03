import java.util.Scanner;

class string{

    public static Scanner scr = new Scanner(System.in);

    public static boolean isPalindrome( String str, int si, int ei )
    {
        while( si < ei )
        {
            if( str.charAt(si) != str.charAt(ei) )
            {
                return false;
            }
            si++;
            ei--;
        }
        return true;   
    }
    public static void printAllPalindromeSubstring( String str )
    {
        int n = str.length();
        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = i ; j < n ; j++ )
            {
                if( isPalindrome(str, i, j) )
                    System.out.println( str.substring(i, j + 1) );
            }
        }
    }

    public static void removeDuplicate( String str )
    {
        if( str.length() == 0 )
        {
            return;
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

        System.out.println(ans);
        System.out.println(changes);
    }

    public static void removeDuplicateInsertCount( String str )
    {
        if( str.length() == 0 )
        {
            return;
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
                ans += count;

            if( i < n )
            {
                ans += str.charAt(i);
            }
            i++;
        }

        System.out.println( ans );
        System.out.println(changes);
    }

    public static int countHi( String str )
    {
        int i = 0, n = str.length();
        int count = 0;
        while( i < n - 1 )
        {
            if( str.charAt(i) == 'h' && str.charAt(i+1) == 'i' )
            {
                i += 2;
                count++;
            }
            else
                i++;
        }
        return count;
    }

    public static int countHiWithoutHit( String str )
    {
        int i = 0, n = str.length();
        int count = 0; 

        while( i < n - 1 )
        {
            if( str.charAt(i) == 'h' && str.charAt(i + 1) == 'i')
            {
                if( i + 2 < n && str.charAt(i + 2) == 't' )
                    i += 3;
                
                else
                {
                    count++;
                    i += 2;
                }    
            }
            else
                i++;
        }
        return count;
    }

    public static String RemoveAllHi( String str )
    {
        String ans = "";
        int i = 0, n = str.length();
        
        while( i < n )
        {
            if( i < n - 1 && str.charAt(i) == 'h' && str.charAt(i + 1) == 'i')
                i += 2;

            else
            {
                ans += str.charAt(i);
                i++;
            }    
        }
        return ans;
    }

    public static String removeAllHiExceptHit( String str )
    {
        String ans = "";
        int  i = 0 , n = str.length();

        while( i < n )
        {
            if( i < n - 1 && str.charAt(i) == 'h' && str.charAt(i + 1) == 'i' )
            {
                if( i + 2 < n && str.charAt(i + 2) == 't' )
                {
                    for( int j = i ; j <= i + 2 ; j++ )
                         ans += str.charAt(j);

                    i += 3;
                }
                else
                    i += 2;
            }
            else
               i ++;
        }
        return ans;
    }
    
    public static void main(String[] args )
    {
        // String str = scr.nextLine();

        // printAllPalindromeSubstring("abcc");

        // removeDuplicate("aaaabbcc");

        // removeDuplicateInsertCount("aaaabbbcc");

        // System.out.println( countHi("phihhiiihihhiihihihihhh") );

        // System.out.println( countHiWithoutHit("ihi") );

        // System.out.println( RemoveAllHi("hithit p shiiihihihiih") );

        // System.out.println( removeAllHiExceptHit("hithihihithitewfhrefhi") );
    }
}

// javac string.java && java string