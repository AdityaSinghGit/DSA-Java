package recursion.strings.combination;

import java.util.*;

public class LetterCombinationsOfPhoneNumber17 {
    public static void main(String[] args) {
        List<String> ans = letterCombinations("23");
        System.out.println(ans);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty() || digits == null) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Character, String> hm = new HashMap<>();

        hm.put('0', "");
        hm.put('1', "");
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        helperBacktrack(hm, sb, ans, 0, digits);

        return ans;
    }

    private static void helperBacktrack(HashMap<Character, String> hm, StringBuilder sb, List<String> ans, int i,
            String digits) {
        if (i == digits.length()) {
            // Once i goes beyond length of digits, store the combination to list.
            ans.add(sb.toString());
            return;
        }

        // Store value string based on digit using hashmap
        String current = hm.get(digits.charAt(i));
        for (int k = 0; k < current.length(); k++) {
            sb.append(current.charAt(k)); // Store alphabet based on current
            helperBacktrack(hm, sb, ans, i + 1, digits);
            sb.deleteCharAt(sb.length() - 1); // Backtrack

        }
    }

}
