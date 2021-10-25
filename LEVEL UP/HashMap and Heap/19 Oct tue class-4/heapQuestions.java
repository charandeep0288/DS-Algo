public class heapQuestions {
    
    // -------------------------------------------------------------
    // leetcode 1642. Furthest Building You Can Reach
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // by default -> min PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int n = heights.length;
        for(int i = 1 ; i < n ; i++) {
            int currDiff = heights[i] - heights[i - 1];
            if(currDiff > 0) // currDiff +ve hai tho hi check kara gai, 0 or -ve currDiff ka case mai next building pai jump kar saka hai easily
                pq.add(currDiff);
            
            if(pq.size() > ladders) {
                bricks -= pq.remove();
            }
            
            if(bricks < 0)
                return i - 1;
        }
        
        return n - 1;
    }

    // -------------------------------------------------------------
    // leetcode 632. 
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        
        // { r, c }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int r1 = a[0], c1 = a[1];
            int r2 = b[0], c2 = b[1];
            
            return nums.get(r1).get(c1) - nums.get(r2).get(c2);
        });
        
        int maxValue = -(int)1e9;
        
        for(int i = 0 ; i < n ; i++) {
            pq.add(new int[]{ i, 0});
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }
        
        // sp -> starting point, ep -> ending point
        int range = (int)1e9, sp = -1, ep = -1;
        while(pq.size() == n) {
            
            int[] re = pq.remove();
            int r = re[0], c = re[1], val = nums.get(r).get(c);
            
            if(maxValue - val < range) {
                range = maxValue - val;
                sp = val;
                ep = maxValue;
            }
            
            c++;
            if(c < nums.get(r).size()) {
                pq.add(new int[]{r, c});
                maxValue = Math.max(maxValue, nums.get(r).get(c));
            }
        }
        
        return new int[]{sp, ep};
    }

    // 128
    
}
