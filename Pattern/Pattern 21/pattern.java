import java.util.*;

public class pattern {

    public static  Scanner scr = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
       
        int n = scr.nextInt();
        int nsp = n-1;
        int nst = 1;
        int helper = 1; //helps decide b/w '*' & '#'

        for(int i = 1; i <= n; i++){
          //for spaces
          for(int j = 1; j <=nsp; j++){
            System.out.print("\t");
          }
          //for '*' & '#'
          for(int j = 1; j <= nst; j++){
            if(helper % 2 == 0){
              System.out.print("#\t");
            }
            else{
              System.out.print("*\t");
            }
            helper++;
          }
          nsp--;
          nst += 2;
          System.out.println();
        }
    }
}

// import java.util.*;

// public class pattern
// {
//     public static Scanner scr = new Scanner(System.in);

//     public static void printPattern( int n )
//     {
//         int nor = n;
//         int nst = 1;
//         int nsp = n - 1;

//         for( int cr = 1 ; cr <= nor ; cr++ )
//         {
//             for( int csp = 1 ; csp <= nsp ; csp++ )
//             {
//                 System.out.print("\t");
//             }

//             for( int cst = 1 ; cst <= nst ; cst++)
//             {
//                 // System.out.print("#\t");
//                 if( cr % 2 == 0 )
//                 {
//                     if( cst % 2 != 0 )
//                     {
//                         System.out.print("#\t");
//                     }
//                     else
//                     {
//                         System.out.print("*\t");
//                     }
//                 }
//                 else if( cr % 2 != 0 )
//                 {
//                     if( cst % 2 != 0 )
//                     {
//                         System.out.print("*\t");
//                     }
//                     else
//                     {
//                         System.out.print("#\t");
//                     }
//                 }
//             }
//             nst += 2;
//             nsp--;
//             System.out.println();
//         }


//     }
//     public static void main(String [] args)
//     {
//         int n = scr.nextInt();

//         printPattern(n);
//     }
// }

// // javac pattern.java && java pattern >output.txt