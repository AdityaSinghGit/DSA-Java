package linked_list.circular_linked_list;

import linked_list.singly_linked_list.LinkedList;

public class CycleQuestions {

    private class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // LeetCode 141
    // https://leetcode.com/problems/linked-list-cycle/
    // AMAZON AND MICROSOFT
    public boolean hasCycle(Node head) {
        Node fast = head;
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

    // Find length of cycle in above question
    public boolean hasCycleAndLength(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                Node temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                System.err.println(length);
                return true;

            }
        }
        return false;
    }

    // LeetCode 142
    // https://leetcode.com/problems/linked-list-cycle-ii/
    public Node detectCycle(Node head) {
        Node f = head;
        Node s = head;
        Node tempf = f;
        Node temps = s;
        int length = 0;

        while (tempf != null && tempf.next != null) {
            temps = temps.next;
            tempf = tempf.next.next;
            if (tempf == temps) {
                do {
                    temps = temps.next;
                    length++;
                } while (temps != tempf);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        while (length > 0) {
            s = s.next;
            length--;
        }

        while (s != f) {
            s = s.next;
            f = f.next;
        }

        return s;
    }

    // LeetCode 202
    // https://leetcode.com/problems/happy-number/
    // GOOGLE
    public static boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private static int findSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
