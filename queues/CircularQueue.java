package queues;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    CircularQueue() {
        this(DEFAULT_SIZE); // USAGE 1 : To call other constructors.
    }

    CircularQueue(int size) {
        this.data = new int[size]; // USAGE 2 : To refer data types/objects.
    }

    // Check if queue is full
    public boolean isFull() {
        return size == data.length;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Insert item in queue
    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Queue is Full!!");
            return false;
        }

        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    // Remove item from queue
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from an empty Queue!!");
        }
        int removed = data[front];

        front++;
        front = front % data.length;
        size--;
        return removed;
    }

    // shows item in first index
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot peek from an empty Queue!!");
        }

        return data[front];
    }

    // Display queue
    public void display() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot display from an empty Queue!!");
        }

        int temp = front;
        do {
            System.out.print(data[temp] + " -> ");
            temp++;
            temp = temp % data.length;
        } while (temp != end);
        System.out.println("END");
    }
}
