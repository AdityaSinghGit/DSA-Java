
import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = { 99, 88, 77, 66, 55, 44, 33, 22, 11, 0 };
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }
        int m = (s + e) / 2;

        mergeSortInPlace(arr, s, m);
        mergeSortInPlace(arr, m, e);

        mergeInPlace(arr, s, m, e);
    }

    public static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int i = s; // pointer for left
        int j = m; // pointer for right
        int k = 0; // pointer for mix(new array)

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {

            arr[s + l] = mix[l];
        }

    }
}
