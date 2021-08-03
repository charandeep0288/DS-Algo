import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericTree {

    public static class Node {
        int data;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    // ====================================================
    // FOR LEETCODE QUESTIONS

    public class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }

    }
    // ====================================================

    // ---------------------------------------------------
    // Levelorder Linewise (generic Tree) (on portal)
    public static void levelOrderLineWise(Node node) {
        LinkedList<Node> que = new LinkedList<>(); // removeFirst(), addLast()
        que.addLast(node);
        int level = 0;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Node rn = que.removeFirst(); // remove node
                System.out.print(rn.data + " ");

                for (Node child : rn.children)
                    que.addLast(child);
            }

            level++;
            System.out.println();
        }
    }

    // -----------------------------------------------------
    // leetcode -429 (N-ary Tree Level Order Traversal)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        int level = 0;

        while (que.size() != 0) {
            int size = que.size();
            // har level ka lia ik new ArrayList create kar raha hai
            List<Integer> smallAns = new ArrayList<>();
            while (size-- > 0) {
                Node rn = que.removeFirst();
                smallAns.add(rn.data); // rn.val

                for (Node child : rn.children) {
                    que.addLast(child);
                }
            }
            ans.add(smallAns);
            level++;
        }
        return ans;
    }

    // -------------------------------------------------------
    // Level order - Linewise - ZigZag of Generic Tree (on portal)
    public static void levelOrderLinewiseZZ(Node root) {
        if (root == null)
            return;

        LinkedList<Node> que = new LinkedList<>(); // removeFirst, addLast
        LinkedList<Node> st = new LinkedList<>(); // removeFirst, addFirst
        int level = 0;

        que.addLast(root);

        List<List<Integer>> ans = new ArrayList<>();
        while (que.size() != 0) {
            int size = que.size();
            List<Integer> smallAns = new ArrayList<>();

            while (size-- > 0) {
                Node rn = que.removeFirst();
                smallAns.add(rn.data);

                if (level % 2 == 0) { // even level pai right to left
                    for (Node child : rn.children)
                        st.addFirst(child);
                } else { // odd level pai left to right
                    for (int i = rn.children.size() - 1; i >= 0; i--) {
                        Node child = rn.children.get(i);
                        st.addFirst(child);
                    }
                }
            }

            level++; // level use hoo raha hia idar abb
            ans.add(smallAns);

            // swaping reffrences of the stack & queue
            LinkedList<Node> temp = que;
            que = st;
            st = temp;
        }

        for (List<Integer> a : ans) {
            for (int ele : a) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

}
