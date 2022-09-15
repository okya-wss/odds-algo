package algo.dp.背包;

import java.util.Arrays;

/**
 * 518 coin-change-2	零钱兑换 II
 *
 * @author shuaishuai.wang
 **/
public class CoinChange2_518 {

    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, 0);
        f[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                f[j] = f[j] + f[j - coins[i]];
            }
        }
        return f[amount];
    }
}
