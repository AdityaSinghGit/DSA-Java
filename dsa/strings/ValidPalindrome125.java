package strings;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        // String s = "A man, a plan, a canal: Panama"; //t
        String s = "0P"; // f
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (str.contains(String.valueOf(s.charAt(i)))) {
                sb.append(s.charAt(i));
            }
        }

        int i = 0;
        int j = sb.length() - 1;

        while (i < j) {
            if (sb.charAt(i) == sb.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
