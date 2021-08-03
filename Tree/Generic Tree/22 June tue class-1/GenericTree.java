import java.util.ArrayList;

public class GenericTree{

    public static class Node{
        int data = 0;
        ArrayList<Node> childs;

        Node(int data){
            this.data = data;
            this.childs = new ArrayList<>();
        }
    }

    // ---------------------------------------------------
    public static int height(Node root){
        int h = -1;
        for(Node child : root.childs)
            h = Math.max(h, height(child));

        return h + 1;
    }

    public static int height2(Node root){
        int h = 0;

        // for(int i = 0 ; i < root.childs.size() ; i++){
        //     Node child = root.childs.get(i);
        for(Node child : root.childs)
            h = Math.max(h, height2(child) + 1);

        return h;
    }

    // -----------------------------------------------
    public static int size(Node root){
        int count = 0;
        for(Node child : root.childs)
            count += size(child);

        return count + 1;
    }

    public static int size2(Node root){
        int count = 0;
        for(int i = 0 ; i < root.childs.size() ; i++){
            Node child = root.childs.get(i);
            count += size2(child);
        }

        return count + 1;
    }

    // --------------------------------------------------
    public static int minimum(Node root){
        int min = root.data;
        for(Node child : root.childs)
            min = Math.min(min, minimum(child));

        return min;
    }

    // -------------------------------------------------
    public static int maximum(Node root){
        int max = root.data;
        for(Node child : root.childs)
            max = Math.max(max, maximum(child) );

        return max;
    } 

    // -------------------------------------------------
    public static int sum(Node root){
        int sum = root.data;
        for(Node child : root.childs)
            sum += sum(child);

        return sum;
    }

    // --------------------------------------------------
    // readable code (Industry Level Code)
    public static boolean find(Node root, int data){
        if(root.data == data)
            return true;

        boolean res = false;
        for(Node child : root.childs)
            res = res || find(child, data);

        return res;
    } 

    public static boolean find2(Node root, int data){
        if(root.data == data)
            return true;

        boolean res = false;
        for( Node child : root.childs )
            if(find2(child, data)){
                res = true;
                break;
            }

        return res;
    }

    // --------------------------------------------------
    public static int countLeaves_(Node node){
        if(node.childs.size() == 0 )
            return 1;

        int count = 0;
        for(Node child : node.childs)
            count += countLeaves_(child);

        return count;
    }

    public static int countLeaves(Node node){
        if(node == null)
            return 0;
        
        return countLeaves_(node);
    }

    // -------------------------------------------------
    public static boolean nodeToRootPath(Node root, int data, ArrayList<Node> ans){
        if(root.data == data){
            ans.add(root);
            return true;
        }

        boolean res = false;
        for(Node child : root.childs)
            res = res || nodeToRootPath(child, data, ans);

        if(res)
            ans.add(root);
    
        return res;
    } 

    public static ArrayList<Node> nodeToRootPath2(Node root, int data){
        if(root.data == data){
            ArrayList<Node> base = new ArrayList<>();
            base.add(root);
            return base;
        }

        ArrayList<Node> smallAns = new ArrayList<>();
        for(Node child : root.childs){
            smallAns = nodeToRootPath2(child, data);
            if(smallAns.size() != 0)
                break;
        }
        if(smallAns.size() != 0)
            smallAns.add(root);

        return smallAns;
    }
    // --------------------------------------------------
    // leetcode - 236 (Lowest Comman Ancestor of Binary Tree)
    public Node lowestCommonAncestor(Node root, int p, int q) {
        ArrayList<Node> list1 = nodeToRootPath2(root, p);
        ArrayList<Node> list2 = nodeToRootPath2(root, q);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        Node LCA = null;
        while (i >= 0 && j >= 0) {
            if (list1.get(i) != list2.get(j))
                break;
            LCA = list2.get(j);
            i--;
            j--;

        }

        return LCA;
    }
}