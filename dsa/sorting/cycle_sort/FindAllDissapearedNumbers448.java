package sorting.cycle_sort;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

import java.util.ArrayList;
import java.util.List;

//Google question

public class FindAllDissapearedNumbers448 {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> ans = findDisappearedNumbers(nums);
        System.out.println(ans);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
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
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                arr.add(j + 1);
            }
        }
        return arr;
    }
}
