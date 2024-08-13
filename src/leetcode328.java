public class leetcode328 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Odd Even Linked List
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode evenNode = evenHead;
        while (evenNode != null && evenNode.next != null) {
            oddHead.next = evenNode.next;
            oddHead = oddHead.next;
            evenNode.next = oddHead.next;
            evenNode = evenNode.next;
        }
        oddHead.next = evenHead;
        return head;
    }
}
