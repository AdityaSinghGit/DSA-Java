package recursion;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 6, 7, 8, 10, 14, 26, 38, 66 };
        int target = 38;
        int ans = binarySearchRecursion(arr, target, 0, arr.length - 1);
        System.out.println(ans);
    }

    public static int binarySearchRecursion(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int mid = s + (e - s) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            // [TIP] : Return your recursive function if there is a return type.
            return binarySearchRecursion(arr, target, s, mid - 1);
        } else {
            return binarySearchRecursion(arr, target, mid + 1, e);
        }
    }
}
