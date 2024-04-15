package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        // In this case if we give input = 50
        // The system will take too long to respond
        System.out.println(fibo(7));

        // With this method, we can easily calculate fibo of n in less time
        System.out.println(fiboFormula(50));
    }

    /************ MORE EFFICIENT ***************/
    public static int fiboFormula(int n) {
        // Formula to find fibonacci number in constant time copmlexity
        return (int) (Math.pow(((1 + Math.sqrt(5)) / 2), n) / Math.sqrt(5));
    }

    /************ LESS EFFICIENT ***************/
    public static int fibo(int n) {

        // Base condition
        if (n < 2) {
            return n;
        }

        // This is not tail recursion
        // Bcz fibo(n - 1) will be added with fibo(n - 2) and then returned.
        // So this is not the last function call
        return fibo(n - 1) + fibo(n - 2);

        // [NOTE]: The formula "fibo(n - 1) + fibo(n - 2)" is recurrence relation.
    }

}