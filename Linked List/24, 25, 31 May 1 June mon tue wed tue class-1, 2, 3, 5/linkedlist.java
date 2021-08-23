public class linkedlist {

    // public static class LinkedList { // agar main() fn iss file mai hi use karna
    // hai tho yaa class likni hogi(and uska andar sara vriable, class & fn of
    // linkedList) with static keyword taki main access kar pai
    private class Node {
        int data = 0;
        // next => store address next node
        Node next = null; // default value daa de

        // constructor
        Node(int data) {
            this.data = data;
        }

    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;
    // public int size = 0;

    // LinkedList ko ArrayList ki tara display kar raha hai
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        Node curr = this.head; // curr ik iterator hai joo puri linkedlist pai traverse kar raha hai
        while (curr != null) {
            sb.append(curr.data);

            if (curr.next != null)
                sb.append(", ");

            curr = curr.next;
        }

        sb.append("]");

        return sb.toString();
        // return sb.toString() + "Charandeep Singh"; // hum chata hai ki ll print karna
        // kaa baad mara name print hoo
    }

    public int size() { // get size only not set
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // public void display(){
    // for(Node temp = head ; temp != null ; temp = temp.next){
    // System.out.println(temp.data + " ");
    // }
    // System.out.println();
    // }

    private void addFirstNode(Node node) {
        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        addFirstNode(node);
    }

    private void addLastNode(Node node) {
        if (this.size == 0)
            this.head = this.tail = node;

        else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        addLastNode(node);
    }

    private void addNodeAt(Node node, int idx) {
        if (idx == 0)
            addFirstNode(node);

        else if (idx == this.size)
            addLastNode(node);

        else {
            Node prevNode = getNodeAt(idx - 1);
            Node forwNode = prevNode.next;

            prevNode.next = node;
            node.next = forwNode;
            this.size++;
        }

    }

    public void addAt(int idx, int data) // 26 May
    {
        if (idx < 0 || idx > this.size) // invalid state -> idx agar kio -1 daa dai, aur idx linkedlist ki size sa badra
                                        // hua (but agar idx linkedlist ka size ka equal hua tho add kar sakta hai last
                                        // mai linkedlist kaa)
            return;

        Node node = new Node(data);
        addNodeAt(node, idx);
    }

    // ===================================================

    public Node removeFirstNode() {
        Node node = this.head;
        if (this.size == 1)
            this.head = this.tail = null;

        else {
            this.head = this.head.next;
            node.next = null;
        }

        this.size--;
        return node;
    }

    public int removeFirst() {
        if (this.size == 0)
            return -1;

        Node node = removeFirstNode();
        return node.data;
    }

    private Node removeLastNode() {
        Node node = this.tail;
        if (this.size == 1)
            this.head = this.tail = null;

        else {
            Node secondLast = getNodeAt(this.size - 2);
            secondLast.next = null;
            this.tail = secondLast;
        }
        this.size--;
        return node;
    }

    public int removeLast() // 25 May
    {
        if (this.size == 0)
            return -1;

        Node node = removeLastNode();
        return node.data;
    }

    private Node removeAtNode(int idx) { // yaha pai joo index da raha hai woo tho valid hai
        if (idx == 0)
            return removeFirstNode();

        else if (idx == this.size - 1) // agar yaa vala check nahi lagata tho tail set hi nahi hoo pata else vala case
                                       // mai, tho yaa vala case lagana padra gaa huma
            return removeLastNode();

        else {
            // IMPORTANT
            // ik pointer koo bacha kaa konsa koi janda gad lai gai -> iss lia forwNode huma
            // rakh lana chahia null pointer exception ana ka changes kam hoo jata hai
            Node prevNode = getNodeAt(idx - 1);
            Node node = prevNode.next;
            Node forwNode = node.next; // prevNode.next.next

            // kisi bhi order mai kar doo marji hai
            prevNode.next = forwNode;
            node.next = null; // null iss lia karta hai taki agar kisi koo node mil gai tho woo puri linked
                              // list koo access naa kar pai

            this.size--;
            return node;
        }
    }

    public int removeAt(int idx) // 25 May
    {
        if (idx < 0 || idx >= this.size)
            return -1;

        return removeAtNode(idx).data;
    }

    // =======================================================

    private Node getFirstNode() {
        return this.head;
    }

    public int getFirst() {
        if (this.size == 0)
            return -1;

        return getFirstNode().data;
    }

    private Node getLastNode() {
        return this.tail;
    }

    public int getLast() {
        if (this.size == 0)
            return -1;

        return getLastNode().data;
    }

    private Node getNodeAt(int idx) {
        Node curr = this.head;
        while (idx-- > 0) {
            curr = curr.next;
        }

        return curr;
    }

    public int getAt(int idx) {
        if (idx < 0 || idx >= this.size)
            return -1;

        return getNodeAt(idx).data;
    }
    // }

    // ====================================================
    // 26 May, 2021 wed class-3
    // ====================================================

    // Questions.

    // -----------------------------------------------------
    // odd even in a LinkedList (on portal)
    public void oddEven() {
        if (this.size == 0 || this.size == 1)
            return;

        Node even = new Node(-1); // Dummy Node
        Node ep = even;

        Node odd = new Node(-1); // Dummy Node
        Node op = odd;

        Node curr = this.head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                ep.next = curr;
                ep = ep.next;
            } else {
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }

        op.next = even.next;
        ep.next = null;

        if (odd.next != null)
            this.head = odd.next;
        else
            this.head = even.next;

        if (even.next != null)
            this.tail = ep;
        else
            this.tail = op;

        odd.next = null;
        even.next = null;
    }
    // -----------------------------------------------------
    // Remove Duplicates In A Sorted Linked List (on portal)
    public void removeDuplicates(){
        // write your code here
          if(this.head == null || this.head.next == null)
              return;
          
          Node dummy = new Node(-1);
          Node dp = dummy;
          
          dp.next = head;
          dp = dp.next;
          
          Node curr = this.head.next;
          int size = 0;
          while(curr != null){
              while(curr != null && dp.data == curr.data){
                  Node forw = curr.next;
                  curr.next = null;
                  curr = forw;
              }
              
              dp.next = curr;
              
              if(curr != null){
                  dp = dp.next;
                  curr = curr.next;
                  size++;
              }
          }
          
          this.head = dummy.next;
          this.tail = dp;
          dummy.next = null;
      }
    
    // -----------------------------------------------------
    // Reverse Linked List (pointer Iterative) (on portal)
    public void reversePI() {
        // write your code here
        if (this.head == null || this.head.next == null)
            return;

        Node prev = null;
        Node curr = this.head;

        while (curr != null) {
            Node forw = curr.next; // backup

            curr.next = prev; // Link

            prev = curr; // move
            curr = forw;
        }

        this.tail = this.head;
        this.head = prev;
    }

    // ====================================================
    // 31 May, 2021 mon class-4
    // ====================================================

    // -----------------------------------------------------
    // Add two linkedList (on portal)
    public static ListNode reverseList(ListNode root){
        if(root == null || root.next == null)
            return root;
            
        ListNode prev = null;
        ListNode curr = root;
        while(curr != null){
            ListNode forw = curr.next; // Backup
            
            curr.next = prev; // Link
            
            prev = curr; // Move
            curr = forw;
        }
        
        return prev;
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        ListNode dummy = new ListNode(-1);
        
        ListNode c1 = l1, c2 = l2, prev = dummy;
        int carry = 0;
        while( c1 != null || c2 != null || carry != 0 ){
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);

            carry = sum / 10;
            sum %= 10;
            
            prev.next = new ListNode(sum); // new node jaa pai bhi bani hai uska address return karta hai 
            
            prev = prev.next;
            
            if(c1 != null)
                c1 = c1.next;
                
            if(c2 != null)
                c2 = c2.next;
        }
        
        ListNode head = dummy.next;
        head = reverseList(head);
        
        dummy.next = null;
        
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        return head;
    }

    // -----------------------------------------------------
    // Add two LinkedList (on portal) recursive solution 
    public static int addTwoLinkedList_02(Node one, int s1, Node two, int s2, LinkedList ans){
        if(one == null && two == null)
            return 0;

        int carry = 0;
        if(s1 > s2){
            carry = addTwoLinkedList_02(one.next, s1 - 1, two, s2, ans);
            int sum = carry + one.data;
            carry = sum / 10;
            sum %= 10;

            ans.addFirst(sum);
        } else {
            carry = addTwoLinkedList_02(one.next, s1 - 1, two.next, s2 - 1, ans);
            int sum = carry + one.data + two.data;
            carry = sum / 10;
            sum %= 10;

            ans.addFirst(sum);
        }

        return carry;
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two){

        int s1 = one.size();
        int s2 = two.size();

        if(s1 < s2){
            LinkedList temp = one;
            one = two;
            two = temp;
        }

        LinkedList ans = new LinkedList();
        int carry = addTwoLinkedList_02(one.head, one.size(), two.head, two.size(), ans);

        if(carry == 1)
            ans.addFirst(carry);

        return ans;
    }

    // ----------------------------------------------
    // Reverse Linked List (pointer - Recursive) (on portal)
    // ---------- soln 1 ---------------
    // private Node reversePRHelper(Node node){
    //   // write your code here
    //     if(node.next == null)
    //         return node;
        
    //     Node reverseNode = reversePRHelper(node.next);
    //     reverseNode.next = node;
        
    //     return node;
    // }

    // public void reversePR(){
    //   // write your code here
        
    //     Node reverseNode = reversePRHelper(head);
    //     reverseNode.next = null;
        
    //     this.head = this.tail;
    //     this.tail = reverseNode;
    // }
    
    
    // ------------------------------------------------------------
    // ---------- soln 2 ---------------
    private void reversePRHelper(Node node){
        if(node.next == null)
            return;
            
        reversePRHelper(node.next);
        Node nextNode = node.next;
        nextNode.next = node; // address dal raha hia node kaa
    }
    
    public void reversePR(){
        reversePRHelper(head);
        
        this.head.next = null; // last vala link break kar dia  
        
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
    }


    // -----------------------------------------------
    // display reverse linkedlist (recursive solution) (on portal) 
    private void displayReverseHelper(Node node){
        // write your code here
        if(node == null)
            return;
        
        displayReverseHelper(node.next);
        System.out.print(node.data + " ");
    }

    public void displayReverse(){
      displayReverseHelper(head);
      System.out.println();
    }

    // ---------------------------------------------
    // fold a linked list (on portal)
    public Node midNode(Node node){
        if(node == null || node.next == null)
            return node;
            
        Node slow = node, fast = node;
        
        while(fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public Node reverse(Node node){
        if(node == null || node.next == null)
            return node;
        
        Node curr = node, prev = null;
        while(curr != null){
            Node forw = curr.next; // backup
            
            curr.next = prev; // link
            
            prev = curr; // move
            curr = forw;
        }
        
        return prev;
    }

    public void fold() {
      // write your code here
      Node mid = midNode(this.head);
      Node nhead = mid.next; // new head for second linked list
      mid.next = null;
      
      nhead = reverse(nhead);
      
      Node c1 = this.head, c2 = nhead;
      while(c2 != null){
          Node f1 = c1.next, f2 = c2.next;
          
          c1.next = c2;
          c2.next = f1;
          
          c1 = f1;
          c2 = f2;
      }
      
      if(size() % 2 != 0) // odd length ki ll(linked list) ka case mai tail mid kaa next hai
        this.tail = mid;  
      
      else                // even length ki ll ka case mai tail mid hi hai
        this.tail = mid.next;
        
       // aur head set hi hai usa chadrna ki jarurat nahi 
    }


    // ==========================================================
    // 1 June tue Class-5
    // ==========================================================

    // leetcode 21. Merge Two Sorted List
    
    // leetcode 148. SortList (Merge Sort)

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

    public static int findIntersection(linkedlist one, linkedlist two){
        return findIntersection(one.head, two.head);
    }

    // ---------------------------------------------------
    // is LinkedList Palindrome (iterative solution) (on portal)

    // public Node midNode(Node head){}
    // public Node reverse(Node head){}
    
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

    // -------------------------------------------
    // Is Palindrome LinkedList (on portal) (recursive sol)
    Node ptr;
    public boolean IsPalindrome(Node node){
        if(node == null)
            return true;

        if(!IsPalindrome(node.next)) 
            return false;
        if(node.data != ptr.data)
            return false;
        
        ptr = ptr.next;
        return true;
    }

    public boolean IsPalindrome(){
        ptr = head; // 
        return IsPalindrome(head);
    }

    // --------------------------------------------
    // public static void main(String[] args) {
    // LinkedList ll = new LinkedList();
    // int data = 10;
    // ll.addFirst(data);
    // }
}
