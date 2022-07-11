package algo;

/**
 * 打家劫舍 198
 *
 * @author shuaishuai.wang
 * @date 2022-05-16
 **/
public class Rob_198 {

    /**
     * 213
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] f = new int[n][2];
        f[0][1] = 0;
        f[0][0] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i];
        }
        int ans = Math.max(f[n - 1][0], f[n - 1][1]);

        f[0][1] = nums[0];
        f[0][0] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i];
        }
        return Math.max(ans, f[n - 1][0]);
    }

    // /**
    //  * 198
    //  * @param nums
    //  * @return
    //  */
    // public int rob(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     int n = nums.length;
    //     int[][] f = new int[n][2];
    //     f[0][1] = nums[0];
    //     f[0][0] = 0;
    //     for (int i = 1; i < n; i++) {
    //         f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
    //         f[i][1] = f[i - 1][0] + nums[i];
    //     }
    //     return Math.max(f[n - 1][0], f[n - 1][1]);
    // }
}
