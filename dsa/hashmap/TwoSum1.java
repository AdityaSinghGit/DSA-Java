package hashmap;

import java.util.HashMap;

public class TwoSum1 {
    // https://leetcode.com/problems/two-sum/description/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (!hashMap.isEmpty() && hashMap.containsKey(sub)) {
                return new int[] { hashMap.get(sub), i };
            }
            hashMap.put(nums[i], i);
        }

        return new int[] {};
    }
}
