package greedy_algorithms;

import java.util.Arrays;

public class AssignCookies455 {
    // Leetcode 455
    // https://leetcode.com/problems/assign-cookies/description/
    // For solution
    // https://www.youtube.com/watch?v=DIX2p7vb9co&list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea

    // TC: O(NlogN)
    // SC: O(1)
    public int findContentChildren(int[] g, int[] s) {
        int i = g.length;
        int j = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0;
        int right = 0;

        while (left < i && right < j) {
            if (g[left] <= s[right]) {
                left++;
            }
            right++;
        }

        return left;

    }
}
