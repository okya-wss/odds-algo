package algo.dichotomy;

/**
 * 分割数组的最大值 410
 *
 * @author shuaishuai.wang
 * @date 2022-04-27
 **/
public class SplitArrayLargestSum_410 {

    private int[] nums;

    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        int left = 0;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right = right + num;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (validate(m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean validate(int m, int mid) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num <= mid) {
                sum = sum + num;
            } else {
                count++;
                sum = num;
            }
        }
        return count <= m;
    }
}
