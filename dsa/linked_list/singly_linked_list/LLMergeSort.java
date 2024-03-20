package linked_list.singly_linked_list;

// ****************LeetCode 148****************
// WORKING, BUT DO IT AGAIN
// https://leetcode.com/problems/sort-list/
public class LLMergeSort {

    private class Node {
        private int value;
        private Node next;

        Node() {
        }

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }

    }

    public Node sortList(Node head) {
        head = linkedListMergeSort(head);
        return head;
    }

    private Node linkedListMergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);

        Node list1 = linkedListMergeSort(head);
        Node list2 = linkedListMergeSort(mid);

        return mergeSort(list1, list2);

    }

    private Node getMid(Node head) {
        Node slow = null;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow == null ? head : slow.next;
            fast = fast.next.next;
        }

        Node midNew = slow.next;
        slow.next = null;

        return midNew;

    }

    private Node mergeSort(Node list1, Node list2) {
        Node head = new Node();
        Node temp = head;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        temp.next = (list1 != null) ? list1 : list2;
        return head.next;
    }
    // ------------XXXXXXXXXXX---------------------
}
