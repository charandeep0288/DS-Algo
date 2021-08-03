import java.io.*;
import java.util.*;

public class Main2 {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

   

   public static void kLevelDown( Node node, int k, Node blockNode){
        if( node == null || k < 0 || node == blockNode )
            return;
        
        if( k == 0 ){
            System.out.println(node.data);
            return;
        }
        
        kLevelDown(node.left, k - 1, blockNode);
        kLevelDown(node.right, k - 1, blockNode);
    }
    
//   public static boolean nodeToRootPath( Node node, int data, ArrayList<Node> ans){
//       if( node == null )
//         return false;
        
//       if( node.data == data ){
//           ans.add(node);
//           return true;
//       }
      
//       boolean recAns = nodeToRootPath( node.left, data, ans ) || nodeToRootPath( node.right, data, ans );
//       if( recAns )
//         ans.add(node);
        
//       return recAns;
//   }
 
  
  
//   public static void printKNodesFar(Node node, int data, int k) {
//     // write your code here
//     ArrayList<Node> list = new ArrayList<>();
//     nodeToRootPath(node, data, list);
    
//     Node block = null;
//     for( int i = 0 ; i < list.size() ; i++ ){
//         kLevelDown( list.get(i), k - i, block );
//         block = list.get(i);
//     }
//   }


    public static int printKNodesFar(Node node, int data, int k){
        if(node == null)
            return -1; // joo ans kaa part nahi ban sakti

        if( node.data == data){
            kLevelDown(node, k, null);
            return 1; // return 1; batata hai mara se mara parent ka distance kitan hai
        }

        int ld = printKNodesFar(node.left, data, k); // left data
        if( ld != -1 ){ // matlab left se javab aya hai
            kLevelDown(node, k - ld, node.left);
            return ld + 1;
        }

        int rd = printKNodesFar(node.right, data, k); // right data
        if(rd != -1){
            kLevelDown(node, k - rd, node.right);
            return rd + 1;
        }

        return -1;
    }
    
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    printKNodesFar(root, data, k);
  }

}