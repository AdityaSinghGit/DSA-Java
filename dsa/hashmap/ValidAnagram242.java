package hashmap;

import java.util.*;

public class ValidAnagram242 {
    // https://leetcode.com/problems/valid-anagram/?source=submission-noac
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean ans = isAnagram(s, t);
        System.out.println(ans);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> hash = new HashMap<>();

        for (char i : s.toCharArray()) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }

        for (char i : t.toCharArray()) {
            hash.put(i, hash.getOrDefault(i, 0) - 1);
        }

        for (int val : hash.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}
