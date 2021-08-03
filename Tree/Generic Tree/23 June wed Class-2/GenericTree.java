public class GenericTree {

    public static class Node{
        int data = 0;
        ArrayList<Node> children;

        Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    // --------------------------------------------------
    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size())
            return false;

        boolean res = true; // khud ko man lia pahala ki mai similar hu
        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            res = res && areSimilar(c1, c2);
        }

        return res;
    }

    // --------------------------------------------------
    public static boolean areMirror(Node r1, Node r2) {
        if (n1.children.size() != n2.children.size())
            return false;

        boolean res = true; // khud ko man lia pahala ki mai similar hu
        int size = n1.children();
        for (int i = 0; i < size; i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(size - i - 1);

            res = res && areSimilar(c1, c2);
        }

        return res;
    }

    // --------------------------------------------------
    public static boolean IsSymmetric(Node node){
        return areMirror(node, node);
    } 

    // --------------------------------------------------
    // ideally inn varibles koo koi value set nahi karni chahia 
    static int ceil;
    static int floor;

    public static void ceilAndFloor_(Node node, int data){
        if(node.data < data)
            floor = Math.max(floor, node.data);
        if(node.data > data)
            ceil = Math.min(ceil, node.data);

        for(Node child : node.children){
            ceilAndFloor_(child, data);
        }
    }

    public static void ceilAndFloor(Node node, int data){
        ceil = (int)1e9;
        floor = -(int)1e9;

        ceilAndFloor_(node, data);
    }

    // ---------------------------------------------------
    // ub -> uper bound
    public static int KthLargest(Node node, int k, int ub){

        int maxRes = -(int)1e9;

        for( Node child : node.children){
            int recRes = kthLargest(child, ub);
            maxRes = Math.max(maxRes, resRes);
        }

        return node.data < ub ? Math.max(node.data, maxRes) : maxRes;
    }

    public static int KthLargest(Node node, int k){
        int ub = (int)1e9;
        while( k-- < 0 ){
            ub = floor(node, ub);
        }

        return ub;
    } 

    // ----------------------------------------------------
    
}
