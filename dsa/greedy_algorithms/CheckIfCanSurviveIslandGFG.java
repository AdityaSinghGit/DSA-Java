package greedy_algorithms;

public class CheckIfCanSurviveIslandGFG {
    // GFG
    // https://www.geeksforgeeks.org/problems/check-if-it-is-possible-to-survive-on-island4922/1
    public static int minimumDays(int S, int N, int M) {
        int sunday = S / 7;
        int buyingDays = S - sunday;
        int minDays = (S * M);
        int ans = 0;

        if (minDays % N == 0) {
            ans = minDays / N;
        } else {
            ans = (minDays / N) + 1;
        }

        if (ans <= buyingDays) {
            return ans;
        } else {
            return -1;
        }
    }
}
