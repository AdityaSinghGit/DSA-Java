package sliding_window;

public class MaxConsecutiveOnes3_1004 {
    // https://leetcode.com/problems/max-consecutive-ones-iii/description/
    // for approach
    // https://www.youtube.com/watch?v=3E4JBHSLpYk&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=4

    // TC: O(N)
    // SC: O(1)
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeroes = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                zeroes++;
            }
            if (zeroes > k) {
                if (nums[l] == 0) {
                    zeroes--;
                }
                l++;
            }
            if (zeroes <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }
}
