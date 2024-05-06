package linked_list.singly_linked_list;

import linked_list.ListNode;

public class DeleteNodeWithoutHead237 {
    // Leetcode 237
    // https://leetcode.com/problems/delete-node-in-a-linked-list/description/?envType=daily-question&envId=2024-05-05
    public void deleteNode(ListNode node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
