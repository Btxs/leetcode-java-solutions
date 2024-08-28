public class Leetcode122 {
    /**
     * Best Time to Buy and Sell Stock II
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int minPrice = prices[0], maxPerfit = 0;
        int maxPerfitDay = 0;
        int perfit = 0;
        while (maxPerfitDay <= prices.length) {
            for (int i = maxPerfitDay; i < prices.length - 1; ++i) {
                minPrice = Math.min(prices[i], minPrice);
                if (prices[i] - minPrice > maxPerfit) {
                    maxPerfit = prices[i] - minPrice;
                    maxPerfitDay = i;
                }
            }
            perfit += maxPerfit;
        }
        return perfit;
    }
}
