package strings;

public class LengthOfLastWord58 {

    public int lengthOfLastWord(String s) {
        s = s.trim();

        String last = s.substring(s.lastIndexOf(" ") + 1);

        return last.length();
    }
}
