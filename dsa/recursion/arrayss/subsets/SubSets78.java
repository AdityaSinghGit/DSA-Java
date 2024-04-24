package recursion.arrayss.subsets;

import java.util.List;
import java.util.ArrayList;

public class SubSets78 {
    // LeetCode 78
    // https://leetcode.com/problems/subsets/
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> ans = subsets(arr);
        for (List<Integer> i : ans) {
            System.out.println(i);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), nums, ans, 0);
        return ans;
    }

    private static void backtrack(List<Integer> temp, int[] nums, List<List<Integer>> ans, int index) {
        ans.add(new ArrayList<>(temp)); // add temp to main list

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]); // add num to list
            backtrack(temp, nums, ans, i + 1); // call recursion
            temp.remove(temp.size() - 1); // backtrack
        }
    }

}
