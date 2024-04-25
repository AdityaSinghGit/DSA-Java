package linked_list.singly_linked_list;

public class RemoveDuplicatesFromSortedList83 {
    // LeetCode 83
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;

        if (head == null) {
            return node;
        }

        while (node.next != null) {
            if (node.next.val == node.val) {
                ListNode temp = node.next;
                node.next = node.next.next;
                temp.next = null;
            } else {
                node = node.next;
            }
        }

        return head;
    }

    private class ListNode {
        private int val;
        private ListNode next;
    }
}
