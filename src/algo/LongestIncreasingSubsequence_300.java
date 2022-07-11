package algo;

/**
 * // 300 longest-increasing-subsequence	最长递增子序列
 *
 * @author shuaishuai.wang
 * @date 2022-05-06
 **/
public class LongestIncreasingSubsequence_300 {
    public static int lengthOfLIS(int[] nums) {
        int m = nums.length;
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, dp[i]);
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
