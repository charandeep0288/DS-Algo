import java.util.ArrayList;

public class binaryTree2 {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data) {                   
            this(data, null, null); 
        }
    }

    // -------------------------------------------------------
    public static boolean findData( Node node, int data ){
        if( node == null )
            return false;

        if( node.data == data )
            return true;

        return findData(node.left, data) || findData(node.right, data);   
    }

    // -------------------------------------------------------
    public static boolean nodeToRootPath( Node node, int data, ArrayList<Node> ans ){
        if( node == null )
            return false;

        if( node.data == data ){
            ans.add(node);
            return true;
        }

        boolean recAns = nodeToRootPath(node.left, data, ans) || nodeToRootPath(node.right, data, ans);
        if(recAns)
            ans.add(node);

         return recAns;   
    }

    public static ArrayList<Node> nodeToRootPath( Node root, int data ){
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath(root, data, ans);
        return ans;
    }

    // -----------------------------------------------------
    public static ArrayList<Node> nodeToRootPath_02(Node node, int data){
        if( node == null )
            return null; // ArrayList heap pai store hota hai, and heap pai yaa koi address store hota hia yaa fir null hota hai
        
        if( node.data == data ){
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        ArrayList<Node> left = nodeToRootPath_02(node.left, data);
        if(left != null){
            left.add(node);
            return left;
        }

        ArrayList<Node> right = nodeToRootPath_02(node.right, data);
        if(right != null){
            right.add(node);
            return right;
        }

        return null; // matlab koi data nahi mila tho koi address nahi
    } 

    public static ArrayList<Node> nodeToRootPath02_(Node node, int data){
        ArrayList<Node> ans = nodeToRootPath_02(node, data);
        return ans != null ? ans : new ArrayList<>();
    }

    //-------------------------------------------------------
    // we are storing data at k level in binary tree
    public static void KLevelDown( Node node, int k, ArrayList<Integer> ans ){
        if( node == null || k < 0 )
            return;
        
        if( k == 0 ){
            ans.add(node.data);
            return;
        }

        KLevelDown(node.left, k - 1, ans);
        KLevelDown(node.right, k - 1, ans);
    }
    
    // -----------------------------------------------------
    // kaway
    // https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1
    public static void KLevelDown_01( Node node, int k, Node blockNode, ArrayList<Integer> ans ){
        if( node == null || k < 0 || node == blockNode )
            return;
        
        if( k == 0 ){
            ans.add(node.data);
            return;
        }

        KLevelDown_01(node.left, k - 1, blockNode, ans);
        KLevelDown_01(node.right, k - 1, blockNode, ans);
    }

    public static ArrayList<Integer> kaway( Node node, int data, int k ){
        ArrayList<Node> list = new ArrayList<>();
        nodeToRootPath(node, data, list);

        ArrayList<Integer> ans = new ArrayList<>();
        Node block = null;
        for( int i = 0 ; i < list.size() ; i++ ){
            KLevelDown_01(list.get(i), k - i, block, ans);
            block = list.get(i);
        }

        return ans; // return kara yaa fir print kara 
    }

    // -------------------------------------------------------
    // recursion space ka alava ArrayList vala space nahi lia humna
    public static int kaway2(Node node, int data, int k, ArrayList<Integer> ans){
        if(node == null)
            return -1; // joo ans kaa part nahi ban sakti

        if( node.data == data){
            KLevelDown_01(node, k, null, ans);
            return 1; // return 1; batata hai mara se mara parent ka distance kitan hai
        }

        int ld = kaway2(node.left, data, k, ans); // left data
        if( ld != -1 ){ // matlab left se javab aya hai
            KLevelDown_01(node, k - ld, node.left, ans);
            return ld + 1;
        }

        int rd = kaway2(node.right, data, k, ans); // right data
        if(rd != -1){
            KLevelDown_01(node, k - rd, node.right, ans);
            return rd + 1;
        }

        return -1;
    }

    // -----------------------------------------------------
    // Binary Search Tree
    // -----------------------------------------------------

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

    //-----------------------------------------------------
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

    // ----------------------------------------------------
    // leetcode-98 ( Validate Binary Search Tree )
    public class isBSTPair{
        boolean isBST = true;
        long maxEle = -(long)1e13; // range baad gai
        long minEle = (long)1e13;
    }
    
    public isBSTPair isBST_03(TreeNode node){
        if( node == null )
            return new isBSTPair(); 

        isBSTPair left = isBST_03(node.left);
        if(!left.isBST)
            return left; 
        
        isBSTPair right = isBST_03(node.right);
        if(!right.isBST)
            return right;

        isBSTPair self = new isBSTPair();
        self.isBST = false; 

        if(left.maxEle < node.val && right.minEle > node.val){
            self.maxEle = Math.max(right.maxEle, node.val); 
            self.minEle = Math.min(left.minEle, node.val); 
            self.isBST = true;
        }

        return self;
    }

    public boolean isValidBST(TreeNode root) {
        isBSTPair ans = isBST_03( root );
        return ans.isBST;
    }

    //-------------------------------------------------------
    // leetcode-98 ( Validate Binary Search Tree )
    TreeNode prev = null;
    public boolean isBST(TreeNode node){
        if( node == null ) 
            return true; 
        
        if( !isBST(node.left))
            return false;
        
        // inorder
        if( prev != null && prev.val >= node.val )
            return false;

        prev = node;

        if( !isBST(node.right))
            return false;
        
        return true;
    }


    public boolean isValidBST(TreeNode root) {
        return isBST( root );
        
    }



}
