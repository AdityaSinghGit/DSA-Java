package linked_list.singly_linked_list;

import linked_list.ListNode;

public class CycleDetection142 {
    // Leeftcode 142
    // https://leetcode.com/problems/linked-list-cycle-ii/description/

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int cycleLen = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                do {
                    slow = slow.next;
                    cycleLen++;
                } while (fast == slow);
            }
        }

        fast = head;
        slow = head;

        for (int i = 0; i <= cycleLen; i++) {
            slow = slow.next;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
