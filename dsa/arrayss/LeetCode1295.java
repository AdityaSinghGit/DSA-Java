package arrayss;

public class LeetCode1295 {
    public static void main(String[] args) {
        int[] arr = { 12, 34, 2, 6, 7896, 22 };
        System.out.println(findNumbers(arr));
    }

    /// Find numbers with even number of digits
    public static int findNumbers(int[] nums) {
        double numLength = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            /// counts length of a number
            numLength = (int) (Math.log10(nums[i])) + 1;
            if (numLength % 2 == 0) {
                count++;
            }
        }
        return count;
    }

};