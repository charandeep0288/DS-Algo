public class binaryTree {
    

    // ------------------------------------------------
    // T: O(n)  S: O(1)
    public static int size(Node node){
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    } 

    // T: O(n)  S: O(1)
    public static int maximum(Node node){
        while(node.right != null)
            node = node.right;
        
        return node.root;
    }

    // T: O(n)  S: O(1)
    public static int minimum(Node node){
        while(node.left != null)
            node = node.left;

        return node.data;
    }

    // T: O(n)  S: O(1)
    public static int find(Node node){
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
    // 
    // public static int sum(Node node){
    //     int sum = 0;
    //     while(node != null){
    //         sum = sum + node.data; 
    //         if(node.left != null)
    //             node = node.left;

    //         if(node.right != null)
    //             node = node.right;
    //     }

    //     return sum;
    // } 

    public static int sum(Node node){
        return node == null ? 0 : sum(node.left) + sum(node.right);
    }


    // -------------------------------------------------
    // height of BST == levels of BST
    // T: O(log n)  S: O(1) 
    public static ArrayList<Node> nodeToRootPath(Node node, int data){
        ArrayList<Node> list = new ArrayList<Node>();
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

        if(!flag) // flag false mila, matlab data nahi mila huma tree mai tho joo ArrayList bhari hai usa khali kara gai then return kara gai
            list.clear();

        Collection.reverse(list);
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
            else{
                lca = node.data;
                break;
            }
        }

        return lca;
    }

    // -----------------------------------------------
    // lr - left range , rr - right range
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
