package recursion;

public class CheckPalindrome125 {
    // Leetcode 125
    // https://leetcode.com/problems/valid-palindrome/description/
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").replaceAll("\\s+", "");
        s = s.toLowerCase();
        return checkPalindrome(0, s.length() - 1, s);
    }

    private static boolean checkPalindrome(int l, int r, String s) {
        if (l >= r)
            return true;

        if (s.charAt(l) == s.charAt(r))
            return checkPalindrome(l + 1, r - 1, s);

        return false;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean ans = isPalindrome(s);
        System.out.println(ans);
    }
}
