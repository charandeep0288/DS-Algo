public class Main{

    public static void removeAllhi(String str )
    {
        int n = str.length();
        int i = 0;
        String ans = "";
        // ans += str.charAt(i);
        
        while( i < n - 1 )
        {
            if( str.charAt(i) != 'h' && str.charAt(i + 1) != 'i')
            {
                ans += str.charAt(i);
                i++;
            }
            else if( i < n - 1 && str.charAt(i) == 'h' && str.charAt(i + 1) == 'i')
            {
                i += 2;
            }
        }
        if( i < n - 1 )
        {
            ans += str.charAt(i);
        }
        System.out.println(ans);
    }
    public static void main(String [] args)
    {
        String str = "idsfdsiiiii";

        removeAllhi(str);
    }
}

// javac Main.java && java Main