import java.util.ArrayList;
import java.util.Scanner;

public class l001 {

  public static Scanner scr = new Scanner(System.in);

  public static void input(ArrayList<Integer> arr, int size) {
    for (int i = 0; i < size; i++) {
      int a = scr.nextInt();
      arr.add(a);
    }
  }

  public static void display(ArrayList<Integer> arr) {
    for (Integer ele : arr) { // can use 'int', but prefered to use 'Integer'
      System.out.print(ele + "\t");
    }
    System.out.println();

  }

  public static void basicFunction() {
    ArrayList<Integer> arr = new ArrayList<>();

    // 1. Add at the end of ArrayList - O(1)
    arr.add(10);
    arr.add(20);

    // Input ArrayList
    input(arr);

    // Display ArrayList
    display(arr);

    // 2. Get - O(1)
    System.out.println("arr.get(1) -> " + arr.get(1)); // .get(index)

    // 3. Remove a element - O(n)
    arr.remove(0); // .remove(index)

    // 4. Set a value at in index
    arr.set(4, 10);

    display(arr);
    
    // 5. Remove all data of arrayList - O(n)
    arr.clear();   
    
    display(arr);
  }

  // ---------------------------------------------------------
  // Q1 Remove Data
  public static void swap(ArrayList<Integer> arr, int i, int j) {
    Integer temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }

  public static void removeData(ArrayList<Integer> arr, int data) {
    int n = arr.size();
    int i = n - 1;

    while(i >= 0) {
        if(arr.get(i) == data) {
            swap(arr, i, arr.size() - 1);
            arr.remove(arr.size() - 1);
        }
        i--;
    }

    display(arr);
  }

  // ---------------------------------------------------------
  // Q2 Remove Primes (WITH EXTRA SPACE) -> Time - O(10^4 * n) -> O(n), Space - O(n)
  public static boolean isPrime(int num) { // O(√n) ==> O(√10^8) -> O(10^4) constant
    int div = 2;

    while(num >= div * div) {
      if(div % num == 0) {
        return false;
      }
      div++;
    }

    return true;
  }

  public static void removePrimes(ArrayList<Integer> arr) {
    // WITH EXTRA SPACE
    ArrayList<Integer> ans = new ArrayList<>();

    for(Integer ele : arr) {
      if(!isPrime(ele)) { 
        ans.add(ele);
      }
    }

    arr.clear(); // O(n)
    display(arr); // O(n)
  }

  public static void main(String[] args) {
    // basicFunction();

    int size = scr.nextInt();
    ArrayList<Integer> arr = new ArrayList<>();
    input(arr, size);
    // int data = scr.nextInt();

    // removeData(arr, data);

    removePrimes(arr);
  }
}

// javac l001.java && java l001 < input.txt > output.txt
