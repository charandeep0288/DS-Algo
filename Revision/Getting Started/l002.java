import java.util.Scanner;

class l002 {

    public static Scanner scr = new Scanner(System.in);

    public static boolean isPrimeNumber_01(int num) { // O(n -2) => O(n)

        for(int i = 2 ; i < num ; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime_01(int num) { // O(n - 2) => O(n)
        for(int i = 2 ; i < num ; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime_02(int num) { // O(n/2)
        for(int i = 2 ; i < num / 2 ; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime_03(int num) { // O(Square root of n)
        int i = 2;
        while( num >= i * i ) {
            if(num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void printfibboSeries_01(int n) { // O(n)
        int a = 0; 
        int b = 1;

        if(n >= 1)
            System.out.print(a + " ");
        if(n >= 2)
            System.out.print(b + " ");

        for( int i = 2 ; i < n ; i++) {
            int sum = a + b;
            System.out.print(sum + " ");
            a = b;
            b = sum;
        }
    }

    public static void printFibboSeires_02(int n) { // O(n)
        int a = 0, b = 1, c;

        for(int i = 0 ; i < n ; i++) {
            c = a + b;
            System.out.print(a + " ");
            a = b;
            b = c;
        }
    }

    public static int countDigits(int num) { // O(n)
        int count = 0, tempNum = num;

        while(tempNum > 0){
            count++;
            tempNum /= 10;
        }

        return count;
    }

    public static void printDigitsInReverse(int num) { // O(n)
        int tempNum = num;

        while(tempNum > 0) {
            int rem = tempNum % 10;
            System.out.println(rem);
            tempNum /= 10;   
        }
    }

    public static int power(int n) {
        int pow = 1, tempNum = n;
        while(tempNum > 10) {
            pow *= 10;
            tempNum /= 10;
        }
        
        return pow;
    }

    public static void printDigitsInOrder(int num) { // O(2n) -> O(n)
        int tempNum = num;

        int pow = power(tempNum);

        int tempNum1 = num;
        while(pow > 0) {
            int digit = tempNum1 / pow;
            System.out.println(digit);
            tempNum1 %= pow;
            pow /= 10;
        }
    }

    public static int rotateANumber(int num, int k) {
        int len = countDigits(num); // calculate digits of the number
        k %= len; // k ko range mai lana
        
        if(k < 0) // handle -ve case for k
            k = len + k;

        int tempNum = num;
        int div = 1, multi = 1;
        for(int i = 1 ; i <= len ; i++) { // calculate div and multi
            if(i <= k) {
                div *= 10;
            } else {
                multi *= 10;
            }
        }

        int a = tempNum % div;
        int b = tempNum / div;
        int res = a * multi + b; // ans
        return res;
    }

    public static boolean phythagoreanTriplet_01(int a, int b, int c) { 
        int max = Math.max(a, Math.max(b, c));

        if(a == max && (a * a == b * b + c * c)) {
            return true;
        } else if(b == max && (b * b == a * a + c * c)) {
            return true;
        } else if(max == c && (c * c == a * a + b * b)) {
            return true;
        }

        return false;
    }

    public static boolean phythagoreanTriplet_02(int a, int b, int c) {
        return ((a * a == b * b + c * c) || (b * b == a * a + c * c) || (c * c == a * a + b * b)); 
    }

    public static void curiousCaseOfBenjaminBulbs(int n) { // O(n)
        for(int i = 1 ; i * i <= n ; i++) {
            System.out.println(i * i);
        }
    }

    public static int power10num(int n) {
        int pow = 1;
        while(n > 0) {
            pow *= 10;
            n--;
        }

        return pow;
    }

    public static int inverseOfANumber(int n) { // O(n)
        int tempNum = n;
        int res = 0, i = 1;
        while(tempNum > 0) {
            int digit = tempNum % 10;
            res += (i * power10num(digit - 1)); // res += (i + (int)Math.pow(10, digit - 1)); // typecasting
            tempNum /= 10;
            i++;
        }
        
        return res;
    }

    public static void reverseANumber(int num) {
        int tempNum = num;
        while(tempNum > 0) {
            int digit = tempNum % 10;
            System.out.println(digit);
            tempNum /= 10;
        }
    }

    public static void calcGCDAndLCM(int n1, int n2) { // Calculate [Gratest Common Divisor] and [Least Common Mulitpler]
        int num1 = n1, num2 = n2;
        if(num2 > num1) {
            int temp = num1;
            num1 = num2;   
            num2 = temp;       
        } 

        while(num1 % num2 != 0) {
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }

        int GCD = num2;
        int LCM = (n1 * n2) / GCD;

        System.out.println("GCD: " + GCD);
        System.out.println("LCM: " + LCM);
    }

    public static void primeFactorisationOfANumber(int num) {
        int div = 2; 
        while (div * div <= num) {
            if(num % div == 0) {
                System.out.println(div);
                num /= div;
            } else {
                div++;
            }
        }

        if(num != 1) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        // System.out.print("Enter a number: ");
        // int num = scr.nextInt();

        // boolean isPrime = isPrime_01(num);
        // boolean isPrime_01 = isPrime_02(num);
        // boolean isPrime_02 = isPrime_03(num);

        // if(isPrime_02) {
        //     System.out.println(num + " is the Prime Number");
        // } else {
        //     System.out.println(num + " is the not a Prime Number");
        // }

        // -------------------------------------------------------------------

        // printfibboSeries_01(num);
        // printFibboSeires_02(num);

        // int digitsCount = countDigits(num);
        // System.out.println("Count of Digits of this '" + num + "' is = " + digitsCount);

        // printDigitsInReverse(num);
        
        // printDigitsInOrder(num);

        // ----------------------------------------------

        // System.out.print("Enter the number of times you want to rotate a number: ");
        // int k = scr.nextInt();

        // System.out.println(rotateANumber(num, k));

        // --------------------------------
        // System.out.println("Enter fist side value: ");
        // int a = scr.nextInt();
        // System.out.println("Enter fist side value: ");
        // int b = scr.nextInt();
        // System.out.println("Enter fist side value: ");
        // int c = scr.nextInt();
        
        // // boolean res = phythagoreanTriplet_01(a, b, c);       
        // boolean res = phythagoreanTriplet_02(a, b, c);

        // if(res) {
        //     System.out.println("It is a Phythagores Triangle");
        // } else {
        //     System.out.println("It is a not Phythagores Triangle");
        // }

        // -------------------------------------
        // System.out.print("Enter a number: ");
        // int num = scr.nextInt();

        // curiousCaseOfBenjaminBulbs(num);
        
        // System.out.println(inverseOfANumber(num));

        // reverseANumber(num);

        // ---------------------------------------
        // System.out.println("Enter First Number: ");
        // int num1 = scr.nextInt();
        // System.out.println("Enter Second Number: ");
        // int num2 = scr.nextInt();
        // calcGCDAndLCM(num1, num2);

        // ---------------------------------------
        System.out.print("Enter a number: ");
        int num = scr.nextInt();
        primeFactorisationOfANumber(num);
    }
}

// javac l002.java && java l002