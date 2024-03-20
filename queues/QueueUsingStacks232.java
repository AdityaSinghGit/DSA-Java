package queues;

import java.util.Stack;

public class QueueUsingStacks232 {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStacks232() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        if (empty()) {
            return 0;
        }
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return removed;
    }

    public int peek() {
        if (empty()) {
            return 0;
        }
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int peeked = second.peek();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return peeked;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
