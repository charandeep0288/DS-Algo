
// REcusion Way up
import java.util.Scanner;
import java.util.ArrayList;

public class recursion {
    
    public static Scanner scr = new Scanner(System.in);

    public static void subsequence( String ques, String ans )
    {
        // base case
        if( ques.length() == 0)
        {
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0); // first character of string
        String roq = ques.substring(1); // rest of the question

        subsequence( roq, ans + ch ); // character add hoo gia ans mai
        subsequence( roq, ans );  // character add nahi hua ans mai 
    }

    public static int subsequence_01( String ques, String ans )
    {
        // base case
        if( ques.length() == 0)
        {
            System.out.println(ans);
            return 1;  // matlab ik ans mil chuka hai
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        int count = 0;

        count += subsequence_01( roq, ans + ch );
        count += subsequence_01( roq, ans );

        return count;
    }

    // ArrayList mai ans ko store kar raha hai 
    // AND int returntype means => number of ans return kar raha hai  
    public static int subsequence( String ques, String ans, ArrayList<String> res ) 
    {
        if( ques.length() == 0)
        {
            res.add(ans); // ans koo store kar lia ArrayList mai
            return 1;  // matlab ik ans mil chuka hai
        }

        char ch = ques.charAt(0); // first character of string
        String roq = ques.substring(1); // rest of the question
        int count = 0;

        count += subsequence( roq, ans + ch, res ); // character add hoo gia ans mai
        count += subsequence( roq, ans, res );  // character add nahi hua ans mai 

        return count;
    }

    

    // print KPC
    public static String[] nokiaKeys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static int nokiaKeyPad(String str, String ans)
    {
        // base case
        if(str.length() == 0)
        {
            System.out.println(ans);
            return 1; // base case mai ik ans mil gia
        }

        char ch = str.charAt(0);
        int idx = ch - '0';
        String word = nokiaKeys[idx];
        int count = 0;

        for( int i = 0 ; i < word.length() ; i++ )
        {
            count += nokiaKeyPad(str.substring(1), ans + word.charAt(i));
        }

        return count;
    }

    // stair Path
    public static int stairPath( int n, String ans )
    {
        // base case
        if( n == 0 )
        {
            System.out.println(ans);
            return 1; // base case mai ik ans mil gia
        }

        int count = 0;
        for( int jump = 1 ; jump <= 3 && (n - jump) >= 0; jump++ )
        {
            count += stairPath( n - jump, ans + jump ); 
        }

        return count;
    }

    // board Path => dice vala ( 10 to 0 ) 
    // picha se chalna better mana jata hai
    public static int boardPath( int n, String ans )
    {
        // base case
        if( n == 0 )
        {
            System.out.println(ans);
            return 1; // base case mai ik ans mil gia
        }

        int count = 0;
        for( int dice = 1 ; dice <= 6 && ( n - dice ) >= 0 ; dice++ )
        {
            count += boardPath(n - dice , ans + dice);
        }
        return count;
    } 

    // board Path => dice vala ( 0 to 10 )
    // 
    public static int boardPath( int sp, int ep, String ans )
    {
        // base case
        if( sp == ep )
        {
            System.out.println(ans);
            return 1; // base case mai ik ans mil gia
        }

        int count = 0;
        for( int dice = 1 ; dice <= 6 && ( sp + dice ) <= ep ; dice++ )
        {
            count += boardPath(sp + dice, ep , ans + dice);
        }
        
        return count;
    }

    // board Path on Array
    public static int boardPathOnArray( int [] arr, int n, String ans )
    {
        if( n == 0 )
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for( int jump : arr )
        {
            if( n - jump >= 0 )
                count += boardPathOnArray( arr, n - jump , ans + jump);
        }
        
        return count;
    }

    // sr => starting row
    // sc => starting column
    // dr => destination row
    // dc => destination column
    public static int printMazePath_HDV( int sr, int sc, int dr, int dc, String ans )
    {
        if( sr == dr && sc == dc )
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        if( sc + 1 <= dc )
            count += printMazePath_HDV(sr, sc + 1, dr, dc, ans + "H");

        if( sr + 1 <= dr && sc + 1 <= dc)     
            count += printMazePath_HDV(sr + 1, sc + 1, dr, dc, ans + "D");
        
        if( sr + 1 <= dr )
            count += printMazePath_HDV(sr + 1, sc, dr, dc, ans + "V");
          
        return count;    
    }

    // sr => starting row
    // sc => starting column
    // dr => destination row
    // dc => destination column
    public static int printMazePath_MultiHDV( int sr, int sc, int dr, int dc, String ans )
    {
        if( sr == dr && sc == dc )
        {
            System.out.println(ans); 
            return 1;
        }

        int count = 0;

        // horizontal
        for( int jump = 1; sc + jump <= dc ; jump++ )
            count += printMazePath_MultiHDV(sr, sc + jump, dr, dc, ans + "H" + jump);

        // diagonal    
        for( int jump = 1; sr + jump <= dr && sc + jump <= dc ; jump++ )   
            count += printMazePath_MultiHDV(sr + jump, sc + jump, dr, dc, ans + "D" + jump);
        
        // vertical    
        for( int jump = 1; sr + jump <= dr ; jump++ )
            count += printMazePath_MultiHDV(sr + jump, sc, dr, dc, ans + "V" + jump);
          
        return count;    
    }

    
    public static void main(String [] args )
    {
        // subsequence("abc", "");

        // System.out.println( subsequence_01("abc" , "") );

        // ArrayList<String> ans = new ArrayList<>();
        // System.out.println( subsequence("abc", "", ans) );
        // System.out.println(ans);

        // System.out.println( nokiaKeyPad("679", "") );

        // System.out.println(stairPath(scr.nextInt(), "") );

        // System.out.println( boardPath( scr.nextInt(), "") );
        // System.out.println( boardPath( 0,scr.nextInt(), "") );

        // int[] arr = {1, 2, 3, 4, 5, 6 };
        // System.out.println( boardPathOnArray(arr, 10 , "") );

        // System.out.println( printMazePath_HDV(0, 0, 2, 2, "") ); // 3X3 MATRIX KA LIA (0, 0, 2, 2)

        System.out.println( printMazePath_MultiHDV(0, 0, 2, 2, "") ); // 3X3 MATRIX KA LIA (0, 0, 2, 2)
    }  
}

// javac recursion.java && java recursion 


//     public static int mazePath_MultiHVD(int sr, int sc, int er, int ec, String ans) {
//         if (sr == er && sc == ec) {
//             System.out.println(ans);
//             return 1;
//         }

//         int count = 0;
//         for (int jump = 1; sc + jump <= ec; jump++)
//             count += mazePath_MultiHVD(sr, sc + jump, er, ec, ans + "H" + jump);
//         for (int jump = 1; sc + jump <= ec && sr + jump <= er; jump++)
//             count += mazePath_MultiHVD(sr + jump, sc + jump, er, ec, ans + "D" + jump);
//         for (int jump = 1; sr + jump <= er; jump++)
//             count += mazePath_MultiHVD(sr + jump, sc, er, ec, ans + "V" + jump);

//         return count;
//     }

//     public static void main(String[] args) {
//         // ArrayList<String> ans = new ArrayList<>();
//         // System.out.println(subsequence("abc", "", ans));
//         // System.out.println(ans);

//         // int[] arr = { 2, 5, 3, 1 };
//         // System.out.println(boardPath(arr, 10, ""));

//         System.out.println(mazePath_MultiHVD(0, 0, 2, 2, ""));
//     }

// }