package greedy_algorithms;

public class JumpGame55 {
    // leetcode.com/problems/jump-game/
    public boolean canJump(int[] nums) {
        int maxInd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxInd < i)
                return false;
            maxInd = Math.max(maxInd, i + nums[i]);
        }

        return true;
    }
}
