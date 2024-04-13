package greedy_algorithms;

public class ReverseWordsInString151 {
    // Leetcode 151
    // https://leetcode.com/problems/reverse-words-in-a-string/description/
    public static String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        String[] arr = s.split(" ");
        String str = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            str += arr[i] + " ";
        }

        return str.trim();
    }

    public static void main(String[] args) {
        String str = " a good   example  ";
        String ans = reverseWords(str);
        System.out.println(ans);
    }
}
