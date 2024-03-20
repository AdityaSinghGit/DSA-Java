package stack;

public class CustomStack {

    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    CustomStack() {
        this(DEFAULT_SIZE); // USAGE 1 : To call other constructors.
    }

    CustomStack(int size) {
        this.data = new int[size]; // USAGE 2 : To refer data types/objects.
    }

    int ptr = -1;

    // Check if stack is full
    public boolean isFull() {
        return ptr == data.length - 1;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return ptr == -1;
    }

    // Push item in stack
    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack is Full!!");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    // Pop item from stack
    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot pop from an empty stack!!");
        }

        // int removed = data[ptr];
        // ptr--;
        // return removed;
        return data[ptr--]; // optimized form of above 3 lines
    }

    // peek first item in stack
    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot peek from an empty stack!!");
        }

        return data[ptr];
    }

}
