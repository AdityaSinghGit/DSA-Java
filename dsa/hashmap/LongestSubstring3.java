package hashmap;

import java.util.HashMap;

public class LongestSubstring3 {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        HashMap<Character, Integer> hash = new HashMap<>();
        int maxLen = 0;

        for (int i = 0, j = 0; j < n; j++) {
            if (!hash.containsKey(s.charAt(j)) || hash.get(s.charAt(j)) < i) {
                hash.put(s.charAt(j), j);
                maxLen = Math.max(maxLen, j - i + 1);
            } else {
                i = hash.get(s.charAt(j)) + 1;
                hash.put(s.charAt(j), j);
            }
        }

        return maxLen;
    }
}
