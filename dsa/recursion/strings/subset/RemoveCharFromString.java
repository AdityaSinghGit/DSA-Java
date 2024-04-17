package recursion.strings.subset;

public class RemoveCharFromString {
    public static void main(String[] args) {
        removeCharFromString("", "baccad");

        // In case of confusion, on how it returned "bccdh"
        // watch kunal's video from 7:00 mins
        // https://www.youtube.com/watch?v=gdifkIwCJyg&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=32
        String ans = removeCharFromExistingString("baccadh");
        System.out.println(ans);
    }

    // Approach with a new string
    static void removeCharFromString(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            removeCharFromString(p, up.substring(1));
        } else {
            removeCharFromString(p + ch, up.substring(1));
        }
    }

    // uproach with existing string
    static String removeCharFromExistingString(String original) {
        if (original.isEmpty()) {
            return "";
        }

        char ch = original.charAt(0);

        if (ch == 'a') {
            return removeCharFromExistingString(original.substring(1));
        } else {
            return ch + removeCharFromExistingString(original.substring(1));
        }
    }

}
