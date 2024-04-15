package recursion;

public class PrintNums {
    public static void main(String[] args) {
        printNum(1);
    }

    public static void printNum(int n) {
        System.out.println(n);

        // This is the base condition
        // Here recursion will stop making calls
        if (n == 5) {
            return;
        }

        // This is called tail recursion
        // This is the last function call
        printNum(n + 1);
    }
}
