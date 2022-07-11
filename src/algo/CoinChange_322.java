package algo;

/**
 * @author shuaishuai.wang
 * @date 2022-04-29
 **/
public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] opt = new int[amount + 1];
        opt[0] = 0;
        for (int i = 1; i <= amount; i++) {
            opt[i] = max;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    opt[i] = Math.min(opt[i], opt[i - coin] + 1);
                }
            }
        }
        return opt[amount] >= max ? -1 : opt[amount];
    }
}
