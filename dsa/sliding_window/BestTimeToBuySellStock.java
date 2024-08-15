package sliding_window;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] prices = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - buy;
            profit = Math.max(profit, cost);
            buy = Math.min(buy, prices[i]);
        }
        return profit;
    }
}
