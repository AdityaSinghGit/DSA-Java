package greedy_algorithms;

public class JumpGame2_45 {
    // https://leetcode.com/problems/jump-game-ii/
    // TC: O(N) bcz while is only checking for condtn
    // SC: O(1)
    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}
