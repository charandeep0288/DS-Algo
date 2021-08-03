import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static Scanner scr =  new Scanner(System.in);

    public static void specialIndex(ArrayList<Integer> arr)
    {
        int i =0, j = arr.size()- 1;
        int sum1 = 0, sum2 = 0;
        int p = -1, q = -1; 
        while( i < j )
        {
            sum1 += arr.get(i);
            sum2 += arr.get(j);

            // System.out.print( sum1 + " "  );
            if( sum1 == sum2 )
            {
                p = i;
                q = j;
                break;
            }
            i++;
            j--;
        }
        for( int z = p + 1 ; z < q  ; z++ )
        {
            System.out.print(arr.get(z) + "  ");
        }
    }
    public static void main(String[] args)
    {
        // int n = 8;
        ArrayList<Integer> arr = new ArrayList<>();

        for( int i = 0 ; i < 7 ; i++)
        {
            int a = scr.nextInt();
            arr.add(a);
        }

        specialIndex(arr);
    }
}

// javac Main.java && java Main