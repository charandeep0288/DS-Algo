/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class leetcode {
    // ------------------------------------------------------------------------------
    // O(n^2)
     public static int height( TreeNode node ){
        return node == null ? -1 : Math.max(height(node.left), height(node.right)) + 1 ;
    }

    // O(n^2)
    public static boolean isBalanceTree( TreeNode node ){
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
    public boolean isBalanced( TreeNode node ){
        return isBalanceTree(node);
    }
    
    
    // --------------------------------------------------------------------------------
    // O(n) most readable code
//     public class balPair{ // isBSTPair
//         int height = -1; // by default in terms of edge
//         boolean isBST = true;
//     }
    
//     public balPair isBal2( TreeNode node ){
//         if( node == null )
//             return new balPair();

//         balPair lPair = isBal2(node.left); // left Pair
//         if( !lPair.isBST )
//             return lPair; // lpair return kar dia kio ki voo wasa bhi false hai

//         balPair rPair = isBal2(node.right); // right Pair
//         if(!rPair.isBST)
//             return rPair;

//         balPair myAns = new balPair();
//         if( Math.abs(lPair.height - rPair.height) > 1 ){ // humasa galat wali chiz check karni chahia 
//             myAns.isBST = false;
//             return myAns;
//         } 

//         myAns.height = Math.max(lPair.height, rPair.height) + 1;
//         return myAns;
//     }
//     public boolean isBalanced(TreeNode root) {
//         return isBal2(root).isBST;
//     }
    
    
    // ----------------------------------------------------------------------------------------
    // yaa code readable nahi hai (jugadu solution)
//     public int isBal3_( TreeNode node ){
//         if( node == null )
//             return -1;

//         int lh = isBal3_( node.left ); // left height
//         if( lh == -2 ) // matlab BST nahi hai, tho lh hi return kar doo
//             return lh;

//         int rh = isBal3_(node.right); // right height
//         if( rh == -2 ) // -2 kia kahana chata hai muaja nahi pata 
//             return rh;

//         if( Math.abs(lh - rh) > 1 ){
//             return -2;
//         }

//         return Math.max(lh, rh) + 1;
//     } 

//     public boolean isBalanced( TreeNode node ){
//         int ans = isBal3_(node);
//         return ans != -2 ? true : false;
//     }
    
}