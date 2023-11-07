import java.util.Scanner;

class l001 {

    public static Scanner scr = new Scanner(System.in);

    public static void printMessage() {
        System.out.println("Hello World!!1");
        System.out.println("Good Morning");
    }

    public static void printOddEven(int n) {
        if(n % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    public static boolean isEvenNumber(int n) {
        if(n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printMultipleOddEven() {
        System.out.print("Enter the count(For how many values you want to check ODD or EVEN): ");
        int count = scr.nextInt();
        
        for(int i = 0 ; i < count ; i++) {
            System.out.print("Please Enter the Number: ");
            int num = scr.nextInt();
            printOddEven(num);
        }
    }

    public static void printTable(int n) {
        for( int i = 1 ; i <= 10 ; i++ ) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
        System.out.println();
    }

    public static void printMultipleTable(int p) {
        for(int i = 1 ; i <= p ; i++) {
            printTable(i);
        }
    }

    public static void main(String[] args) {
        // printMessage();

        // ----------------------------------------
        // System.out.print("Enter a number:- ");
        // int num = scr.nextInt();

        // printOddEven(num);
        
        // boolean res = isEvenNumber(num);
        // String isEven = res ? "Even" : "Odd";
        // System.out.println("Entered Number is " + isEven);
        // ----------------------------------------

        // printMultipleOddEven();

        // printTable(num);

        // System.out.print("Enter the limit to print the tables:- ");
        // int limit = scr.nextInt();
        // printMultipleTable(limit);

    }
}

// javac l001.java && java l001