package stack;

import java.util.Stack;

public class CountValidParanthesis921 {
    public static void main(String[] args) {
        String str = "())))((";
        int ans = minAddToMakeValid(str);
        System.out.println(ans);
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && ch == ')' && stack.lastElement() == '(') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

}
