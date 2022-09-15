package algo.dp.线性DP;

/**
 * 213 house-robber-ii	打家劫舍 II
 *
 * @author shuaishuai.wang
 * @date 2022-07-19
 **/
public class HouseRobberIi_213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] f = new int[n][2];
        //第一家不偷
        f[0][1] = 0;
        f[0][0] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i];
        }
        int ans = Math.max(f[n - 1][0], f[n - 1][1]);
        //最后一家不偷
        f[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i];
        }
        //取最大值
        return Math.max(ans, f[n-1][0]);
    }
}