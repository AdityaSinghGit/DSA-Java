package strings;

public class StringCountPostDelSimilarEnds1750 {

    public static void main(String[] args) {
        int ans = minimumLength("cabaabac");
        System.out.println(ans);
    }

    public static int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end && s.charAt(start) == s.charAt(end)) {
            char ch = s.charAt(start);

            while (start < s.length() && s.charAt(start) == ch) {
                start++;
            }
            while (end >= 0 && s.charAt(end) == ch) {
                end--;
            }
        }
        return start > end ? 0 : (end - start + 1);
    }
}
