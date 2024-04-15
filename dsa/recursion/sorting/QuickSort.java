package recursion.sorting;

import java.util.Arrays;

// very important, often asked in interviews directly.
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 1, 6, 4, 3, 9, 8, 0, 5, 7 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(4 & 3);

    }

    static void quickSort(int[] arr, int low, int hi) {
        int s = low;
        int e = hi;

        if (s >= e) {
            return;
        }

        int m = s + (e - s) / 2;

        int pivot = arr[m];

        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = arr[e];
                arr[e] = arr[s];
                arr[s] = temp;
                s++;
                e--;
            }

        }

        quickSort(arr, low, e);
        quickSort(arr, s, hi);

    }

}
