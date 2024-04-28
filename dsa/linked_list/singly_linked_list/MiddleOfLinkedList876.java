package linked_list.singly_linked_list;

import linked_list.ListNode;

public class MiddleOfLinkedList876 {
    // Leetcode 876
    // https://leetcode.com/problems/middle-of-the-linked-list/description/

    // TIME : O(n)
    // SPACE : O(1)
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
