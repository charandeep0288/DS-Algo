import java.util.LinkedList;
import java.util.Arrays;

public class l001 {
    
    // ----------------------------------------------------------
    // leetcode 84. Largest Rectangle in Histogram

    // O(3n)
    public int[] NSOR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);

        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for(int i = 0 ; i < n ; i++){
            while(st.getFirst() != -1 && arr[st.getFirst()] > arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }

    // O(3n)
    public int[] NSOL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for(int i = n - 1 ; i >= 0 ; i--){
            while(st.getFirst() != -1 && arr[st.getFirst()] > arr[i])
                ans[st.removeFirst()] = i;

            st.addFirst(i);
        }

        return ans;
    }

    // Solution 1
    // O(7n)
    public int largestRectangleArea_01(int[] heights) {
        int[] nsol = NSOL(heights); // next smaller on left
        int[] nsor = NSOR(heights); // next smaller om right

        int maxArea = 0;
        for(int i = 0 ; i < heights.length ; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nsor[i] - nsol[i] - 1));
        }

        return maxArea;
    }   

    // Solution 2
    // O(2n)
    public int largestRectangleArea_02(int[] heights) {
        int n = heights.length, maxArea = 0;
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for(int i = 0 ; i < n ; i++){
            while(st.getFirst() != -1 && heights[st.getFirst()] >= heights[i]) {
                int h = heights[st.removeFirst()];
                int w = i - st.getFirst() - 1;
                maxArea = Math.max(maxArea, h * w);
            }

            st.addFirst(i);
        }

        while(st.getFirst() != -1) {
            int h = heights[st.removeFirst()];
            int w = n - st.getFirst() - 1;
            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;
    }

    // ----------------------------------------------------------
    // leetcode 85. 
    public int maximalLength(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int n = matrix.length, m = matrix[0].length;
        int[] height = new int[m];
        int maxArea = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) 
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            
                maxArea = Math.max(maxArea, largestRectangleArea_02(height));
        }

        return maxArea;
    }

    // -----------------------------------------------------------
    // leetcode 32.
    public int longestValidParentheses(String s) {
        int n = s.length(), maxLen = 0;
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);

        for(int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if(ch == ')' && st.getFirst() != 1 && s.charAt(st.getFirst()) == '(') {
                st.removeFirst();
                maxLen = Math.max(maxLen, i - st.getFirst());
            } else {
                st.addFirst(i);
            }
        }

        return maxLen;
    }
}
