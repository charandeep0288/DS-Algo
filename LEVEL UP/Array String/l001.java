public class l001 {


    // ------------------------------------------------
    // rotate array by k
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i++, j--);
        }
    }
    public void rotate(int[] nums, int k) {
        int size = nums.length;

        int rot = (k % size + size) % size;

        // reverse first part (array a)
        reverse(nums, 0, size-rot-1);
        // reverse second part (array b)
        reverse(nums, size - rot, size - 1);
        // reverse whole array(a, b);
        reverse(nums, 0, size - 1);
    }

    // ----------------------------------------
    // segregate odd & even 
    public void segregatePosNeg(int[] arr) {
        int neg_ptr = -1;
        int ptr = 0;
        int n = arr.length;

        while(ptr < n) {
            if(arr[ptr] < 0) {
                swap(arr, ++neg_ptr, ptr);
            }
            ptr++;
        }
    }

    // -------------------------------------------
    // segregate 0's ard 1's 
    public void segregateZeroOne(int[] arr) {
        int zero_ptr = -1;
        int ptr = 0;
        int n = arr.length;

        while(ptr < n) {
            if(arr[ptr] == 0) {
                swap(arr, ++zero_ptr, ptr);
            }
            ptr++;
        }
    }

    // ------------------------------------------
    // leetcode-75 Sort Colors (segregate 0', 1's and 2's)
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p1 = -1;
        int p2 = 0;
        int p3 = n - 1;

        while(p2 <= p3) {
            if(nums[p2] == 0) {
                swap(nums, ++p1, p2++);
            } else if(nums[p2] == 2) {
                swap(nums, p3--, p2);
            } else {
                p2++;
            }
        }
    }


    // -----------------------------------------------
    // https://practice.geeksforgeeks.org/problems/max-sum-in-the-configuration/1
    public int max_sum(int arr[], int n){
	    // Your code here
	    int sum = 0;
	    for(int i = 0 ; i < n ; i++) 
	        sum += arr[i];
	
	    int currSum = 0; // current sum
	    for(int i = 0 ; i < n ; i++) 
	        currSum += (i * arr[i]);
	        
	       int ans = currSum;
	       
	       for(int i = 1 ; i < n ; i++) {
	           int newSum = currSum - sum + (n * arr[i - 1]);
	           ans = Math.max(ans, newSum);
	           currSum = newSum;
	       }
	       
	       return ans;
    }
}
