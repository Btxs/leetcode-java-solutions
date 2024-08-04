public class leetcode2130 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Maximum Twin Sum of a Linked List
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse linked list
        ListNode prev = null, curr = slow, nextNode;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        int maxSum = Integer.MIN_VALUE;
        while (prev != null && head != null) {
            maxSum = Math.max(maxSum, head.val + prev.val);
            head = head.next;
            prev = prev.next;
        }
        return maxSum;
    }
}
