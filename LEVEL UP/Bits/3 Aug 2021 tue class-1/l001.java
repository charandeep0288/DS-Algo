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


    // 
    // for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);

    public static void main(String[] args){

        int n1 = 7;
        // n1 = !n1; // not allowed, compilatoin error
        // n1 = ~n1; // allowed hai
        
        int n = 15;
        int k = 4;
        System.out.println(onToOff(n, k));

    }
}


// javac l001.java && java l001.java > output.txt