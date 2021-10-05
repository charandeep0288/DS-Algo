import java.util.LinkedList;
import java.util.Arrays;

public class l001 {
    
    // ------------------------------------------------
    // Next Greater On Right
    public static int[] NGOR(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for(int i = 0 ; i < n ; i++){
            while(st.getFirst() != -1 && arr[st.getFirst()] < arr[i])
                arr[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }

    // ------------------------------------------------
    // Next Smaller On Right

    // ------------------------------------------------
    // Next Greater on Left

    // ------------------------------------------------
    // Next Smaller On Left

// ------------------------------------------------
    // leetcode 503
    public int[] nextGreaterElements(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1); // -1 value iss lia rakh raha hai taki, empty stack kaa check naa lagna padhra

        for(int i = 0 ; i < 2 * n ; i++ ){
            while(st.getFirst() != -1 && arr[st.getFirst()] < arr[i % n])
                ans[st.removeFirst()] = i % n; // arr[i % n] // kara gai koi ki huma vaha pai arr ka value chahia naa ki index
                
            if(i < n)
                st.addFirst(i);
        }

        return ans;
    }

    // ------------------------------------------------
    // https://www.geeksforgeeks.org/the-stock-span-problem/
    // https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1


    // ------------------------------------------------
    // leetcode 901
}
