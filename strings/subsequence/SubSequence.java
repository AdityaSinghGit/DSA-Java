package strings.subsequence;

import java.util.ArrayList;

public class SubSequence {

    static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        String up = "abc";
        findSubSequence("", up);
        System.out.println(list);
    }

    static void findSubSequence(String p, String up) {
        if (up.isEmpty()) {
            list.add(p);
            return;
        }

        char ch = up.charAt(0);

        findSubSequence(p + ch, up.substring(1));

        findSubSequence(p, up.substring(1));

    }
}
