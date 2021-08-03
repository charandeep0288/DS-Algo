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
    // TILT OF A BINARY TREE
    public stati c class tiltPair{
        int tiltSF = 0; // tilt so far
        int sum = 0;
    }

    public tiltPair findTilt( TreeNode root ){
        if( root == null )
            return new tiltPair();

        tiltPair left = findTilt( root.left );
        tiltPair right = fingTilt( root.right );

        tiltPair myAns = new tiltPair();

        myAns.tiltSF = left.tiltSF + right.tiltSF + Math.abs( left.sum - right.sum );
        myAns.sum = left.sum + right.sum + root.val;
        return myAns;
    }

    // ------------------------------------------------
    // { tilt, sum }
    public int[] findTilt2( TreeNode node ){
        if( root == null )
            return new int[2];

        int[] left = findTilt2( root.left );
        int[] right = findTilt2( root.right );

        int [] myAns = new int[2];
        myAns[0] = left[0] + right[0] + Math.abs(left[1] + right[1]);
        myAns[1] = left[1] + right[1] + root.val;
        return myAns;
    }

    public int findTilt( TreeNode root ){
        return findTilt2(root)[0];
    }

    // ------------------------------------------------
    // DIAMETER OF A BINARY TREE
}
