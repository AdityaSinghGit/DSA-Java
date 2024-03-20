import java.util.Arrays;

public class SquaresOfSortedArray977 {
    // Try doing it in O(n)
    public static void main(String[] args) {
        int[] arr = { -4, -1, 0, 3, 10 };
        int[] ans = result(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] result(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int startSq = arr[start] * arr[start];
            int endSq = arr[end] * arr[end];
            if ((startSq) > (endSq)) {
                int temp = arr[end];
                arr[end] = startSq;
                arr[start] = temp;
            } else {
                arr[start] = arr[start];
                arr[end] = endSq;
            }
            end--;
        }

        return arr;
    }

}
