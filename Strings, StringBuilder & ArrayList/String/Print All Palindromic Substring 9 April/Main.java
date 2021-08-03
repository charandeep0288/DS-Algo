import java.util.Scanner;

public class Main{

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
                    String s = str.substring(i, j);
                    System.out.println(s);
                }
		    }
		}
	}

    public static void main(String [] args)
    {
        String str = "abccd";

        printAllPalindromeSubstring2(str);
        
    }
}

// javac Main.java && java Main