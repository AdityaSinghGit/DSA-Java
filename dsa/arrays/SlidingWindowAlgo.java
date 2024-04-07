public class SlidingWindowAlgo {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int ans = slidingWindow(arr, arr.length, 4);
        System.out.println(ans);
    }

    // Returns maximum sum in
    // a subarray of size k.
    public static int slidingWindow(int[] arr, int n, int k) {
        int maxSum = 0;

        if (n < k) {
            return -1;
        }

        for (int i = 0; i < k; i++)
            maxSum += arr[i];

        int currentMax = maxSum;
        for (int i = k; i < n; i++) {
            currentMax += arr[i] - arr[i - k];
            maxSum = Math.max(currentMax, maxSum);
        }

        return maxSum;
    }
}
