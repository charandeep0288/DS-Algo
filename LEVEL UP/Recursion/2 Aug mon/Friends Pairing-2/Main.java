import java.io.*;
import java.util.*;

public class Main {

     public static int c = 1;
    public static void friendsPairing(int count, int n, boolean[] used, String asf){
        if(count == n){
            System.out.println(c++ + "." + asf);
            return;
        }

        int fup = 1; // first un used person
        while(fup <= n && used[fup])
            fup++;

        used[fup] = true;
        friendsPairing(count + 1, n, used, asf + "(" + fup + ") ");

        for( int pp = fup + 1 ; pp <= n ; pp++){ // pair person
            if(!used[pp]){
                used[pp] = true;
                friendsPairing(count + 2, n, used, asf + "(" + fup + "," + pp + ") ");
                used[pp] = false;
            }
        }
        used[fup] = false;
    }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    friendsPairing(0, n, used, "");
  }
}
