public class l001 {

    // --------------------------------------------------------
    // leetcode 735
    public int[] asteriodCollision(int[] arr){
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        // ArrayDequeue<Integer> st = new ArrayDequeue<>();

        for(int ele : arr) {
            if(ele > 0){ // agar +ve value hai tho stack mai directly push kar sakta hai (no collision)
                st.addFirst(ele);
                continue;
            }

            while(st.size() != 0 && st.getFirst() > 0 && st.getFirst() < ele) 
                st.removeFirst();

            if(st.size() != 0 && st.getFisrt() == ele)
                st.removeFirst();

            else if(st.size() == 0 || st.getFirst())
                st.addFirst();
            else {
                // nothing to do
            } 
        }

        int[] ans = new int[st.size()];
        int idx = ans.length - 1;
        while(st.size() != 0) {
            ans[idx--] = st.removeFirst();
        }

        return ans;
    }


    // ------------------------------------------------------
    // leetocde 946
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length, idx = 0;
        LinkedList<Integer> st = new LinkedList<>();
        for(int ele : pushed) {
            st.addFirst(ele);
            while(st.size() != 0 && st.getFirst() == popped[idx]){
                idx++;
                st.removeFirst();
            }
        }

        // yaa doo case likh kaa check kar sakta hai return karta hua
        return st.size() == 0; // idx == n;
    }

    // ----------------------------------------------------------
    // 856
    public int scoreOfParentheses(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(0);

        for(int i = 0 ; i < s.length ; i++ ) {
            char ch = s.charAt(i);
            
        }
    }
    

}
