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

    // ----------------------------------------------------
    // on portal
    public static int minimum(Node node){
        while(node.left != null)
            node = node.left;
            
        return node.data;
    }
    
    public static int maximum(Node node){
        while(node.right != null)
            node = node.right;
            
        return node.data;
    }
    
    public static Node removeNode_02(Node node, int data){
        if( node == null) 
            return null;
        
        if( node.data < data ) 
            node.right = removeNode_02(node.right, data);
        else if( node.data > data ) 
            node.left  = removeNode_02(node.left, data);
        else{ 
            if(node.left == null || node.right == null)
                return node.left != null ? node.left : node.right; // case I, II, III

            // left kaa maximum lai kaa bhi kar sakta hai -> jasa yaha right ka minimum liya hai
            // int minEle = minimum(node.right);
            // node.data = minEle;

            int maxEle = maximum(node.left);
            node.data = maxEle;
            
            // node.right = removeNode_02(node.right, minEle);
            node.left = removeNode_02(node.left, maxEle);
        }

        return node;
    }
    
  public static Node remove(Node node, int data) {
    // write your code here
    return removeNode_02(node, data);
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

    Node root = construct(arr);
    root = remove(root, data);

    display(root);
  }

}