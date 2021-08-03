import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class binary_Tree {

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

    // ====================================================
    // FOR LEETCODE QUESTIONS
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // ====================================================

    // -------------------------------------------------
    // LevelOrder Traversal of Binary Tree (on portal)
    public static void levelOrder(Node node) {
        LinkedList<Node> que = new LinkedList<>(); // removeFirst, addLast
        que.addLast(node);
        int level = 0;

        while (que.size() != 0) {
            int size = que.size(); // size of current level
            while (size-- > 0) {
                Node rn = que.removeFirst(); // remove Node
                System.out.print(rn.data + " ");

                if (rn.left != null)
                    que.addLast(rn.left);
                if (rn.right != null)
                    que.addLast(rn.right);
            }

            // level vala kam idar karna hota hai
            level++;
            System.out.println();
        }
    }

    // ------------------------------------------------------
    // leetcode-102 (Binary Tree Level Order Traversal)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        LinkedList<TreeNode> que = new LinkedList<>(); // addLast, removeFirst
        que.addLast(root);

        int level = 0;

        while (que.size() != 0) {
            int size = que.size();
            List<Integer> smallAns = new ArrayList<>();
            while (size-- > 0) {
                TreeNode rn = que.removeFirst();
                smallAns.add(rn.val);

                if (rn.left != null)
                    que.addLast(rn.left);
                if (rn.right != null)
                    que.addLast(rn.right);
            }
            level++;
            ans.add(smallAns);
        }
        return ans;
    }

    // ------------------------------------------------------
    // Level order - Linewise - ZigZag of binary tree
    public static List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        LinkedList<TreeNode> que = new LinkedList<>(); // removeFirst, addLast
        LinkedList<TreeNode> st = new LinkedList<>(); // removeFirst, addFirst

        que.addLast(root);
        int level = 0;

        while (que.size() != 0) {
            int size = que.size();
            List<Integer> smallAns = new ArrayList<>();
            while (size-- > 0) {
                TreeNode rn = que.removeFirst(); // remove Node
                smallAns.add(rn.val); // rn.data

                if (level % 2 == 0) { // even level pai right to left
                    if (rn.left != null)
                        st.addFirst(rn.left);

                    if (rn.right != null)
                        st.addFirst(rn.right);
                } else { // odd level pai left to right
                    if (rn.right != null)
                        st.addFirst(rn.right);

                    if (rn.left != null)
                        st.addFirst(rn.left);
                }
            }
            level++; // level use hoo raha hia idar abb
            ans.add(smallAns);

            // swaping refrences of the stack & queue
            LinkedList<TreeNode> temp = que;
            que = st;
            st = temp;
        }
        return ans;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        return zigzag(root);
    }
    
}
