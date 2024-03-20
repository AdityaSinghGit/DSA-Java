package strings;

public class LetterCombinationsOfPhoneNumber17 {
    public static void main(String[] args) {
        dialPad("", "12");
    }

    static void dialPad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0'; // This will convert '1' to 1

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            dialPad(p + ch, up.substring(1));
        }

    }

}
