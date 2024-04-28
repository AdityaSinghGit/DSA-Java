package linked_list.singly_linked_list;

public class HappyNumber202 {
    // Leetcode 202
    // https://leetcode.com/problems/happy-number/

    // TIME : O(n)
    // SPACE : O(1)
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = findSquare(n);
            fast = findSquare(findSquare(n));
        } while (fast != slow);

        if (slow == 1) {
            return true;
        }

        return false;
    }

    private int findSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num = num / 10;
        }
        return ans;
    }
}
