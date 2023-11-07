import java.util.Scanner;

public class l001 {

  public static Scanner scr = new Scanner(System.in);

  public static void input(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      arr[i] = scr.nextInt(); // set
    }
  }

  public static void display_01(int[] arr) {
    // for each loop used for :-
    // 1. only for get, if you try to set value you will gat a beautiful error
    // 2. automatically increment by 1
    // 3. always move in forward direction
    // 4. range of loop [0, n-1]
    // cannot increment by 2, 3, 4 .....

    for (int ele : arr) { // fast and easy to write
      System.out.print(ele + " "); // get
      // arr[3] = 255; // error do not do this in for each loop
    }

    System.out.println(arr); // address of the Array
  }

  public static void display_02(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  // ------------------------------------------------------
  // Q1  Find Maximum in an array
  public static int maximum(int[] arr) {
    int maxEle = -(int) 1e9;

    /* // We can write this logic also

      int n = arr.length;
      for(int i = 0 ; i < n ; i++) {
        if(arr[i] > max) {
          max = arr[i];
        }
      }
    */

    for (int ele : arr) {
      maxEle = Math.max(ele, maxEle);
    }

    return maxEle;
  }

  // ------------------------------------------------------
  // Q2  Find Minimum in an array
  public static int minimum(int[] arr) {
    int minEle = (int) 1e9;

    for (int ele : arr) {
      minEle = Math.min(minEle, ele);
    }

    return minEle;
  }

  // -------------------------------------------------------
  // Q3  Find Element in an array return index, otherwise -1;
  public static int findElement(int[] arr, int data) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      if (arr[i] == data) {
        return i;
      }
    }

    return -1;
  }

  // -------------------------------------------------------
  // Q4 Inverse Of An Array
  public static int[] inverseOfAnArray(int[] arr) {
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      int idx = arr[i];
      res[idx] = i;
    }

    return res;
  }

  // -------------------------------------------------------
  // Q5 Reverse An Array
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int[] reverseofArray(int[] arr) {
    int i = 0, j = arr.length - 1;

    while (i < j) {
      swap(arr, i++, j--);
    }
    return arr;
  }

  // --------------------------------------------------------
  // Q6 Rotate an Array - Using extra space
  public static int[] rotateAnArrayUsingExtraSpace(int[] arr, int k) {
    int n = arr.length;
    int[] result = new int[n];
    k = k % n;
    if (k < 0) {
      k += n;
    }

    for (int i = 0; i < n; i++) {
      int idx = (i + k) % n;
      result[idx] = arr[i];
    }

    return result;
  }

  // --------------------------------------------------------
  // Q6 Rotate an Array - Without using extra space
  public static void reverseofArray_01(int[] arr, int i, int j) {
    while (i < j) {
      swap(arr, i++, j--);
    }
  }

  public static int[] rotateAnArrayWithoutExtraSpace(int[] arr, int k) {
    int n = arr.length;
    k = k % n;
    if (k < 0) {
      k += n;
    }

    reverseofArray_01(arr, 0, n - 1);
    reverseofArray_01(arr, 0, k - 1);
    reverseofArray_01(arr, k, n - 1);

    return arr;
  }

  // --------------------------------------------------------
  // Q7 Sum of Two Arrays - Not given which array length is greater
  public static int[] sumOfTwoArrays(int[] arr1, int[] arr2) {
    int n = arr1.length;
    int m = arr2.length;
    int p = Math.max(n, m);

    int[] res = new int[p + 1];

    int i = n - 1, j = m - 1, k = res.length - 1, carry = 0;
    while (k >= 0) {
      int sum = carry + (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0);
      carry = sum / 10;
      res[k] = sum % 10;

      j--;
      i--;
      k--;
    }

    return res;
  }

  public static void displaySumOfTwoArrays(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (i == 0 && arr[i] == 0) {
        continue;
      }
      System.out.print(arr[i] + " ");
    }
  }

  // --------------------------------------------------------
  // Q8 Difference Of Two Arrays
  public static int[] diffOfTwoArrays(int[] arr1, int[] arr2) {
    int n = arr1.length;
    int m = arr2.length;
    int[] res = new int[m];

    int i = n - 1, j = m - 1, k = res.length - 1, borrow = 0;
    while (k >= 0) {
      int diff = borrow + arr2[j] - (i >= 0 ? arr1[i] : 0);

      if (diff < 0) {
        borrow = -1;
        diff += 10;
      } else {
        borrow = 0;
      }

      res[k] = diff;
      i--;
      j--;
      k--;
    }

    return res;
  }

  public static void displayDiffOfTwoArrays(int[] arr) {
    boolean nonZeroFound = false;
    for (int ele : arr) {
      if (ele != 0) {
        nonZeroFound = true;
      }

      if (nonZeroFound) {
        System.out.print(ele + " ");
      }
    }
  }

  // ------------------------------------------------
  // Q9 Sub Array -> O(n^3)
  public static void printSubArray(int[] arr, int si, int ei) {
    while (si <= ei) {
      System.out.print(arr[si++] + " ");
    }
  }

  public static void subArray(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        printSubArray(arr, i, j);
        System.out.println();
      }
    }
  }

  // ------------------------------------------------
  // Q10 Subset Problem
  public static void subsetProblem(int[] arr) {
    int n = arr.length;

    int limit = (int) Math.pow(2, n);
    for (int i = 0; i < limit; i++) {
      String set = "";
      int temp = i;
      for (int j = n - 1; j >= 0; j--) {
        int rem = temp % 2;
        temp /= 2;

        if (rem == 1) {
          set = arr[j] + "\t" + set;
        } else {
          set = "_" + "\t" + set;
        }
      }
      System.out.println(set);
    }
  }

  // ------------------------------------------------
  // Q11 Binary Search -> O(log(n))
  public static int binarySearch(int[] arr, int data) {
    int si = 0, ei = arr.length - 1;

    while (si <= ei) {
      int mid = (si + ei) / 2; // mid = si + ((ei - si) / 2) ... to decrease the overflow probability
      if (data < arr[mid]) {
        ei = mid - 1;
      } else if (data > arr[mid]) {
        si = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

  // ------------------------------------------------
  // Q12 First Index and Last Index -> O(2*log(n))
  public static int firstIndex(int[] arr, int data) {
    int si = 0, ei = arr.length - 1;
    while (si <= ei) {
      int mid = (si + ei) / 2;
      if (data < arr[mid]) {
        ei = mid - 1;
      } else if (data > arr[mid]) {
        si = mid + 1;
      } else {
        if (mid - 1 >= 0 && arr[mid - 1] == arr[mid]) {
          ei = mid - 1;
        } else {
          return mid;
        }
      }
    }
    return -1;
  }

  public static int lastIndex(int[] arr, int data) {
    int si = 0, ei = arr.length - 1;

    while (si <= ei) {
      int mid = (si + ei) / 2;
      if (data < arr[mid]) {
        ei = mid - 1;
      } else if (data > arr[mid]) {
        si = mid + 1;
      } else {
        if (mid + 1 < arr.length && arr[mid + 1] == arr[mid]) {
          si = mid + 1;
        } else {
          return mid;
        }
      }
    }

    return -1;
  }

  public static void firstIndexAndLastIndex(int[] arr, int data) {
    int fi = firstIndex(arr, data);
    int li = lastIndex(arr, data);
    System.out.println(
      "First and Last Index of " +
      data +
      " element in an array ==>\t" +
      fi +
      "\t" +
      li
    );
  }

  // ------------------------------------------------
  // Q13 Span of Array
  public static int spanOfArray(int[] arr) {
    int minEle = (int)1e9, maxEle = -(int)1e9;

    for(int ele : arr) {
      minEle = Math.min(ele, minEle);
      maxEle = Math.max(ele, maxEle);
    }

    return maxEle - minEle;
  }

  // ------------------------------------------------
  // Q14 Bar Chart -> O(n) + O(max * n), where "max" is maximum value element of an array
  public static void barChart(int[] arr) {
    int max = -(int)1e9;

    for(int ele : arr) {
      max = Math.max(ele, max);
    }

    for(int i = max ; i >= 1 ; i--) {
      for(int j = 0 ; j < arr.length ; j++) {
        if(arr[j] >= max) {
          System.out.print("*\t");
        } else {
          System.out.print("_\t");
        }
      }
      max--;
      System.out.println();
    }
  }

  // ------------------------------------------------
  // Q15 Inverted Bar Chart
  public static void invertedBarChart(int[] arr) {
    int max = -(int)1e9;
    for(int ele : arr) {
      max = Math.max(ele, max);
    }

    for(int i = 1 ; i <= max ; i++) {
      for(int j = 0 ; j < arr.length ; j++) {
        if(arr[j] >= i) {
          System.out.print("*\t");
        } else {
          System.out.print("_\t");
        }
      }
      System.out.println();
    }
  }

  // ------------------------------------------------
  // Q16 Ceil Floor Official 
  public static void ceilFloor(int[] arr, int data) {
    int n = arr.length, si = 0, ei = n - 1;
    int ceil = -1, floor = -1;

    while(si <= ei) {
      int mid = (si + ei) / 2;
      if(data < arr[mid]) {
        ei = mid - 1;
        ceil = arr[mid];
      } else if(data > arr[mid]) {
        si = mid + 1;
        floor = arr[mid];
      } else {
        System.out.println("Ceil And Floor Value ==> " + arr[mid]);
        return;
      }
    }

    System.out.println("Ceil And Floor Value ==> " + ceil + "\t" + floor);
  }

  public static void main(String[] args) {
    int n = scr.nextInt();

    int[] arr = new int[n];

    input(arr);
    // display_01(arr);
    // display_02(arr);

    // int maxEle = maximum(arr);
    // System.out.println("Maximum Number--> " + maxEle);

    // int minEle = minimum(arr);
    // System.out.println("Minimum Number--> " + minEle);

    // int data = scr.nextInt();
    // int index = findElement(arr, data);
    // System.out.println("Index of element in an array--> " + index);

    // int [] res = inverseOfAnArray(arr);
    // System.out.print("Inverse of an Array--> ");
    // display_02(res);

    // int [] reverseArr = reverseofArray(arr);
    // System.out.println("Reverse of an Array--> ");
    // display_02(reverseArr);

    // int k = scr.nextInt();
    // int[] rotatedArray = rotateAnArrayUsingExtraSpace(arr, k); // With Using Extra Space
    // int[] rotatedArray = rotateAnArrayWithoutExtraSpace(arr, k); // Without Using Extra Space
    // display_02(rotatedArray);

    // ------------------------------
    // int n2 = scr.nextInt();
    // int[] arr2 = new int[n2];
    // input(arr2);

    // int[] res = sumOfTwoArrays(arr, arr2);
    // displaySumOfTwoArrays(res);

    // int [] diffRes = diffOfTwoArrays(arr, arr2);
    // displayDiffOfTwoArrays(diffRes);

    // ------------------------------
    // subArray(arr);
    // subsetProblem(arr);

    // ------------------------------
    int data = scr.nextInt();

    // int index = binarySearch(arr, data);
    // if(index == -1) {
    //   System.out.println("Element not found");
    // } else {
    //   System.out.println("Element found at index ==> " + index);
    // }

    // firstIndexAndLastIndex(arr, data);

    ceilFloor(arr, data);
    
    // ------------------------------
    // int spanOfArray = spanOfArray(arr);
    // System.out.println("span Of an Array ==> " + spanOfArray);

    // barChart(arr);
    // invertedBarChart(arr);

  }
}
// javac l001.java && java l001 < input.txt > output.txt
