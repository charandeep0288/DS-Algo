

// import java.util.*;

// public class Main19 {

//     public static void printSwastikPattern( int n)
//     {
//         for( int cr = 1 ; cr <= n ; cr++)
//         {
//             for( int cc = 1 ; cc <= n ; cc++ )
//             {
//                 if(cr == 1 && (cc <= (n/2)+1 || cc == n)) // condition 1
//                 {
//                     System.out.print("*\t");
//                 }
//                 else if(cr <= n/2 && (cc == (n/2)+1 || cc == n ))  // condition 2
//                 {
//                     System.out.print("*\t");
//                 }
//                 else if(cr == (n/2)+1) // condition 3
//                 {
//                     System.out.print("*\t");
//                 }
//                 else if(cr > n/2 && (cc == 1 || cc == (n/2)+1))  // condition 4
//                 {
//                     System.out.print("*\t");
//                 }
//                 else if(cr == n && (cc == 1 || cc > n/2))  // condition 5
//                 {
//                     System.out.print("*\t");
//                 }
//                 else
//                 {
//                     System.out.print("\t");
//                 }
//             }
//             System.out.println();
//         }
//     }

//     public static void main( String [] args) {
//         Scanner scn = new Scanner(System.in);

//         // write ur code here
//         int n = scn.nextInt();
//         printSwastikPattern(n);
//         scn.close();

//     }
// }


 // javac Main19.java && java Main19
// javac Main19.java && java Main19 > output19.txt