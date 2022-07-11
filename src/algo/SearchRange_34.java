package algo;

/**
 * 排序数组中查找元素的第一个和最后一个位置
 *
 * @author shuaishuai.wang
 * @date 2022-04-21
 **/
public class SearchRange_34 {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[right] != target) {
            return new int[]{-1, -1};
        }
        int L = right;
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{right, L};
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
