import java.util.LinkedList;

public class leetcode_232 {
    class MyQueue {
    
        LinkedList<Integer> st = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        
        int peekEle = 0;
    
        /** Initialize your data structure here. */
        public MyQueue() {
            
        }
        
        /** Push element x to the back of queue. */
        // O(1)
        public void push(int x) { 
            if( st.size() == 0 )
                peekEle = x;
            
            st.addFirst(x);
        }
        
        private void transfer( LinkedList<Integer> st1, LinkedList<Integer> st2 ){
            while( st1.size() != 0 ){
                st2.addFirst(st1.removeFirst());
            }
            
        }
        
        /** Removes the element from in front of queue and returns that element. */
        // O(n)
        public int pop() {
            transfer( st, temp );
            int rEle = temp.removeFirst();
            
            while( temp.size() != 0 )
                this.push(temp.removeFirst()); // hum push() fn call kara gai transfer() fn ki jaga, kioki peekEle humara push() fn mai handle hoo rakha hai, transfer fn ko agar call karka kam karna chataho too peekEle set karna vala kam 
            
            return rEle;
        }
        
        /** Get the front element. */
        // O(1)
        public int peek() {
            return peekEle;   
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return st.size() == 0;
        }
    }
    
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}
