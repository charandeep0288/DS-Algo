// solution 2 sir vala
import java.util.*;

public class Main18{
    
    public static void print2Triangle(int n)
    {
        int nst = n; // number of stars
        int nosp = 0; // number of outer spaces
        int nor = n; // number of rows
        
        for( int cr = 1 ; cr <= nor ; cr++ ) // current row
        {
            
            for( int cosp = 1 ; cosp <= nosp ; cosp++ )
            {
                System.out.print("\t");
            }
            
            for( int cst = 1 ; cst <= nst ; cst++ ) //current star
            {
                if( cr <= nor / 2 && (cr != 1) && cst != 1 && cst != nst)
                {
                    System.out.print("\t");
                }
                else
                {
                    System.out.print("*\t");
                }
            }
            
            if(cr <= nor/2)
            {
                nst -= 2;
                nosp++;
                
            }
            else
            {
                nst += 2;
                nosp--;
            }
            System.out.println();
        }
    }

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n = scn.nextInt();
     print2Triangle(n);
     scn.close();

 }
}


// //solution 1 done by me
// import java.util.*;

// public class Main18{
    
//     public static void print2Triangle(int n)
//     {
//         int nst = n; // number of stars
//         int nosp = 0; // number of outer spaces
//         int nor = n; // number of rows
        
//         for( int cr = 1 ; cr <= nor ; cr++ ) // current row
//         {
            
//             for( int cosp = 1 ; cosp <= nosp ; cosp++ )
//             {
//                 System.out.print("\t");
//             }
            
//             for( int cst = 1 ; cst <= nst ; cst++ ) //current star
//             {
// if( cr <= nor / 2 && (cr == 1 || cr+nosp == nor+1 || cr == cst+nosp) || cr > n/2)
//                 {
//                     System.out.print("*\t");
//                 }
//                 else
//                 {
//                     System.out.print("\t");
//                 }
//             }
            
//             if(cr <= nor/2)
//             {
//                 nst -= 2;
//                 nosp++;
                
//             }
//             else
//             {
//                 nst += 2;
//                 nosp--;
//             }
//             System.out.println();
//         }
//     }

// public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//      // write ur code here
//      int n = scn.nextInt();
//      print2Triangle(n);
//      scn.close();
//  }
// }


 // javac Main18.java && java Main18
// javac Main18.java && java Main18 > output18.txt  