package linked_list.singly_linked_list;

import linked_list.ListNode;

public class DoubleLinkedListNumber2816 {
    // Leetcode 2816
    // https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/?envType=daily-question&envId=2024-05-07
    // For Solution
    // https://www.youtube.com/watch?v=KpjU5dy-ZcA

    /*
     * Logic 1
     * Reverse the linked list and multiply by 2 from left to right
     * use carry forward from left to right
     * once done, reverse the list again. But the problem is
     * Time : O(3N)
     * Space : (1)
     */

    /*
     * Logic 2
     */
    public ListNode doubleIt(ListNode head) {
        if (head == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            int newVal = curr.value * 2;
            if (newVal < 10) {
                curr.value = newVal;
            } else {
                curr.value = newVal % 10;
                if (prev == null) {
                    ListNode newNode = new ListNode(1);
                    head = newNode;
                    head.next = curr;
                } else {
                    prev.value += 1;
                }
            }
            prev = curr;
            curr = curr.next;
        }

        return head;
    }

}
