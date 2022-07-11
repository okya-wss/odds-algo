package algo;

/**
 * @author shuaishuai.wang
 * @date 2022-04-27
 **/
public class PartitionDisjoint_915 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int leftMax = nums[0];
        int pos = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, nums[i]);
            if (leftMax <= nums[i]) {
                continue;
            }
            leftMax = max;
            pos = i;
        }
        return pos + 1;
    }
}
