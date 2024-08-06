package sliding_window;

public class MaxPointsFromCards1423 {
    // https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
    // For Sol
    // https://www.youtube.com/watch?v=pBWCOCS636U&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=2

    // TC: O(2K)
    // SC: O(1)
    public static void main(String[] args) {
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 }; // 12
        System.out.println(maxScore(cardPoints, 3));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int maxsum = 0;

        for (int i = 0; i < k; i++) {
            lsum = lsum + cardPoints[i];
            maxsum = Math.max(maxsum, lsum);
        }

        int rind = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rind];
            rind = rind - 1;
            maxsum = Math.max(maxsum, lsum + rsum);
        }
        return maxsum;
    }
}
