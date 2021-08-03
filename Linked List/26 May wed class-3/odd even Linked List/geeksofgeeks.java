// https://practice.geeksforgeeks.org/problems/rearrange-a-linked-list/1

// https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1

// Odd even Linked List

public class geeksofgeeks {
    Node divide(int N, Node head){
        // code here 
        Node tail = null;
        
        if(head == null || head.next == null)
                return head;
                
          Node even = new Node(-1);
          Node ep = even;
          
          Node odd = new Node(-1);
          Node op = odd;
          
          Node curr = head;
          while(curr != null){
              if(curr.data % 2 == 0){
                  ep.next = curr;
                  ep = ep.next;
              } else{
                  op.next = curr;
                  op = op.next;
              }
              curr = curr.next;
          }
          
          ep.next = odd.next;
          op.next = null;
          
          if(even.next != null)
            head = even.next;
          else
            head = odd.next;
            
          if(odd.next != null)
            tail = op;
          else
            tail = ep;
            
          odd.next = null;
          even.next = null;
          
          return head;
    }
}
