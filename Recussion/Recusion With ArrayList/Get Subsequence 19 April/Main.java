import java.util.ArrayList;
 import java.util.Scanner;

public class Main {

    public static Scanner scr = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        String str = scr.nextLine();
        
        System.out.print( getSubseq(str) ); 

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
}

// javac Main.java && java Main
