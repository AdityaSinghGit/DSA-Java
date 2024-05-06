package linked_list.singly_linked_list;

import java.util.Stack;

import linked_list.ListNode;

public class RemoveNodesWithBiggerRight2487 {
    // Leetcode 2487
    // https://leetcode.com/problems/remove-nodes-from-linked-list/description/?envType=daily-question&envId=2024-05-06
    public ListNode removeNodes(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();

        while (curr != null) {
            while (!stack.isEmpty() && stack.peek().value < curr.value) {
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }

        ListNode nxt = null;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            curr.next = nxt;
            nxt = curr;
        }

        return curr;
    }
}
