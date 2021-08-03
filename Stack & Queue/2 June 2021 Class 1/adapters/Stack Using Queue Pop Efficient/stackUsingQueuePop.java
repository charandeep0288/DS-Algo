// leetcode 255
import java.util.LinkedList;

class stackUsingQueuePop { // MyStack
    
    LinkedList<Integer> que = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    /** Initialize your data structure here. */
    public stackUsingQueuePop() { // MyStack
        
    }

    private void transfer( LinkedList<Integer> st1, LinkedList<Integer> st2 ){
        while( st1.size() != 0){
            st2.addLast(st1.removeFirst());
        }
    }
    
    /** Push element x onto stack. */
    // O(n)
    public void push(int x) {
        temp.addLast(x);
        transfer( que, temp );

        // Reference swap
        LinkedList<Integer> temp1 = que;
        que = temp;
        temp = temp1;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    // O(1)
    public int pop() {
        return que.removeFirst();
    }
    
    /** Get the top element. */
    public int top() {
        return que.getFirst();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */