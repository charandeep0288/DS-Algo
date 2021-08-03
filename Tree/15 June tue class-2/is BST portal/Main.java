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

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }


    // ----------------------------------------------------------------
    static Node prev = null;
    public static boolean isBST(Node node){
        if( node == null ) 
            return true; // matlab empty node bhi bst hota hai       & ik node hai tho woo bhi bst hai

        if( !isBST(node.left))
            return false;
        
        // inorder
        if( prev != null && prev.data > node.data )
            return false;

        prev = node;

        if( !isBST(node.right))
            return false;
        
        return true;
    }
    
    // ----------------------------------------------------------------
    public static class isBSTPair{
        boolean isBST = true;
        int maxEle = -(int)1e9;
        int minEle = (int)1e9;
    }
    
    public static isBSTPair isBST_02(Node node){
        if( node == null )
            return new isBSTPair(); 

        isBSTPair left = isBST_02(node.left);
        if(!left.isBST)
            return left; // agar BST nahi hai tho aga check karna ki jarurat nahi baki kaa tree

        isBSTPair right = isBST_02(node.right);
        if(!right.isBST)
            return right;

        isBSTPair self = new isBSTPair();
        self.isBST = false; 

        if(left.maxEle < node.data && right.minEle > node.data){
            self.minEle = Math.min(left.minEle, node.data); // ideally left mai min element milna chahia but agar +infinity ata hai tho node khud hi min element ban jai gaa 
            self.maxEle = Math.max(right.maxEle, node.data); // because -1e9 was coming for max element for self tree
            self.isBST = true;
        }

        return self;
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
    System.out.println(isBST(root));
    // System.out.println(isBST_02(root).isBST);
  }

}