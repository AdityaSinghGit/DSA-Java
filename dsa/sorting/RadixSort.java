package sorting;

import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = { 29, 83, 471, 36, 91, 8, -42, -10, -440, -112 };
        System.out.println("Original array : " + Arrays.toString(arr) + "\n");

        // This line of code uses Java's Stream API
        // to find and store +ive and -ive values in the array.
        int[] posArr = Arrays.stream(arr).filter((int i) -> i >= 0).toArray();
        int[] negArr = Arrays.stream(arr).filter((int i) -> i < 0).toArray();

        // Converting all values to +ive
        for (int i = 0; i < negArr.length; i++) {
            negArr[i] *= -1;
        }

        radixSort(posArr);
        radixSort(negArr);

        // Converting all values to -ive
        // And storing -ive values in reverse
        for (int i = 0; i < negArr.length; i++) {
            negArr[negArr.length - 1 - i] *= -1;
            arr[i] = negArr[negArr.length - 1 - i];
        }

        // Storing all +ive values after -ive values
        for (int i = 0; i < posArr.length; i++) {
            arr[negArr.length + i] = posArr[i];
        }

        System.out.println("Sorted array : " + Arrays.toString(arr));
    }

    // RADIX SORT
    public static void radixSort(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return;
        }
        // This line of code uses Java's Stream API
        // to find the maximum/maxinum value in the array.
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        // exponent will hold the ones, tens, hundreds, etc places.
        // max / exp will return a non 0 digit.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(exp, arr);
        }
    }

    // COUNT SORT
    private static void countSort(int exp, int[] arr) {
        int[] currentArr = new int[10];

        // Create freq Arr
        for (int value : arr) {
            currentArr[(value / exp) % 10]++;
        }

        // Add prev element from currentArr to ith element
        for (int i = 1; i < 10; i++) {
            currentArr[i] += currentArr[i - 1];
        }

        int[] output = new int[arr.length];
        // Place elements in sorted manner based on currentArr
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            int outputArr = currentArr[(current / exp) % 10] - 1;
            output[outputArr] = current;
            currentArr[(current / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

}
