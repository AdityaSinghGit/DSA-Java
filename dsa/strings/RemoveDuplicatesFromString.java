package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        String[] a = { "programming", "aabcd" };
        System.out.println(Arrays.toString(helper(a)));
    }

    private static String[] helper(String[] a) {
        String[] ans = new String[a.length];
        for (int n = 0; n < a.length; n++) {
            String str = a[n];
            Map<Character, Integer> hash = new HashMap<>();
            StringBuilder newStr = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (!hash.containsKey(str.charAt(i))) {
                    hash.put(str.charAt(i), i);
                    newStr.append(str.charAt(i));
                }
            }
            ans[n] = newStr.toString();
        }
        return ans;
    }
}
