package algo.dp.背包;

/**
 * 279 perfect-squares	完全平方数
 *
 * @author shuaishuai.wang
 * @date 2022-08-10
 **/
public class PerfectSquares_279 {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = i;
            for (int j = 0; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }
}
