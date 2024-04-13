package greedy_algorithms;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-length-of-pair-chain/
public class MaxLenPairChain646 {
    public static void main(String[] args) {
        // int[][] pairs = { { 1, 2 }, { 7, 8 }, { 4, 5 } };
        int[][] pairs = { { -6, 9 }, { 1, 6 }, { 8, 10 }, { -1, 4 }, { -6, -2 }, {
                -9, 8 }, { -5, 3 }, { 0, 3 } };
        int ans = findLongestChain(pairs);
        System.out.println(ans);
    }

    public static int findLongestChain(int[][] pairs) {
        int count = 0;
        if (pairs.length == 0) {
            return count;
        }

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int end = pairs[0][1];
        count = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                count++;
                end = pairs[i][1];
            }
        }

        return count;
    }
}
