public class findNoForInfiniteArrayBinarySearch {
    /// find a number in a sorted infinite array.
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 6, 8, 10, 12, 14, 16, 18, 22, 55, 58, 67, 69, 70, 99 };
        int target = 67;
        int ans = ans(arr, target);
        System.out.println(ans);
    }

    public static int ans(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int newStart = end + 1;
            // we keep increasing the range of array by double and apply BS on it.
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return orderAgnosticBs(arr, start, end, target);
    }

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
