package arrayss;

import java.util.Arrays;

public class LargestPositiveIntExistingWithItsNegative2441 {
    // Leetcode 2441
    // https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/?envType=daily-question&envId=2024-05-02
    public static void main(String[] args) {
        int[] nums = { -1, 10, 6, 7, -7, 1 }; // 7
        // int[] nums = { -17, 48, 12, -28, 19, -33, 13, -39, -30, -30 }; // -1
        int ans = findMaxK(nums);
        System.out.println(ans);
    }

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (Math.abs(nums[start]) < nums[end]) {
                end--;
            }
            if (Math.abs(nums[start]) > nums[end]) {
                start++;
            }
            if (nums[start] == nums[end] || start == end) {
                return -1;
            }
            if (Math.abs(nums[start]) == nums[end]) {
                return nums[end];
            }
        }

        return -1;
    }
}
