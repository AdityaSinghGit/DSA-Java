package binary_search;

public class BinarySearchBasic {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 12, 15, 18, 25, 29, 36, 44, 51, 63 };
        int target = 36;
        int ans = orderAgnosticBs(arr, target);
        System.out.println(ans);
    }

    public static int orderAgnosticBs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

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
