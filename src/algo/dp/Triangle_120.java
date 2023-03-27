package algo.dp;

import java.util.List;

/**
 * 120 triangle	三角形最小路径和
 *
 * @author shuaishuai.wang
 * @date 2023-03-02
 **/
public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int n = triangle.size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int cur = i % 2;
            int prev = 1 - cur;
            dp[cur][0] = dp[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[cur][j] = Math.min(dp[prev][j], dp[prev][j - 1]) + triangle.get(i).get(j);
            }
            dp[cur][i] = dp[prev][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = dp[(n - 1) % 2][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[(n - 1) % 2][i]);
        }
        return minTotal;
    }


    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        //从后向前
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i] + triangle.get(i).get(i);
            for (int j = triangle.get(i).size() - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        int minTotal = dp[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }
}
