package linked_list.singly_linked_list;

import linked_list.ListNode;

public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // calculate mid
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second half and detach from first half
        ListNode newHead = reverse(slow.next);
        slow.next = null;

        // execute insert logic
        ListNode first = head;
        ListNode sec = newHead;

        while (sec != null) {
            ListNode fNext = first.next;
            ListNode sNext = sec.next;
            first.next = sec;
            sec.next = fNext;
            first = fNext;
            sec = sNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
}
