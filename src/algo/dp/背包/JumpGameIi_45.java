package algo.dp.背包;

/**
 * 45 jump-game-ii	跳跃游戏 II
 *
 * @author shuaishuai.wang
 **/
public class JumpGameIi_45 {

    /**
     * https://leetcode.cn/problems/jump-game-ii/solution/dong-tai-gui-hua-jie-fa-by-alchemist-5r/
     * @param nums
     * @return
     */
    public int jumpDp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums.length + 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }


    public int jumpDpI(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums.length + 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) {
                    return dp[n - 1];
                }
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }


    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int fastest = 0;
        int jump = 0;
        // n-1 最后一个不需要遍历 因为开始时 0步已经加了1
        for (int i = 0; i < n - 1; i++) {
            // 每次找到最远能到的距离
            fastest = Math.max(nums[i] + i, fastest);
            //寻找局部最优
            // for循环找到本次跳跃能达到的最大值边界 到达边界 更新边界
            if (end == i) {
                end = fastest;
                jump++;
            }
        }
        return jump;
    }
}
