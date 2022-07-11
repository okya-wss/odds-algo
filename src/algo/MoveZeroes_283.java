package algo;

/**
 * // 283 move-zeroes	移动零
 *
 * @author shuaishuai.wang
 * @date 2022-02-24
 **/
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
