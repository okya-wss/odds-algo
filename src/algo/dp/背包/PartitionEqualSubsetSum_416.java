package algo.dp.背包;

/**
 * 416 分割等和子集
 *
 * @author shuaishuai.wang
 * @date 2022-05-25
 **/
public class PartitionEqualSubsetSum_416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int[] nums1 = new int[n + 1];
        nums1[0] = 0;
        System.arraycopy(nums, 0, nums1, 1, n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= nums1[i]; j--) {
                f[j] |= f[j - nums1[i]];
            }
        }
        return f[sum / 2];
    }

    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        int[] nums1 = new int[n + 1];
        nums1[0] = 0;
        System.arraycopy(nums, 0, nums1, 1, n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j < nums1[i]) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j] || f[i - 1][j - nums1[i]];
                }
            }
        }
        return f[n][sum / 2];
    }
}
