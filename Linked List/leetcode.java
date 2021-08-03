public class leetcode {

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

    // ===================================================
    // ---------- 25 MAY 2021 WED CLASS-3 ------------------
    // ===================================================

    // ------------------------------------------------------
    // leetcode. 876 Middle of Linked List
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

    // ------------------------------------------------------
    // leetcode. 19. Remove Nth Node From End of List (1st WAY OF SOLUTION)
    // MAna ASA KIA HAI
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head, slow = head;

        while (n-- > 0)
            fast = fast.next;

        if (fast == null) {
            ListNode rnode = head; // head or slow
            head = head.next;
            rnode = null;
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode rnode = slow.next; // remove Node
        slow.next = slow.next.next;
        rnode.next = null;

        return head;
    }

    // ------------------------------------------------------
    // leetcode. 19. Remove Nth Node From End of List (1st WAY OF SOLUTION)
    // SIR NAA ASA KARVIA HAI
    public ListNode removeNthFromEnd_02(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head, slow = head;

        while (n-- > 0)
            fast = fast.next;

        if (fast == null)
            return head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    
    // ===================================================
    // ---------- 26 MAY 2021 TUE CLASS-3 ------------------
    // ===================================================

    // ------------------------------------------------------
    // leetcode 83. Remove Duplicates from Sorted List
    // 1st WAY OF SOLUTION
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        ListNode dp = dummy;

        dp.next = head;
        dp = dp.next;
        ListNode curr = head.next;
        int size = 0;
        while (curr != null) {

            // yaa while loop ik bar mai sara duplicate element ko remove kar dai gaa
            while (curr != null && curr.val == dp.val) {
                ListNode forw = curr.next;
                curr.next = null;
                curr = forw;
            }

            dp.next = curr;
            if (curr != null) {
                curr = curr.next; // null pointer exception se bachna ka lia kia hai yaa humna, kioki agar curr
                                  // kaa next pai move krana ki koshish kara gai jab curr null pai hai tho null
                                  // pointer exception aya gii
                dp = dp.next; // curr not null hai tabhi dp ko aga move kara raha hai, agar asa nahi kara gai
                              // tho huma tail nahi mil pai gii (DO DRY RUN FOR THIS)
                size++;
            }
        }

        head = dummy.next;
        dummy.next = null;
        return head;
    }

    // ------------------------------------------------------
    // leetcode 83. Remove Duplicates from Sorted List
    // 2nd WAY OF SOLUTION
    public ListNode deleteDuplicates_02(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(-101); // dummy node ki value bhi compare hongi tho iss lia, joo range dii hai ques mai ik node ki value ki linkedList mai usa badri value loo
        ListNode dp = dummy;
        
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            
             // yaa while loop ik bar mai sara duplicate element ko remove kar dai gaa
            while(curr != null && curr.val == dp.val){
                ListNode forw = curr.next;
                curr.next = null;
                curr = forw;
            }
            
            dp.next = curr;
            if(curr != null){
                curr = curr.next; // null pointer exception se bachna ka lia kia hai yaa humna, kioki agar curr kaa next pai move krana ki koshish kara gai jab curr null pai hai tho null pointer exception aya gii
                dp = dp.next; // curr not null hai tabhi dp ko aga move kara raha hai, agar asa nahi kara gai tho huma tail nahi mil pai gii (DO DRY RUN FOR THIS)
                size++;
            }
        }
        
        head = dummy.next;
        dummy.next = null;
        return head;
    }

    // ------------------------------------------------------
    // leetcode - 206 Reverse Linked List
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode forw = curr.next; // Backup

            curr.next = prev; // Link

            prev = curr; // move
            curr = forw;
        }

        head = prev;
        return head;
    }
}
