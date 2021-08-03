// leetcode 255

import java.util.LinkedList;

class stackUsingQueuePush { // MyStack
    
    LinkedList<Integer> que = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    int topEle = 0;
    /** Initialize your data structure here. */
    public stackUsingQueuePush() { // MyStack
        
    }
    
    /** Push element x onto stack. */
    // O(1)
    public void push(int x) {
        topEle = x;
        que.addLast(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    // O(n)
    public int pop() {
        while( que.size() > 1 ){
            temp.addLast(que.removeFirst());
        }
        
        int rEle = que.removeFirst(); // Remove Element
        
        while( temp.size() != 0 )
            push(temp.removeFirst());
        
        return rEle;
    }
    
    /** Get the top element. */
    public int top() {
        return topEle;
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