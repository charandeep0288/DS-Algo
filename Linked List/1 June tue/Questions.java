public class Questions {

    // for leetcode Questions
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

    // for portal Questions
    private class Node {
        int data = 0;
        // next => store address next node
        Node next = null; // default value daa de

        // constructor
        Node(int data) {
            this.data = data;
        }

    }

    // this mid node will give us first mid node in even length LL case
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

    // -------------------------------------------------------
    // leetcode 148. Sort List (Merge Sort)
    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
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
        prev.next = c1 != null ? c1 : c2;

        return dummy.next;

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) // jab ik node hi raha gayi hai linkedlist mai tho usa sorted hi man raha hai
            return head;

        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;

        ListNode leftSortedList = sortList(head);
        ListNode rightSortedList = sortList(nHead);

        return mergeTwoSortedLists(leftSortedList, rightSortedList);
    }

    // ------------------------------------------------
    // Intersection Of LinkedList (on portal)
    private static int lengthOfLL(Node node){
        if(node == null)
            return 0;

        Node curr = node;
        int len = 0;
        while(curr != null){
            curr = curr.next;
            len++;
        }

        return len;
    }

    private static int findIntersection(Node one, Node two){
        
        int a = lengthOfLL(one);
        int b = lengthOfLL(two);

        Node biggerListHead = a > b ? one : two; // pahli ll ko badra man raha hai
        Node smallerListHead = b < a ? two : one;
        int diff = Math.abs(a - b); // Math.max(a, b) - Math.min(a, b); difference of both the LL

        while(diff-- > 0) // joo difference hai dono LL mia, agar same hai hai tho badri vali LL ko uss differnrence se chala doo
            biggerListHead = biggerListHead.next;

        // dono ll ko same speed se chalya 
        while(biggerListHead != smallerListHead){ // null vala case bhi handle hai idar, but last mai return karta hua null vala check lagana hoga
            biggerListHead = biggerListHead.next;
            smallerListHead = smallerListHead.next;
        }

        // smallerListNode OR biggerListNode dono mai se kisi pai bhi check kar sakta hai
        return smallerListHead != null ? smallerListHead.data : -1; // ll agar intersect nahi hoo rahi
    }

    // LinkedList => it defined well on portal
    public static int findIntersection(LinkedList one, LinkedList two){
        return findIntersection(one.head, two.head);
    }

    // ---------------------------------------------------
    // is LinkedList Palindrome (iterative solution)
    public Node midNode(Node head){
        if(head == null || head.next == null)
            return head;
            
        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public Node reverse(Node head){
        if(head == null || head.next == null)
            return head;
            
        Node prev = null, curr = head;
        while(curr != null){
            Node forw = curr.next; // backup
            
            curr.next = prev; // move
            
            prev = curr; // move
            curr = forw;
        }
        head = prev;
        
        return head;
    }
    
    public boolean IsPalindrome(){
        Node mid = midNode(head); // yaa "head" kaa huma ll vali class mai access hoga portal vala Questions mai
        Node nHead = mid.next;
        mid.next = null;

        nHead = reverse(nHead);
        Node c1 = head, c2 = nHead;
        boolean isPalindrome = true;
        while(c2 != null){ // c2 pai hi null ka check lagya gai sirf kio ki c2 pointer vali ll badri hogi yaa fir equal size ki hogi c1 pointer vali ll kaa kio ki humna mid hi asa nikala hai
            if(c1.data != c2.data){
                isPalindrome = false;
                break; 
            }  
            c1 = c1.next;
            c2 = c2.next;
        }

        // joo linkedList ko humna karab kia hai usa thik karna ki jimadari bhi humari hai
        nHead = reverse(nHead);
        mid.next = nHead;

        return isPalindrome;
    } 
}