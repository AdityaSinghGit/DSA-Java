package sorting.cycle_sort;

// https://leetcode.com/problems/find-the-duplicate-number/description/

//Amazon and Microsoft question

public class FindDuplicateNumber287 {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 2 };
        int ans = findDuplicate(nums);
        System.out.println(ans);
    }

    public static int findDuplicate(int[] nums) {
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
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }
        }
        return -1;
    }
}
