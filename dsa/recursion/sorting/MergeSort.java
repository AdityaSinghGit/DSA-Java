package recursion.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 99, 88, 77, 66, 55, 44, 33, 22, 11, 0 };
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;

        // copyOfRange copies from the given array in the given range
        // [NOTE] : the end range is exclusive
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];

        int i = 0; // pointer for left
        int j = 0; // pointer for right
        int k = 0; // pointer for mix(new array)

        // picking and comparing both arrays
        // then adding the smaller element in the new array
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }
        // if left is bigger in length than right
        // we simply add the remaining elements from the array
        while (i < left.length) {
            mix[k] = left[i];
            i++;
            k++;
        }

        // if right is bigger in length than left
        // we simply add the remaining elements from the array
        while (j < right.length) {
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;

    }
}

// TIME COMPLEXITY = O(n*logn)
// SPACE COMPLEXITY = O(n)