import java.util.LinkedList;
import java.util.Arrays;

public class l001 {

    // ------------------------------------------------
    // Next Greater On Right (NGOR)
    public static int[] NGOR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        // Stack hum -> AarryList, LinkedList, Stack kaa use karka bana sakta hai  
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1); // by default value -1 dal di 

        for (int i = 0; i < n; i++) {
            while (st.getFirst() != -1 && arr[st.getFirst()] < arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }

    // ------------------------------------------------
    // Next Smaller On Right (NSOR)
    public static int[] NSOR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = 0; i < n; i++) {
            while (st.getFirst() != -1 && arr[st.getFirst()] > arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }

    // ------------------------------------------------
    // Next Greater on Left (NGOL)
    public static int[] NGOL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for (int i = n - 1; i >= 0; i--) {
            while (st.getFirst() != -1 && arr[st.getFirst()] < arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }

    // ------------------------------------------------
    // Next Smaller On Left (NSOL)
    public static int[] NSOL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for(int i = n - 1 ; i >= 0 ; i--) {
            while(st.getFirst() != -1 && arr[st.getFirst()] > arr[i]) 
                ans[st.removeFirst()] = i;
            
            st.addFirst(i);
        }

        return ans;
    }

    // ------------------------------------------------
    // leetcode 503. Next Greater Element II
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1); // -1 value iss lia rakh raha hai taki, empty stack kaa check naa lagna padhra

        for (int i = 0; i < 2 * n; i++) {
            while (st.getFirst() != -1 && arr[st.getFirst()] < arr[i % n])
                ans[st.removeFirst()] = arr[i % n]; // i % n // kara gai tho huma vaha pai arr ka index mila gaa value ki jaga

            if (i < n)
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
