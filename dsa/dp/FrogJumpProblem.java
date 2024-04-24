package dp;

// https://www.naukri.com/code360/problems/frog-jump_3621012
public class FrogJumpProblem {
    public static void main(String[] args) {
        int[] arr = { 30, 10, 60, 10, 60, 50 }; // 40
        // int[] arr = { 10, 20, 30, 10 }; //20
        int ans = frogJump3(2, arr);
        System.out.println(ans);
    }

    // APPROACH 1 - Recursion & Memoization
    public static int frogJump1(int n, int heights[]) {
        int[] dpArr = new int[heights.length];

        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
        }

        return findMinJump(heights.length - 1, heights, dpArr);
    }

    private static int findMinJump(int index, int[] original, int[] dpArr) {
        if (index == 0)
            return 0;

        if (dpArr[index] != -1) // if exists in dp array then return
            return dpArr[index];

        // Taking ONE step and calculating the diff b\w them
        int left = findMinJump(index - 1, original, dpArr) + Math.abs(original[index] - original[index - 1]);
        // Taking TWO steps and calculating the diff b\w them
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = findMinJump(index - 2, original, dpArr) + Math.abs(original[index] - original[index - 2]);
        }

        dpArr[index] = Math.min(left, right);

        return dpArr[index];
    }

    // APPROACH 2 - Tabluation
    public static int frogJump2(int n, int heights[]) {
        int[] dpArr = new int[heights.length];

        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
        }

        dpArr[0] = 0;
        int fs = Integer.MAX_VALUE;
        int ss = Integer.MAX_VALUE;
        for (int i = 1; i < heights.length; i++) {
            fs = dpArr[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            if (i > 1)
                ss = dpArr[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dpArr[i] = Math.min(fs, ss);
        }

        return dpArr[heights.length - 1];
    }

    // APPROACH 3 - Space Optimization
    public static int frogJump3(int n, int heights[]) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = 1; i < heights.length; i++) {
            int fs = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1)
                ss = prev2 + Math.abs(heights[i] - heights[i - 2]);

            int curr = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

}
