// leetcode 232

import java.util.LinkedList;

    class queueUsingStackPop { // MyQueue
    
        // two stack created
        LinkedList<Integer> st = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        
    
        /** Initialize your data structure here. */
        public queueUsingStackPop() {  // MyQueue
            
        }
        
        private void transfer( LinkedList<Integer> st1, LinkedList<Integer> st2 ){
            while( st1.size() != 0 ){
                st2.addFirst(st1.removeFirst());
            }
        }

        /** Push element x to the back of queue. */
        // O(n)
        public void push(int x) { 
            transfer( st, temp );
            st.addFirst(x);
            transfer( temp, st );
        }
        
        
        /** Removes the element from in front of queue and returns that element. */
        // O(1)
        public int pop() {
            return st.removeFirst(); // remove Element
        }
        
        /** Get the front element. */
        // O(1)
        public int peek() {
            return st.getFirst();   
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