package dp;

public class HouseRobberPt2_213 {
    public static void main(String[] args) {
        int[] nums = { 1 };
        int ans = rob(nums);
        System.out.println(ans);
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dpArr = new int[nums.length];

        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
        }

        int[] dpArr2 = new int[nums.length];

        for (int i = 0; i < dpArr2.length; i++) {
            dpArr2[i] = -1;
        }

        int[] temp1 = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            temp1[i - 1] = nums[i];
        }

        int[] temp2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            temp2[i] = nums[i];
        }

        return Math.max(houseRobber(temp1.length - 1, dpArr, temp1), houseRobber(temp2.length - 1, dpArr2, temp2));
    }

    private static int houseRobber(int index, int[] dpArr, int[] nums) {
        if (index == 0) {
            return nums[0];
        }

        if (index == -1) {
            return 0;
        }

        if (dpArr[index] != -1) {
            return dpArr[index];
        }

        int pick = nums[index] + houseRobber(index - 2, dpArr, nums);
        int notPick = 0 + houseRobber(index - 1, dpArr, nums);

        dpArr[index] = Math.max(pick, notPick);

        return dpArr[index];
    }
}
