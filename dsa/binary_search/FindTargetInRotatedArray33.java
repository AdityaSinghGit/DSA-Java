package binary_search;

public class FindTargetInRotatedArray33 {

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int ans = search(arr, target);
        System.out.println(ans);

    }

    public static int search(int[] nums, int target) {
        int peak = findPivot(nums);
        int ans = orderAgnosticBs(nums, 0, peak, target);
        if (ans == -1) {
            ans = orderAgnosticBs(nums, peak + 1, nums.length - 1, target);
        }
        return ans;
    }

    // method to find pivot
    public static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;

    }

    // apply binary search
    public static int orderAgnosticBs(int[] arr, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;

    }

}
