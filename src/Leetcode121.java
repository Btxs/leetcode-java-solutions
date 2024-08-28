public class Leetcode121 {
    /**
     * Best Time to Buy and Sell Stock
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int maxPerfit = 0;
        for (int i = 0; i <= prices.length - 2; ++i) {
            if (prices[i] < prices[i + 1]) {
                maxPerfit += prices[i + 1] - prices[i];
            }
        }
        return maxPerfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int haveStock = -prices[0], notHaveStock = 0;
        for (int i = 0; i <= prices.length - 1; ++i) {
            int newHaveStock = Math.max(haveStock, notHaveStock - prices[i]);
            int newNotHaveStock = Math.max(haveStock + prices[i], notHaveStock);
            haveStock = newHaveStock;
            notHaveStock = newNotHaveStock;
        }
        return notHaveStock;
    }
}
