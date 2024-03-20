public class StepsToReduceNumToZero1342 {
    public static void main(String[] args) {
        int ans = numberOfSteps(123);
        System.out.println(ans);
    }

    static int steps = 0;

    public static int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 2 == 0) {
            num /= 2;
        } else {
            num -= 1;
        }
        ++steps;
        numberOfSteps(num);
        return steps;
    }
}
