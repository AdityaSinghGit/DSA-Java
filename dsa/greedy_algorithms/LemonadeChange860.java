package greedy_algorithms;

public class LemonadeChange860 {
    // Leetcode 860
    // https://leetcode.com/problems/lemonade-change/
    // For sol
    // https://www.youtube.com/watch?v=n_tmibEhO6Q&list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea&index=2
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            // check if we got 5 or 10
            if (bills[i] == 5) {
                five += 1;
            } else if (bills[i] == 10) {
                ten += 1;
                if (five > 0) {
                    five -= 1;
                } else {
                    return false;
                }
                // if we got changes then 20 can work else false
            } else {
                if (five > 0 && ten > 0) {
                    five -= 1;
                    ten -= 1;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
