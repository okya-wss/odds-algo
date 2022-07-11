package algo;

/**
 * @author shuaishuai.wang
 * @date 2022-05-06
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int m = nums.length;
        int[] dp = new int[m];
        dp[0] = nums[0];
        for (int i = 1; i < m; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
