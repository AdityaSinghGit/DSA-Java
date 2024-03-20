
// https://leetcode.com/problems/set-mismatch/

import java.util.Arrays;

public class SetMismatch645 {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 2 };
        int[] ans = findErrorNums(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
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

                return new int[] { nums[j], j + 1 };

            }
        }
        return new int[] { -1, -1 };
    }
}
