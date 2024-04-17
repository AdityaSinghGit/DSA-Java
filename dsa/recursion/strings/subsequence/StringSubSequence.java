package recursion.strings.subsequence;

import java.util.ArrayList;

public class StringSubSequence {
    public static void main(String[] args) {
        String up = "abc";
        SubSequen("", up);

        ArrayList<String> ans = subSequenList("", up);
        System.out.println(ans);

    }

    // print individual substrings
    static void SubSequen(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        SubSequen(p + ch, up.substring(1));

        SubSequen(p, up.substring(1));

    }

    // Return substrings in an ArrayList
    static ArrayList<String> subSequenList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subSequenList(p + ch, up.substring(1));
        ArrayList<String> right = subSequenList(p, up.substring(1));

        left.addAll(right);

        return left;

    }
}
