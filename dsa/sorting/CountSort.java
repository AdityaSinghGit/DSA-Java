package sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 1, 3, 2, 5, 2, 8 };
        countSort(arr);
        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return;
        }

        int max = 0;
        // Find max
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }

        // Make frequency array
        int[] freqArr = new int[max + 1];
        for (int num : arr) {
            freqArr[num]++;
        }
        System.out.println("Frequency Arr : " + Arrays.toString(freqArr));

        int index = 0;
        // Using frequency array, sort original array
        for (int i = 0; i <= max; i++) {
            while (freqArr[i] > 0) {
                arr[index] = i;
                index++;
                freqArr[i]--;
            }
        }

    }
}
