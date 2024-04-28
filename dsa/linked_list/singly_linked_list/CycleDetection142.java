package linked_list.singly_linked_list;

import linked_list.ListNode;

public class CycleDetection142 {
    // Leeftcode 142
    // https://leetcode.com/problems/linked-list-cycle-ii/description/

    // TIME : O(n)
    // SPACE : O(1)
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
                } while (fast != slow);
                break;
            }
        }

        if (cycleLen == 0) {
            return null;
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
