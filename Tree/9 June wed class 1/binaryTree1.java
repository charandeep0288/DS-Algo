import java.util.ArrayList;
import java.util.List;

public class binaryTree1 {
    // static => matlab class ki tahra use kar raha hai 
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        // constructor chaning => ik constructor mai dusra constructor koo call karta hai
        Node(int data) {                   
            this(data, null, null); // apna class mai constructor koo call kar raha hai
            // this.data = data; // yaa line dubara likna ki jarurat nahi ( oop's ka rules ka kilaf hai )
            // this.left = this.right = null;
        }
    }

    // =================================================
    // for leetcode QUESTIONS this is needed
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // ====================================================

    // -----------------------------------------------------
    public static void preOrder(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        ans.add(root.data);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }

    // ---------------------------------------------------
    // leetcode 144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        List<Integer> myAns = new ArrayList<>();
        
        myAns.add(root.val);
        
        List<Integer> left = preorderTraversal(root.left);
        for( int ele : left )   myAns.add(ele);
        
        List<Integer> right = preorderTraversal(root.right);
        for( int ele : right )  myAns.add(ele);
        
        return myAns;
    }

    // ------------------------------------------------
    public static void inOrder(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        inOrder(root.left, ans);
        ans.add(root.data); // ArrayList heap paa create hoti hai
        inOrder(root.right, ans);
    }

    // -------------------------------------------------
    // leetcode 94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        if( root == null ){
            return new ArrayList<>();
        }
        
        List<Integer> myAns = new ArrayList<>();
        
        List<Integer> left = inorderTraversal( root.left );
        
        // myAns.addAll(left); // to add all element in ArrayList
        for( int ele : left ) myAns.add(ele);
        
        myAns.add(root.val);
        
        List<Integer> right = inorderTraversal(root.right);
        
        for( int ele : right ) myAns.add(ele);
        
        return myAns;
            
    }

    // ----------------------------------------------------
    public static void postOrder(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.data);
    }

    // -------------------------------------------
    // leetcode 145. Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        List<Integer> myAns = new ArrayList<>();
        
        List<Integer> left = postorderTraversal(root.left);
        for( int ele : left )   myAns.add(ele);
        
        List<Integer> right = postorderTraversal(root.right);
        for (int ele :right )  myAns.add(ele);
        
        myAns.add(root.val);
        
        return myAns;
    }

    // ------------------------------------------------------
    public static int size( Node node ){
        // if( node == null )
        //     return 0;

        // int count = 1; // khud kaa lia 1 likha hai
        // count += size(node.left);
        // count += size(node.right);
        
        // return count;

        if( node == null )
            return 0;

        int leftSize = size(node.left);
        int rightSize = size(node.right);

        return leftSize + rightSize + 1;

        // return node == null ? 0 : size(node.left) + size(node.right) + 1; 
    }

    // -----------------------------------------------------
    public static int sum( Node node ){
        // if( node == null )
        //     return 0;

        // int recAns = node.data;
        // recAns +=  sum( node.left );
        // recAns += sum( node.right );
        
        // return recAns;

        if( node == null )
            return 0;
        
        int leftSum = sum( node.left );
        int rightSum = sum( node.right );

        return leftSum + rightSum + node.data; 


        // return node == null ? 0 : sum( node.left ) + sum( node.right ) + node.data; 
    }

    // ----------------------------------------------------
    // post order
    public static int max( Node node ){
        if( node == null )
            return -(int)1e9;
        
        int leftMax = max( node.left );
        int rightMax = max( node.right );

        return Math.max( Math.max( leftMax, rightMax ), node.data );
        
        // return node == null ? -(int)1e9 : Math.max( node.data, Math.max( max(node.left), max(node.right) ) );
    }

    // post order
    public static int max2( Node node ){
        if( node == null )
            return -(int)1e9;

        int maxEle = node.data;
        maxEle = Math.max(maxEle, max2( node.left ) );
        maxEle = Math.max( maxEle, max2( node.left ) );

        return maxEle;
    }
    
    // --------------------------------------------------
    public static int min( Node node ){
        if( node == null )
            return (int)1e9;
        
        int leftMin = min(node.left);
        int rightMin = min(node.right);

        return Math.min(Math.min(leftMin, rightMin), node.data);

        // return node == null ? -(int)1e9 : Math.min( node.data, Math.min( min(node.left), min(node.right) ) );
    }

    // ----------------------------------------------------
    // Height in Terms of Edges return -1 or null, Height in terms of no. of Nodes return 0 at null
    public static int height( Node node){
        return node == null ? -1 : Math.max( height( node.left ), height( node.right ) ) + 1;
    }

    // -----------------------------------------------------
    // https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1
    public static int countLeaves( Node node ){
        if( node == null )
            return 0;

        if( node.left == null && node.right == null )
            return 1;

        // int count = 0;
        // count += countLeaves( node.left );
        // count += countLeaves( node.right );

        return countLeaves(node.left) + countLeaves(node.right);
    }

    // -------------------------------------------------
    // Print the nodes having exactly one child in a Binary Tree
    // https://www.geeksforgeeks.org/print-the-nodes-having-exactly-one-child-in-a-binary-tree/
    public static void exactlyOneChild( Node node, ArrayList<Integer> ans ){
        if( node == null || node.left == null && node.right == null )
            return;
        if( node.left == null || node.right == null )
            ans.add(node.data);

        exactlyOneChild( node.left, ans );
        exactlyOneChild( node.right, ans );    
    }

    // ----------------------------------------------------
    public static int countExactlyOneChild( Node node ){
        if( node == null || ( node.left == null && node.right == null ) )
            return 0;

        int left = countExactlyOneChild( node.left );
        int right = countExactlyOneChild( node.right );
        int sum = left + right; 

        if( node.left == null || node.right == null )
            sum++;
        
        return sum;
    }
}
