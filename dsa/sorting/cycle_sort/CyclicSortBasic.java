package sorting.cycle_sort;

import java.util.Arrays;

public class CyclicSortBasic {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 9, 7, 5, 4, 6, 2, 8 };
        int[] ans = cyclicSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                // SWAP if mismatch
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }
        return arr;
    }
}
