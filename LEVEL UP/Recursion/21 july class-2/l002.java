import java.util.ArrayList;
import java.util.Scanner;

public class l002 {
    
    // leetcode-1219. Path with Maximum Gold
    // https://leetcode.com/problems/path-with-maximum-gold/
    public int getMaxGold(int[][] grid, int sr, int sc, int[][] dir){
        
        int maxGold = 0, n = grid.length, m = grid[0].length;
        
        int val = grid[sr][sc];
        grid[sr][sc] = -grid[sr][sc]; // mark
        
        for(int d = 0 ; d < dir.length ; d++ ){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] > 0 ){
                int recGold = getMaxGold(grid, r, c, dir);
                if(recGold > maxGold)
                    maxGold= recGold;
            }
        }
        
        grid[sr][sc] = -grid[sr][sc]; // unmark
        
        return maxGold + val;
    }
    
    public int getMaximumGold(int[][] grid) {
        
        int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
		
        int maxGold = 0, n = grid.length, m = grid[0].length;
        
	    for(int i = 0 ; i < n ; i++){
	        for(int j = 0 ; j  < m ; j++){
	            if(grid[i][j] > 0)
                    maxGold = Math.max(maxGold, getMaxGold(grid, i, j, dir));
	        }
	    }
        
        return maxGold;
    }

    // 
}
