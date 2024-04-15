package recursion;

public class CountNumberOfZeroes {

    public static void main(String[] args) {
        int ans = countZeroes(5050000);
        System.out.println(ans);
    }

    static int count = 0;

    public static int countZeroes(int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 10 == 0) {
            count++;
        }
        countZeroes(n / 10);
        return count;
    }

}
