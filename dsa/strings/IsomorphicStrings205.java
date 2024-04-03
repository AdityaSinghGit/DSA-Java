package strings;

import java.util.ArrayList;
import java.util.List;

public class IsomorphicStrings205 {

    public static void main(String[] args) {
        boolean ans = isIsomorphic("titlex", "biblee");
        System.out.println(ans);
    }

    public static boolean isIsomorphic(String s, String t) {
        List<List<Integer>> resultS = new ArrayList<>();
        List<List<Integer>> resultT = new ArrayList<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            List<Integer> checkS = new ArrayList<>();
            List<Integer> checkT = new ArrayList<>();

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    checkS.add(i);
                    checkS.add(j);
                }
            }
            if (!checkS.isEmpty()) {
                resultS.add(checkS);
            }

            for (int j = i + 1; j < t.length(); j++) {
                if (t.charAt(i) == t.charAt(j)) {
                    checkT.add(i);
                    checkT.add(j);
                }
            }
            if (!checkT.isEmpty()) {
                resultT.add(checkT);
            }
        }

        return resultS.equals(resultT);
    }
}
