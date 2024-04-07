public class BuyAndSellStocks121 {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 6, 5, 0, 3 };
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
                sell = prices[i];
            }

            if (prices[i] > sell) {
                sell = prices[i];
                int current = sell - buy;
                if (profit < current) {
                    profit = current;
                }
            }
        }

        return profit;
    }
}
