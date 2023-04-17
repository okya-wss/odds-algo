package algo.greedy;

/**
 *
 * 122 best-time-to-buy-and-sell-stock-ii	买卖股票的最佳时机 II
 * @author shuaishuai.wang
 * @date 2023-03-15
 **/
public class BestTimeToBuyAndSellStockIi_122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[1] - prices[0];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
}
