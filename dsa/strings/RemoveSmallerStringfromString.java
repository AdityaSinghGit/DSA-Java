package strings;

public class RemoveSmallerStringfromString {
    public static void main(String[] args) {
        String given = "abcdskipthisefgh";
        String ans = removeString(given);
        System.out.println(ans);
    }

    static String removeString(String up) {
        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (up.startsWith("skipthis")) {
            return removeString(up.substring(8));
        } else {
            return ch + removeString(up.substring(1));
        }

    }

}