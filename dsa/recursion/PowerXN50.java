package recursion;

public class PowerXN50 {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            if (n < 0) {
                return (1 / temp) * (1 / temp);
            }
            return temp * temp;
        } else {
            if (n < 0) {
                System.out.println(1 / temp + " and " + 1 / x);
                return (1 / temp) * (1 / temp) * (1 / x);
            }
            return temp * temp * x;
        }
    }

    public static void main(String[] args) {
        double ans = myPow(2, -6);
        System.out.println(ans);
    }
}
