import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static Scanner scr = new Scanner(System.in);

    // HW OF LAST CLASS
    public static String[] nokiaKeys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz", "+-*", "<>/%"};
    public static ArrayList<String> decodeWays2( String str )
    {

        if(str.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch1 = str.charAt(0);
        String word = nokiaKeys[ch1 - '0'];
        ArrayList<String> myAns = new ArrayList<>();

        ArrayList<String> recAns1 = decodeWays2(str.substring(1));
        for( int i = 0 ; i < word.length() ; i++ )
        {
            for( String s : recAns1 )
                myAns.add(word.charAt(i) + s);
        }
           
        if( str.length() > 1 )
        {
            char ch2 = str.charAt(1);
            int num = ( ch1 - '0' ) * 10 + ( ch2 - '0' );
            if( num == 10 || num == 11 )
            {
                ArrayList<String> recAns2 = decodeWays2(str.substring(2));
                word = nokiaKeys[num];
                for( int i = 0 ; i < word.length() ; i++ )
                {
                    for( String s : recAns2 )
                        myAns.add(word.charAt(i) + s);
                }
            }
        }
        return myAns;
    }


    // GET STAIRS PATH
    public static ArrayList<String> getStairsPath( int n )
    {
        if( n == 0 )
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for( int i = 1 ; i <= 3 && n - i >= 0 ; i++ )
        {
            ArrayList<String> recAns = getStairsPath( n - i );
            for( String s : recAns )
            {
                myAns.add( i + s );
            }
        }
        return myAns;
    }

    // BOARD PATH
    public static ArrayList<String> boardPath( int n )
    {
        if( n == 0 )
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for( int dice = 1 ; dice <= 6 && n - dice >= 0 ; dice++ )
        {
            ArrayList<String> recAns = boardPath( n - dice );
            for( String s : recAns )
            {
                myAns.add( dice + s );
            }
        }
        return myAns;
    }

    // BOARD PATH BASED ON ARRAY
    public static ArrayList<String> boardPathOnArray( int n, int [] moves )
    {
        if( n == 0 )
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for( int i = 0 ; i < moves.length && n - moves[i] >= 0 ; i++ )
        {
            ArrayList<String> recAns = boardPathOnArray( n - moves[i], moves );
            for( String s : recAns )
            {
                myAns.add( moves[i] + s );
            }
        }
        return myAns;
    }

    
    // GET MAZE PATHS HV
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths_HV(int sr, int sc, int dr, int dc)
    {
        if( sr == dr && sc == dc)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

            if( sc + 1 <= dc )
            {
                ArrayList<String> horizontal = getMazePaths_HV(sr, sc + 1, dr, dc);
                for(String s : horizontal)
                {
                    myAns.add("H" + s); // CPP : string(1, 'H') + s;
                }
            }

            if( sr + 1  <= dr )
            {
                ArrayList<String> vertical = getMazePaths_HV(sr + 1, sc, dr, dc);
                for(String s : vertical)
                {
                    myAns.add("V" + s);
                }
            } 
        return myAns;
    }


    // GET MAZE  HDV
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths_HDV(int sr, int sc, int dr, int dc)
    {
        if( sr == dr && sc == dc)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
            
            if( sc + 1 <= dc )
            {
                ArrayList<String> horizontal = getMazePaths_HDV(sr, sc + 1, dr, dc);
                for(String s : horizontal)
                {
                    myAns.add("H" + s); // CPP : string(1, 'H') + s;
                }
            }

            if( sr + 1  <= dr && sc + 1 <= dc )
            {
                ArrayList<String> diagonal = getMazePaths_HDV(sr + 1, sc  + 1, dr, dc);
                for(String s : diagonal)
                {
                    myAns.add("D" + s);
                }
            }

            if( sr + 1  <= dr )
            {
                ArrayList<String> vertical = getMazePaths_HDV(sr + 1, sc, dr, dc);
                for(String s : vertical)
                {
                    myAns.add("V" + s);
                }
            }
        return myAns;
    }

    // GET MAZE PATH WITH JUMPS
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths_MultiHDV( int sr, int sc, int dr, int dc)
    {
        if( sr == dr && sc == dc )
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

        for( int jump = 1;  sc + jump <= dc ; jump++ )
        {
            ArrayList<String> horizontal = getMazePaths_MultiHDV(sr, sc + jump, dr, dc);
            for(String s : horizontal)
            {
                myAns.add("H" + jump + s); // CPP : string(1, 'H') + s;
            }
        }

        for(int jump = 1 ; sr + jump  <= dr && sc + jump <= dc ; jump++ )
        {
            ArrayList<String> diagonal = getMazePaths_MultiHDV(sr + jump, sc  + jump, dr, dc);
            for(String s : diagonal)
            {
                myAns.add("D" + jump + s);
            }
        }

        for( int jump = 1 ; sr + jump  <= dr ; jump++ )
        {
            ArrayList<String> vertical = getMazePaths_MultiHDV(sr + jump, sc, dr, dc);
            for(String s : vertical)
            {
                myAns.add("V" + jump + s);
            }
        }
        return myAns;
    }

    public static void main(String[] args)
    {

        // System.out.println( decodeWays2( "110" ) );
        
        // System.out.println( getStairsPath(5) );

        // System.out.println( boardPath(5) );

        // int [] arr = {1, 2, 3};
        // System.out.println( boardPathOnArray(5, arr ) );
        // System.out.println( getMazePaths_HV( 0, 0, 2, 2) );

        // System.out.println( getMazePaths_HDV( 0, 0, 2, 2) );
        System.out.println( getMazePaths_MultiHDV( 0, 0, 2, 2) );
    }
    
}

// javac Main.java && java Main