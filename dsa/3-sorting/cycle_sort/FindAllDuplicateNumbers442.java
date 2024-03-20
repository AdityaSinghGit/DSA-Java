
// https://leetcode.com/problems/find-all-duplicates-in-an-array/submissions/1177888372/
import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumbers442 {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 2, 3, 2, 4 };
        List<Integer> ans = findDuplicates(nums);
        System.out.println(ans);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        List<Integer> arr = new ArrayList<Integer>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                arr.add(nums[j]);
            }
        }
        return arr;
    }
}
