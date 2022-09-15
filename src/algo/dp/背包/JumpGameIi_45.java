package algo.dp.背包;

/**
 * 45 jump-game-ii	跳跃游戏 II
 *
 * @author shuaishuai.wang
 **/
public class JumpGameIi_45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int fastest = 0;
        int jump = 0;
        for (int i = 0; i < n - 1; i++) {
            fastest = Math.max(nums[i] + i, fastest);
            if (end == i) {
                end = fastest;
                jump++;
            }
        }
        return jump;
    }

    // public int jumpDp(int[] nums) {
    //     int n = nums.length;
    //     int[] algo.dp = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         algo.dp[i]
    //     }
    // }
}
