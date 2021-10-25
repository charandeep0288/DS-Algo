public class heapQuestions {

    // ---------------------------------------------------------------
    // https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1#
    // Solution 1
    // O( Nlog(K) )
    public static int kthSmallest(int[] arr, int l, int r, int k) {

        // max type priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a; // other - this
        });

        while(l <= r) {
            pq.add(arr[l]); // -> log(K) * N
            if(pq.size() > k) 
                pq.remove(); // -> log(K) * N

            l++;
        }

        return pq.peek();
    }

    // Solution 2 
    // O(N + K*log(N))

    
    // ---------------------------------------------------------------
    // https://leetcode.com/problems/kth-largest-element-in-a-stream/
    // leetcode 703
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // min type PQ
    int K;
    
    public KthLargest(int k, int[] nums) {
        K = k;
        for(int ele : nums) {
            pq.add(ele);
            if(pq.size() > k) 
                pq.remove();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > K)
            pq.remove();
        
        return pq.peek();
    }



    // ---------------------------------------------------------------
    // https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
    // Same as GFG question link given up
    // leetcode 378. Kth Smallest Element in a Sorted Matirx
    public int kthSmallest(int[][] matrix, int k) {
        int n =matrix.length;
        int m = matrix[0].length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int i1 = a / m, j1 = a % m;
            int i2 = b / m, j2 = b % m;
            
            return matrix[i1][j1] - matrix[i2][j2];
        });
        
        for(int i = 0 ; i < n ; i++)
            pq.add(i * m + 0);
        
        int r = 0, c = 0;
        while(k-- > 0) {
            int idx = pq.remove();
            r = idx / m;
            c = idx % m;
            if(c + 1 < m) 
                pq.add(r * m + c + 1);
        }
        
        return matrix[r][c];
    }

    // 347

    // HomeWork -> 
    // leetcode 451. 
}
