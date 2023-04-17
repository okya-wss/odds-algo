package algo.dp.背包;

/**
 * 55 jump-game	跳跃游戏
 *
 * @author shuaishuai.wang
 **/
public class JumpGame_55 {


    public boolean canJumpDp(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (j + nums[j] >= i) && dp[j];
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i <= n; i++) {
            if (i <= farthest) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            if (farthest >= n - 1) {
                return true;
            }
        }
        return false;
    }


}