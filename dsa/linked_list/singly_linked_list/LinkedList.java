package linked_list.singly_linked_list;

import linked_list.ListNode;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        Node() {
        }

        Node(int value) {
            this.value = value;
        }

        @SuppressWarnings("unused")
        Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }

    }

    // Insert at the beginning
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    // Insert at the end
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        // node.next = null;
        tail = node;

        size += 1;
    }

    // Insert on index
    public void insertOnIndex(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }

        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    // get node by index
    public Node getNodeByIndex(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // get node by index
    public Node getNodeByValue(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // Delete first node
    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    // Delete last node
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node node = getNodeByIndex(size - 2);
        int val = tail.value;
        tail = node;
        tail.next = null;
        size--;
        return val;
    }

    // Delete by index
    public int deleteByIndex(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size) {
            return deleteLast();
        }

        Node node = getNodeByIndex(index - 1);
        int value = node.next.value;

        node.next = node.next.next;
        size--;
        return value;
    }

    // Display linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END\n");
    }

    /**************************** INTERVIEW QUESTIONS ****************************/

    // Q1 - Insert Node at index using RECURSION
    // For solution watch from 12:58
    // https://www.youtube.com/watch?v=70tx7KcMROc&t=261s
    public void insertOnIndexRecursion(int val, int index) {
        head = insertNodeRecursion(val, index, head);
    }

    private Node insertNodeRecursion(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val);
            size++;
            temp.next = node;
            return temp;
        }

        node.next = insertNodeRecursion(val, index - 1, node.next);

        return node;
    }

    // ****************LeetCode 83****************
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public Node deleteDuplicates() { // SOLUTION FOR MY LL
        Node node = head;
        while (node != null && node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
        return head;
    }
    // public ListNode deleteDuplicates(ListNode head) { // SOLUTION FOR LEETCODE LL
    // ListNode node = head;
    // while (node != null && node.next != null) {
    // if (node.val == node.next.val) {
    // node.next = node.next.next;
    // } else {
    // node = node.next;
    // }
    // }
    // return head;
    // }

    // ****************LeetCode 21****************
    // https://leetcode.com/problems/merge-two-sorted-lists/
    public static LinkedList mergeTwoSortedLists(LinkedList list1, LinkedList list2) { // SOLUTION FOR MY LL
        if (list1 == null && list2 == null) {
            return null;
        }
        Node first = list1.head;
        Node second = list2.head;
        LinkedList list = new LinkedList();

        while (first != null && second != null) {
            if (first.value < second.value) {
                list.insertLast(first.value);
                first = first.next;
            } else {
                list.insertLast(second.value);
                second = second.next;
            }
        }

        while (first != null) {
            list.insertLast(first.value);
            first = first.next;
        }

        while (second != null) {
            list.insertLast(second.value);
            second = second.next;
        }

        return list;
    }

    // LEETCODE SOLUTION
    public Node mergeTwoLists(Node list1, Node list2) {
        Node head = new Node();
        Node tail = head;
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
        tail.next = (list1 != null) ? list1 : list2;
        return head.next;
    }

    // ****************LeetCode 141****************
    // https://leetcode.com/problems/linked-list-cycle/description/
    // (check notebook for understanding)

    public boolean hasCycle(Node head) {
        Node fast = head; // FAST AND SLOW POINTER METHOD
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // ****************LeetCode 876****************
    // https://leetcode.com/problems/middle-of-the-linked-list/description/
    public Node middleNode(LinkedList list) {
        Node node = list.head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        int mid = (size / 2) + 1;
        for (int i = 1; i < mid; i++) {
            head = head.next;
        }
        return head;
    }

    // Same question using fast and slow pointers
    public Node middleNodeWithPointers(LinkedList list) {
        Node slow = list.head;
        Node fast = list.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        head = slow;
        return head;
    }

    /******** REVERSE A LINKED LIST ********/

    // For better code check
    // E:\Java\dsa\linked_list\singly_linked_list\ReverseLinkedList206.java

    // 1. USING RECURSION
    public void reverseWithRecursion(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverseWithRecursion(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;

    }

    // 2. IN PLACE REVERSAL ==(MOST IMPORTANT)==
    public Node reverseInPlace(Node node) {
        Node pres = node;
        Node prev = null;
        Node post = node.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = post;
            if (post != null) {
                post = post.next;
            }
        }

        return prev;
    }
    // -----------x-------x-------x----------

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node newHead = helper(head);

        Node first = head;
        Node second = newHead;

        while (first != null && first.next != null) {
            if (first.value != second.value) {
                System.out.println("False");
                return false;
            }
            first = first.next;
            second = second.next;
        }
        System.out.println("True");
        return true;
    }

    private static Node helper(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = helper(head.next);

        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    // ****************LeetCode 234****************
    // https://leetcode.com/problems/palindrome-linked-list/description/
    public boolean checkPalindrome(Node head) {
        Node mid = getMid(head);
        Node secondHead = getReverse(mid);
        Node reReverseSecondHead = secondHead;

        while (head != reReverseSecondHead && secondHead != null) {
            if (head.value != secondHead.value) {
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }

        getReverse(reReverseSecondHead);

        if (head != reReverseSecondHead || secondHead == null) {
            return true;
        }

        return false;

    }

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        head = slow;
        return head;
    }

    public Node getReverse(Node node) {
        Node pres = node;
        Node prev = null;
        Node post = node.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = post;
            if (post != null) {
                post = post.next;
            }
        }

        return prev;
    }
    // -----------x-------x-------x----------

    // ****************LeetCode 61****************
    // https://leetcode.com/problems/rotate-list/description/
    public Node rotateRight(Node head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        Node unChanged = head;
        Node sizeNode = head;
        int size = 1;
        while (sizeNode.next != null) {
            sizeNode = sizeNode.next;
            size++;
        }

        int newK = k % size;

        for (int i = 1; i < size - newK; i++) {
            unChanged = unChanged.next;
        }

        Node toRotate = unChanged.next;
        Node tempToRotate = toRotate;
        getReverseRotateRight(toRotate);

        tempToRotate.next = head;
        unChanged.next = null;

        return toRotate;
    }

    public Node getReverseRotateRight(Node node) {
        Node pres = node;
        Node prev = null;
        Node post = node.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = post;
            if (post != null) {
                post = post.next;
            }
        }

        return prev;
    }
    // -----------x-------x-------x----------

    // ****************LeetCode 143****************
    // https://leetcode.com/problems/reorder-list/description/
    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = getMid(head);
        Node firstHead = head;
        Node secondHead = getReverse(mid);

        while (firstHead != null && secondHead != null) {
            Node temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;
            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }

        if (firstHead != null) {
            firstHead.next = null;
        }
    }

    public Node getMidReorderList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        head = slow;
        return head;
    }

    public Node getReverseReorderList(Node node) {
        Node pres = node;
        Node prev = null;
        Node post = node.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = post;
            if (post != null) {
                post = post.next;
            }
        }

        return prev;
    }

    // -----------x-------x-------x----------
    // Leetcode 2816
    // https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/?envType=daily-question&envId=2024-05-07
    // For Solution
    // https://www.youtube.com/watch?v=KpjU5dy-ZcA
    public static Node doubleIt(Node head) {
        if (head == null)
            return head;

        LinkedList list = new LinkedList();

        long total = 0;
        Node temp = head;
        while (temp != null) {
            total = total * 10 + temp.value;
            temp = temp.next;
        }

        total *= 2;
        String num = Long.toString(total);
        num = num.substring(0, num.length() - 2);

        Node newHead = list.new Node(num.charAt(0) - '0');
        Node front = newHead;
        for (int i = 1; i < num.length(); i++) {
            front.next = list.new Node(num.charAt(i) - '0');
            front = front.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertLast(8);
        ll.insertLast(3);
        ll.insertLast(6);
        ll.insertLast(9);
        ll.insertLast(9);
        ll.insertLast(9);
        ll.insertLast(9);
        ll.insertLast(9);
        ll.display();
        // LinkedList ll2 = new LinkedList();

        // ll2.insertLast(1);
        // ll2.insertLast(4);
        // ll2.insertLast(5);
        // ll2.display();

        // LinkedList llFinal = mergeTwoSortedLists(ll, ll2);
        // llFinal.display();

        // ll.middleNode(ll);

        // ll.middleNodeWithPointers(ll);

        // reverseInPlace(ll.head);

        // LinkedList.isPalindrome(ll.head);

        // ll.display();

        doubleIt(ll.head);

        ll.display();

    }

}
