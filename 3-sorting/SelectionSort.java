import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 5, 4 };
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = 0;
            int max = arr[0];
            for (int j = 1; j < arr.length - i; j++) {

                if (max < arr[j]) {
                    max = arr[j];
                    index = j;
                }
            }

            int temp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = max;
            arr[index] = temp;

        }
        return arr;
    }
}
