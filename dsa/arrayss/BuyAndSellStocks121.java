package arrayss;

public class BuyAndSellStocks121 {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 7, 44, 67, 33, 3, 55, 51, 66, 82, 29, 67, 6, 4 };
        System.out.println(maxProfitModifiedResult(arr));
    }

    public static int maxProfitSlidingWindow(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - buy;
            profit = Math.max(profit, cost);
            buy = Math.min(buy, prices[i]);
        }
        return profit;
    }

    public static String maxProfitModifiedResult(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        int buyDay = 0;
        int sellDay = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - buy;
            if (cost > profit)
                sellDay = i;
            profit = Math.max(profit, cost);
            if (prices[i] < buy)
                buyDay = i;
            buy = Math.min(buy, prices[i]);
        }
        return "Bought at day " + buyDay + " and sold at day " + sellDay;
    }
}
