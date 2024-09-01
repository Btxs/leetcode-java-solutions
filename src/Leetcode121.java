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

    /**
     * 计算在给定股价数组中，包含冷冻期条件下的最大利润
     * @param prices 股价数组
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int haveStock = -prices[0], notHaveStock = 0;
        for (int i = 0; i <= prices.length - 1; ++i) {
            /**
             * 计算在持有股票状态下的新状态：
             * 如果前一天没有股票且不买卖，或如果前一天有股票但是今天卖出（利润为负）
             */
            int newHaveStock = Math.max(haveStock, notHaveStock - prices[i]);
            /**
             * 计算在不持有股票状态下的新状态：
             * 如果前一天就没有股票，或者如果今天购买了股票
             */
            int newNotHaveStock = Math.max(haveStock + prices[i], notHaveStock);

            // 更新持有股票和不持有股票的当前状态值
            haveStock = newHaveStock;
            notHaveStock = newNotHaveStock;
        }
        return notHaveStock;
    }
}
