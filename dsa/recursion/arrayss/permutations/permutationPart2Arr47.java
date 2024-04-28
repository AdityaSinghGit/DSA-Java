package recursion.arrayss.permutations;

import java.util.ArrayList;
import java.util.List;

public class permutationPart2Arr47 {
    // Leetcode 47
    // https://leetcode.com/problems/permutations-ii/
    public static void main(String[] args) {
        int[] arr = { 1, 1, 3 };
        List<List<Integer>> ans = permuteUnique(arr);
        for (List<Integer> i : ans) {
            System.out.println(i);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // boolean[nums.length] - list to keep a track whether a number has been used.
        // [false, false, false]
        backtracking(result, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }

    private static List<List<Integer>> backtracking(List<List<Integer>> result, int[] nums, List<Integer> temp,
            boolean[] used) {
        if (temp.size() == nums.length && !result.contains(temp)) { // If result already contains temp list, ignore.
            result.add(new ArrayList<>(temp)); // add temp to main list
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            // if boolean is true then ignore.
            if (used[i]) {
                continue;
            }

            used[i] = true; // before adding to list, set to true;
            temp.add(nums[i]); // add num to list

            backtracking(result, nums, temp, used); // call recursion

            used[i] = false; // before removing from list, set to false;
            temp.remove(temp.size() - 1); // backtrack
        }

        return result;
    }
}
