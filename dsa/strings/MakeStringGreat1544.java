package strings;

import java.util.Stack;

public class MakeStringGreat1544 {
    public static void main(String[] args) {
        String s = "leEeetcode";
        String ans = makeGood(s);
        System.out.println(ans);
    }

    public static String makeGood(String s) {
        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                s = s.substring(0, i) + s.substring(i + 1);
                s = s.substring(0, i) + s.substring(i + 1);
                if (i - 1 > -1) {
                    i--;
                }
            } else {
                i++;
            }
        }

        return s;
    }

}
