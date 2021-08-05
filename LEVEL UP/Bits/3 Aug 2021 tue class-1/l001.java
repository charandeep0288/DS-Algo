public class l001 {
    // BITS mai bracket jarur lagana 
    
    // 1 -> 0, 0 -> 0 / true -> false, false -> false // -> arr[idx] = true
    public static void onToOff(int n, int k){
        int mask = (1 << k);
        n |= mask;

        System.out.println(n);
    }

    // 1 -> 1, 0 -> 1 / false -> true, true -> true // arr[idx] = false
    public static void offToOn(int n, int k){
        int mask = (1 << k);
        n &= (~mask);

        System.out.println(n);
    }

    // leetcode - 338

    // jtna 1 exist karta hai unka count return karna hai
    public static int countSetBits( int n ){
        int count = 1;
        for(int i = 0 ; i < 32 ; i++){
            int mask = (1 << i);

            if((n & mask) != 0){
                count++;
            }
        }
        return count;
    }

    public static int countSetBits_02(int n){
        int count = 1;
        while(n != 0){
            if((n & 1) != 0)
                count++;
            n >>>= 1;
        }

        return count;
    }


    public static int countSetBits_03(int n){
        int count = 0;
        while(n != 0){
            n &= (n - 1);
            count++;
        }

        return count;
    }

    // leetcode 231. Power of Two
    public boolean isPowerOfTwo(int n){
        return n > 0 && (n & (n - 1)) == 0;
    }

    // leetcode 342.
    public boolean isPowerOfFour(int n){
        if(n <= 0 || (n & (n - 1)) != 0)
            return false;
        
        int count = 0;
        while(n != 1){
            count++;
            n >>>= 1;
        }

        return (count & 1) == 0; 
    }

    // leetcode 136. 
    public int singleNumber( int[] nums){
        int ans = 0;
        for(int ele : nums) 
            ans ^= ele;

        return ans;
    }

    // 338.
    public int[] countBits(int n){
        
        int[] arr = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            arr[i] = arr[i & (i - 1)] + 1;
        }

        return arr;
    }

    // 268
    public int missingNumber(int[] nums){
        int ans = 0;
        int i = 0;
        for( int ele : nums){
            ans ^= ele;
            ans ^= i;
            i++;
        }

        return ans ^ i;
    }

    public int missingNumber_02(int[] nums){
        int ans = 0, n = nums.length;
        for(int ele : nums){
            ans += ele;
        }

        return ((n * (n - 1)) / 2) - ans;
    }
    // 
    // for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);

    // HW -> leetcode 190
    public static void main(String[] args){

        int n1 = 0;
        // n1 = !n1; // not allowed in java, compilatoin error, but allowed in C++
        // n1 = ~n1; // allowed hai
        
        int n = 15;
        int k = 4;
        // System.out.println(onToOff(n, k));

    }
}


// javac l001.java && java l001.java > output.txt