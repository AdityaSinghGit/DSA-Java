package sorting;

import java.util.Arrays;

public class RadixSort {

    public static void radixSort(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return;
        }
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

    }

    // public static void radixSort(int[] arr) {
    // // This line of code uses Java's Stream API
    // // to find the maximum value in the array.
    // int max = Arrays.stream(arr).max().getAsInt();

    // // exponent will hold the ones, tens, hundreds, etc places.
    // // max / exp will return a non 0 digit.
    // for (int exp = 1; max / exp > 0; exp *= 10) {
    // countSort(arr, exp);
    // }
    // }

    // private static void countSort(int[] arr, int exp) {
    // int n = arr.length;
    // int[] outputArr = new int[n];
    // int[] countArr = new int[10]; // As ones place can hold digits from 0-9 only

    // for (int i = 0; i < n; i++) {
    // countArr[(arr[i] / exp) % 10]++;
    // }
    // System.out.println("Count array for : " + Arrays.toString(countArr));

    // for (int i = 1; i < 10; i++) {
    // countArr[i] += countArr[i - 1];
    // }
    // System.out.println("Updated count array : " + Arrays.toString(countArr));

    // for (int i = n - 1; i >= 0; i--) {
    // outputArr[countArr[(arr[i] / exp) % 10] - 1] = arr[i];
    // countArr[(arr[i] / exp) % 10]--;
    // }
    // System.out.println("Output array : " + Arrays.toString(outputArr) + "\n");

    // System.arraycopy(outputArr, 0, arr, 0, n);

    // }

    public static void main(String[] args) {
        int[] arr = { 29, 83, 471, 36, 91, 8 };
        System.out.println("Original array : " + Arrays.toString(arr) + "\n");
        radixSort(arr);
        System.out.println("Sorted array : " + Arrays.toString(arr));
    }
}
