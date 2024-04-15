package binary_search;

import java.util.Arrays;

public class FirstLastElementIndexBinarySearch34 {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int firstIn = findFirstAndLastIndex(arr, target, true);
        int endIn = findFirstAndLastIndex(arr, target, false);
        int[] finalArr = { firstIn, endIn };
        System.out.println(Arrays.toString(finalArr));
    }

    public static int findFirstAndLastIndex(int[] arr, int target, boolean isStart) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (isStart) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
        }
        return ans;

    }

}
