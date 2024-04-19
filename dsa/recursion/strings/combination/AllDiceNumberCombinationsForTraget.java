package recursion.strings.combination;

public class AllDiceNumberCombinationsForTraget {
    /****** AMAZON QUESTION ********/
    // ANother varient of leetcode problem
    // Gives all possible dice combinations returning the sum target

    public static void main(String[] args) {
        diceCombination("", 4);
    }

    static void diceCombination(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            diceCombination(p + i, target - i);
        }

    }
}
