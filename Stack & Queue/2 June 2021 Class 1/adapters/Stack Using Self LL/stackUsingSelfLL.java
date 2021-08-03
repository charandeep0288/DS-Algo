public class stackUsingSelfLL {
    
    public static class stack{

        private class Node{
            int data;
            Node next;

            Node( int data ){
                this.data = data;
            }
        }

        private Node head = null;
        private Node tail = null;
        private int size = 0;

        private void addFirst( int data ){
            Node node = new Node(data);

            if( this.size == 0 )
                this.head = this.tail = node;
            else{
                node.next = this.head;
                this.head = node;
            }

            this.size++;
        }

        // yaa fn yaha stack mai use nahi hoo raha balki queue mai hoo gaa
        private void addLast( int data ){
            Node node = new Node(data);

            if( this.size == 0 )
                this.head = this.tail = node;
            else{
                this.tail.next = node;
                this.tail = node;
            } 

            this.size++;
        }

        private Node removeFirst(){
            Node node = this.head;

            if( this.size == 1 )
                this.head = this.tail = null;
            else{
                this.head = node.next;
            } 

            node.next = null;
            this.size--;

            return node;
        }
    

        public int size(){
            return this.size;
        }
    
        public boolean isEmpty(){
            return this.size == 0;
        }
    
        public void push( int data ){ // stack => push(), queue => add()
            addFirst(data);
        }
    
        public int top(){ // stack => top(), queue => peek()
            return this.head.data;
        }
    
        public int pop(){ // stack => pop(), queue => remove()
            return removeFirst().data;
        }
    }

   
    public static void main(String[] args){
        stack st = new stack();

        st.push(10);
        st.push(20);
        System.out.println(st.pop()); // 20
        st.push(30);
        System.out.println(st.pop()); // 30
        st.push(40);
        st.push(50);
        st.push(60);

        while( st.size() != 0 ){
            System.out.println(st.pop()); // 60 50 40 10
        }
    }
}


// javac stackUsingSelfLL.java && java stackUsingSelfLL