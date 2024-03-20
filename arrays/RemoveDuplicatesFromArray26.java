import java.util.ArrayList;

public class RemoveDuplicatesFromArray26 {

    static ArrayList<Integer> vector = new ArrayList<Integer>();

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        removeDuplicates(arr);
    }

    public static int removeDuplicates(int[] nums) {
        vector.add(nums[0]);
        singleElement(nums, 0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (i < vector.size()) {
                nums[i] = vector.get(i);
            } else {
                nums[i] = 0;
            }
        }
        int ans = vector.size();
        vector.clear();
        return ans;
    }

    public static int singleElement(int[] arr, int s, int e) {
        if (s == e) {
            return e;
        }
        while (e < arr.length) {
            if (arr[s] == arr[e]) {
                return singleElement(arr, ++s, ++e);
            } else {
                vector.add(arr[e]);
                return singleElement(arr, ++s, ++e);

            }
        }

        return -1;

    }

}
