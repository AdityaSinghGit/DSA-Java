package arrayss;

public class PrefixSumAlgo {
    public static void main(String[] args) {
        int[] nums = { 6, 3, -2, 4, -1, 0, -5 };
        int[] range = { 2, 6 };
        int ans = findSum(nums, range);
        System.out.println(ans);
    }

    public static int findSum(int[] arr, int[] range) {
        int sum = 0;
        int[] sumArr = prefixSum(arr);
        int first = range[1];
        int second = range[0] > 0 ? range[0] - 1 : 0;

        sum = sumArr[first] - sumArr[second];

        return sum;
    }

    public static int[] prefixSum(int[] nums) {
        int[] prefixSumArr = new int[nums.length];
        prefixSumArr[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSumArr[i] = prefixSumArr[i - 1] + nums[i];
        }

        return prefixSumArr;
    }
}
