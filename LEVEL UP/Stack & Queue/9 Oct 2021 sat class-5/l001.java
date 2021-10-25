public class l001 {

    // ------------------------------------------------------
    // leetcode 402.
    public String removeKdigits(String num, int k) {
        ArrayList<Character> st = new ArrayList<>();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (st.size() != 0 && st.get(st.size() - 1) > ch && k > 0) {
                k--;
                st.remove(st.size() - 1);
            }
            
            st.add(ch);
        }
        while (k-- > 0)
            st.remove(st.size() - 1);

        StringBuilder sb = new StringBuilder();
        boolean nonZeroValue = false;
        for (Character ch : st) {
            if (ch == '0' && !nonZeroValue)
                continue;

            nonZeroValue = true;
            sb.append(ch);
        }

        return sb.length() != 0 ? sb.toString() : "0";
    }

    // ----------------------------------------------------
    // leetcode 316.
    public String removeDuplicateLetters(String s) {
        int n = s.length;
        StringBuilder st = new StringBuilder();

        for(int i = 0 ; i < n ; i++) {
            while(st.length() != 0 && st.charAt(st.length() - 1) > ch){

            }
        }
    }

    // 1081

    // 1249

}
