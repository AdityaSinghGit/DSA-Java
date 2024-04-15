package sorting.cycle_sort;

// https://leetcode.com/problems/first-missing-positive/description/

import java.util.Arrays;

// Amazon question

public class FirstMissingPositive41 {
    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        int ans = missingNumber(nums);
        System.out.println(ans);
    }

    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }
}
