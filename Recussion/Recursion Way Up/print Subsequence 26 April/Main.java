import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str = scr.nextLine();
        
        subsequence_01(str, "");

        // ArrayList<String> ans = new ArrayList<>();
        // System.out.println( subsequence("abc", "", ans) );
        // System.out.println(ans);
    }

    public static int subsequence_01( String ques, String ans )
    {
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

}public class Main {
    
}
