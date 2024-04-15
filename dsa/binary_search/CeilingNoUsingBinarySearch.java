package binary_search;

public class CeilingNoUsingBinarySearch {
    /// ceiling is a number immediate greater than or equal to target number
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 6, 8, 10, 12, 14, 16, 18 };
        int target = 17;
        int ans = orderAgnosticBs(arr, target);
        System.out.println(ans);
    }

    public static int orderAgnosticBs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

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
        /*
         * The only change from regular binary search is that
         * instead of returning -1 you return start because when the while loop breaks:
         * 
         * 1) start--target--end
         * 2) if target not found loop will collapse
         * 3) end--target--start
         * it will become our ceiling ans
         */
        return start;

        // ***For floor number***
        // return end;

    }

}
