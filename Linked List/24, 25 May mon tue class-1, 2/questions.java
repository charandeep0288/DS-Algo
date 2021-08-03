public class questions {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // leetcode - 876 (Middle of LinkedList)
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // leetcode 19. Remove Nth Node From End of List (1ST WAY OF SOLUTION)
    // jismai pichla node koo null kia hai joo remove kar raha hai
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if( head == null || head.next == null )
            return null;
        
        ListNode fast = head, slow = head;
        
        while(n-- > 0) 
            fast = fast.next;
        
        if(fast == null){
            ListNode rnode = head; // head or slow
            head = head.next; 
            rnode = null;
            return head;
        }
        
        while( fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode rnode = slow.next; // remove Node
        slow.next = slow.next.next;
        rnode.next = null;
        
        return head;
    }

    // leetcode 19. Remove Nth Node From End of List (1ST WAY OF SOLUTION)
    // jismai pichla node koo null nahi kia hai joo remove ki hai (Sir naa asa karwia hai)
    public ListNode removeNthFromEnd_02(ListNode head, int n) {
        if( head == null || head.next == null )
            return null;
        
        ListNode fast = head, slow = head;
        
        while(n-- > 0) 
            fast = fast.next;
        
        if(fast == null)
            return head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
}
