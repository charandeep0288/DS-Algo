import java.util.HashMap;
import java.util.Arrays;

public class HashMapQuestions {
    

    // leetcode 954.
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = arr.length;
        Integer[] ARR = new Integer[N];
        for(int i = 0 ; i < N ; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            ARR[i] = arr[i];
        }

        // primitive datatype ma kam nahi kar raha iss lia 
        Arrays.sort(ARR, (a, b) -> { 
            return Math.abs(a) - Math.abs(b);
        });

        for(Integer ele : ARR) {
            // get
            if(map.get(ele) == 0) // frequency 
                continue;

            if(map.getOrDefault(2 * ele, 0) <= 0)
                return false;

            map.put(ele, map.put(ele) - 1);
            map.put(2 * ele, map.get(2 * ele) - 1);
        }

        return true;
    }

    // 295

    // 127


}
