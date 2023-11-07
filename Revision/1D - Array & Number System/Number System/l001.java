import java.util.Scanner;

public class l001 {

  public static Scanner scr = new Scanner(System.in);

  // ------------------------------------------------
  // Q1 Decimal to Binary Number Convertion
  public static int decimalToBinary(int n) {
    int ans = 0, pow = 1;
    while (n != 0) {
      int rem = n % 2;
      ans += (rem * pow);
      n /= 2;
      pow *= 10;
    }

    return ans;
  }

  // ------------------------------------------------
  // Q2 Binary to Decimal Number Convertion
  public static int binaryToDecimal(int n) {
    int ans = 0, pow = 1;
    while (n != 0) {
      int rem = n % 10;
      ans += (pow * rem);
      n /= 10;
      pow *= 2;
    }

    return ans;
  }

  // ------------------------------------------------
  // Q3 Decimal to Anybase Convertion
  public static int decimalToAnybase(int n, int b) {
    int ans = 0, pow = 1;

    while (n != 0) {
      int rem = n % b;
      ans += (pow * rem);
      n /= b;
      pow *= 10;
    }

    return ans;
  }

  // ------------------------------------------------
  // Q4 Anybase to Decimal Convertion
  public static int anybaseToDecimal(int num, int b) {
    int ans = 0, pow = 1;

    while (num != 0) {
      int rem = num % 10;
      ans += (rem * pow);
      num /= 10;
      pow *= b;
    }

    return ans;
  }

  // ------------------------------------------------
  // Q5 Anybase to Anybase Convertion
  public static int anybaseToAnybase(int n, int b1, int b2) {
    int decimalNumber = anybaseToDecimal(n, b1);
    int finalAns = decimalToAnybase(decimalNumber, b2);

    return finalAns;
  }

  // ------------------------------------------------
  // Q6 Any Base Addition -> O(n) where n is largest number amoung 2
  public static int anybaseAddition(int num1, int num2, int base) {
    int ans = 0, carry = 0, pow = 1;

    while (num1 != 0 || num2 != 0 || carry != 0) {
      int sum = carry + (num1 % 10) + (num2 % 10);

      int digit = sum % base;
      carry = sum / base;

      ans += (digit * pow);

      num1 /= 10;
      num2 /= 10;
      pow *= 10;
    }

    return ans;
  }

  // ------------------------------------------------
  // Q7 Any Base Subtraction -> O(n) where n is largest number amoung 2
  public static int anybaseSubtraction(int n1, int n2, int base) {
    int ans = 0, borrow = 0, pow = 1;

    while (n2 > 0) {
      int diff = borrow + (n2 % 10) - (n1 % 10);

      if (diff < 0) {
        borrow = -1;
        diff += base;
      } else {
        borrow = 0;
      }
      int digit = diff % base;
      ans += (digit * pow);
      n1 /= 10;
      n2 /= 10;
      pow *= 10;
    }

    return ans;
  }

  // ------------------------------------------------
  // Q8 Any Base Multiplication Given (n2 > n1) -> O(n^2)
  public static int multiplyDigitWithNumber(int n, int d, int base) {
    int ans = 0, pow = 1, carry = 0;

    while (n != 0 || carry != 0) {
      int product = carry + ((n % 10) * d);

      int digit = product % base;
      carry = product / base;

      ans += (digit * pow);

      n /= 10;
      pow *= 10;
    }

    return ans;
  }

  public static int anybaseMultiplication(int n1, int n2, int base) { // O(n)
    int ans = 0, pow = 1;
    while (n2 != 0) {
      int digit = n2 % 10;

      int productRes = (multiplyDigitWithNumber(n1, digit, base) * pow);
      ans = anybaseAddition(ans, productRes, base);

      n2 /= 10;
      pow *= 10;
    }

    return ans;
  }

  public static void main(String[] args) {
    // int n = scr.nextInt();

    // int binaryNumber = decimalToBinary(n);
    // System.out.println("Decimal to Binary Number ==> " + binaryNumber);

    // int decimalNumber = binaryToDecimal(n);
    // System.out.println("Binary to Decimal Number ==> " + decimalNumber);

    // int base = scr.nextInt();
    // int decimalToAnybaseResultant = decimalToAnybase(n, base);
    // System.out.println("Decimal to Anybase Number ==> " + decimalToAnybaseResultant);

    // int anybaseToDecimalResultant = anybaseToDecimal(n, base);
    // System.out.println("Anybase to Decimal Number ==> " + anybaseToDecimalResultant);

    // ----------------------------------------
    int n1 = scr.nextInt();
    int n2 = scr.nextInt();
    int base = scr.nextInt();

    // int anybaseAdditionResultant = anybaseAddition(n1, n2, base);
    // System.out.println("Anybase Addition result ==> " + anybaseAdditionResultant);

    // int anybaseSubtractionResultant = anybaseSubtraction(n1, n2, base);
    // System.out.println("Anybase Subtraction result ==> " + anybaseSubtractionResultant);

    int anybaseMultiplication = anybaseMultiplication(n1, n2, base);
    System.out.println(
      "Anybase Multiplication result ==> " + anybaseMultiplication
    );
  }
}
// javac l001.java && java l001 < input.txt > output.txt
