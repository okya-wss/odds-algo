package algo;

/**
 * @author shuaishuai.wang
 * @date 2022-05-25
 **/
public class CanPartition_416 {
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
                f[j] |= f[j - nums1[i ]];
            }
        }
        return f[sum / 2];
    }
}
