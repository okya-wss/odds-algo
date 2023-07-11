package algo.dp.线性DP;

/**
 * 70 climbing-stairs	爬楼梯
 *
 * @author shuaishuai.wang
 * @date 2023-03-02
 **/
public class ClimbingStairs_70 {
    //斐波那契数
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
