import java.util.Scanner;

public class Main {

    public static Scanner scn = new Scanner(System.in);
    
	public static String toggleCase( String str )
    {
        StringBuilder sb = new StringBuilder();
        int n = str.length();

        for( int i = 0 ; i < n ; i++ )
        {
            char ch = str.charAt(i);
            // to upper
            if( ch >= 'a' && ch <= 'z')
            {
                sb.append((char)(ch - 'a' + 'A'));
            }
            // to lower
            else
            {
                sb.append((char)(ch - 'A' + 'a'));
            }
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		
		String str = scn.next();
        
		System.out.println(toggleCase(str));
	}

}

// javac Main.java && java Main