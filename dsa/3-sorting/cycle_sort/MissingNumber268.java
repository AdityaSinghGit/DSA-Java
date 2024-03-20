
// https://leetcode.com/problems/missing-number/

//Amazon question

public class MissingNumber268 {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1, 2 };
        int ans = missingNumber(nums);
        System.out.println(ans);
    }

    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return nums.length;
    }
}
