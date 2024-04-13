package greedy_algorithms;

import java.util.*;

public class MinimumCostOfRopesGFG {
    // GFG
    // https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
    public static long minCost(long arr[], int n) {
        // For min seq
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        // For max seq
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        long fir = 0;
        long sec = 0;
        long total = 0;
        long sum = 0;
        while (minHeap.size() > 1) {
            fir = minHeap.remove();
            sec = minHeap.remove();

            sum = fir + sec;
            total += sum;

            minHeap.add(sum);
        }

        return total;
    }

    public static void main(String[] args) {
        long[] arr = { 4, 2, 7, 6, 9 };
        long ans = minCost(arr, 5);
        System.out.println(ans);
    }
}
