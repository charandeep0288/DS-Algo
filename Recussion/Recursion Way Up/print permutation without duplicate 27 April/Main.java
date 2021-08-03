import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    public static int permutationWithoutDuplicate( String str, String ans )
    {
        if( str.length() == 0 )
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        char prev = '$'; // previous pointer
        for( int i = 0 ; i < str.length() ; i++ )
        {
            if( str.charAt(i) != prev )
            {
                String ros = str.substring(0, i) + str.substring(i + 1);
                count += permutationWithoutDuplicate(ros, ans + str.charAt(i));
            }
            prev = str.charAt(i);
        }

        return count;
    } 

    // sorting string
    public static void permutationWithoutDuplicate( String str )
    {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for( int i = 0 ; i < str.length() ; i++ )
            freq[str.charAt(i) - 'a']++;

        // O(n) => dono for loop ki time complexity 
        for( int i = 0 ; i < 26 ; i++ )
        {
            for( int j = 0 ; j < freq[i] ; j++ )
            {
                sb.append( (char) (i + 'a') ); // forcefully convert kia hai character mai
            }
        }    

        // System.out.println(sb);
        System.out.println( permutationWithoutDuplicate(sb.toString(), ""));
    }
    public static void main(String[] args)
    {
        permutationWithoutDuplicate("aba");
    } 
}

// javac Main.java && java Main
