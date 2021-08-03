import java.util.*;

public class Main {
    public static Scanner scr = new Scanner(System.in);

    public static void input1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt(); // set
        }

    }

    public static void display2(int[] arr) {
        for (int ele : arr) // fast and easy to write
        {
            System.out.print(ele + " ");
        }
    }

    public static void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    public static void reverseOfArray(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    // WITHOUT USING EXTRA SPACE O(n)
    public static int[] rotateAnArray_01(int[] arr, int k) // WITHOUT USING EXTRA SPACE
    {
        // write your code here
        int n = arr.length;
        k %= n;

        if (k < 0) {
            k += n;
        }

        reverseOfArray(arr, 0, n - 1);
        reverseOfArray(arr, 0, k - 1);
        reverseOfArray(arr, k, n - 1);

        return arr;
    }

    // WITH USING EXTRA SPACE O(n)
    public static int[] rotateAnArray_02( int [] arr, int k )
    {
        int n = arr.length;
        int [] ans = new int[n];

        for( int i = 0 ; i < n ; i++ )
        {
            int idx = (i+ k ) % n ;
            ans[idx] = arr[i]; 
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = scr.nextInt();
        int[] arr = new int[n];
        input1(arr);
        int k = scr.nextInt();
        // int[] arr1 = rotateAnArray_01(arr, k);
        // display2(arr1);

        int[] arr2 = rotateAnArray_02(arr, k);
        display2(arr2);
    }
}

// javac Main.java && java Main
// javac Main.java && java Main < input.txt > output.txt