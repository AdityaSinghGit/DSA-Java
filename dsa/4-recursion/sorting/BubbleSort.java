
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 2, 4, 6, 10, 0, 22 };
        bubbleSort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, int i, int j) {
        if (i == 0) {
            return;
        }
        if (j < i) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
            bubbleSort(arr, i, ++j);
        } else {
            bubbleSort(arr, --i, 0);
        }
    }
}
