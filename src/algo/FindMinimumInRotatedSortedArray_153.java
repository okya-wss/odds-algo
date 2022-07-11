package algo;

/**
 * 查找最小值 153
 * @author shuaishuai.wang
 * @date 2022-04-26
 **/
public class FindMinimumInRotatedSortedArray_153 {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2, 1}));
    }
}
