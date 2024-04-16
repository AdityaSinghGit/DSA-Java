package recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int ans = sumOfDigits(1234);
        System.out.println(ans);
    }

    public static int sumOfDigits(int n) {
        if (n <= 0) {
            return 0;
        }
        // This returns remainder i.e 5 in case of 1234.5
        int remainder = n % 10;
        // This returns remaining numbers 1234 out of 1234.5
        int remaining = n / 10;
        return remainder + sumOfDigits(remaining);
    }
}
