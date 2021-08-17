public class l001 {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode forw = curr.next; // backup
            
            curr.next = prev; // Link
            
            prev = curr; // move
            curr = forw;
        }
        head = prev;
        
        return head;
    }


    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) // agar koi node nahi hai and ik hi node hai tho palindrome hai
            return true;
        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;
        
        nhead = reverse(nhead);
        ListNode c1 = head, c2 = nhead;
        
        boolean flag = true;
        while( c2 != null && c2 != null){
            if(c1.val != c2.val){
                flag = false;
                break; // direct yaha se return nahi kara gai kio ki huma linkedlist ko wapis thik bhi karna hai
            } 
                
            c1 = c1.next;
            c2 = c2.next;
        }
        
        nhead = reverse(nhead);
        mid.next = nhead;
        
        return flag;
    }


    public static void unfold(ListNode head){
        if(head == null || head.next == null)
            return;
        
        ListNode d1 = new ListNode(-1), d2 = new ListNode(-1), c1 = d1, c2 = d2, c = head;

        while(c != null){
            c1.next = c;
            c2.next = c.next;

            c1 = c1.next;
            c2 = c2.next;

            c = c.next;
            if(c != null)
                c = c.next;
        }

        c1.next =  null;
        ListNode rhead = reverse(d2.next);
        c1.next = rhead;
    }

    public static void main(String[] args) {

    }
}