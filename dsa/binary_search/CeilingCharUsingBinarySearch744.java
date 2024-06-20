package binary_search;

public class CeilingCharUsingBinarySearch744 {
    /// ceiling char is immediate greater than the target char
    /// if last char in array then return first index
    public static void main(String[] args) {
        char[] arr = { 'a', 'c', 'e', 'x' };
        // char target = 'd';
        char target = 'y';
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
        // Divident / Divisor
        // if Divident < Divisor = Divident
        // if Divident > Divisor = Remainder
        // So if start = 4 & len = 3 then remainder = 1
        // and if start = 2 & len = 3 then remainde = 2
        return arr[start % arr.length];

    }

}
