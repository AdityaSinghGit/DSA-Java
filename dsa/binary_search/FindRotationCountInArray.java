package binary_search;

public class FindRotationCountInArray {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1, 2 };

        int ans = search(arr);
        System.out.println(ans);

    }

    public static int search(int[] nums) {
        int peak = findPivot(nums);
        return peak + 1;
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
}
