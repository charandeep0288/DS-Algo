import java.util.Scanner;

public class Main {

  public static Scanner scr = new Scanner(System.in);

  // -----------------------------------------------------------
  // Q1 Digit Frequency - O(n)
  public static int digitFrequency(int num, int data) {
    int count = 0;

    while (num != 0) {
      int digit = num % 10;
      if (digit == data) count++;
      num /= 10;
    }

    return count;
  }

  // -----------------------------------------------------------
  // Q2 Digit Frequency For Query
  // Time Complexity -> O(n) + O(P) -> O(P)
  // O(n) or O(18) long
  // O(P) where P is number of queries given by user
  public static void digitFreqForQuery(long num, int[] query) {
    int[] frequency = new int[10]; // Space Complexity -> O(10) -> O(1)

    while (num != 0) {
      long digit = num % 10;
      frequency[(int) digit]++; // type casting
      num /= 10;
    }

    for (int q : query) {
      System.out.println(frequency[q]);
    }
  }

  public static void input(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scr.nextInt();
    }
  }

  public static void main(String[] args) {
    // int num = scr.nextInt();

    // int data = scr.nextInt();
    // int digitFreq = digitFrequency(num, data);
    // System.out.println("Digit Frequency ==> " + digitFreq);

    // -------------------------------------------
    long num = scr.nextLong();
    int[] query = new int[scr.nextInt()];
    input(query);

    digitFreqForQuery(num, query);
  }
}
// javac Main.java && java Main < input.txt > output.txt
