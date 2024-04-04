public class leetcode19 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 
    /**
     * Remove Nth Node From End of List
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            ++length;
            temp = temp.next;
        }
        if (n > length) return head;
        
        int count = length - n + 1; // Count from the end of the list
        ListNode before = null;
        temp = head;
        while (--count > 0) {
            before = temp;
            temp = temp.next;
        }
        if (before == null) {
            return temp.next;
        } else {
            before.next = temp.next;
        }
    
        return head;
    }
}
