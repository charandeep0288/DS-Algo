
public class Tree
{
    // =========================================
    // Construted by me (was not able to cpoy this code)
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    // =========================================

    //--------------------------------
    int countLeaves(Node node) 
    {
         // Your code  
         if( node == null )
            return 0;
         if( node.left == null && node.right == null )
            return 1;
        
         return countLeaves(node.left) + countLeaves(node.right);
         
    }
}