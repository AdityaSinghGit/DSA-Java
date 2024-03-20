import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 18, 9, 23, 45, 58, 63, 75, 88 };
        int ans = linearSearch(arr, 58, 0);
        System.out.println(ans);
        int[] arr1 = { 3, 2, 1, 18, 9, 23, 45, 58, 58, 58, 63, 75, 88 };
        linearSearchMultiple(arr1, 58, 0);
        System.out.println(arrList);
    }

    /// For searching one index of target
    public static int linearSearch(int[] arr, int target, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (target == arr[i]) {
            return i;
        } else {
            return linearSearch(arr, target, ++i);
        }
    }

    static ArrayList<Integer> arrList = new ArrayList<>();

    /// For searching multiple indexes of target
    public static int linearSearchMultiple(int[] arr, int target, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (target == arr[i]) {
            arrList.add(i);
        }
        return linearSearchMultiple(arr, target, ++i);

    }

}
