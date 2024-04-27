package linked_list.singly_linked_list;

import linked_list.ListNode;

public class CycleDetection141 {
    // Leetcode 141
    // https://leetcode.com/problems/linked-list-cycle
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
