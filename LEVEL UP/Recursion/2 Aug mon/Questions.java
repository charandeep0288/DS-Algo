import java.util.HashSet;

public class Questions {

    // on portal 
    public static int c = 1;
    public static void friendsPairing(int count, int n, boolean[] used, String asf) {
        if (count == n) {
            System.out.println(c++ + "." + asf);
            return;
        }

        int fup = 1; // first un used person
        while (fup <= n && used[fup])
            fup++;

        used[fup] = true;
        friendsPairing(count + 1, n, used, asf + "(" + fup + ") ");

        for (int pp = fup + 1; pp <= n; pp++) { // pair person
            if (!used[pp]) {
                used[pp] = true;
                friendsPairing(count + 2, n, used, asf + "(" + fup + "," + pp + ") ");
                used[pp] = false;
            }
        }
        used[fup] = false;
    }

    // on portal
    public static int wordBreak(String str, String ans, HashSet<String> dict){
        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int ei = 0 ; ei < str.length() ; ei++){
            // pword -> potentail word
            String pword = str.substring(0, ei + 1); // starting index fix raha gaa 
            if(dict.contains(pword)){
                count += wordBreak(str.substring(ei + 1), ans + pword + " ", dict);
            }
        }

        return count;
    }

    // iterative solution are better

    // on portal
    public static String max = "";
    // ii -> jiss character koo use yaa check kar lia hai uska next character se check karna start karo, har bar start se character ko check karna ki bajai
    public static void findMaximum(String str, int k, int ii){
        if( k == 0 )
            return;

        for( int i = ii ; i < str.length() ; i++){
            int idx = -1;
            char maxCh = '0';
            for(int j = i + 1 ; j < str.length() ; j++){
                if(str.charAt(i) < str.charAt(j) && maxCh < str.charAt(j)){
                    idx = j;
                    maxCh = str.charAt(j);
                }
            }

            if(idx != -1){
                for(int j = idx ; j < str.length() ; j++){
                    if(str.charAt(j) == maxCh){
                        String temp = swap(str, i, j);
                        if(isGreater(temp, max))
                            max = temp;
                        findMaximum(temp, k - 1, i + 1);
                    }
                }
            }
        }
    }

    // big integer bhi yaa hi vala kam karta hai
    // this -> temp, other -> str ( hum humasha this ka respect mai other ki baat kara gai)
    public static boolean isGreater(String temp, String str){ // O(n)
        if(temp.length() > str.length())
            return true;
        else if(temp.length() < str.length())
            return false;

        for(int i = 0 ; i < str.length() ; i++){
            // acsii value compare hongi humari yaha pai, actual value ki jaga 
            if(temp.charAt(i) > str.charAt(i))
                return true;
            else if(temp.charAt(i) < str.charAt(i))
                return false;
        }

        return true; // return true yaa false ik hi baat hai, kioki agar upar sara cases check kia hai, matlab dono number equal hai tho return true karo yaa false kio farak nahi padrta kioki dono numbers equal hai
    }

    // O(n)
    public static String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        char c1 = str.charAt(i); // first character
        char c2 = str.charAt(j); // second character

        sb.setCharAt(i, c2);
        sb.setCharAt(j, c1);

        return sb.toString();
    }
}
