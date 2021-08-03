import java.io.*;
import java.util.*;

public class Main {
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
  
    //---------------------------------------------
    public static int height( Node node ){
        return node == null ? -1 : Math.max(height(node.left), height(node.right)) + 1 ;
    }

    // O(n^2)
    public static boolean isBalanceTree( Node node ){
        if( node == null )
            return true;

        if(!isBalanceTree(node.left)) // left balance hai ki nahi bata hai, agar nahi hai tho return false;
            return false;

        if(!isBalanceTree(node.right)) // tells right balance hai ki nahi, agar nahi hai tho return false;
            return false;

        int lh = height(node.left); // left height
        int rh = height(node.right); // right height

        // 0 <= diff <= 1 
        int diff = Math.abs(lh - rh);

        if( diff > 1 ) // humasha galat vala case dekhna chahia 
            return false; 

        return true;
    }
    
    
    
    // ------------------------------------------------------------------------
    // most readable code ( this is industry level code)
    public static class balPair{ // isBSTPair
        int height = -1; // by default in terms of edge
        boolean isBST = true;
    }
    
    // O(n)
    public static balPair isBal2( Node node ){
        if( node == null )
            return new balPair();

        balPair lPair = isBal2(node.left); // left Pair
        if( !lPair.isBST )
            return lPair; // lpair return kar dia kio ki voo wasa bhi false hai

        balPair rPair = isBal2(node.right); // right Pair
        if(!rPair.isBST)
            return rPair;

        balPair myAns = new balPair();
        if( Math.abs(lPair.height - rPair.height) > 1 ){ // humasa galat wali chiz check karni chahia 
            myAns.isBST = false;
            return myAns;
        } 

        myAns.height = Math.max(lPair.height, rPair.height) + 1;
        return myAns;
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

    Node root = construct(arr);
    
    // write your code here
    // System.out.println(isBalanceTree(root));
    
    System.out.println(isBal2(root).isBST);
  }

}