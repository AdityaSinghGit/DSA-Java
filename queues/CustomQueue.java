package queues;

public class CustomQueue {
    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    CustomQueue() {
        this(DEFAULT_SIZE); // USAGE 1 : To call other constructors.
    }

    CustomQueue(int size) {
        this.data = new int[size]; // USAGE 2 : To refer data types/objects.
    }

    int end = 0;

    // Check if queue is full
    public boolean isFull() {
        return end == data.length;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return end == 0;
    }

    // Insert item in queue
    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Queue is Full!!");
            return false;
        }

        data[end++] = item;
        return true;
    }

    // Remove item from queue
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from an empty Queue!!");
        }
        int removed = data[0];

        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }

        end--;
        return removed;
    }

    // shows item in first index
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot peek from an empty Queue!!");
        }

        return data[0];
    }

    // Display queue
    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
}
