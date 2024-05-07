package linked_list.singly_linked_list;

import java.util.Stack;

import linked_list.ListNode;

public class DoubleTheLinkedList2816 {
    // Leetcode 2816
    // https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/?envType=daily-question&envId=2024-05-07
    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int carry = 0;
        ListNode nxt = null;
        ListNode currentNode = new ListNode();
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            if (currentNode.value <= 4) {
                currentNode.value = (currentNode.value * 2) + carry;
                carry = 0;
            } else {
                currentNode.value = ((currentNode.value * 2) % 10) + carry;
                carry = 1;
            }

            currentNode.next = nxt;
            nxt = currentNode;
        }

        if (carry != 0) {
            currentNode = new ListNode(carry);
            currentNode.next = nxt;
        }

        return currentNode;
    }
}
