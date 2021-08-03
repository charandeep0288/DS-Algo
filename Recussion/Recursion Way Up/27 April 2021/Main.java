import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{

    public static Scanner scr= new Scanner(System.in);

    // print permutation with duplicate
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

    // print permutation without duplicate
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

    // print Encoding
    public static int decodeWays(String str, String ans)
    {
        if( str.length() == 0 )
        {
            System.out.println(ans);
            return 1;
        } 

        int count = 0;
        char ch = str.charAt(0);
        if(ch == '0')
           return 0; // ik bhi ans nahi mila kio ki '0' ki mapping given nahi hai

        count += decodeWays(str.substring(1), ans + (char)('a' + ch - '1'));
        if( str.length() > 1)
        {
            int num = (ch - '0') * 10 + ( str.charAt(1) - '0' );
            if( num <= 26 )
                 count += decodeWays( str.substring(2), ans + (char)('a' + num - 1) );
        } 
        return count;
    }

    // LEETCODE 46
    public static void permute( int[] nums, int count, List<List<Integer>> res, List<Integer> ans )
    {
        if( count == nums.length )
        {
            List<Integer> base = new ArrayList<>(ans);
            res.add(base);
            return ;
        }

        for( int i = 0 ; i < nums.length ; i++ )
        {
            if( nums[i] >= -10 ) // nums[i] >= -10 && num[i] <= 10
            {
                int val = nums[i];
                nums[i] = -11;
                ans.add(val);

                // recursive call
                permute(nums, count + 1, res, ans);

                ans.remove( ans.size() - 1 );
                nums[i] = val;
            }
        }
    }

    public static List<List<Integer>> permute( int[] nums )
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        permute(nums, 0, res, ans);

        return res;
    }

    // LEETCODE 47
    public static void main(String[] args)
    {
        // System.out.println( permutation("abc", "") );

        // permutationWithoutDuplicate( "aba");

        // System.out.println( decodeWays("112043", "") );

        int [] arr = {1, 2, 1};
        System.out.println( permute(arr) ); // leetcode 46
    }
}

// javac Main.java && java Main