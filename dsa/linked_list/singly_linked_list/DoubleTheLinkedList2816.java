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

    public ListNode doubleIt2(ListNode head) {
        int total = 0;
        ListNode temp = head;
        while (temp != null) {
            total = total * 10 + temp.value;
            temp = temp.next;
        }
        total = total * 2;

        String sol = Integer.toString(total);
        ListNode ans = new ListNode();
        ListNode answer = new ListNode(sol.charAt(sol.length() - 1) - 0);
        int length = sol.length() - 2;
        while (length > 0) {
            ans.value = sol.charAt(length) - 0;
            ans = ans.next;
        }
        return answer;
    }
}
