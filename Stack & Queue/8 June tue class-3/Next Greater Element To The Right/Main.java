import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = nextGreater(a);
    display(nge);
 }

 public static int[] nextGreater(int[] arr){
   // solve
   int n = arr.length;

   int[] ans = new int[n];
   Arrays.fill(ans, -1);

   LinkedList<Integer> st = new LinkedList<>();
   for( int i = 0 ; i < n ; i++ ){
        while( st.size() != 0 && arr[st.getFirst()] < arr[i] )
            ans[st.removeFirst()] = arr[i];

        st.push(i); // st.addLast(i);
   }

//    for( int ele : ans )
//         System.out.println(ele);

   return ans;
 }

}