import java.util.*;

class lecture_001 {
    public static Scanner scr = new Scanner(System.in);

    public static void printMsg() // method => function
    {
        System.out.println("Hello World");
        System.out.println("HI, FRIENDS");
    }

    public static void printOddEven(int n) {
        if (n % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    public static boolean isEvenNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printMultipleOddEven()
    {   
        System.out.println();
        System.out.println("Enter Count : ");
        int count = scr.nextInt();
        for(int i=0 ; i < count ; i++)
        {
            int num = scr.nextInt();
            printOddEven(num);
        }
    }

    public static void main(String[] args) {
        // printMsg();

        int n = scr.nextInt();
        System.out.println(n);

        boolean res = isEvenNumber(n);
        if (res)
            System.out.println("Even");
        else {
            System.out.println("Odd");
        }

        printMultipleOddEven();
        
    }
}

// javac lecture_001.java && java lecture_001