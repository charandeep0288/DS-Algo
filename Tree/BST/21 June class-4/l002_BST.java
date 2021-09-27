import java.util.ArrayList;
import java.util.Collections;

public class l002_BST {

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

    // ========================================
    // for leetcode Questions
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // ========================================

    // ------------------------------------------------
    // T: O(n) S: O(1)
    public static int size(Node node) {
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

    // ------------------------------------------------
    // T: O(n), S: O(1)
    // (height no. of edges ki terms mai nikal raha hai)
    public static int height(Node node) {
        return node == null ? -1 : Math.max(height(node.left), height(node.right)) + 1;
    }

    // ------------------------------------------------
    // T: O(log n) S: O(1)
    public static int maximum(Node node) { // yaa ensure karka call lagya iss function ko ki root null naa hoo
        while (node.right != null)
            node = node.right; // right most node of BST is maximum valued node

        return node.data;
    }

    // ------------------------------------------------
    // T: O(log n) S: O(1)
    public static int minimum(Node node) { // yaa ensure karka call lagya iss function ko ki root null naa hoo
        while (node.left != null)
            node = node.left; // left most value of BST is minimum valued node of BST

        return node.data;
    }

    // ------------------------------------------------
    // T: O(log n) S: O(1)
    public static boolean find(Node node, int data) { // work like BINARY SEARCH
        while (node != null) {
            if (node.data == data)
                return true;
            else if (node.data < data)
                node = node.right;
            else
                node = node.left;
        }

        return false;
    }

    // ------------------------------------------------
    // yaa sum vala question iteratively possible nahi hai
    // T: O(n), S: O(1)
    public static int sum(Node node) {
        return node == null ? 0 : sum(node.left) + sum(node.right) + node.data;
    }

    // -------------------------------------------------
    // height of BST == levels of BST
    // T: O(log n) S: O(1)
    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        ArrayList<Node> list = new ArrayList<>();
        boolean flag = false;
        while (node != null) {
            list.add(node);
            if (node.data == data) {
                flag = true;
                break;
            } else if (node.data < data)
                node = node.right;
            else
                node = node.left;
        }

        if (!flag) // flag false mila, matlab data nahi mila huma tree mai tho joo ArrayList bhari
                   // hai usa khali kara gai, then return kara gai
            list.clear();

        // RootToNodePath kaa lia hum list ko reverse nahi kara gai
        Collections.reverse(list); // nodeToRootPath nikalna hai, naa ki RootToNodePath iss liya ArrayList ko
                                   // reverse kar raha hai
        return list;
    }

    // ------------------------------------------
    // lowest comman ancestor => we calculate on lca on BST having unique data
    public static int lca(Node node, int d1, int d2) {
        int lca = -1;
        while (node != null) {
            if (node.data < d1 && node.data < d2)
                node = node.right;
            else if (node.data > d1 && node.data > d2)
                node = node.left;
            else { // decide nahi kar paa raha ki data kaha mila gaa tho matlab yaa vali node hi
                   // humari LCA node hai
                lca = node.data; // lca mil gya
                break;
            }
        }

        return lca;
    }

    // -----------------------------------------------
    // lr -> left range , rr -> right range
    public static void printInRange(Node node, int lr, int rr) {
        if (node == null)
            return;

        printInRange(node.left, lr, rr);

        if (node.data >= lr && node.data <= rr) // inorder mai traverse kar raha hai
            System.out.println(node.data);

        printInRange(node.right, lr, rr);
    }

    // --------------------------------------------------
    // iss code sa duplicate values bhi add kar sakta hai BST mai (kio ki BST can
    // have dupliacte values)
    // LEFT ORINTED hai yaa -> agar data exist karta hai tree mai tho us node ka
    // left mai add kara gai new node koo
    public static Node addData(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (node.data < data)
            node.right = addData(node.right, data);

        else // (node.data > data) or (node.data = data) pai dono condition pai kam kara gai
             // -> matlab agar data exist karta hai agar pahla se BST mai tho fir bhi hum new
             // node bana kaa iss new node ko add kara gai
            node.left = addData(node.left, data);

        return node;
    }

