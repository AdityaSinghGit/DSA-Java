package linked_list.singly_linked_list;

import linked_list.ListNode;

public class RotateList61 {
    // For solution
    // https://www.youtube.com/watch?v=uT7YI7XbTY8
    // Leetcode 61
    // https://leetcode.com/problems/rotate-list/description/
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        // check list size
        // make tail reach the end node
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        // calculate actual rotations required
        // eg- 7 % 5 = 2 rotations
        int rotation = k % size;
        if (rotation == 0) {
            return head;
        }

        // Push temp until before we rotate
        ListNode temp = head;
        for (int i = 0; i < size - rotation - 1; i++) {
            temp = temp.next;
        }

        // execute logic
        tail.next = head;
        head = temp.next;
        temp.next = null;

        return head;
    }
}
