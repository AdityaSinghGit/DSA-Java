package strings;

public class ReversePrefixOfWords2000 {
    public static String reversePrefix(String word, char ch) {
        if (word.isEmpty() || word == null) {
            return word;
        }

        // Strings are immutable so we cannot make changes to the existing one but can
        // make a new one.
        StringBuilder str = new StringBuilder(word);

        int start = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                end = i;
                break;
            }
        }

        while (start < end) {
            char temp = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, temp);

            start++;
            end--;
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String str = "abcdefd";
        char ch = 'd';
        String ans = reversePrefix(str, ch);
        System.out.println(ans);
    }
}
