package sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = { 5, 1, -2, 3, 2, 1, -1, 0 };
        countSortForAllNos(arr);
        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }

    // COUNT SORT FOR ALL +ive AND -ive VALUES
    public static void countSortForAllNos(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // This line of code uses Java's Stream API
        // to find the maximum/maxinum value in the array.
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        int[] currentArr = new int[max - min + 1];
        // Create freq Arr
        for (int value : arr) {
            currentArr[value - min]++;
        }

        // Add prev element from currentArr to ith element
        for (int i = 1; i < currentArr.length; i++) {
            currentArr[i] += currentArr[i - 1];
        }

        int[] output = new int[arr.length];
        // Place elements in sorted manner based on currentArr
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            int opIndex = currentArr[current - min] - 1;
            output[opIndex] = current;
            currentArr[current - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // *******************************************************************/
    // CONVENTIONAL METHOD FOR ONLY POSITIVE NUMBERS
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
