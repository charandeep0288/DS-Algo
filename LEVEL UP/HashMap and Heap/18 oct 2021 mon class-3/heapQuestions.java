import java.util.PriorityQueue;

public class heapQuestions {

    // 973
    public int[][] kClosest(int[][] points, int k) {
        
        // max PQ -> other - this
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int d1 = ((points[a][0] * points[a][0]) + (points[a][1] * points[a][1])); // this
            int d2 = ((points[b][0] * points[b][0]) + (points[b][1] * points[b][1])); // other

            return d2 - d1;
        });
        
        for(int i = 0 ; i < points.length ; i++) {
            pq.add(i);
            if(pq.size() > k) 
                pq.remove();
        }
        
        int[][] ans = new int[k][];
        int i = 0;
        while(pq.size() != 0) {
            int idx = pq.remove();
            ans[i++] = points[idx];
        }
        
        return ans;
    }

    // 692
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);
        
        // min type PQ
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(map.get(a) == map.get(b))
                return b.compareTo(a);
            
            return map.get(a) - map.get(b);
        });
        
        for(String s : map.keySet()) { 
            pq.add(s);
            if(pq.size() > k)
                pq.remove();
        }
        
        List<String> ans = new LinkedList<>();
        while(pq.size() != 0) {
            ans.add(0, pq.remove());
        }
        
        return ans;
    }

    // 778 Swim in Rising Water
    public int swimInWater(int[][] grid) {
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int n = grid.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int i1 = a / m, j1 = a % m;
            int i2 = b / m, j2 = b % m;

            return grid[i1][j1] - grid[i2][j2];
        });

        boolean[][] vis = new boolean[n][m];
        pq.add(0);
    }

    
}