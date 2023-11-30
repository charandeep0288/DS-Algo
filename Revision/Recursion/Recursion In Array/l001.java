import java.util.Scanner;

public class l001 {

  public static Scanner scr = new Scanner(System.in);

  public static void input(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      arr[i] = scr.nextInt();
    }
  }

  // --------------------------------------------------
  // Q1 Display Array -> Time, Space - O(n)
  public static void displayArr(int[] arr, int idx) {
    if (idx == arr.length) {
      return;
    }

    System.out.println(arr[idx]);
    displayArr(arr, idx + 1);
  }

  // --------------------------------------------------
  // Q2 Display Array in Reverse -> Time, Space - O(n)
  // pre
  public static void displayArrReverse(int[] arr, int idx) {
    if (idx == arr.length) {
      return;
    }

    displayArrReverse(arr, idx + 1);
    System.out.println(arr[idx]);
  }

  // post
  public static void displayArrReverse_01(int[] arr, int idx) {
    if (idx == -1) {
      return;
    }

    System.out.println(arr[idx]);
    displayArrReverse_01(arr, idx - 1);
  }

  // --------------------------------------------------
  // Q3 Maximum of an Array -> Time, Space - O(n)
  public static int maximum(int[] arr, int idx) {
    if (idx == arr.length) {
      return -(int) 1e9;
    }

    int recMax = maximum(arr, idx + 1);
    if (arr[idx] > recMax) {
      recMax = arr[idx];
    }
    return recMax;
  }

  // --------------------------------------------------
  // Q4 Minimum of an Array -> Time, Space - O(n)
  public static int minimum(int[] arr, int idx) {
    if (idx == arr.length) {
      return (int) 1e9;
    }

    int recMin = minimum(arr, idx + 1);
    return Math.min(recMin, arr[idx]);
  }

  // --------------------------------------------------
  // Q5 Find Data in an Array -> Time, Space - O(n)
  // post - not better - we would traverse the whole array even if we found first somewhere in the array
  public static boolean findData(int[] arr, int idx, int data) {
    if (idx == arr.length) {
      return false;
    }

    boolean recAns = findData(arr, idx + 1, data);
    return recAns ? recAns : arr[idx] == data;
  }

  // pre - better - agar answer jaldi mila toh pura array traversal nahi hoga, wahi se return kar jayege
  public static boolean findData_01(int[] arr, int idx, int data) {
    if (idx == arr.length) {
      return false;
    }

    if (arr[idx] == data) {
      return true;
    }

    return findData_01(arr, idx + 1, data);
  }

  // --------------------------------------------------
  // Q6 Last Index - O(n) where n is arr.length
  public static int lastIndex(int[] arr, int idx, int data) {
    if (idx == arr.length) {
      return -1;
    }

    int recAns = lastIndex(arr, idx + 1, data);
    if (recAns != -1) {
      return recAns;
    }

    return arr[idx] == data ? idx : -1;
  }

  // --------------------------------------------------
  // Q7 First Index
  public static int firstIndex(int[] arr, int idx, int data) {
    if (idx == arr.length) {
      return -1;
    }

    if (arr[idx] == data) {
      return idx;
    }

    return firstIndex(arr, idx + 1, data);
  }

  // --------------------------------------------------
  // Q8 All Index of Array - O(n)
  public static int[] allIndices(int[] arr, int idx, int data, int count) {
    if (idx == arr.length) {
      return new int[count];
    }

    if (arr[idx] == data) {
      count++;
    }

    int[] recAns = allIndices(arr, idx + 1, data, count);
    if (arr[idx] == data) {
      recAns[count - 1] = idx;
    }

    return recAns;
  }

  // --------------------------------------------------
  // Q9 First and Last Index
  public static boolean firstLastIdx(int[] arr, int idx, int data, int[] ans, boolean ffe) { // ffe - found first element
    if(idx == arr.length) {
        return false;
    }

    if(!ffe && arr[idx] == data) {
        ans[0] = idx;
        ffe = true;
    }
    
    boolean recAns = firstLastIdx(arr, idx + 1, data, ans, ffe);
    if(recAns) {
        return recAns; // return true;
    }

    if(arr[idx] == data) {
        ans[1] = idx;
        return true;
    }

    return false;
  }

  public static void main(String[] args) {
    int n = scr.nextInt();
    int[] arr = new int[n];

    input(arr);

    // displayArr(arr, 0);

    // displayArrReverse(arr, 0); // pre
    // displayArrReverse_01(arr, n - 1); // post

    // System.out.println(maximum(arr, 0));

    // System.out.println(minimum(arr, 0));

    int data = scr.nextInt();
    // System.out.println(findData(arr, 0, data)); // post
    // System.out.println(findData_01(arr, 0, data)); // pre

    // System.out.println(lastIndex(arr, 0, data));

    // System.out.println(firstIndex(arr, 0, data));

    // int[] allIndicesResArray = allIndices(arr, 0, data, 0);
    // displayArr(allIndicesResArray, 0);

    int[] resArray = new int[2];
    firstLastIdx(arr, 0, data, resArray, false);
    displayArr(resArray, 0);

  }
}
// javac l001.java && java l001 < input.txt > output.txt
