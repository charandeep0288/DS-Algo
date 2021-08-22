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

    public static ListNode segregateEvenOdd(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode even = new ListNode(-1), odd = new ListNode(-1), ep = even, op = odd, curr = head;
        while(curr != null){
            if((curr.val & 1) == 0){ // even 
                ep.next = curr;
                ep = ep.next;
            } else { // odd
                op.next = curr;
                op = op.next;
            }

            curr = curr.next;
        }

        ep.next = op.next = null;
        ep.next = odd.next;

        return even.next;
    }

    public static ListNode segregate012(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode zero = new ListNode(-1), one = new ListNode(-1), two = new ListNode(-1), zp = zero, op = one, tp = two, curr = head;

        while(curr != null){
            if(curr.val == 0){
                zp.next = curr;
                zp = zp.next;
            } else if(curr.val == 1){
                op.next = curr;
                op = op.next;
            } else {
                tp.next = curr;
                tp = tp.next;
            }
            curr = curr.next;
        }

        zp.next = op.next = tp.next = null;

        op.next = two.next;
        zp.next = one.next;

        return zero.next;
    }

    public static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;

        return mergeTwoLists(mergeSort(head), mergeSort(nHead));
    }

    public static ListNode mergeKLists(ListNode[] lists, int si, int ei){
        if(si == ei)
            return lists[si];

        int mid = (si + ei) / 2;
        ListNode leftList = mergeKLists(lists, si, mid);
        ListNode rightList = mergeKLists(lists, mid + 1, ei);

        return mergeTwoLists(leftList, rightList);
    }

    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0)
            return null;

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode th = null, tt = null;
    private static ListNode addFirstNode(ListNode node){

    }


    public static ListNode reverseInRange(ListNode haed, int n, int m){
        
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

    public static void main(String[] args) {

    }
}