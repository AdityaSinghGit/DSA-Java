public class FirstTargetIndexInMountainArray1095 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 3, 1 };
        int target = 3;
        int finalAns = findInMountainArray(target, arr);
        System.out.println(finalAns);

    }

    public static int findInMountainArray(int target, int[] arr) {
        int peak = peakIndexInMountainArray(arr);
        int ans = orderAgnosticBs(arr, 0, peak, target);
        // if target not found in asc arr then try for dec.
        if (ans == -1) {
            ans = orderAgnosticBs(arr, peak + 1, arr.length - 1, target);
        }
        // if target is not even found in dec then return -1 or target index.
        if (ans == -1) {
            return -1;
        } else {
            return ans;
        }
    }

    // First find the peak and split array into asc and dec.
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }

    // apply binary search for target in both asc and dec order
    public static int orderAgnosticBs(int[] arr, int start, int end, int target) {

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;

    }
}
