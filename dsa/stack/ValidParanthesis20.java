package stack;

import java.util.Stack;

public class ValidParanthesis20 {
    public static void main(String[] args) {
        // String str = "(])";
        String str = "()[]{}";
        boolean ans = isValid(str);
        System.out.println(ans);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isOpen(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (check(stack) == ch) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static char check(Stack<Character> stack) {
        if (stack.lastElement() == '(') {
            return ')';
        } else if (stack.lastElement() == '[') {
            return ']';
        } else {
            return '}';
        }
    }

    private static boolean isOpen(char check) {
        return check == '(' || check == '[' || check == '{';
    }
}
