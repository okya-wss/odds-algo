package algo;

import java.util.Arrays;

/**
 * 买卖股票
 *
 * @author shuaishuai.wang
 * @date 2022-05-09
 **/
public class MaxProfit {

    /**
     * 买卖股票的最佳时机 II
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][0] = 0;
        for (int i = 1; i < n; i++) {
            f[i][1] = Math.max(f[i][1], f[i - 1][0] - prices[i]);
            f[i][0] = Math.max(f[i][0], f[i - 1][1] + prices[i]);
            for (int j = 0; j < 2; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j]);
            }
        }
        return f[n - 1][0];
    }

    /**
     * 买卖股票的最佳时机 III
     *
     * @param c 交易次数
     */
    public int maxProfit3(int[] pricesInput, int c) {
        int n = pricesInput.length;
        int[] prices = new int[n + 1];
        prices[0] = 0;
        System.arraycopy(pricesInput, 0, prices, 1, n);
        int[][][] f = new int[n + 1][2][c + 1];
        Arrays.fill(f[0][0], -100000);
        Arrays.fill(f[0][1], -100000);
        f[0][0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= c; k++) {
                f[i][0][k] = Math.max(f[i][0][k], f[i - 1][1][k] + prices[i]);
                if (k > 0) {
                    f[i][1][k] = Math.max(f[i][1][k], f[i - 1][0][k - 1] - prices[i]);
                }
                for (int j = 0; j < 2; j++) {
                    f[i][j][k] = Math.max(f[i - 1][j][k], f[i][j][k]);
                }
            }
        }


        int ans = 0;
        for (int k = 0; k <= c; k++) {
            ans = Math.max(ans, f[n][0][k]);
        }
        return ans;
    }
}
