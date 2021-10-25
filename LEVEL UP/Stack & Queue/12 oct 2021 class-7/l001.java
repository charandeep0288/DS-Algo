import java.util.LinkedList;
import java.util.Arrays;

public class l001 {

    // ------------------------------------------------------------
    // leetcode 636. Exclusive Time of Function
    public int[] exclusiveTime(int n, List<String> logs) {
        class logPair {
            int id, timeStamp, sleepTime;
            boolean isStart = false;
            
            logPair(String str) {
                String[] ar = str.split(":");
                this.id = Integer.parseInt(ar[0]);
                this.timeStamp = Integer.parseInt(ar[2]);
                this.isStart = ar[1].equals("start");
                this.sleepTime = 0;
            }
        }
        
        LinkedList<logPair> st = new LinkedList<>();
        int[] ans = new int[n];
        
        for(String s : logs) {
            logPair log = new logPair(s);
            
            if(log.isStart) 
                st.addFirst(log);
            else {
                logPair rp = st.removeFirst(); // removePair
                ans[rp.id] += log.timeStamp - rp.timeStamp + 1 - rp.sleepTime;
                
                if(st.size() != 0)
                    st.getFirst().sleepTime += log.timeStamp - rp.timeStamp + 1;
            }
        }
        
        return ans;
    }

    // ------------------------------------------------------
    // leetcode 853.
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        
        // { position, time }
        double[][] disTimeData = new double[n][2];
        
        for(int i = 0 ; i < n ; i++) {
            disTimeData[i][0] = position[i] * 1.0;
            disTimeData[i][1] = ((target - position[i]) * 1.0) / speed[i];
        }
        
        Arrays.sort(disTimeData, (a, b) -> {
            return (int)(a[0] - b[0]);
        });
        
        int carFleet = 1;
        double prevTime = disTimeData[n - 1][1];
        for(int i = n - 2 ; i >= 0 ; i--) {
            if(disTimeData[i][1] > prevTime) {
                prevTime = disTimeData[i][1];
                carFleet++;
            } else {
                // fleet will be same;
            }
        }
        
        return carFleet;
    }

    // HW -> 
    // -----------------------------------------------------------
    // leetcode 1776. Car Fleet II
    

}