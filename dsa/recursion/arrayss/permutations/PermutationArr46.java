package recursion.arrayss.permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationArr46 {
    // Leetcode 46
    // https://leetcode.com/problems/permutations/
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> ans = permute(arr);
        for (List<Integer> i : ans) {
            System.out.println(i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, nums, new ArrayList<Integer>());
        return result;
    }

    private static List<List<Integer>> backtracking(List<List<Integer>> result, int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp)); // add temp to main list
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            // If list already contains the num, ignore.
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]); // add num to list
            backtracking(result, nums, temp); // call recursion
            temp.remove(temp.size() - 1); // backtrack
        }

        return result;
    }

}
