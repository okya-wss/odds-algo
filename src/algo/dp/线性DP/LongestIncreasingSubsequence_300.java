package algo.dp.线性DP;

import java.util.Arrays;

/**
 * 300 longest-increasing-subsequence	最长递增子序列
 *
 * @author shuaishuai.wang
 * @date 2023-03-02
 **/
public class LongestIncreasingSubsequence_300 {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //以i为结尾 计算dp[i】
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
