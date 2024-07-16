package linked_list.singly_linked_list;

import linked_list.ListNode;

public class CheckPalindrome234 {
    // For solution :
    // https://www.youtube.com/watch?v=lRY_G-u_8jk
    // Leetcode 234
    // https://leetcode.com/problems/palindrome-linked-list/description/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = reverse(slow.next);

        ListNode first = head;
        ListNode sec = newHead;

        while (sec != null) {
            if (first.value != sec.value) {
                return false;
            }
            first = first.next;
            sec = sec.next;
        }
        return true;
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
