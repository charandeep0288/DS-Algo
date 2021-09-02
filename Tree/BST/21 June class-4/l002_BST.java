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

        Node(int data){
            this(data, null, null);
        }
    }

    // ------------------------------------------------
    // T: O(n)  S: O(1)
    public static int size(Node node){
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    } 

    // ------------------------------------------------
    // T: O(n), S: O(1) 
    // (height no. of edges ki terms mai nikal raha hai)
    public static int height(Node node){
        return node == null ? -1 : Math.max(height(node .left), height(node.right)) + 1;
    }
    // ------------------------------------------------
    // T: O(log n)  S: O(1)
    public static int maximum(Node node){ // yaa ensure karka call lagya iss function ko ki root null naa hoo
        while(node.right != null)
            node = node.right; // right most node of BST is maximum valued node
        
        return node.data;
    }

    // ------------------------------------------------
    // T: O(log n)  S: O(1)
    public static int minimum(Node node){ // yaa ensure karka call lagya iss function ko ki root null naa hoo
        while(node.left != null)
            node = node.left; // left most value of BST is minimum valued node of BST

        return node.data;
    }

    // ------------------------------------------------
    // T: O(log n)  S: O(1)
    public static boolean find(Node node, int data){ // work like BINARY SEARCH
        while(node != null){
            if(node.data == data)
                return true;
            else if(node.data < data)
                node = node.right;
            else
                node = node.left;
        }

        return false;
    }

    // ------------------------------------------------
    // yaa sum vala question iteratively possible nahi hai 
    // T: O(n), S: O(1)
    public static int sum(Node node){
        return node == null ? 0 : sum(node.left) + sum(node.right) + node.data;
    }


    // -------------------------------------------------
    // height of BST == levels of BST
    // T: O(log n)  S: O(1) 
    public static ArrayList<Node> nodeToRootPath(Node node, int data){
        ArrayList<Node> list = new ArrayList<>(); 
        boolean flag = false;
        while(node != null){
            list.add(node);
            if(node.data == data){
                flag = true;
                break;
            }
            else if(node.data < data)
                node = node.right;
            else
                node = node.left;
        }

        if(!flag) // flag false mila, matlab data nahi mila huma tree mai tho joo ArrayList bhari hai usa khali kara gai, then return kara gai
            list.clear();

        // RootToNodePath kaa lia hum list ko reverse nahi kara gai
        Collections.reverse(list); // nodeToRootPath nikalna hai, naa ki RootToNodePath iss liya ArrayList ko reverse kar raha hai
        return list;
    }


    // ------------------------------------------
    // lowest comman ancestor => we calculate on lca on BST having unique data
    public static int lca(Node node, int d1, int d2){
        let lca = -1;
        while(node != null){
            if(node.data < d1 && node.data < d2)
                node = node.right;
            else if(node.data > d1 && node.data > d2)
                node = node.left;
            else { // decide nahi kar paa raha ki data kaha mila gaa tho matlab yaa vali node hi humari LCA node hai
                lca = node.data; // lca mil gya 
                break;
            }
        }

        return lca;
    }

    // -----------------------------------------------
    // lr -> left range , rr -> right range
    public static void printInRange(Node node, int lr, int rr){
        if(node == null)
            return;

        printInRange(node.left, lr, rr);

        if(node.data >= lr && node.data <= rr)
            System.out.println(node.data);

        printInRange(node.right, lr, rr);
    }

    // --------------------------------------------------
    public static Node addData(Node node, int data){
        if( node == null ) 
            return new Node(data);

        if( node.data < data )
            node.right = addData(node.right, data);

        else
            node.left = addData(node.left, data);

        return node;
    }

    // portal Solution (agar jonsi node add karna jaa raha hai agar woo tree mai exist karti hai tho woo kuch nahi kara gaa)
    public static Node addData(Node node, int data){
        if( node == null )
            return new Node(data);

        if( node.data < data )
            node.right = addData(node.right, data);

        else if( node.data > data )
            node.left = addData(node,left, data);

        return node;
    }

    // ----------------------------------------------------
    public static Node removeNode(Node node, int data){
        if( node == null )
            return null;
        
        if( node.data < data )
            node.right = removeNode(node.right, data);
        else if( node.data > data )
            node.left  = removeNode(node.left, data);
        else{
            if(node.left == null || node.right == null)
                return node.left != null ? node.left : node.right; 

            int minEle = minimum(node.right);
            node.data = minEle;

            node.right = removeNode(node.right, minEle);

        }

        return node;
    }











    // ----------------------------------------------------
    // https://practice.geeksforgeeks.org/problems/add-all-greater-values-to-every-node-in-a-bst/1
    public void modify(Node root, int[] arr){
        if(root == null)
            return;

        modify(root.right, arr);

        root.data += arr[0];
        arr[0] = root.data;

        modify(root.left, arr);
    }

    public Node modify(Node root){
        int[] arr = new int[1];
        modify(root, arr);
        return root;
    }
}
