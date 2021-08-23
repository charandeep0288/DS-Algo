public class Questions {

    // For leecode Questions
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // ------------------------------------------
    // leetcode-141 Linked List Cycle
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    // ------------------------------------------
    // leecode 142.  Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow)
                break;
        }
        
        if(slow != fast)
            return null;
        
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }

    // ------------------------------------------
    // leetcode 160. Intersection of Two Linked Lists (dusra method intersection of Linked List Nikalna kaa liya)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;

        ListNode tail = headA;
        while(tail.next != null){
            tail = tail.next;
        }

        tail.next = headB;

        ListNode ans = detectCycle(headA);

        tail.next = null;

        return ans;
    }

    // ------------------------------------------
    // All Variable
    public int getCycleLen(ListNode mp){
        int cycleLen = 1;
        ListNode curr = mp.next;

        while(curr != mp){
            curr = curr.next;
            cycleLen++;
        }

        return cycleLen;
    }

    public ListNode cycleVariable(ListNode head){
        if(head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                break;
        }

        if(slow != fast)
            return null;

        slow = head;
        ListNode mp = fast; // meetingPoint
        int cycleCount = 0;
        int A = 0;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;

            if(mp == fast)
                cycleCount++;
            
            A++;
        }

        int cycleLen = getCycleLen(mp);
        int m = 0, C = 0, B = 0;
        if(A != 0 && A % cyleLen == 0){
            m = cycleLen - 1;
            B = cycleLen;
        } else {
            m = cycleCount + 1;
            C = A - cycleCount * cycleLen;
            B = cycleLen - C;
        }

        return slow;
    }

    public static void main(String[] args){

    }
}


