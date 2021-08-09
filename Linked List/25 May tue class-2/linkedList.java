public class linkedList {

    // private 
    private class Node {
        int data = 0;
        // Node => ikk data type hai joo mana banya hai, jiska andar doo info hai data & next ie. next node ka address
        // next => store address of next node kaa
        // Node next = new Node(10); // abb data iska pas aa chuka hai
        Node next = null; // default value daa de

        // constructor
        Node(int data) {
            this.data = data;
        }
    } 

    // private => iss lia taki class ka bahar yaa chiza koi aur use naa kar saka
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int size()
    {
        return this.size;
    } 

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    private void addFirstNode(Node node)
    {
        if(this.size == 0)
        {
            this.head = this.tail = node;
        }
        else
        {
             node.next = this.head;
             this.head = node;  
        }
        this.size++;
    }

    public void addFirst( int data )
    {
        Node node = new Node(data); // new node create kia 
        addFirstNode(node);
    }

    private void addLastNode( Node node )
    {
        if( this.size == 0 )
           this.head = this.tail = node;
        
        else   
        {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public void addLast( int data )
    {
        Node node = new Node(data);
        addLastNode(node);
    }

    // private void addNodeAt( Node node, int idx )
    // {
    //     if( idx == 0 )
    //       addFirstNode(node);

    //     else if( idx == this.size() )
    //        addLastNode(node);

    //     else
    //     {
    //         Node prevNode = getNode(idx - 1);
    //         Node forwNode = prevNode.next;

    //         prevNode.next = node;
    //         node.next = forwNode;
    //         this.size++;
    //     }   

    // }
    // public void addAt( int idx, int data ) // 26 May
    // {
    //     if(idx < 0 || idx > this.size )
    //        return;

    //     Node node = new Node(data);
    //     addNodeAt(node, idx);
    // }

    // //====================================================

    private Node removeFirstNode()
    {
        Node node = this.head; // jiss node koo remove karna hai woo store kar lia, kioki return bhi karni hai yaa node
        if(this.size == 1)
           this.head = this.tail = null;
        
        else
        {
            this.head = this.head.next;
            node.next = null;
        }   
        
        this.size--;
        return node;
    }

    public int removeFirst()
    {
        if(this.size == 0)
           return -1;
        
        Node node = removeFirstNode();
        return node.data;   
    }

    // private Node removeLastNode()
    // {
    //     Node node = this.tail;
    //     if( this.size == 1 )
    //        this.head = this.tail = null;

    //     else 
    //     {
    //         Node secondLast = getNodeAt(this.size - 2);
    //         secondLast.next = null;
    //         this.tail = secondLast;
    //     }   
    //     this.size--;
    //     return node;
    // }

    // public int removeLast() // 25 May
    // {
    //     if( this.size == 0 )
    //        return -1;

    //     Node node = removeLastNode();
    //     return node.data;  
    // }

    // private Node removeAtNode(int idx)
    // {
    //     if( idx == 0 )
    //        return removeFirstNode();

    //     else if( idx == this.size - 1 )
    //        return removeLastNode();
           
    //     else
    //     {
    //         Node prevNode = getNodeAt( idx - 1 );
    //         Node node = prevNode.next;
    //         Node forwNode = prevNode.next;

    //         node.next = null;
    //         prevNode.next = forwNode;
    //         this.size--; 
    //         return forwNode;
    //     }   
    // }
    
    // public int revomeAt( int idx ) // 25 May
    // {
    //     if( idx < 0 && idx >= this.size )
    //       return -1;

    //     Node node = removeAtNode(idx); 
    //     return node.data; 
    // }

    // //=======================================================

    private Node getFirstNode()
    {
        return this.head;
    }

    public int getFirst(){
        if( this.size == 0 )
           return -1;
        
        return getFirstNode().data;   
    }

    
    private Node getLastNode()
    {
        return this.tail;
    }
    
    public int getLast()
    {
        if( this.size == 0 )
           return -1;

        return getLastNode().data;   
    }


    private Node getNodeAt(int idx)
    {
        Node curr = this.head;
        while( idx-- > 0 )
        {
            curr = curr.next;
        }

        return curr;
    }
    public int getAt( int idx )
    {
        if(idx < 0 || idx >= this.size)
            return -1;

        return getNodeAt(idx).data;    
    }


    //-----------------------------=-----------------------------
    // 26 May wed class-3

}