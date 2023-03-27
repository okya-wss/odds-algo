package algo.dp;

/**
 * 152 乘积最大子数组
 *
 * @author shuaishuai.wang
 * @date 2022-05-06
 **/
public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        int m = nums.length;
        int[] min = new int[m];
        int[] max = new int[m];
        min[0] = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < m; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}
