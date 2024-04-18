package recursion.strings.permutation;

import java.util.ArrayList;

public class StringPermutation {
    public static void main(String[] args) {

        // permutation("", "abc");

        ArrayList<String> ans = findPermutation("", "abc");
        System.out.println(ans);

        // int ans = permutationCount("", "abc");
        // System.out.println(ans);
    }

    // Prints processed permutations
    static void permutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        // ***IMPORTANT***
        // For this logic, checkout notebook
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutation(f + ch + s, up.substring(1));
        }

    }

    // Returns processed permutations in ArrayList
    static ArrayList<String> findPermutation(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<String>();

        char ch = up.charAt(0);
        // ***IMPORTANT***
        // For this logic, checkout notebook/notes
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            ans.addAll(findPermutation(first + ch + second, up.substring(1)));
        }

        return ans;
    }

    // RETURN PERMUTATION COUNT
    static int permutationCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);
        // ***IMPORTANT***
        // For this logic, checkout notebook/notes
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count += permutationCount(f + ch + s, up.substring(1));
        }

        return count;

    }

}
