public class Questions {

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

    public static ListNode midNode(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            slow =slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    // -----------------------------------------------------------------
    // leetcode 21 Merge tow Sorted Array

    // not better code (without dummy node)
    public ListNode mergeTwoLists_02(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) // three cases isna hi handle kar lia
            return l1 != null ? l1 : l2;

        ListNode head = null, prev = null, c1 = l1, c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                if (prev != null) { // iss code mai yaa null vala check bar bar lagana padhrta hai
                    prev.next = c1;
                    prev = prev.next;
                } else {
                    head = c1;
                    prev = head;
                }
                c1 = c1.next;
            } else {
                if (prev != null) {
                    prev.next = c2;
                    prev = prev.next;
                } else {
                    head = c2;
                    prev = head;
                }
                c2 = c2.next;
            }
        }
        prev.next = (c1 != null) ? c1 : c2;

        return head;
    }

    // better code leetcode 21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) // three cases isna hi handle kar lia
            return l1 != null ? l1 : l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, c1 = l1, c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = (c1 != null) ? c1 : c2;

        return dummy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null)
            return head;

        ListNode slow = head, fast = head;
        while(n-- > 0)
            fast = fast.next;

        if(fast == null){
            ListNode rnode = slow; // remove node
            head = head.next;
            rnode.next = null;

            return head;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode rnode = slow.next;
        slow.next = rnode.next;
        rnode.next = null;

        return head;
    }


}