package arrayss;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = { -3, 4, 3, 90 };
        int[] ans = twoSum(nums, 0);

        System.out.println(Arrays.toString(ans));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (!hash.isEmpty() && hash.containsKey(sub)) {
                return new int[] { hash.get(sub), i };
            } else {
                hash.put(nums[i], i);
            }
        }

        return new int[] { -1, -1 };
    }
}
