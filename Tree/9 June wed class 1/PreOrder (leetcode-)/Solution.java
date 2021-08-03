import java.util.ArrayList;
import java.util.List;

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
class Solution {
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
}