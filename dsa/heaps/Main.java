package heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(22);
        heap.insert(45);
        heap.insert(36);
        heap.insert(97);
        heap.insert(5);

        heap.remove();

        ArrayList<Integer> list = heap.heapSort();

        System.out.println(list);
    }
}
