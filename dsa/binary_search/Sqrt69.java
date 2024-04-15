package binary_search;

public class Sqrt69 {

    public static void main(String[] args) {
        int x = 15;
        int ans = findSqrt(x);
        System.out.println(ans);
    }

    public static int findSqrt(int x) {
        long start = 0;
        long end = x;

        while (start <= end) {
            long mid = (start + (end - start) / 2);
            long arrSquare = mid * mid;

            if (x < arrSquare) {
                end = mid - 1;
            } else if (x > arrSquare) {
                start = mid + 1;
            } else
                return (int) mid;
        }
        return (int) start - 1;
    }

}
