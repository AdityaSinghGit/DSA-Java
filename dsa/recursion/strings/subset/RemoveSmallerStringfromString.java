package recursion.strings.subset;

public class RemoveSmallerStringfromString {
    public static void main(String[] args) {
        String given = "abcdskipthisefgh";
        String ans = removeStringFromOriginal(given);
        System.out.println(ans);

        removeString("", given, "skipthis");
    }

    // Approach with new string
    static void removeString(String p, String up, String skip) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if (up.startsWith(skip)) {
            removeString(p, up.substring(skip.length()), skip);
        } else {
            removeString(p + ch, up.substring(1), skip);
        }

    }

    // Approach with existing string
    static String removeStringFromOriginal(String up) {
        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (up.startsWith("skipthis")) {
            return removeStringFromOriginal(up.substring(8));
        } else {
            return ch + removeStringFromOriginal(up.substring(1));
        }

    }

}