package greedy_algorithms;

import java.util.*;

public class ChocolateDistributionGFG {
    // GFG
    // https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
    public static long findMinDiff(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        int min = 0;
        int max = 0;
        int diff = a.get(a.size() - 1);

        System.out.println(a.toString());

        for (int i = 0; i <= n - m; i++) {
            min = a.get(i);
            max = a.get(m - 1 + i);
            int current = max - min;
            diff = Math.min(current, diff);
        }

        return (long) diff;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(7);
        a.add(3);
        a.add(2);
        a.add(4);
        a.add(9);
        a.add(12);
        a.add(56);
        long n = findMinDiff(a, 7, 3);
        System.out.println(n);
    }
}
