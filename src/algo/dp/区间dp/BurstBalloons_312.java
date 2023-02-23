package algo.dp.区间dp;

/**
 * 312 burst-balloons	戳气球
 *
 * @author shuaishuai.wang
 **/
public class BurstBalloons_312 {

    public int maxCoins(int[] nums) {
        // 先戳哪个， 戳完p以后，子问题【l.p-1】 和【p+1，r】 两端相邻的气球都发生了变化 所有的状态变量都发生了变化
        // 选择最后戳哪个
        // f[l.r] = max {f[l,p-1] + f[p+1,r] + nums[p] * nums[l-1] * nums[r+1]}
        int n = nums.length;
        nums1 = new int[n + 1];
        nums1[0] = 1;
        nums1[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            nums1[i] = nums[i - 1];
        }
        f = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) { //区间长度
            for (int l = 1; l <= n - len + 1; l++) {
                int r = l + len - 1;
                if (r > n) {
                    continue;
                }
                for (int p = l; p <= r; p++) {
                    f[l][r] = Math.max(f[l][r], f[l][p - 1] + f[p + 1][r] + nums1[p] * nums1[l - 1] * nums1[r + 1]);
                }
            }
        }
        // 全部戳的值
        return f[1][n];
    }


    // 方法二：递归
    int[] nums1;
    int[][] f;

    public int maxCoins2(int[] nums) {
        int n = nums.length;
        nums1 = new int[n + 2];
        nums1[0] = 1;
        nums1[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            nums1[i] = nums[i - 1];
        }
        f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = -1;
            }
        }
        return calc(1, n);
    }

    private int calc(int l, int r) {
        if (l > r) {
            return 0;
        }
        if (f[l][r] != -1) {
            return f[l][r];
        }
        for (int p = l; p <= r; p++) {
            f[l][r] = Math.max(f[l][r], calc(l, p - 1) + calc(p + 1, r) + nums1[p] * nums1[l - 1] * nums1[r + 1]);
        }
        return 0;
    }

}



