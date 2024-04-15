package binary_search;

public class CeilingCharUsingBinarySearch744 {
    /// ceiling char is immediate greater than the target char
    /// if last char in array then return first index
    public static void main(String[] args) {
        char[] arr = { 'a', 'c', 'e', 'x' };
        char target = 'd';
        char ans = orderAgnosticBs(arr, target);
        System.out.println(ans);
    }

    public static char orderAgnosticBs(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return arr[start % arr.length];

    }

}
