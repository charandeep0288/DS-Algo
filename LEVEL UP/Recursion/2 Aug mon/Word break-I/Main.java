import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence,"", dict);
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
		
}