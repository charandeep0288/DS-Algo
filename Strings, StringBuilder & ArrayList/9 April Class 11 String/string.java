import java.util.Scanner;

public class string{
    
    public static Scanner scr = new Scanner(System.in);

    public static boolean isPalindrome( String str, int si, int ei )
    {
        while( si < ei )
        {
            if(str.charAt(si) != str.charAt(ei)) 
               return false;
            
            si++;
            ei--;
        }
        return true;
    }

    // solution 1
    public static void printAllPalindromeSubstring1(String str){
		// donot use substring

		int len = str.length(); /// string length

		for( int i = 0 ; i < len ; i++ )
		{
		    for( int j = i ; j < len ; j++ )
		    {
                if(isPalindrome(str, i, j ))
                {
                    String s = str.substring(i, j + 1);
                    System.out.println(s);
                }
		    }
		}
	}

    // solution 2
    public static void printAllPalindromeSubstring2(String str){
		// donot use substring

		int len = str.length(); /// string length

		for( int i = 0 ; i < len ; i++ )
		{
		    for( int j = i + 1 ; j <= len ; j++ )
		    {
                if(isPalindrome(str, i, j - 1 ))
                {
                    String s = str.substring(i, j + 1);
                    System.out.println(s);
                }
		    }
		}
	}
    

    // removeDuplicate
    // public static void stringCompression1(String str)
    // {
    //     if(str.length() == 0 )
    //     {
    //         return;
    //     }
    //     int n = str.length(); // string length

    //     String ans = str.charAt(0) + ""; // to convert char to string

    //     for( int i = 1 ; i < n ; i++)
    //     {
    //         char curr = str.charAt(i);
    //         char prev = str.charAt(i - 1);

    //         if( curr != prev )
    //         {
    //             str1 += curr;
    //         }
    //     }
    //     return str1;
    // }

    public static void removeDuplicate(String str)
    {
        if(str.length() == 0 )
        {
            return;
        }
        int n = str.length(); // string length

        String ans = str.charAt(0) + ""; // to convert char to string

        int i = 1;
        int changes = 0;

        while( i < n )
        {
            while( i < n && ans.charAt( ans.length() - 1 ) == str.charAt(i))
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


    public static void removeDuplicateInsertCount(String str)
    {
        if(str.length() == 0 )
        {
            return;
        }
        int n = str.length(); // string length

        String ans = str.charAt(0) + ""; // to convert char to string

        int i = 1;
        int changes = 0, count = 0;

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
                ans += str.charAt(i);

            i++;
        }
        System.out.println(ans);
        System.out.println(changes);
    }


    // Count 'Hi' in the string 
    // https://codingbat.com/prob/p147448
    public static int countOfHi(String str)
    {
        int n = str.length();
        int i = 0, count = 0;
        
        while( i < n - 1 )
        {
            if( str.charAt(i) == 'h' && str.charAt(i+1) == 'i')
            {
                count++;
                i += 2;
            }
            else
            {  i++;  }
        }
        return count;
    }


    public static int RemoveHitCountHi(String str)
    {
        int n = str.length();
        int i = 0, count = 0;
        
        while( i < n - 1 )
        {
            if( str.charAt(i) == 'h' && str.charAt(i+1) == 'i' )
            {
                if(i + 2 < n && str.charAt(i+2) == 't')
                {
                    i += 3;
                }
                else
                {
                    count++;
                     i += 2;
                }
            }
            else
            {  i++;  }
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
    public static void main(String [] args )
    {
        String str = "aaabbcdefgghit hit hihihi"; // 

        // printAllPalindromeSubstring(str);

        // removeDuplicate(str);

        //removeDuplicateInsertCount(str);
    
        // int count = countOfHi(str);
        // System.out.println(count);

        int count = RemoveHitCountHi(str);
        System.out.println(count);

        //----------------------------HOMEWORK-----------------------------
        // System.out.println( RemoveAllHi("hithit p shiiihihihiih") );

        // System.out.println( removeAllHiExceptHit("hithihihithitewfhrefhi") );
    }

}

// javac string.java && java string