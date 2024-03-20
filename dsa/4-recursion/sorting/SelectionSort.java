
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 2, 4, 6, 10, 0, 22 };
        selectionSort(arr, arr.length - 1, 0, arr[0], 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr, int i, int j, int max, int index) {
        if (i == 0) {
            return;
        }
        if (j <= i) {
            if (max < arr[j]) {
                max = arr[j];
                index = j;
            }
            selectionSort(arr, i, ++j, max, index);
        } else {
            if (max != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
            selectionSort(arr, --i, 0, arr[0], 0);
        }
    }
}
