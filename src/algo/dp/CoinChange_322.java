package algo.dp;

import java.util.Arrays;

/**
 * 322 coin-change	零钱兑换
 *
 * @author shuaishuai.wang
 * @date 2023-02-24
 **/
public class CoinChange_322 {
    public static int coinChange(int[] coins, int amount) {
        int INF = Integer.MAX_VALUE;
        int[] opt = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            opt[i] = INF;
            for (int coin : coins) {
                if (coin <= i) {
                    opt[i] = Math.min(opt[i - coin] + 1, opt[i]);
                }
            }
        }
        if (opt[amount] >= INF) {
            opt[amount] = -1;
        }
        return opt[amount];
    }

    public static int coinChangeGreedy(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int ans = Integer.MAX_VALUE;
        coinChange(coins, amount, 0, 0, ans);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    static void coinChange(int[] coins, int amount, int index, int count, int ans) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        if (index == coins.length) {
            return;
        }

        for (int k = amount / coins[index]; k >= 0 && k + count < ans; k--) {
            coinChange(coins, amount - k * coins[index], index + 1, count + k, ans);
        }
    }



    public static void main(String[] args) {
        coinChange(new int[]{2}, 3);
    }
}
