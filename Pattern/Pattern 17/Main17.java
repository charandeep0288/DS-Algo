// solution 2
import java.util.*;

public class Main17 {
    
    public static void printPattern( int n )
    {
        int nor = n ; // number of rows 
        int nst = 1; // number of stars 
        int nsp = n/2; // number of spaces
        
        for( int cr = 1 ; cr <= nor ; cr++ ) // current row
        {
            
            for( int csp = 1 ; csp <= nsp ; csp++) //current space
            {
                System.out.print("\t");
            }
            
            for( int cst = 1 ; cst <= nst ; cst++) // current star
            {
                if(cst <= nst/2 && cr != (n/2)+1 )
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
                nst += 2;
                nsp--;
            }
            else
            {
                nst -= 2;
                nsp++;
            }
            System.out.println();
            
        }
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        printPattern(n);

        scn.close();

    }
}



// solution 1
// import java.util.*;

// public class Main17 {
    
//     public static void printPattern( int n )
//     {
//         int nor = n ; // number of rows 
//         int nst = 1; // number of stars 
//         int nsp = n/2; // number of spaces
        
//         for( int cr = 1 ; cr <= nor ; cr++ ) // current row
//         {
            
//             for( int csp = 1 ; csp <= nsp ; csp++) //current space
//             {
//                  if(cr  == (nor/2)+1)
//                 {
//                     System.out.print("*\t");
//                 }
//                 else
//                 {
//                     System.out.print("\t");                    
//                 }
//             }
            
//             for( int cst = 1 ; cst <= nst ; cst++) // current star
//             {
//                 System.out.print("*\t"); 
//             }
            
//             if(cr <= nor/2)
//             {
//                 nst++;
//             }
//             else
//             {
//                 nst--;
//             }
//             System.out.println();
            
//         }
//     }


//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);

//         // write ur code here
//         int n = scn.nextInt();
//         printPattern(n);
//         scn.close();
//     }
// }