public class leetcode24 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Swap Nodes in Pairs
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        ListNode next = head != null && head.next != null ? head.next : head;
        ListNode prev = null;
        while (node != null) {
            if (node.next != null) {
                if (prev != null) {
                    prev.next = node.next;
                }
                prev = node;
                ListNode list = node.next.next;
                node.next.next = node;
                node.next = list;
                node = list;
            } else {
                node = null;
            }
        }
        return next;
    }
}
