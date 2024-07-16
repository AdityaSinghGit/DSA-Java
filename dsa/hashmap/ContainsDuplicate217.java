package hashmap;

import java.util.HashMap;

public class ContainsDuplicate217 {
    // https://leetcode.com/problems/contains-duplicate/description/
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hash.isEmpty() && hash.containsKey(nums[i])) {
                return true;
            }
            hash.put(nums[i], i);
        }

        return false;
    }
}
