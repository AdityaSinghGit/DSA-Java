public class ReverseNumber {

    public static void main(String[] args) {
        int ans = reverseNumber(12345);
        System.out.println(ans);
    }

    static int reverse = 0;

    public static int reverseNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        // This returns remainder i.e 5 in case of 1234.5
        int remainder = n % 10;
        // This gives reversed numbers
        reverse = reverse * 10 + remainder;
        // This returns remaining numbers 1234 out of 1234.5
        int remaining = n / 10;
        reverseNumber(remaining);
        return reverse;
    }

}
