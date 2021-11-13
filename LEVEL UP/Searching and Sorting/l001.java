import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class l001 {

    // ==========================================================
    // 26 oct 2021 tue

    // ------------------------------------------------------
    // log(n)
    public static int binarySearch(int[] arr, int si, int ei, int data) {

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == data)
                return mid;
            else if (arr[mid] < data)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return -1;
    }

    public static int firstIndex(int[] arr, int data) {
        if (arr[0] == data)
            return 0;

        int si = 0, ei = arr.length - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == data) {

                if (arr[mid + 1] == data)
                    si = mid + 1;
                else
                    return mid;

            } else if (arr[mid] < data)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return -1;
    }

    public static int lastIndex(int[] arr, int data) {
        if (arr[arr.length - 1] == data)
            return arr.length - 1;

        int si = 0, ei = arr.length - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == data) {

                if (arr[mid + 1] == data)
                    si = mid + 1;
                else
                    return mid;

            } else if (arr[mid] < data)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return -1;
    }

    // ----------------------------------------------------------
    // leetcode 34. FindFirst and Last Position of Element in Sorted Array
    public int[] searchRange(int[] arr, int target) {
        if (arr.length == 0)
            return new int[] { -1, -1 };

        return new int[] { firstIndex(arr, target), lastIndex(arr, target) };
    }

    public int closesetElement(int[] arr, int data) {

        int si = 0, ei = arr.length - 1;

        if (data < arr[si])
            return si;
        else if (data > arr[ei])
            return ei;

        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == data)
                return mid;
            else if (arr[mid] < data)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return data - arr[ei] < arr[si] - data ? ei : si;
    }

    public int perfectLocation(int[] arr, int data) {
        int si = 0, ei = arr.length;

        while (si < ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] <= data)
                si = mid + 1;
            else
                ei = mid;
        }

        return ei; // return si;
    }

    // leetcode 74.
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int si = 0, ei = n * m - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2, r = mid / m, c = mid % m;

            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] < target)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return false;
    }
    // git add . && git commit -m "26 oct 2021 tue levelup Searching and Sorting
    // class-1" && git push origin main

    // ==========================================================
    // 27 oct 2021 wed

    // public static

    // =========================================================
    // 29 oct 2021

    // ------------------------------------------------------
    // leetcode 1. Two Sum
    // 1st Solution -> Time -> O(n)
    public int[] twoSum_01(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int newTarget = target - nums[i];
            for (int j = i + 1; j < n; j++) {
                if (newTarget - nums[j] == 0)
                    return new int[] { i, j };
            }
        }

        return new int[] { -1, -1 };
    }

    // 2nd Solution -> space lai sakta hai -> O(n) & Time complexity -> O(n)
    public int[] twoSum_02(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] { i, map.get(target - nums[i]) };
            else
                map.put(nums[i], i);
        }

        return new int[0]; // return new int[] { -1, -1 };
    }

    // 3rd Solution -> Space -> O(1), Time -> O(1)
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        int si = 0, ei = nums.length - 1;
        while (si < ei) {
            int currSum = nums[si] + nums[ei];

            if (currSum == target)
                return new int[] { nums[si], nums[ei] }; // return new int[] { si, ei }; // but indexes tho change hoo
                                                         // jai gaa ga Array ko sort karna kaa baad
            else if (currSum < target)
                si++;
            else
                ei--;
        }

        return new int[] {};
    }

    public static List<List<Integer>> allPairs(int[] nums, int tar) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int si = 0, ei = nums.length - 1;

        while (si < ei) {
            int sum = nums[si] + nums[ei]; // current sum

            if (sum == tar) {
                List<Integer> smallAns = new ArrayList<>();

                smallAns.add(nums[si++]);
                smallAns.add(nums[ei--]);

                ans.add(smallAns);

                // ans.add(Arrays.asList(nums[si++], nums[ei--]));

                // 3 options
                while (si < ei && nums[si] == nums[si - 1])
                    si++;
                while (si < ei && nums[ei] == nums[ei + 1])
                    ei--;
            } else if (csum < tar) {
                si++;
            } else {
                ei--;
            }
        }

        return ans;
    }

    // leetcode 15. 3 Sum
    // public List<List<Integer>>

    // https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

    // =======================================================
    // 11 Nov, 2021 fri Searching and sorting class-5
    // =======================================================

    // ---------------------------------------------------------
    // leetcode 4
    // solution 1
    // Time -> O(n + m), Space -> O(n + m)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int p = m + n;

        int[] ans = new int[p];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            // compare nums1 & nums2
            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        while (i < n)
            ans[k++] = nums1[i++];

        while (j < m)
            ans[k++] = nums2[j++];

        // find median
        if (p % 2 == 0) {
            int sum = (ans[p / 2] + ans[(p - 1) / 2]);
            return (sum * 1.0) / 2.0;
        } else {
            return ans[p / 2];
        }
    }

    // solution 2
    // Time -> O(log(min(n, m))), Space -> O(1)

}