    // portal Solution (agar jonsi node add karna jaa raha hai agar woo tree mai
    // exist karti hai tho woo kuch nahi kara gaa)
    // fn name wapis 'addData' karna hai submit karna se phala
    public static Node addData_02(Node node, int data) {
        if (node == null)
            return new Node(data);

        // (node.data == data) kaa check nahi lagya kio ki tree mai data exist karta hai
        // tho usa add nahi kara gai
        if (node.data < data)
            node.right = addData_02(node.right, data);

        else if (node.data > data)
            node.left = addData_02(node.left, data);

        return node;
    }

    // ----------------------------------------------------
    // Delete Node in a BST
    // sir code -> jisma right ka minimum se replace kar eaha hai
    public static Node removeNode(Node node, int data) {
        if (node == null)
            return null;

        if (node.data < data)
            node.right = removeNode(node.right, data);
        else if (node.data > data)
            node.left = removeNode(node.left, data);
        else {
            if (node.left == null || node.right == null)
                return node.left != null ? node.left : node.right; // case I, II, III

            // left kaa maximum lai kaa bhi kar sakta hai -> jasa yaha right ka minimum liya
            // hai
            int minEle = minimum(node.right);
            node.data = minEle;

            node.right = removeNode(node.right, minEle);
        }

        return node;
    }

    // leetcode 450. Delete Node in a BST
    public int minimum_01(TreeNode node){
        while(node.left != null)
            node = node.left;

        return node.val;
    }
    public TreeNode removeNode(TreeNode node, int data) {
        if (node == null)
            return node;

        if (node.val < data)
            node.right = removeNode(node.right, data);
        else if (node.val > data)
            node.left = removeNode(node.left, data);
        else {
            if (node.left == null || node.right == null)
                return node.right != null ? node.right : node.left;

            int minEle = minimum_01(node.right);
            node.val = minEle;

            node.right = removeNode(node.right, minEle);
        }

        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        return removeNode(root, key);
    }

    // on portal
    public static Node removeNode_02(Node node, int data) {
        if (node == null)
            return null;

        if (node.data < data)
            node.right = removeNode_02(node.right, data);
        else if (node.data > data)
            node.left = removeNode_02(node.left, data);
        else {
            if (node.left == null || node.right == null)
                return node.left != null ? node.left : node.right; // case I, II, III

            // left kaa maximum lai kaa bhi kar sakta hai -> jasa yaha right ka minimum liya
            // hai
            int maxEle = maximum(node.left);
            node.data = maxEle;

            node.left = removeNode_02(node.left, maxEle);
        }

        return node;
    }

    public static Node remove(Node node, int data) {
        // write your code here
        return removeNode_02(node, data);
    }

    // ----------------------------------------------------
    // https://practice.geeksforgeeks.org/problems/add-all-greater-values-to-every-node-in-a-bst/1
    public void modify(Node root, int[] arr) {
        if (root == null)
            return;

        modify(root.right, arr); // phala right ki call laga raha hai & fir

        root.data += arr[0];
        arr[0] = root.data;

        modify(root.left, arr); // left ki class tree mai
    }

    public Node modify(Node root) {
        int[] arr = new int[1]; // array ki jaga variable nahi laa sakta kio ki varible stack pai banta hai
        modify(root, arr);
        return root;
    }

    // ----------------------------------------------------
    // HW ->
    // Replace with Sum of Larger (on portal)
    // ----------------------------------------------------------------
    public static void modify_02(Node node, int[] arr) {
        if (node == null)
            return;

        modify_02(node.right, arr);

        int val = node.data;
        node.data = arr[0];
        arr[0] += val;

        modify_02(node.left, arr);
    }

    // static int sum = 0;
    public static void rwsol(Node node) {
        int[] arr = new int[1];

        // write your code here
        modify_02(node, arr);
    }


    
    public static void main(String[] args) {

    }
}
