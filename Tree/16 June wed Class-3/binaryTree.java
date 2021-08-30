public class binaryTree {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node( int data, Node left, Node right ){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node( int data ){
            this(data, null, null);
        }
    }

    // for leetcode Questions
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
    }

    //---------------------------------------------
    // leetcode-110
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

    // ----------------------------------------------------
    // leetcode-110
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

    // ---------------------------------------------------
    // leetcode-110
    // yaa code readable nahi hai (jugadu solution)
    public static int isBal3_( Node node ){
        if( node == null )
            return -1;

        int lh = isBal3_( node.left ); // left height
        if( lh == -2 ) // matlab BST nahi hai, tho lh hi return kara doo
            return lh;

        int rh = isBal3_(node.right); // right height
        if( rh == -2 ) // -2 kia kahana chata hai muaja nahi pata 
            return rh;

        if( Math.abs(lh - rh) > 1 ){
            return -2;
        }

        return Math.max(lh, rh) + 1;
    } 

    public static boolean isBal3( Node node ){
        int ans = isBal3_(node);
        return ans != -2 ? true : false;
    }


    // -----------------------------------------------
    // first solution
    // TILT OF A BINARY TREE (leetcode 563)
    public static class tiltPair{
        int tiltSF = 0; // tilt so far
        int sum = 0;
    }

    public tiltPair findTilt_( TreeNode root ){
        if( root == null )
            return new tiltPair();

        tiltPair left = findTilt_( root.left );
        tiltPair right = findTilt_( root.right );

        tiltPair myAns = new tiltPair();

        myAns.tiltSF = left.tiltSF + right.tiltSF + Math.abs( left.sum - right.sum );
        myAns.sum = left.sum + right.sum + root.val;
        return myAns;
    }
    
    public int findTilt(TreeNode root) {
        return findTilt_(root).tiltSF;
    }

    // ------------------------------------------------
    // second solution
    // { tilt, sum } // like pair of c++
    public int[] findTilt2( TreeNode root ){ 
        if( root == null )
            return new int[2]; // yaa array vala kam tab kara gai jab mara pair class (in 1st solution) kaa sara variable ik hi datatype kaa hai (like int in this case).

        int[] left = findTilt2( root.left );
        int[] right = findTilt2( root.right );

        int [] myAns = new int[2];
        myAns[0] = left[0] + right[0] + Math.abs(left[1] - right[1]);
        myAns[1] = left[1] + right[1] + root.val;
        return myAns;
    }

    // public int findTilt( TreeNode root ){
    //     return findTilt2(root)[0];
    // }

    // ------------------------------------------------
    // leetcode 543 DIAMETER OF A BINARY TREE
    public int height(TreeNode node){
        return (node == null) ? -1 : Math.max(height(node.left), height(node.right)) + 1;
    }

    // -------- O(n^2) solution (slow hai solution) ---------
    public int diameterOfBinaryTree_(TreeNode root){
        if(root == null)
            return 0;
        
        int ld = diameterOfBinaryTree_(root.left); // left diameter 
        int rd = diameterOfBinaryTree_(root.right); // right diameter
        
        int lh = height(root.left); // left sub tree height
        int rh = height(root.right); // right sub tree height 
        
        return Math.max(Math.max(ld, rd), lh + rh + 2);
    }


    // ---------- O(n) solution -----------
    // { diameter, height }
    public int[] diameterOfBinaryTree_02(TreeNode root){
        if(root == null)
            return new int[]{0, -1}; // for no node its diameter -> 0, height -> -1

        int[] ld = diameterOfBinaryTree_02(root.left);
        int[] rd = diameterOfBinaryTree_02(root.right);

        int[] myAns = new int[2];
        myAns[0] = Math.max(Math.max(ld[0], rd[0]), ld[1] + rd[1] + 2);
        myAns[1] = Math.max(ld[1], rd[1]) + 1;

        return myAns;
    }
    
    // --------- 3rd solution with static variable ----------
    // bas yaa thori se memory extra lata hai yaa static vala solution
    int diameter = 0; // static variable
    public int diameterOfBinaryTree_03(TreeNode root){
        if(root == null)
            return -1;
        
        int ld = diameterOfBinaryTree_03(root.left);
        int rd = diameterOfBinaryTree_03(root.right);

        diameter = Math.max(diameter, ld + rd + 2); // iss line koo hata dai tho yaa code height of binary tree kaa hai
        return Math.max(ld, rd) + 1;
    }

    
    public int diameterOfBinaryTree(TreeNode root) {
        // return diameterOfBinaryTree_(root); // 1st solution O(n^2)
        
        // return diameterOfBinaryTree_02(root)[0]; // 2nd solution O(n) 

        diameterOfBinaryTree_03(root); // 3rd solution with static variable 
        return diameter;
    }


    // -----------------------------------------------------
    // largest BST (on portal)
    public static class lBSTPair{ // largest BST pair
        boolean isBST = true;
        int max = -(int) 1e9;
        int min = (int) 1e9;

        int MaxSize = 0; // max size joo BST exist karta hai
        Node MaxBSTNode = null; // woo node kaa address joo largerst BST hai
    }

    public static lBSTPair largestBST(Node node){
        if(node == null)
            return new lBSTPair();

        lBSTPair left = largestBST(node.left);
        lBSTPair right = largestBST(node.right);

        lBSTPair myAns = new lBSTPair();
        if(left.isBST && right.isBST && left.max < node.data && node.data > right.min){
            myAns.isBST = true;
            myAns.min = Math.min(left.min, node.data);
            myAns.max = Math.max(right.max, node.data);

            myAns.MaxSize = left.MaxSize + right.MaxSize + 1;
            myAns.MaxBSTNode = node;
        } else {
            myAns.isBST = false;
            // max & min ko set karna ki jarurat nahi, karan chaha tho kar sakta hai 
            myAns.MaxSize = Math.max(left.MaxSize, right.MaxSize);
            myAns.MaxBSTNode = left.MaxSize > right.MaxSize ? left.MaxBSTNode : right.MaxBSTNode;
        }

        return myAns;
    }
}
