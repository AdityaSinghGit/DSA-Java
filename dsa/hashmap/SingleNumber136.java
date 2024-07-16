package hashmap;

public class SingleNumber136 {
    // https://leetcode.com/problems/single-number/description/
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }

        return result;
    }
}
