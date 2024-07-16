package linked_list.singly_linked_list;

import linked_list.ListNode;

public class ReverseLinkedList206 {
    // For solution :
    // https://www.youtube.com/watch?v=D2vI2DNJGd8

    // LeetCode 206
    // https://leetcode.com/problems/reverse-linked-list/description/
    public ListNode inPlaceReversal(ListNode head) {
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

    public ListNode recursionReversal(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = recursionReversal(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
}
