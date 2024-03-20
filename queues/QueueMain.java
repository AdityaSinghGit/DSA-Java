package queues;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        // CustomQueue queue = new CustomQueue(5);

        // queue.insert(1);
        // queue.insert(2);
        // queue.insert(3);
        // queue.insert(4);
        // queue.insert(5);

        // queue.display();

        // System.out.println(queue.remove());

        // queue.display();

        CircularQueue cQueue = new CircularQueue(5);

        cQueue.insert(1);
        cQueue.insert(2);
        cQueue.insert(3);
        cQueue.insert(4);
        cQueue.insert(5);

        cQueue.display();

        System.out.println(cQueue.remove());
        cQueue.insert(6);

        cQueue.display();
    }
}
