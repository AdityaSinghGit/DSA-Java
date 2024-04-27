package linked_list.singly_linked_list;

import linked_list.ListNode;

public class MergeTwoSortedLists21 {
    // leetcode 21
    // https://leetcode.com/problems/merge-two-sorted-lists/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        // whichever is not empty will be attached to reaultant tail
        tail.next = (list1 != null) ? list1 : list2;
        return head.next; // bcz items started to add from 2nd node (line 11)
    }
}
