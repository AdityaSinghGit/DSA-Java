public class CheckForSortedArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        boolean ans = checkForSortedArray(arr, 0);
        System.out.println(ans);
    }

    public static boolean checkForSortedArray(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        return arr[i] < arr[i + 1] && checkForSortedArray(arr, ++i);
    }
}
