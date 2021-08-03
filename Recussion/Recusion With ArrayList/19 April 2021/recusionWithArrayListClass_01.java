import java.util.Scanner;
import java.util.ArrayList;

public class recusionWithArrayListClass_01 {
    
    public static Scanner scr = new Scanner(System.in);

    public static ArrayList<Integer> input( int n )
    {
        ArrayList<Integer> al = new ArrayList<Integer>();

        for( int i = 0 ; i < n ; i++ )
        {
            al.add(scr.nextInt());
        }
        return al;
    } 

    public static void Display( ArrayList<Integer> al )
    {
        for( Integer ele : al )
            System.out.println(ele); 
    }

    public static ArrayList<String> getSubseq( String str )
    {
        if( str.length() == 0 )
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> recAns = getSubseq(str.substring(1));

        ArrayList<String> myAns = new ArrayList<>();
        for( String s : recAns )
        {
            myAns.add(s); // character add nahi hua ArrayList mai
            // myAns.add(ch + s);
        }
        for( String s : recAns )
        {
            myAns.add(ch + s); // character add hoo gia ArrayList mai
        }
        return myAns;

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

    // leatcode 91 ( NOT ON PORTAL )
    // check for these test cases => 11283, 11023, 0, 11341011
    public static ArrayList<String> decodeWays( String str )
    {

        if( str.length() == 0 )
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        if( str.charAt(0) == '0' )
        return new ArrayList<>();  // ans not possible return emty ArrayList
        
        char ch1 = str.charAt(0);
        
        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> recAnsFor1Len = decodeWays( str.substring(1) );
        for( String s : recAnsFor1Len )
        {
            myAns.add((char) ('a' + ch1 - '1') + s);
        }

        if( str.length() > 1 )
        {
            int num = (ch1 - '0') * 10 + (str.charAt(1) - '0');
            if(num <= 26)
            {
                ArrayList<String> recAnsFor2Len = decodeWays( str.substring(2) );
                for(String s : recAnsFor2Len)
                {
                    myAns.add((char) ('a' + num - 1) + s);
                }
            }
        }
        return myAns;
    }

    public static ArrayList<String> decodeWay2(String str)
    {
        return null;
    }
    public static void main(String [] args)
    {
        // int n = scr.nextInt();
        
        // ArrayList<Integer> ans = input(n);

        // Hard code => input khud dai hai humna 
        System.out.println(getSubseq("abcd"));

        // for( String s : getKPC("456"))
        // {
        //     System.out.println(s);
        // }

        // System.out.println((int) '0'); // 48
        // System.out.println((int) '1'); // 49
        // System.out.println('3' + '4'); // acsii value koo add kar raha hai => 103
        System.out.println('3' + "" +'4'); // 34
        // System.out.println("" + '3' +'4'); // 34
        System.out.println('3' +'4' + ""); // 103
        // System.out.println("3" + "4"); // 34

        for(String s : decodeWays("1233"))
        {
            System.out.println(s);
        }

    }
}

// javac recusionWithArrayListClass_01.java && java recusionWithArrayListClass_01