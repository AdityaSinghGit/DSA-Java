package stack;

import java.util.Stack;

public class CountBalanceParanthesis1541 {
    public static void main(String[] args) {
        String str = "())";
        int ans = minInsertions(str);
        System.out.println(ans);
    }

    public static int minInsertions(String s) {
        int x = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char nextCh = s.charAt(i + 1 >= s.length() ? i : i + 1);
            if (!stack.isEmpty() && stack.lastElement() == '(' && ch == ')') {
                if (nextCh == ')') {
                    x++;
                } else {
                    continue;
                }
            } else {
                if (x > 0) {
                    continue;
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }
}
